package com.micropole.inventorysystem.ui.personal.mine

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DateTimePicker
import com.blankj.utilcode.util.EncodeUtils
import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.entity.ImgUpBean
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.PersonalMsgContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.PersonalMsgPresent
import com.micropole.inventorysystem.widght.NickNameDialog
import com.micropole.inventorysystem.widght.SexDialog
import com.xx.baseutilslibrary.extensions.loadImag
import kotlinx.android.synthetic.main.activity_personal_msg.*
import org.devio.takephoto.model.TResult
import java.io.File
import java.util.*

/**
 * @ClassName       PersonalMsgActivity
 * @Description     个人信息设置
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:14
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalMsgActivity : BaseUpImgActivity<PersonalMsgPresent>(),PersonalMsgContract.View{
    lateinit var img:String
    override fun getImg(img: ImgUpBean) {
        this.img=img.imgUrl
        getPresenter().settringInfo("","",img.imgUrl,"",5)
    }

    override fun imgResult(result: TResult) {
//        iv_hand.setImageURI(Uri.fromFile(File(result.images[0].compressPath)))
        var imgs = EncodeUtils.base64Encode2String(File(result.images[0].compressPath).readBytes())
        getPresenter().getImg(imgs)


    }

    override fun getData(index: Int) {
        when(index){
            1->{
                if (nickName!=null) ul_name.setCustomTxt(nickName.content)
            }
            2->{
                if (sexDialog!=null) ul_sex.setCustomTxt("男")
            }
            3->{
                if (sexDialog!=null) ul_sex.setCustomTxt("女")
            }
            4->{
                if (!bri.isNullOrEmpty()) ul_bir.setCustomTxt(bri)
            }
            5->{
                iv_hand.loadImag(img)
            }
        }
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter()=PersonalMsgPresent()

    override fun getActivityLayoutId(): Int  = R.layout.activity_personal_msg

    override fun initData() {
        setTitleText(res = R.string.personal_mine_message)
        ul_name.setCustomTxt(intent.getStringExtra("nickName"))
        if (intent.getStringExtra("sex").equals("1")){
            ul_sex.setCustomTxt("女")
        }else{
            ul_sex.setCustomTxt("男")
        }
        ul_bir.setCustomTxt(intent.getStringExtra("bir"))
        iv_hand.loadImag(intent.getStringExtra("handImg"))

    }
    lateinit var nickName:NickNameDialog
    lateinit var sexDialog:SexDialog
    override fun initEvent() {
        ul_name.setOnClickListener {
             nickName=NickNameDialog(this)
            nickName.show()
            nickName.setOnBtnClickListener(object : NickNameDialog.OnBtnClickListener {
                override fun cancel() {
                    nickName.dismiss()
                }

                override fun sure() {
                    getPresenter().settringInfo(nickName.content,"","","",1)
                    nickName.dismiss()
                }
            })
        }
        ul_sex.setOnClickListener {
            sexDialog= SexDialog(this)
            sexDialog.show()
            sexDialog.setOnBtnClickListener(object : SexDialog.OnBtnClickListener{
                override fun cancel() {
                    sexDialog.dismiss()
                }

                override fun one() {
                    getPresenter().settringInfo("","2","","",2)
                    sexDialog.dismiss()
                }

                override fun two() {
                    getPresenter().settringInfo("","1","","",3)
                    sexDialog.dismiss()
                }

            })
        }
        ul_bir.setOnClickListener {
            showDatePicker()
        }
        ll_hand.setOnClickListener {
            showChooseDialog()
        }

    }
    var bri=""
    fun showDatePicker(){
        val datePicker = DatePicker(this, DateTimePicker.YEAR_MONTH_DAY)
        datePicker.setRangeStart(1980,1,1)
        val myear = Calendar.getInstance().get(Calendar.YEAR)
        val mmonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        val mday = Calendar.getInstance().get(Calendar.DATE)
        datePicker.setRangeEnd(myear,mmonth,mday)

        datePicker.setOnDatePickListener(object : DatePicker.OnYearMonthDayPickListener {
            override fun onDatePicked(year: String?, month: String?, day: String?) {
                bri="${year}-${month}-$day"
                getPresenter().settringInfo("","","","${year}-${month}-$day",4)
            }
        })
        datePicker.show()
    }

    companion object {
        fun startPersonalMsgActivity(context: Context,nickName:String,sex:String,bir:String,handImg:String){
            var intent=Intent(context,PersonalMsgActivity::class.java)
            intent.putExtra("nickName",nickName)
            intent.putExtra("sex",sex)
            intent.putExtra("bir",bir)
            intent.putExtra("handImg",handImg)
            context.startActivity(intent)

        }
    }

}