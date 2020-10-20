package com.klossteles.aula22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val chats: List<Chat>): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val txtName by lazy { view.findViewById(R.id.txtName) as TextView }
        private val txtResume by lazy { view.findViewById(R.id.txtResume) as TextView }
        private val txtTime by lazy { view.findViewById(R.id.txtTime) as TextView }

        fun bind(chat: Chat) {
            txtName.text = chat.nome
            txtTime.text = chat.hora
            txtResume.text = chat.resumo
        }
    }

    // Inflar o xml (a linha)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return MeuViewHolder(view)
    }

    // Vai ser chamado a cada item do dataset
    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    // Quantidade de items do meu dataset
    override fun getItemCount() = chats.size
}