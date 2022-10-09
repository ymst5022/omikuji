package jp.wings.nikkeidp.omikuji

import android.hardware.SensorEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import java.util.*

class OmikujiBox : Animation.AnimationListener {

    var beforeTime = 0L
    var beforeValue = 0F

    lateinit var omikujiButton: Button
    lateinit var omikujiView: ImageView

    var finish = false // 箱から出たか？
    val number: Int //くじ番号(0~19の乱数)

        get() {
            val rnd = Random()
            return rnd.nextInt(20)
        }

    fun shake() {
        val translate = TranslateAnimation(0f, 0f, 0f, -200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100

        var rotate =
            RotateAnimation(0f, -36f, omikujiView.width / 2f, omikujiView.height / 2f)
        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(rotate)
        set.addAnimation(translate)

        set.setAnimationListener(this)

        omikujiView.startAnimation(set)
    }

    fun chkShake(event: SensorEvent?): Boolean {

        val nowtime = System.currentTimeMillis()
        val difftime: Long = nowtime - beforeTime
        val nowvalue: Float = (event?.values?.get(0) ?: 0F) + (event?.values?.get(1) ?: 0F)

        if (1500 < difftime) {

            // 前回の値との差からスピードを計算
            val speed = Math.abs(nowvalue - beforeValue) / difftime * 10000
            beforeTime = nowtime
            beforeValue = nowvalue

            // 50を超えるスピードでシェイクしたとみなす
            if (50 < speed) {
                return true
            }
        }
        return false
    }

    override fun onAnimationStart(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
        omikujiView.setImageResource(R.drawable.omikuji2)
        omikujiButton.setText(R.string.bt_result)
        omikujiButton.visibility = View.VISIBLE
        finish = true
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }
}