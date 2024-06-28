package com.example.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var listView: ListView
   // private lateinit var arrayList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        listView = view.findViewById(R.id.lstAlumnos)

        // Obtener el array de estudiantes desde los recursos
        val estudiantes = resources.getStringArray(R.array.alumnos)

        // Crear el adaptador con el array de estudiantes
        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, estudiantes)

        // Configurar el adaptador al ListView
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


