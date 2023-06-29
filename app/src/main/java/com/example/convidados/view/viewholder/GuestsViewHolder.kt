package com.example.convidados.view.viewholder


import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel
import com.example.convidados.view.listerner.OnGuestListener

class GuestsViewHolder(private val bind: RowGuestBinding,private val listener: OnGuestListener) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel){
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener { //esse set onLong é se vc manter pressionado

            //um poopup que abre na tela exibindo um alerta
            androidx.appcompat.app.AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover esse convidado?")
                .setPositiveButton("Sim") { dialog, which ->  listener.onDelete(guest.id) }
                .setNegativeButton("Não", null)
                .create()
                .show()

            true}

    }

}