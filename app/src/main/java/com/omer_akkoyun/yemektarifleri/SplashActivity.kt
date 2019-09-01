package com.omer_akkoyun.yemektarifleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        var yukaridanAsagi = AnimationUtils.loadAnimation(this,R.anim.yukaridan_asagi)
        var asagidanyulari = AnimationUtils.loadAnimation(this,R.anim.asagidan_yukari)
        var bulunduguyerdenAsagi = AnimationUtils.loadAnimation(this,R.anim.bulunanyerden_asagi)

        imageView.animation=yukaridanAsagi
        imageView3.animation=asagidanyulari
        button.setOnClickListener {

            imageView3.startAnimation(bulunduguyerdenAsagi)


            //Animasyon bitmeden 1sn sonra MainActivity açılsın
            object : CountDownTimer(1000,1000){
                override fun onFinish() {
                    var intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }

                override fun onTick(p0: Long) {
                    //işimiz yok burasıyla
                }

            }.start()



        }

    }
}
