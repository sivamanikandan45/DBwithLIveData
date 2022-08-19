package com.example.dbwithlivedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewDialog:DialogFragment() {

    val viewModel:ListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn=view.findViewById<Button>(R.id.add_btn)
        btn.setOnClickListener {
            val string=view.findViewById<TextView>(R.id.editText).text.toString()
            GlobalScope.launch {
                    withContext(Dispatchers.IO){
                        viewModel.insertUser(User(0,string))
                    }
            }
            dismiss()
        }
    }

}