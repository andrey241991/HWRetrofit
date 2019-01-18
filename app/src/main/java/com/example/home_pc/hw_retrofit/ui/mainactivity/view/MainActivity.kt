package com.example.home_pc.hw_retrofit.ui.mainactivity.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.home_pc.hw_retrofit.R
import com.example.home_pc.hw_retrofit.model.StudentData
import com.example.home_pc.hw_retrofit.ui.mainactivity.view.adapter.RecyclerItemDecorator
import com.example.home_pc.hw_retrofit.ui.mainactivity.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val clientId = "b67e0f20c47b02dbe875"
    val clientSecret = "2612058e83b607105ab34c1b1a90318a3edac419"

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener({viewModel.addUserDataList()})
        initAdapter()
        viewModel.addUserDataList()

        val userDataObserver = Observer<MutableList<StudentData>> { newStrings ->
            viewModel.adapter.notifyDataSetChanged()
        }
        viewModel.listItems.observe(this, userDataObserver)
    }

    private fun initAdapter() {
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recycler.adapter = viewModel.adapter
        recycler.addItemDecoration(RecyclerItemDecorator())
    }

}


