import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.AlumnosAdapter
import com.example.bottomnavigation.DataBase.Alumno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WindowFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: AlumnosAdapter // Asumiendo que tienes un adaptador ya implementado

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_window, container, false)

        // Inicializar RecyclerView
        recyclerView = rootView.findViewById(R.id.recId)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = AlumnosAdapter(emptyList(), object : AlumnosAdapter.OnItemClickListener {
            override fun onItemClick(alumno: Alumno) {
                // Implementa aquí la lógica cuando se haga clic en un alumno
            }
        })
        recyclerView.adapter = adapter

        // Inicializar FloatingActionButton
        fab = rootView.findViewById(R.id.fab)
        fab.setOnClickListener {
            // Implementa aquí la lógica cuando se haga clic en el FAB
            // Por ejemplo, navegar hacia FragmentData
            navigateToDataFragment()
        }

        // Ejemplo de carga inicial de datos (simulado)
        val alumnosList = generateDummyData()
        adapter.updateData(alumnosList)

        return rootView
    }

    private fun navigateToDataFragment() {
        // Implementa aquí la lógica para navegar hacia FragmentData
        val fragment = FragmentData()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Permite volver atrás
            .commit()
    }

    // Método de ejemplo para generar datos ficticios
    private fun generateDummyData(): List<Alumno> {
        val list = mutableListOf<Alumno>()
        // Agrega aquí datos de prueba
        list.add(Alumno("Nombre1", "Especialidad1", "202100001"))
        list.add(Alumno("Nombre2", "Especialidad2", "202100002"))
        list.add(Alumno("Nombre3", "Especialidad3", "202100003"))
        return list
    }
}
