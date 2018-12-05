package com.micropole.inventorysystem.ui.personal.inventory

import android.graphics.Color
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.RegexUtils
import com.micropole.inventorysystem.R
import com.micropole.inventorysystem.R.id.tv_right
import com.micropole.inventorysystem.ui.personal.inventory.mvp.AddColorContract
import com.micropole.inventorysystem.ui.personal.inventory.mvp.present.AddColorPresent
import com.micropole.inventorysystem.util.ColorUtils
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_add_color.*
import kotlinx.android.synthetic.main.view_input_message.view.*
import kotlinx.android.synthetic.main.view_title.*

/**
 * @ClassName       AddColorActivity
 * @Description     添加新颜色
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/11/21 17:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AddColorActivity : BaseMvpActivity<AddColorContract.Presente>(),AddColorContract.View {

    private val COLOR_REGEX = "^#[0-9a-fA-F]+"

    var colorR = 0
    var colorG = 0
    var colorB = 0
    var colorA = 255

    override fun getActivityLayoutId(): Int = R.layout.activity_add_color

    override fun createPresenter(): AddColorContract.Presente {
        return AddColorPresent()
    }

    override fun initData() {
        setTitleText(res = R.string.new_create_color)
        tv_right.setText(R.string.save_txt)
        initTemlate()
        initInput()
    }

    override fun initEvent() {
        idWatcherListner()

        tv_right.setOnClickListener {
            getPresenter().addcolor(tv_color_name.text.toString(),tv_color_id.text.toString())
        }
    }

    /**
     * r,g,b,a 输入 0-255
     */
    fun initInput(){
        imv_color_r.setInputType(InputType.TYPE_CLASS_NUMBER)
        imv_color_g.setInputType(InputType.TYPE_CLASS_NUMBER)
        imv_color_b.setInputType(InputType.TYPE_CLASS_NUMBER)
        imv_color_a.setInputType(InputType.TYPE_CLASS_NUMBER)

        imv_color_r.et_input_msg.addTextChangedListener(addWatcher(0))
        imv_color_g.et_input_msg.addTextChangedListener(addWatcher(1))
        imv_color_b.et_input_msg.addTextChangedListener(addWatcher(2))
        imv_color_a.et_input_msg.addTextChangedListener(addWatcher(3))

        imv_color_name.et_input_msg.addTextChangedListener(object : TextWatcher {   //颜色名称
            override fun afterTextChanged(s: Editable?) {
                tv_color_name.text = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun addWatcher(type : Int) : TextWatcher{
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) return
                val i = s?.toString()?.toInt()
                if (i != null && i >= 0 && i <= 255){
                    imv_color_id.setInputContent("")
                    when(type){
                        0 -> colorR = i
                        1 -> colorG = i
                        2 -> colorB = i
                        3 -> colorA = i
                    }
                    changeRgb(ColorUtils.rgb2String(colorR,colorG,colorB,colorA))
                }else{
                    s?.delete(0,s.length)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
    }

    /**
     * rgb改变
     */
    fun changeRgb(text : String){
        iv_color_bg.setBackgroundColor(ColorUtils.string2Color(text))
        tv_color_id.text = text
    }

    /**
     * 色码值监听
     */
    fun idWatcherListner(){
        var isInput = true  //输入是否正确
        var index = 0
        imv_color_id.et_input_msg.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) return
                if (!isInput) {
                    s?.delete(index,s.length)
                    showToast(getString(R.string.check_sure_color_id))
                }else{
                    if (s?.length == 4 || s?.length == 7 || s?.length == 9){
                        changeRgb(s.toString())
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()){
                    return
                }
                index = start
                when(start){
                    0 -> {
                        if (s?.length == 1 && s.toString() == "#"){
                            isInput = true
                            initRGB()
                        }else if (RegexUtils.isMatch(COLOR_REGEX,s)){
                            isInput = true
                            initRGB()
                        }else{
                            isInput = false
                        }
                    }
                    1,2,3,4,5,6,7,8 -> {
                        isInput = RegexUtils.isMatch(COLOR_REGEX,s)
                    }
                    else -> isInput = false
                }
            }
        })
    }

    fun initRGB(){
        imv_color_r.setInputContent("")
        imv_color_g.setInputContent("")
        imv_color_b.setInputContent("")
        imv_color_a.setInputContent("")
        iv_color_bg.setBackgroundColor(Color.WHITE)
    }

    /**
     * 初始化 以模板创建
     */
    fun initTemlate(){
        val data = arrayListOf(Color.RED,Color.BLUE,Color.GREEN,Color.GRAY,Color.BLACK,Color.YELLOW,Color.WHITE)
        for (i in data){
            ll_color_template.addView(createTemplateView(i))
        }
    }

    fun createTemplateView(color : Int) : View{
        val frameLayout = FrameLayout(this)
        val flparams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        frameLayout.setPadding(0,ConvertUtils.dp2px(14f),0,ConvertUtils.dp2px(14f))
        frameLayout.layoutParams = flparams

        val circleImageView = CircleImageView(this)
        val cvParams = FrameLayout.LayoutParams(ConvertUtils.dp2px(18f), ConvertUtils.dp2px(18f))
        circleImageView.setBackgroundColor(color)
        frameLayout.addView(circleImageView,cvParams)

        val textView = TextView(this)
        val tvParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        tvParams.gravity = Gravity.RIGHT
        textView.textSize = 15f
        textView.setTextColor(resources.getColor(R.color.title_color))
        textView.text = ColorUtils.color2String(color)
        frameLayout.addView(textView,tvParams)

        frameLayout.setOnClickListener {
            createMB(ColorUtils.color2String(color))
        }

        return frameLayout
    }

    private fun createMB(color: String) {
        initRGB()
        changeRgb(color)
        imv_color_id.setInputContent(color)
        tv_color_name.text = ""
        imv_color_name.setInputContent("")
    }
}