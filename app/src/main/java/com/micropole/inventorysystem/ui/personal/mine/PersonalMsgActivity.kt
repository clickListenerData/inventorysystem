package com.micropole.inventorysystem.ui.personal.mine

import android.content.Context
import android.content.Intent
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.ui.personal.mine.mvp.contract.PersonalMsgContract
import com.micropole.inventorysystem.ui.personal.mine.mvp.present.PersonalMsgPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity

/**
 * @ClassName       PersonalMsgActivity
 * @Description     个人信息设置
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/22 10:14
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class PersonalMsgActivity : BaseMvpActivity<PersonalMsgPresent>(),PersonalMsgContract.View{
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter()=PersonalMsgPresent()

    override fun getActivityLayoutId(): Int  = R.layout.activity_personal_msg

    override fun initData() {
        setTitleText(res = R.string.personal_mine_message)
    }

    override fun initEvent() {
    }
    companion object {
        fun startPersonalMsgActivity(context: Context,nickName:String,sex:String,bir:String,handImg:String){
            var intent=Intent(context,PersonalMsgActivity::class.java)
            intent.putExtra("nickName",nickName)
            intent.putExtra("sex",sex)
            intent.putExtra("bir",bir)
            intent.putExtra("handImg",handImg)

        }
    }

}