package com.example.listaprodutos.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.listaprodutos.R
import kotlinx.android.synthetic.main.layout_login.view.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.buttonEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_listaFragment)
        }

        return  view
    }


}