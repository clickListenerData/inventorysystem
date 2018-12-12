package com.micropole.inventorysystem.ui.shoppingmall

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.micropole.baseapplibrary.appconst.setTurnImage
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ProductDetailBean
import com.micropole.inventorysystem.entity.SelectSpecBean
import com.micropole.inventorysystem.ui.personal.shopmall.ContactServiceActivity
import com.micropole.inventorysystem.ui.personal.shopmall.EvaluationOrderActivity
import com.micropole.inventorysystem.ui.shoppingmall.mvp.contract.ProductDetailContract
import com.micropole.inventorysystem.ui.shoppingmall.mvp.presenter.ProductDetailPresent
import com.micropole.inventorysystem.widght.FlowLayout
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity
import com.xx.baseutilslibrary.extensions.startActivity
import com.xx.baseutilslibrary.network.exception.ApiFaileException
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.item_addcar.view.*
import kotlinx.android.synthetic.main.view_quantity.view.*

/**
 * @ClassName       ProductDetailActivity
 * @Description     商品详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/12/3 16:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ProductDetailActivity : BaseMvpLcecActivity<View,ProductDetailBean?, ProductDetailContract.Model, ProductDetailContract.View, ProductDetailContract.Prenset>(), ProductDetailContract.View{

    companion object {
        fun startProductDetail(context: Context,id:String){
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("pro_id",id)
            context.startActivity(intent)
        }
    }

    var mProId = ""
    var mType = 0             // 0 : 选择规格，1：加入购物车，2：立即购买
    var mBean : ProductDetailBean? = null

    var mMoName = ""
    var mSpName = ""
    var mNum = 1
    var mSpView : View? = null
    var mMoView : View? = null

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

        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.home_recommended_place_chart)
        siv_imgs.addView(imageView)
        initWeb()
        loadData(true)
    }

    override fun initEvent() {
        tv_contract_service.setOnClickListener { startActivity<ContactServiceActivity>() }
        tv_collection.setOnClickListener { presenter.collectProduct(mProId) }
        stv_add_cart.setOnClickListener {
            mBottomDialog.show()
            mType = 1
        }
        stv_confirm_buy.setOnClickListener {
            mType = 2
        }
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
            mBean = data
            cb_product_detail.setTurnImage(data.pro_imgs)
            tv_product_title.text = data.pro_name
            tv_product_price.text = "¥${data.pro_shop_price}"
            stv_mian_you.visibility = if (data.is_pinkage == "1") View.VISIBLE else View.GONE
            web_product_detail.loadDataWithBaseURL("",data.pro_text,"text/html","utf-8","")

            //siv_imgs.removeAllViews()
            for (i in 0..3){
                //siv_imgs.addShowImgView("",R.drawable.home_recommended_place_chart)
            }
        }else{
            showError(ApiFaileException(""),true)
        }
    }

    var mDialogView:View?=null
    var mStoke = 0
    //购物车弹出框
    private val mBottomDialog: AlertDialog by lazy {
        val dialog = AlertDialog.Builder(mContext).show()

        val contentView = layoutInflater.inflate(R.layout.item_addcar, null)
        for (i in mBean!!.sp_name_arr.indices){
            setTextView(contentView.fl_colur,Color.parseColor("#666666"),mBean!!.sp_name_arr[i],0)
        }
        for (i in mBean!!.mo_name_arr.indices){
            setTextView(contentView.fl_chicun,Color.parseColor("#333333"),mBean!!.mo_name_arr[i],1)
        }
        contentView.tv_price.text = "¥${mBean?.pro_shop_price}"
        contentView.tv_kucun.text = getString(R.string.kucun_count).format(mBean?.pro_stock)

        val window = dialog.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        window.setBackgroundDrawableResource(android.R.color.transparent)
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        window.setGravity(Gravity.BOTTOM)//底部弹出
        window.setWindowAnimations(R.style.CarAnimation)

        window.setContentView(contentView)
        mDialogView = contentView
        addQuantityLis(contentView)

        dialog
    }

    fun setTextView(flow: FlowLayout, color:Int, text:String, position:Int){
        var textView=TextView(this)
        textView.textSize=13f
        textView.text=text
        textView.setTextColor(color)
        textView.setBackgroundDrawable(resources.getDrawable(R.drawable.select_drawable_txt))
        textView.setPadding(ConvertUtils.dp2px(10f),ConvertUtils.dp2px(4f),ConvertUtils.dp2px(10f),ConvertUtils.dp2px(4f))
        var param=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        param.leftMargin= ConvertUtils.dp2px(14f)
        param.topMargin=ConvertUtils.dp2px(10f)
        textView.layoutParams=param
        flow.addView(textView)
        textView.setOnClickListener {
            textView.setTextColor(Color.parseColor("#ffffff"))
            if (position == 0){
                mSpView?.isSelected = false
                it.isSelected = true
                mSpName = text
                mSpView = it
            }else{
                mMoView?.isSelected = false
                it.isSelected = true
                mMoName = text
                mMoView = it
            }
            if (!mSpName.isEmpty() && !mMoName.isEmpty()){
                presenter.selectSpec(mProId,mSpName,mMoName)
            }
        }
    }

    fun addQuantityLis(view : View){
        view.stv_quantity_add.setOnClickListener {
            if (mNum < mStoke){
                ++mNum
            }
            view.tv_quantity.text = "$mNum"
        }
        view.stv_quantity_remove.setOnClickListener {
            if (mNum > 1){
                --mNum
            }
            view.tv_quantity.text = "$mNum"
        }

        view.sv_sure.setOnClickListener {

            when(mType){
                0 -> {}
                1 -> { presenter.addCart(mProId,mSpName,mMoName,mNum.toString()) }
                2 -> {}
            }
            mBottomDialog.dismiss()
        }
    }

    override fun specResult(bean: SelectSpecBean?) {
        if (mBottomDialog.isShowing && bean != null && mDialogView != null){
            mDialogView?.tv_price?.text = "¥${bean.pro_price}"
            mDialogView?.tv_kucun?.text = getString(R.string.kucun_count).format(bean.pro_stock)
            mStoke = bean.pro_stock.toInt()
            tv_product_price.text = "¥${bean.pro_price}"
        }
    }

}