package com.androidsolutions.activitytofragment.view

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidsolutions.activitytofragment.view.ChatFragment
import com.androidsolutions.activitytofragment.view.StatusFragment

class VPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

    var fragList = arrayListOf(ChatFragment(), StatusFragment())

    override fun getItemCount() = fragList.size

    override fun createFragment(position: Int) = fragList[position]

}