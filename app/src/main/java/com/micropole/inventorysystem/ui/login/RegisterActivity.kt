package com.micropole.inventorysystem.ui.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DateTimePicker
import cn.qqtheme.framework.picker.SinglePicker
import com.blankj.utilcode.util.EncodeUtils
import com.micropole.baseapplibrary.activity.BaseUpImgActivity
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.login.mvp.contract.RegisterContract
import com.micropole.inventorysystem.ui.login.mvp.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.view_title.*
import org.devio.takephoto.model.TResult
import java.io.File
import java.util.*

/**
 * @ClassName       RegisterActivity
 * @Description     注册
 * @Author          xiaoguangfei
 * @Sign            。。。
 * @Date            2018/11/19 17:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class RegisterActivity : BaseUpImgActivity<RegisterContract.Presenter>(),RegisterContract.View {

    var imgs = ""

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_register

    override fun createPresenter(): RegisterContract.Presenter {
        return RegisterPresenter()
    }

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=getString(R.string.reg_register)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        rl_select_birth.setOnClickListener { showDatePicker() }
        rl_select_img.setOnClickListener { showChooseDialog() }
        rl_select_country.setOnClickListener { getPresenter().getCountry() }
        tv_getCode.setOnClickListener { getPresenter().sendSMS(et_phone.text.toString()) }
        stv_register.setOnClickListener { getPresenter().register(imgs,et_name.text.toString(),
                tv_country.text.toString(),tv_bri.text.toString(),et_phone.text.toString(),et_code.text.toString(),et_pwd.text.toString() ) }
    }

    fun showDatePicker(){
        val datePicker = DatePicker(this, DateTimePicker.YEAR_MONTH_DAY)
        datePicker.setRangeStart(1980,1,1)
        val myear = Calendar.getInstance().get(Calendar.YEAR)
        val mmonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        val mday = Calendar.getInstance().get(Calendar.DATE)
        datePicker.setRangeEnd(myear,mmonth,mday)

        datePicker.setOnDatePickListener(object : DatePicker.OnYearMonthDayPickListener {
            override fun onDatePicked(year: String?, month: String?, day: String?) {
                tv_bri.text = "$year$month$day"
            }
        })
        datePicker.show()
    }

    override fun imgResult(result: TResult) {
        iv_hand.setImageURI(Uri.fromFile(File(result.images[0].compressPath)))
        imgs = EncodeUtils.base64Encode2String(File(result.images[0].compressPath).readBytes())
    }

    override fun getCountry(data: List<String>) {
        val singlePicker = SinglePicker<String>(this, data)
        singlePicker.setOnItemPickListener { index, item ->
            tv_country.text = item
        }
        singlePicker.show()
    }

    companion object {
        fun startRegisterActivity(context:Context){
            var intent=Intent(context,RegisterActivity::class.java)
            context.startActivity(intent)
        }
    }

}
