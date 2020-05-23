package com.examen.mvpkotlin.ui.users.get_user

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.examen.kotlinretrofit.utils.NetworkUtils
import com.examen.mvpkotlin.utils.AppConstants
import com.google.android.material.snackbar.Snackbar
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class GetUserFragment : Fragment() {
    var const_userDtlsLayout: ConstraintLayout ? = null
    var btn_Cancel :Button ? = null
    var btn_Update :Button ? = null
    var et_UserId: EditText ? = null
    var tv_UserId: TextView ? = null
    var tv_UserName: TextView ? = null
    var tv_UserPassword: TextView ? = null
    var toolbar: Toolbar? = null
    private var presenter:UserContractPresenterImpl ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =inflater.inflate(R.layout.fragment_get_user, container, false)
        btn_Cancel = view.findViewById(R.id.et_UserId) as Button
        btn_Update = view.findViewById(R.id.et_UserId) as Button
        et_UserId = view.findViewById(R.id.et_UserId) as EditText
        tv_UserId = view.findViewById(R.id.et_UserId) as TextView
        tv_UserName = view.findViewById(R.id.et_UserId) as TextView
        tv_UserPassword = view.findViewById(R.id.et_UserId) as TextView
        toolbar = view.findViewById(R.id.toolbar)
        const_userDtlsLayout = view.findViewById(R.id.const_userDtlsLayout)
        initView()
        return view
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initView(){
        toolbar!!.setTitle("Get User")
        toolbar?.setTitleTextColor(resources.getColor(R.color.colorWhite))
        et_UserId!!.setOnKeyListener(View.OnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    KeyEvent.KEYCODE_BACK, KeyEvent.KEYCODE_DPAD_CENTER -> return@OnKeyListener true
                    KeyEvent.KEYCODE_ENTER -> {
                        (Objects.requireNonNull(Objects.requireNonNull(activity)!!.getSystemService(Context.INPUT_METHOD_SERVICE)) as InputMethodManager)
                            .hideSoftInputFromWindow(et_UserId!!.getWindowToken(), 0)
                        if (et_UserId!!.getText().toString().trim({ it <= ' ' }) != AppConstants.EMPTY) {
                             if (NetworkUtils().isNetworkConnected(activity))
                                 presenter =
                                     UserContractPresenterImpl(this@GetUserFragment,
                                         GetUserIntractorImpl(activity,  et_UserId!!.text.toString().trim().toInt()))
                               /*  presenter = UserContractPresenterImpl(GetUserFragment::,GetUserIntractorImpl(activity,et_UserId.text.toString().trim()))
                                presenter!!.validateUserDtslFromServer()*/
                            } else {
                                val snackbar = Snackbar.make(const_userDtlsLayout!!, "Please check internet connection try again!", Snackbar.LENGTH_SHORT)
                                val view1 = snackbar.view
                                val textView = view1.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
                                textView.setTextColor(Color.RED)
                                snackbar.show()
                            }
                        } else {
                            SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Oops..")
                                .setContentText("Please scan Barcode!")
                                .setConfirmClickListener { sDialog ->
                                    et_ScnItemBrCode.setText("")
                                    et_ScnItemBrCode.requestFocus()
                                    sDialog.dismissWithAnimation()
                                }
                                .show()
                        }
                        return@OnKeyListener true
                    }
                    KeyEvent.KEYCODE_DPAD_RIGHT -> return@OnKeyListener true
                }
            }
            false
        })

    }

}
