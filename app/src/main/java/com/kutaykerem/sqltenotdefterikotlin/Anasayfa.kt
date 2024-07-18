package com.kutaykerem.sqltenotdefterikotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.kutaykerem.sqltenotdefterikotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

private lateinit var binding: ActivityMainBinding

var notArrayList = ArrayList<NotDetails>()



class Anasayfa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)








        try{
            var sqlDatabase = openOrCreateDatabase("Notlarım",MODE_PRIVATE,null)

            var cursor =  sqlDatabase.rawQuery("SELECT * FROM notlarım",null)

            var notIx = cursor.getColumnIndex("notum")
            var idIx = cursor.getColumnIndex("id")
            var tarihIx = cursor.getColumnIndex("tarih")


            while (cursor.moveToNext()){
                var notum = cursor.getString(notIx)
                var notDetails = NotDetails(notum,idIx,tarihIx)
                notArrayList.add(notDetails)
            }

        }catch (e:Exception){
            e.printStackTrace()
        }



        val adaptor = AdaptorNotlar(notArrayList)
        recyclerView.adapter = adaptor
        recyclerView.layoutManager = LinearLayoutManager(this)

        adaptor.notifyDataSetChanged()


    }

    fun addimage(view: View){
        var intent = Intent(applicationContext,AddNot::class.java)
        startActivity(intent)
    }












}