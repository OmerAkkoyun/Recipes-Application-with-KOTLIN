package com.omer_akkoyun.yemektarifleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tumVeriler: ArrayList<YemekVerisi>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verileriHazirla()


        var myBaseAdapter = BaseAdapterSinifi(this, tumVeriler)
        listViewMain.adapter = myBaseAdapter


        listViewMain.setOnItemClickListener { adapterView, view, i, l ->

            //Tıklama olunca yeni aktivity açılsın
            var intent = Intent(this, Detay::class.java)

            //DetayActivitisine veri gönderimi
            intent.putExtra("isim",tumVeriler.get(i).isim)
            intent.putExtra("aciklama",tumVeriler.get(i).aciklama)
            intent.putExtra("resim",tumVeriler.get(i).resim)
            intent.putExtra("tarif",tumVeriler.get(i).tarif)
            startActivity(intent)

        }



    }


    private fun verileriHazirla() {

        tumVeriler = ArrayList<YemekVerisi>()

        var _baslik = resources.getStringArray(R.array.basliklar)
        var _aciklama = resources.getStringArray(R.array.sure)
        var _tarif = resources.getStringArray(R.array.tarif)
        var _resim = arrayOf(
            R.drawable.domatesli_kofte,
            R.drawable.ekmekli_pizza,
            R.drawable.ispanakli_yumurta,
            R.drawable.kiymali,
            R.drawable.krep,
            R.drawable.mantar_sote,
            R.drawable.omlet,
            R.drawable.patates_koftesi,
            R.drawable.patates_salatasi,
            R.drawable.sosisli_makarna,
            R.drawable.sucuklu_yumurta,
            R.drawable.tavuk_kizartma,
            R.drawable.tavuk_sote,
            R.drawable.tereyagli_patates,
            R.drawable.tonbalik_makarna,
            R.drawable.yogurtlu_corba,
            R.drawable.yumurtali_ekmek
        )

        for (i in 0..16) {

            var hazirVeri = YemekVerisi(_baslik[i], _aciklama[i], _resim[i], _tarif[i])


            tumVeriler.add(hazirVeri)
        }


    }

}




