package com.example.home_pc.hw_retrofit.ui.mainactivity.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home_pc.hw_retrofit.model.StudentData
import com.example.home_pc.hw_retrofit.ui.mainactivity.view.adapter.UserDataAdapter
import com.example.home_pc.hw_retrofit.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val repository = Repository()
    val adapter  = UserDataAdapter(this)
    var listItems = MutableLiveData<ArrayList<StudentData>>()   //MutableLiveData


    fun addUserDataList(){
        repository.getClient().getUserByName("andrey241991").enqueue(object :
            Callback<StudentData> {
            override fun onFailure(call: Call<StudentData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<StudentData>, response: Response<StudentData>) {
                if(response.isSuccessful){
                    Log.v("TAG", "listItems =" + listItems)
                    var studentData = response.body()
                    Log.v("TAG", "studentData =" + studentData)
                    if (studentData != null && listItems !=null) {
                        listItems.value?.add(studentData) ?: Log.v("TAG", "IS NULL")
                    }

                }
            }
        })
    }

    fun onBindRepositoryRowViewAtPosition(position: Int, viewHolder: UserDataAdapter.ViewHolder) {
            var currentUserData = listItems.value?.get(position) ?: return
            viewHolder.bindAvatar(currentUserData.avatar_url)
            viewHolder.bindLogin(currentUserData.login)
            viewHolder.bindId(currentUserData.id.toString())
    }

    fun onItemClicked(position: Int) {

    }

}