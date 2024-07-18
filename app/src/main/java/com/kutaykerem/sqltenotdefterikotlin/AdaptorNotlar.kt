package com.kutaykerem.sqltenotdefterikotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kutaykerem.sqltenotdefterikotlin.databinding.RecyclerRowKaydedilennotlarBinding
import kotlinx.android.synthetic.main.recycler_row_kaydedilennotlar.view.*

class AdaptorNotlar(val arrayNotlar : ArrayList<NotDetails>) : RecyclerView.Adapter<AdaptorNotlar.NotlarHolder>() {


    class NotlarHolder(var binding:View) : RecyclerView.ViewHolder(binding.rootView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotlarHolder {
        val binding = RecyclerRowKaydedilennotlarBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotlarHolder(binding.root)

    }

    override fun onBindViewHolder(holder: NotlarHolder, position: Int) {
        holder.binding.textNot.text = arrayNotlar.get(position).Notlar
        holder.binding.textTarih.text = arrayNotlar.get(position).tarih.toString()

        holder.binding.cardview.setOnClickListener { view->
            var kaydedilmisNot = arrayNotlar.get(position).Notlar

            var intent = Intent(view.context,AddNot::class.java)
            intent.putExtra("kaydedilmisNot",kaydedilmisNot)
            view.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return arrayNotlar.size
    }

}