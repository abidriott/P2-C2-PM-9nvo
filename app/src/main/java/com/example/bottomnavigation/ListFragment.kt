package com.example.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class ListFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var arrayList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Verificar si view es nulo (práctica defensiva)
        view ?: return null

        listView = view.findViewById(R.id.lstAlumnos)
        val items = resources.getStringArray(R.array.alumnos)

        arrayList = ArrayList()
        arrayList.addAll(items)
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val alumno: String = parent.getItemAtPosition(position).toString()
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Lista de Alumnos")
            builder.setMessage("$position: $alumno")
            builder.setPositiveButton("OK") { dialog, which ->
                // Aquí puedes agregar la lógica cuando se presiona OK en el diálogo
            }
            builder.show()
        }

        return view
    }
}

