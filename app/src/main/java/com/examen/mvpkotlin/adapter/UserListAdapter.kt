package com.examen.mvpkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.data.model.UserListInfo
import com.examen.mvpkotlin.utils.AppConstants

class UserListAdapter(activity: FragmentActivity?, userListInfoItem: UserListInfo?) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
     var context:Context ? = null
     var getUserList: List<UserListInfo.UserListInfoItem>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View? = LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return getUserList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var getUser: UserListInfo.UserListInfoItem = getUserList!!.get(position)
        if (getUser.iD!=0){
            holder.tv_UserId.setText(getUser.iD)
        }else{
            holder.tv_UserId.setText(AppConstants.EMPTY)
        }

            holder.tv_UserName.setText(getUser.userName)

            holder.tv_Password.setText(getUser.password)

    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        var  tv_UserId :TextView = itemView!!.findViewById(R.id.tv_UserId)
        var tv_UserName :TextView = itemView!!.findViewById(R.id.tv_UserName)
        var tv_Password : TextView = itemView!!.findViewById(R.id.tv_Password)
    }
}