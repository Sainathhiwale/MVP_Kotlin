package com.examen.mvpkotlin.ui.users.delete_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.examen.mvpkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class DeleteUserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_user, container, false)
    }

}
