package com.example.instagames_ds3m.fragments

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.Toolbar
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.model.Console
import com.example.instagames_ds3m.repository.ConsoleRepository
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NewPostFragment : Fragment() {

    private lateinit var sppinerConsole: AppCompatSpinner
    private var consoleList = listOf<Console>()
    private var spinnerAdapter: ArrayAdapter<Console>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true) // Essa instrução permite a utilização de menu na toolbar da Fragment

        val view = inflater.inflate(R.layout.fragment_new_post, container, false)

        // Instanciar o spinner
        sppinerConsole = view.findViewById(R.id.spinner_console)

        // Carregar lista de consoles
        doAsync {
            consoleList = ConsoleRepository().getConsoles()
            uiThread {
                spinnerAdapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, consoleList)
                sppinerConsole.adapter = spinnerAdapter
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = toolbar
        toolbar.title = "Sua publicação"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_fragment_post_add, menu)
    }


}