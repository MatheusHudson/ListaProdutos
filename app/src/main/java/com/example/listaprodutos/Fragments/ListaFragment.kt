package com.example.listaprodutos.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listaprodutos.Adapters.ProdutoAdapter
import com.example.listaprodutos.MainViewModel
import com.example.listaprodutos.Model.Notificacao
import com.example.listaprodutos.R
import kotlinx.android.synthetic.main.layout_recycler_produtos.view.*
import kotlinx.android.synthetic.main.recycler_produtos.*
import kotlinx.android.synthetic.main.recycler_produtos.view.*


class ListaFragment : Fragment(), ProdutoAdapter.OnClickProduto {

    private lateinit var listaProduto: ArrayList<Notificacao>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: MainViewModel by viewModels()
         listaProduto = viewModel.getProdutosLista()
        val adapter = ProdutoAdapter(listaProduto, this)

        view.recycler.adapter = adapter
        view.recycler.layoutManager = LinearLayoutManager(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.layout_recycler_produtos, container, false)

        return view
    }

    override fun onClickProduto(position: Int) {

    }

    override fun onDestroy() {
        (activity as AppCompatActivity).supportActionBar?.hide()
        super.onDestroy()
    }
}