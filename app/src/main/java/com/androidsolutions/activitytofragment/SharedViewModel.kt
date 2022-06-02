package com.androidsolutions.activitytofragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){

    private val _data = MutableLiveData<DataObj>()
    val data : LiveData<DataObj>
    get() = _data

    private val _chatData = MutableLiveData<DataObj>()
    val chatData : LiveData<DataObj>
        get() = _chatData

    private val _statusData = MutableLiveData<DataObj>()
    val statusData : LiveData<DataObj>
        get() = _statusData

    fun setValue(newData : DataObj){
        _data.value = newData
    }

    fun setChatValue(newData : DataObj){
        _chatData.value = newData
    }

    fun setStatusValue(newData : DataObj){
        _statusData.value = newData
    }

}