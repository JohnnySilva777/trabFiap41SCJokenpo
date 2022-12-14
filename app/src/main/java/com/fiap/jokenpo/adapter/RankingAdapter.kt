package com.fiap.jokenpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fiap.jokenpo.R
import com.fiap.jokenpo.model.Jogador
import kotlinx.android.synthetic.main.ranking_card.view.*

class RankingAdapter(private val jogadores: List <Jogador>,
                     private val context: Context,
                     private val listener: (Jogador) -> Unit): RecyclerView.Adapter <RankingAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jogadorPosition = jogadores[position]
        holder.let{
            it.bindView(jogadorPosition,listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(context).inflate(
                R.layout.ranking_card,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jogadores.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindView (jogador : Jogador,
                      listener: (Jogador) -> Unit) = with(itemView){
            val tvNome = tvNome
            val tvTitulo = tvTitulo
            val tvPontos = tvPontos

            //Para colocar imagem do usuario
            ivUser.setImageDrawable(ContextCompat.getDrawable(this.context,R.drawable.user))
            tvNome.text = jogador.nome
            tvPontos.text = jogador.pontos.toString()
            tvTitulo.text = "PONTUAÇÃO"

            setOnClickListener{listener(jogador)}
        }
    }
}