package com.example.close_by_home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.close_by_home.R
import com.example.close_by_home.adapters.FuncionarioAdapter
import com.example.close_by_home.models.Funcionario

class AgendaFragment : Fragment() {

    lateinit var funcionarioAdapter: FuncionarioAdapter

    private val funcionarios = mutableListOf<Funcionario>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val colecoes : RecyclerView = view.findViewById(R.id.rvFuncionarios)
        funcionarioAdapter = FuncionarioAdapter(funcionarios, view.context)

        val layoutManager = LinearLayoutManager(view.context)

        colecoes.layoutManager = layoutManager
        colecoes.adapter = funcionarioAdapter

        preencherLista()
    }

    private fun preencherLista() {

        funcionarios.clear()
        funcionarios.add(Funcionario(1, "Julio Cézar", "Mecânico","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11968579719"))
        funcionarios.add(Funcionario(2, "Ana Júlia", "Babá","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11934951010"))
        funcionarios.add(Funcionario(3, "Robson Mendes", "Serviços Gerais","https://guides.codepath.com/images/logos/codepath.svg?1684262685", "11940028922"))


        funcionarioAdapter.notifyDataSetChanged()
    }
}