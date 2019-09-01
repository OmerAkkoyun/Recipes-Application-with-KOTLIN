package com.omer_akkoyun.yemektarifleri

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_splash.*

class Detay : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var isim = intent.extras?.get("isim")
        var aciklama = intent.extras?.get("aciklama")
        var resim = intent.extras?.get("resim")
        var tarif= intent.extras?.get("tarif")

        tvTarif.setText(tarif.toString())
        resimDetay.setImageResource(resim.hashCode())
        collapsing_toolbar.title = isim.toString()

        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}





