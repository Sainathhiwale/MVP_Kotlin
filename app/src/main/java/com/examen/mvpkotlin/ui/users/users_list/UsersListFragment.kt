package com.examen.mvpkotlin.ui.users.users_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

import com.examen.mvpkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class UsersListFragment : Fragment() {
    var rv_UserList:RecyclerView ? = null
    var toolbar : Toolbar ? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var  view : View? =inflater.inflate(R.layout.fragment_users_list, container, false)
        rv_UserList = view?.findViewById(R.id.rv_UserList)
        toolbar = view?.findViewById(R.id.toolbar)
        initView()
        return view
    }
    fun initView(){
        toolbar?.setTitle("User List")
        toolbar?.setTitleTextColor(resources.getColor(R.color.colorWhite))
    }
}
