package com.example.dbwithlivedata

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    lateinit var adapter:ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn=findViewById<Button>(R.id.add)
        btn.setOnClickListener{
            /*val dialog=NewDialog()
            dialog.show(supportFragmentManager,"")*/
            val string=findViewById<EditText>(R.id.editText2).text.toString()
            GlobalScope.launch {
                launch {
                        viewModel.insertUser(User(0,string))
                }
            }

        }



        val recyclerView=findViewById<RecyclerView>(R.id.recycler)
        viewModel= ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.getAllUserObservers().observe(this, Observer {
                    adapter.setData(ArrayList(it))
                    adapter.notifyDataSetChanged()
        })
        //adapter=ListAdapter(viewModel.getAllUsers())
        //adapter= viewModel.getAllUserObservers().value?.let { ListAdapter(it) }!!
        val manager=LinearLayoutManager(this)
        adapter= ListAdapter()
        recyclerView.adapter=adapter
        recyclerView.layoutManager=manager

        /*GlobalScope.launch {
            launch {
                var name="Hello"
                    repeat(10){
                    //delay(1000)name+="Hello"
                    viewModel.insertUser(User(0,name))
                }
            }
        }*/
        println(viewModel.getAllUserObservers().value)
    }
}