package com.examen.mvpkotlin.ui.users.users_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.adapter.UserListAdapter
import com.examen.mvpkotlin.data.model.UserListInfo

/**
 * A simple [Fragment] subclass.
 */
class UsersListFragment : Fragment() ,UserListContract.UserListView{
    companion object{
        const val TAG ="UsersListFragment"
    }
    var rv_UserList:RecyclerView ? = null
    var toolbar : Toolbar ? = null
    var userListAdapter:UserListAdapter ? = null
    private var presenter: UserListPresenterImpl ? = null
    private var layoutManager: LinearLayoutManager ? = null
    private var userList:UserListInfo.UserListInfoItem ?=null
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
        layoutManager = LinearLayoutManager(activity)
        rv_UserList!!.layoutManager = layoutManager
        presenter = UserListPresenterImpl(this,GetUserListIntractorImpl(activity))
        presenter!!.validateUserListFromServer()
    }



    override fun setUserListInfoData(userListInfoItem: UserListInfo?) {
            if (userListInfoItem!=null){
                for (i in userListInfoItem){
                    Log.d(TAG,""+i)
                }
            }
            userListAdapter = UserListAdapter( activity,userListInfoItem)
            rv_UserList!!.adapter(userListInfoItem)
    }

    override fun onResponseFailure(throwable: Throwable) {
        Toast.makeText(activity,""+throwable.message, Toast.LENGTH_LONG).show()
    }
}

private operator fun Any?.invoke(userListInfoItem: UserListInfo?) {
  if (userListInfoItem!=null){

  }else{

  }
}
