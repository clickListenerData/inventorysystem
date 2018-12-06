package com.micropole.inventorysystem.common;

import android.support.annotation.NonNull;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.micropole.baseapplibrary.appconst.AppApi;
import com.micropole.baseapplibrary.appconst.Constants;
import com.micropole.inventorysystem.entity.ShortTokenBean;
import com.micropole.inventorysystem.ui.login.LoginActivity;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;
import com.xx.baseutilslibrary.entity.BaseResponseStatusEntity;
import com.xx.baseutilslibrary.network.gson.ZipHelper;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * TokenInterceptor
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2018/5/10 20:19.
 */

public class TokenInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();


        // try the request
        Response originalResponse = chain.proceed(request);
        ResponseBody responseBody = originalResponse.body();
        BufferedSource source = responseBody != null ? responseBody.source() : null;
        if (source != null) {
            source.request(Long.MAX_VALUE); // Buffer the entire body.
        }
        assert source != null;
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        assert charset != null;

        String encoding = originalResponse
                .headers()
                .get("Content-Encoding");

        Buffer clone = buffer.clone();

        String bodyString;
        if (encoding != null && encoding.equalsIgnoreCase("gzip")) {//content使用gzip压缩
            bodyString = ZipHelper.decompressForGzip(clone.readByteArray());//解压
        } else {//content没有被压缩
            charset = Charset.forName("UTF-8");
            contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            bodyString = clone.readString(charset);
        }

        try {
            BaseResponseStatusEntity baseResponseEntity = new Gson().fromJson(bodyString, BaseResponseStatusEntity.class);
            if (baseResponseEntity != null) {
                //根据和服务端的约定判断token过期
                if (Constants.LONG_TOKEN_INVALID.equals(baseResponseEntity.getCode())) {
                    //长token过期,重新登录
                    Constants.INSTANCE.loginOut();
                    ActivityUtils.startActivity(LoginActivity.class);
                } else if (Constants.SHORT_TOKEN_INVALID.equals(baseResponseEntity.getCode())) {
                    //不是请求刷新token时才进行token刷新
                    if (!request.url().url().toString().contains("get_short_token")) {
                        //短token过期,同步刷新token

                        //remove 短token

                        Request apisign = AppService.INSTANCE.getApi()
                                .refreshToken(Constants.INSTANCE.getLongToken())
                                .request()
                                .newBuilder()
                                .build();
                        String string = chain.proceed(apisign).body().string();
                        BaseResponseEntity<ShortTokenBean> body = new Gson().fromJson(string, new TypeToken<BaseResponseEntity<ShortTokenBean>>() {
                        }.getType());

                        //要用retrofit的同步方式
                        synchronized (Utils.getApp()) {
                            String newToken = body.getData().getShortToken();
                            if (newToken != null) {
                                Constants.INSTANCE.putShortToken(newToken);
                            }

                            Request newRequest = request.newBuilder()
                                    .header("token", newToken)//设置新的token
                                    .build();
                            originalResponse.body().close();

                            // retry the request
                            return chain.proceed(newRequest);
                        }
                    }
                }
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // otherwise just pass the original response on
        return originalResponse;
    }
}