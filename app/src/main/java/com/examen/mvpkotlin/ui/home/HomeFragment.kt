package com.examen.mvpkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.ui.users.UsersFragment
import com.sdsmdg.tastytoast.TastyToast

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), View.OnClickListener {
     var cv_Users:CardView?=null
     var cv_Activities:CardView?=null
     var cv_Authors:CardView?=null
     var cv_Books:CardView?=null
     var cv_CoversPhotos:CardView?=null
     var cv_Exits:CardView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View? = inflater.inflate(R.layout.fragment_home, container, false)
        cv_Users = view?.findViewById(R.id.cv_Users)
        cv_Activities = view?.findViewById(R.id.cv_Activities)
        cv_Authors = view?.findViewById(R.id.cv_Authors)
        cv_Books = view?.findViewById(R.id.cv_Books)
        cv_CoversPhotos = view?.findViewById(R.id.cv_CoversPhotos)
        cv_Exits = view?.findViewById(R.id.cv_Exits)
        cv_Users?.setOnClickListener(this)
        cv_Activities?.setOnClickListener(this)
        cv_Authors?.setOnClickListener(this)
        cv_Books?.setOnClickListener(this)
        cv_CoversPhotos?.setOnClickListener(this)
        cv_Exits?.setOnClickListener(this)
        return view;
    }

    override fun onClick(p0: View?) {
        val ids = p0?.id
        when(ids){
            R.id.cv_Users ->{
                val userFragment:UsersFragment = UsersFragment()
                val transition = fragmentManager?.beginTransaction()
                transition?.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                transition?.replace(R.id.main_container,userFragment)
                transition?.addToBackStack(null)
                transition?.commit()
            }
            R.id.cv_Activities ->{
                Toast.makeText(activity,"Activities", Toast.LENGTH_LONG).show()
            }
            R.id.cv_Authors ->{
                Toast.makeText(activity,"Authers", Toast.LENGTH_LONG).show()
            }
            R.id.cv_Books ->{
                Toast.makeText(activity,"Book", Toast.LENGTH_LONG).show()

            }
            R.id.cv_CoversPhotos -> {
                Toast.makeText(activity,"Covers Photos", Toast.LENGTH_LONG).show()
            }
            R.id.cv_Exits ->{
                Toast.makeText(activity,"Exit", Toast.LENGTH_LONG).show()
            }
        }
    }

}


