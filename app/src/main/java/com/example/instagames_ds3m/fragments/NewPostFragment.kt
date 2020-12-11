package com.example.instagames_ds3m.fragments

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.Toolbar
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.constants.SharedPreferencesProfile
import com.example.instagames_ds3m.model.Console
import com.example.instagames_ds3m.repository.ConsoleRepository
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NewPostFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var spinnerConsole: AppCompatSpinner
    private var consoleList = listOf<Console>()
    private var spinnerAdapter: ArrayAdapter<Console>? = null
    private lateinit var selectedConsole: Console

    private lateinit var textViewUserName: TextView
    private lateinit var textViewUserEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true) // Essa instrução permite a utilização de menu na toolbar da Fragment

        val view = inflater.inflate(R.layout.fragment_new_post, container, false)

        textViewUserEmail = view.findViewById(R.id.text_view_user_email)
        textViewUserName = view.findViewById(R.id.text_view_user_name)

        textViewUserName.text = SharedPreferencesProfile.getUser(context!!).name
        textViewUserEmail.text = SharedPreferencesProfile.getUser(context!!).email

        // Instanciar o spinner
        spinnerConsole = view.findViewById(R.id.spinner_console)
        spinnerConsole.onItemSelectedListener = this

        // Carregar lista de consoles
        doAsync {
            consoleList = ConsoleRepository().getConsoles()
            uiThread {
                spinnerAdapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, consoleList)
                spinnerConsole.adapter = spinnerAdapter
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

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedConsole = spinnerConsole.selectedItem as Console
        Log.i("console", "${selectedConsole.id} - ${selectedConsole.releaseDate}")
    }


}