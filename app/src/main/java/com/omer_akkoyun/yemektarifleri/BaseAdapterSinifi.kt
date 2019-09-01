package com.omer_akkoyun.yemektarifleri

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.teksatir.view.*
import org.w3c.dom.Text

class BaseAdapterSinifi(context: Context, tumBilgi:ArrayList<YemekVerisi>) : BaseAdapter() {

    var tumveriler: ArrayList<YemekVerisi>
    var contextim: Context//inflater için sadece

    init {
        this.tumveriler =tumBilgi
        this.contextim = context
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {

        var teksatirView = p1
        var viewHolderNesnem: ViewHolder


        if (teksatirView == null) {
            var inflater = LayoutInflater.from(contextim)
            teksatirView = inflater.inflate(R.layout.teksatir, p2, false)
            viewHolderNesnem = ViewHolder(teksatirView)
            teksatirView.tag = viewHolderNesnem
            Log.e("DURUM GOSTERGE ","INFLATE YAPILIYOR =  "+tumveriler.get(p0).isim)
        } else {

            viewHolderNesnem = teksatirView.getTag() as ViewHolder
        }

        viewHolderNesnem.isim.setText(tumveriler.get(p0).isim)
        viewHolderNesnem.aciklama.setText(tumveriler.get(p0).aciklama)
        viewHolderNesnem.resim.setImageResource(tumveriler.get(p0).resim)

        return teksatirView
    }

    override fun getItem(p0: Int): Any {
        return tumveriler.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumveriler.size
    }
}


class ViewHolder(view: View) {

    var isim: TextView
    var aciklama: TextView
    var resim: ImageView


    init {

        this.isim = view.baslikXml
        this.aciklama = view.aciklamaXml
        this.resim = view.resimXml

    }

}