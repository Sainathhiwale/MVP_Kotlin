package com.examen.mvpkotlin.ui.users.update_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.examen.mvpkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class UpdateUserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_user, container, false)
    }

}
