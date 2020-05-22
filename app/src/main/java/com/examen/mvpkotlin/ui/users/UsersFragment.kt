package com.examen.mvpkotlin.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.adapter.ViewPagerAdapter
import com.examen.mvpkotlin.ui.home.HomeFragment
import com.examen.mvpkotlin.ui.users.delete_user.DeleteUserFragment
import com.examen.mvpkotlin.ui.users.get_user.GetUserFragment
import com.examen.mvpkotlin.ui.users.update_user.UpdateUserFragment
import com.examen.mvpkotlin.ui.users.users_list.UsersListFragment
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class UsersFragment : Fragment(), View.OnClickListener {
    var cv_User_List:CardView ? = null
    var cv_GetUser: CardView  ? = null
    var cv_DeleteUser :CardView ? = null
    var cv_UpdateUser : CardView  ? = null
    var toolbar: Toolbar? = null
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_users, container, false)
        cv_User_List = view?.findViewById(R.id.cv_User_List)
        cv_GetUser = view?.findViewById(R.id.cv_GetUser)
        cv_DeleteUser = view?.findViewById(R.id.cv_DeleteUser)
        cv_UpdateUser = view?.findViewById(R.id.cv_UpdateUser)
        toolbar = view?.findViewById(R.id.toolbar)

        // onclicklistener
        cv_User_List?.setOnClickListener(this)
        cv_GetUser?.setOnClickListener(this)
        cv_DeleteUser?.setOnClickListener(this)
        cv_UpdateUser?.setOnClickListener(this)
        initView()
        return view
    }
    fun initView(){
        toolbar?.setTitle("User")
        toolbar?.setTitleTextColor(resources.getColor(R.color.colorWhite))
    }

    override fun onClick(p0: View?) {
        val ids = p0?.id
        when(ids){
            R.id.cv_User_List ->{
                val userListFragment:UsersListFragment = UsersListFragment()
                val transition = fragmentManager?.beginTransaction()
                transition?.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                transition?.replace(R.id.main_container,userListFragment)
                transition?.addToBackStack(null)
                transition?.commit()
            }
            R.id.cv_GetUser ->{
                val getUserFragment:GetUserFragment = GetUserFragment()
                val transition = fragmentManager?.beginTransaction()
                transition?.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                transition?.replace(R.id.main_container,getUserFragment)
                transition?.addToBackStack(null)
                transition?.commit()
            }
            R.id.cv_DeleteUser ->{
                val deleteUserFragment:DeleteUserFragment = DeleteUserFragment()
                val transition = fragmentManager?.beginTransaction()
                transition?.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                transition?.replace(R.id.main_container,deleteUserFragment)
                transition?.addToBackStack(null)
                transition?.commit()
            }
            R.id.cv_UpdateUser ->{
                val updateUserFragment:UpdateUserFragment = UpdateUserFragment()
                val transition = fragmentManager?.beginTransaction()
                transition?.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                transition?.replace(R.id.main_container,updateUserFragment)
                transition?.addToBackStack(null)
                transition?.commit()
            }
        }
    }


}
