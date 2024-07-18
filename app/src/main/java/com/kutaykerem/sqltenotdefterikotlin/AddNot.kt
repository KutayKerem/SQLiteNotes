package com.kutaykerem.sqltenotdefterikotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kutaykerem.sqltenotdefterikotlin.databinding.ActivityAddNotBinding
import com.kutaykerem.sqltenotdefterikotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_add_not.*

class AddNot : AppCompatActivity() {


    private lateinit var binding: ActivityAddNotBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var intent = intent

        if(intent.getStringExtra("kaydedilmisNot") != null){
            kaydet.visibility = View.INVISIBLE
            var not = intent.getStringExtra("kaydedilmisNot").toString()
            textKaydedilmisNot.text = "${not}"

        }




    }


    fun kaydet(view: View){



        var not = textnotekle.text.toString()

        if(not.isEmpty()){
            Toast.makeText(applicationContext,"Lütfen bir metin giriniz",Toast.LENGTH_SHORT).show()

        }
        else{
            var sqlDatabase = openOrCreateDatabase("Notlarım",Context.MODE_PRIVATE,null)

            sqlDatabase.execSQL("CREATE TABLE IF NOT EXISTS notlarım (id INTEGER PRIMARY KEY,notum VARCHAR)")

            val sqlString = "INSERT INTO notlarım (notum) VALUES (1)"
            val statemnt = sqlDatabase.compileStatement(sqlString)
            statemnt.bindString(1,not)
            statemnt.execute()




            Toast.makeText(applicationContext,"Kaydedildi",Toast.LENGTH_SHORT).show()
            intent = Intent(applicationContext,Anasayfa::class.java)
            startActivity(intent)

        }




    }



}

