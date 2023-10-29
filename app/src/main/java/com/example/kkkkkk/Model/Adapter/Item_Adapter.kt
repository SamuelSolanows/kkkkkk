package com.example.kkkkkk.Model.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kkkkkk.Model.Models.Sexo
import com.example.kkkkkk.Model.Models.Usuario
import com.example.kkkkkk.databinding.ItemAdapterBinding

class Item_Adapter(var lista: MutableList<Sexo>, var list2: MutableList<Usuario>) :
    RecyclerView.Adapter<Item_Adapter.Holder>() {
    inner class Holder(var binding: ItemAdapterBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemAdapterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var item = lista[position]
        var usuario = list2[position]
        var binding = holder.binding
        binding.apply {
            txtname.text = item.ID.toString()
            txtapellido.text = item.Nombre

            txtnose.text = usuario.Nombre
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}