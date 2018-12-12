package com.micropole.inventorysystem.ui.shoppingmall

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.GridLayoutManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.micropole.baseapplibrary.appconst.setTurnImage
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.adapter.shopmall.AddCarChicunAdapter
import com.micropole.inventorysystem.adapter.shopmall.AddCarColorAdapter
import com.micropole.inventorysystem.entity.ProductDetailBean
import com.micropole.inventorysystem.ui.personal.shopmall.ContactServiceActivity
import com.micropole.inventorysystem.ui.shoppingmall.mvp.ProductDetailContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.present.ProductDetailPresent
import com.micropole.inventorysystem.widght.FlowLayout
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity
import com.xx.baseutilslibrary.extensions.startActivity
import com.xx.baseutilslibrary.network.exception.ApiFaileException
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.item_addcar.view.*

/**
 * @ClassName       ProductDetailActivity
 * @Description     商品详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 16:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ProductDetailActivity : BaseMvpLcecActivity<View,ProductDetailBean?,ProductDetailContract.Model,ProductDetailContract.View,ProductDetailContract.Prenset>(),ProductDetailContract.View{

    companion object {
        fun startProductDetail(context: Context,id:String){
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("pro_id",id)
            context.startActivity(intent)
        }
    }

    var mProId = ""

    override fun getActivityLayoutId(): Int = R.layout.activity_product_detail

    override fun createPresenter(): ProductDetailContract.Prenset {
        return ProductDetailPresent()
    }

    override fun loadData(refresh: Boolean) {
        presenter.productDetail(mProId)
    }

    override fun initData() {
        mProId = intent.getStringExtra("pro_id")
        super.initData()
        initWeb()
        loadData(true)
    }

    override fun initEvent() {
        tv_contract_service.setOnClickListener { startActivity<ContactServiceActivity>() }
        tv_collection.setOnClickListener {  }
        stv_add_cart.setOnClickListener {
            mBottomDialog.show()
        }
        stv_confirm_buy.setOnClickListener {  }
    }

    fun initWeb(){
        web_product_detail.settings.setSupportZoom(false)
        web_product_detail.isHorizontalScrollBarEnabled = false
        web_product_detail.isVerticalScrollBarEnabled = false
        web_product_detail.isScrollContainer = false
        with(web_product_detail.settings) {
            javaScriptEnabled = true
            blockNetworkImage = false
            useWideViewPort = false
            layoutAlgorithm = android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN
            layoutAlgorithm = android.webkit.WebSettings.LayoutAlgorithm.NARROW_COLUMNS
            builtInZoomControls = false // 设置显示缩放按钮
            setSupportZoom(false) // 支持缩放
            if (android.os.Build.VERSION.SDK_INT >= 21)
            //Build.VERSION_CODES.LOLLIPOP
                mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

            web_product_detail.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }
            }
        }
    }

    override fun setData(data: ProductDetailBean?) {
        if (data != null){
            showContent()
            cb_product_detail.setTurnImage(data.pro_imgs)
            tv_product_title.text = data.pro_name
            tv_product_price.text = data.pro_shop_price
            stv_mian_you.visibility = if (data.is_pinkage == "1") View.VISIBLE else View.GONE
            web_product_detail.loadDataWithBaseURL("",data.pro_text,"text/html","utf-8","")
        }else{
            showError(ApiFaileException(""),true)
        }
    }

    //购物车弹出框
    private val mBottomDialog: AlertDialog by lazy {
        val dialog = AlertDialog.Builder(mContext).show()

        val contentView = layoutInflater.inflate(R.layout.item_addcar, null)
        for (i in 0..7){
            setTextView(contentView.fl_colur,resources.getColor(R.color.color666666),"蓝色",i)
        }
        for (i in 0..7){
            setTextView(contentView.fl_chicun,resources.getColor(R.color.color_333),"XL",i)
        }
        val window = dialog.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        window.setBackgroundDrawableResource(android.R.color.transparent)
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        window.setGravity(Gravity.BOTTOM)//底部弹出
        window.setWindowAnimations(R.style.CarAnimation)

        window.setContentView(contentView)

        dialog
    }
    fun setTextView(flow: FlowLayout, color:Int, text:String, position:Int){
        var textView=TextView(this)
        textView.textSize=14f
        textView.text=text
        textView.setTextColor(color)
        textView.setBackgroundResource(R.drawable.bg_txt_addcar)
        textView.setPadding(ConvertUtils.dp2px(10f),ConvertUtils.dp2px(4f),ConvertUtils.dp2px(10f),ConvertUtils.dp2px(4f))
        var param=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        param.leftMargin= ConvertUtils.dp2px(14f)
        param.topMargin=ConvertUtils.dp2px(10f)
        textView.layoutParams=param
        flow.addView(textView)
        textView.setOnClickListener {

        }
    }

}