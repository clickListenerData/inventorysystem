package com.micropole.inventorysystem.ui.inventory

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.text.InputType
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.EncodeUtils
import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.inventory.mvp.NewGoodsContract
import com.micropole.inventorysystem.ui.inventory.mvp.present.NewGoodsPresent
import com.micropole.inventorysystem.ui.personal.inventory.CategoryActivity
import com.micropole.inventorysystem.util.ColorUtils
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_new_goods.*
import kotlinx.android.synthetic.main.view_input_message.view.*
import org.devio.takephoto.model.TResult
import java.io.File


/**
 * @ClassName       NewGoodsActivity
 * @Description     新建商品
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 11:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NewGoodsActivity : BaseUpImgActivity<NewGoodsContract.Present>(),NewGoodsContract.View {

    var mColors = ""
    var mSpecs = ""
    var mMaterials = ""
    var mCategoryId = ""
    var mImgs = ""

    override fun getActivityLayoutId(): Int = R.layout.activity_new_goods

    override fun createPresenter(): NewGoodsContract.Present {
        return NewGoodsPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.new_create_goods)
        imv_cost_price.et_input_msg.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        imv_retail_price.et_input_msg.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
    }

    override fun initEvent() {
        nll_goods_category.setOnClickListener {
            CategoryActivity.startCategory(this,CategoryActivity.TYPE_SELECT)
        }
        nll_goods_material.setOnClickListener { SelectActivity.startSelect(this,SelectActivity.SELECT_MATERIAL) }
        nll_goods_size.setOnClickListener { SelectActivity.startSelect(this,SelectActivity.SELECT_SIZE) }
        ll_goods_color.setOnClickListener { SelectActivity.startSelect(this,SelectActivity.SELECT_COLOR) }
        ll_select_img.setOnClickListener { showChooseDialog() }
        stv_goods_save.setOnClickListener {
            getPresenter().newGoods(imv_goods_name.getInputContent(),mCategoryId,imv_goods_sn.getInputContent(),
                    imv_cost_price.getInputContent(),imv_retail_price.getInputContent(),imv_remark.getInputContent(),
                    mColors,mSpecs,mMaterials,mImgs,imv_goods_pack.getInputContent())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SelectActivity.REQUEST_CODE && resultCode == SelectActivity.RESULT_CODE && data != null){
            val type = data.getIntExtra("select_type", SelectActivity.SELECT_COLOR)
            val content = data.getStringExtra("select_content")
            val id = data.getStringExtra("select_id")
            //颜色  规格 材质
            setContent(type,content,id)
        }else if (requestCode == 0x11 && resultCode == 0x12){
            val name = data?.getStringExtra("category_name") ?: ""
            mCategoryId = data?.getStringExtra("category_id") ?: ""
            nll_goods_category.setCustomTxt(name)
        }
    }

    /**
     * 选择图片的结果
     */
    override fun imgResult(result: TResult) {
        iv_goods_img.setImageURI(Uri.fromFile(File(result.images[0].compressPath)))
        mImgs = EncodeUtils.base64Encode2String(File(result.images[0].compressPath).readBytes())
    }

    /**
     * 设置颜色，规格，材质
     */
    fun setContent(type : Int,content:String,id:String){
        when(type){
            SelectActivity.SELECT_COLOR -> {
                mColors = id
                ll_select_colors.removeAllViews()
                if (content.isEmpty()) return
                val split = content.split("/")
                for (i in split){
                    ll_select_colors.addView(getCircleImg(i))
                }
            }
            SelectActivity.SELECT_MATERIAL -> {
                mMaterials = content
                nll_goods_material.setCustomTxt(content)
            }
            SelectActivity.SELECT_SIZE -> {
                mSpecs = id
                nll_goods_size.setCustomTxt(content)
            }
        }
    }

    /**
     * 圆形颜色view
     */
    fun getCircleImg(color:String) : View{
        val circleImageView = CircleImageView(this)
        val layoutParams = LinearLayout.LayoutParams(ConvertUtils.dp2px(18f), ConvertUtils.dp2px(18f))
        layoutParams.rightMargin = ConvertUtils.dp2px(4f)
        circleImageView.layoutParams = layoutParams
        circleImageView.setImageDrawable(ColorDrawable(ColorUtils.string2Color(color)))
        return circleImageView
    }
}