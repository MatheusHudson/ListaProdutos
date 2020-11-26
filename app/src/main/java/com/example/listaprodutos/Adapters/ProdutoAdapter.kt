package com.example.listaprodutos.Adapters

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.listaprodutos.Model.Notificacao
import com.example.listaprodutos.R
import kotlinx.android.synthetic.main.recycler_produtos.*
import kotlinx.android.synthetic.main.recycler_produtos.view.*

class ProdutoAdapter(
    private val listaProduto: ArrayList<Notificacao>,
    var listener: OnClickProduto
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutoAdapter.ProdutoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_produtos, parent, false)
        return ProdutoViewHolder(itemView)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {


        var produto = listaProduto[position]
        var context = holder.imageProduto.context
        var imageId =  context.resources.getIdentifier(produto.imageProduto,"drawable",context.packageName)

        holder.nomeProduto.text =
            Html.fromHtml("<b>${produto.nomeProduto}</b> ${produto.descricaoProduto}", 0)

        holder.imageProduto.setImageResource(imageId)

        holder.layout.setOnClickListener {

            holder.nomeProduto.text=  "${produto.nomeProduto} ${produto.descricaoProduto}"
            holder.layout.setBackgroundColor(context.resources.getColor(R.color.white))
          
        }


    }

    override fun getItemCount() = listaProduto.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var nomeProduto: TextView = itemView.findViewById(R.id.textNomeProduto)
        var imageProduto: ImageView = itemView.findViewById(R.id.imageFoto)
        var layout : ConstraintLayout = itemView.findViewById(R.id.recyclerLayout)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickProduto(position)
            }
        }
    }
    interface OnClickProduto {
        fun onClickProduto(position: Int)
    }

}


