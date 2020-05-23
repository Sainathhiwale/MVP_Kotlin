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
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.data.model.GetUserDtlsInfo
import com.examen.mvpkotlin.utils.AppConstants
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.user_list.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class GetUserFragment : Fragment(), UserContract.UserView {
    var const_userDtlsLayout: ConstraintLayout? = null
    var btn_Cancel: Button? = null
    var btn_Update: Button? = null
    var et_UserId: EditText? = null
    var tv_UserId: TextView? = null
    var tv_UserName: TextView? = null
    var tv_UserPassword: TextView? = null
    var toolbar: Toolbar? = null
    private var presenter: UserContractPresenterImpl? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_get_user, container, false)
        btn_Cancel = view.findViewById(R.id.btn_Cancel)
        btn_Update = view.findViewById(R.id.btn_Update)
        et_UserId = view.findViewById(R.id.et_UserId)
        tv_UserId = view.findViewById(R.id.tv_UserId)
        tv_UserName = view.findViewById(R.id.tv_UserName)
        tv_UserPassword = view.findViewById(R.id.tv_Password)
        toolbar = view.findViewById(R.id.toolbar)
        const_userDtlsLayout = view.findViewById(R.id.const_userDtlsLayout)
        initView()
        initCall()
        return view
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initView(): Boolean {
        toolbar!!.setTitle("Get User")
        toolbar?.setTitleTextColor(resources.getColor(R.color.colorWhite))

       et_UserId!!.setOnKeyListener(View.OnKeyListener { view: View, keyCode: Int, keyEvent: KeyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    R.id.et_UserId -> {
                        if (keyCode == KeyEvent.KEYCODE_ENTER) {
                         if (NetworkUtils().isNetworkConnected(activity)){
                             if (et_UserId!!.text.toString().trim().equals("")){
                                 presenter = UserContractPresenterImpl(this@GetUserFragment,GetUserIntractorImpl(activity,et_UserId!!.text.toString().trim().toInt()))
                                 presenter!!.validateUserDtslFromServer()
                             }else{
                                 SweetAlertDialog(activity,SweetAlertDialog.ERROR_TYPE).setTitleText("Oops..").setContentText("Please Enter User Id!").setConfirmClickListener { mDialog ->
                                     et_UserId!!.setText("")
                                     et_UserId!!.requestFocus() }
                             }
                         }else{
                             val snackbar:Snackbar = Snackbar.make(const_userDtlsLayout!!,"Please check internet connection try again!",Snackbar.LENGTH_SHORT)
                             val view1 : View = snackbar.view
                             val textView = view1.findViewById<View>(com.google.android.material.R.id.text) as TextView
                             textView.setTextColor(Color.RED)
                             snackbar.show()
                         }
                        }
                    }
                }
            }
            return@OnKeyListener true
        })
        return false
    }

    fun initCall(){
        presenter = UserContractPresenterImpl(this@GetUserFragment,GetUserIntractorImpl(activity,1))
        presenter!!.validateUserDtslFromServer()
    }


    override fun setUserDtlsInfo(getuserDtsl: GetUserDtlsInfo?) {
       if (getuserDtsl!= null){
           tv_UserId!!.setText(getuserDtsl.iD)
           tv_UserName!!.setText(getuserDtsl.userName)
           tv_Password!!.setText(getuserDtsl.password)
       }else{
           val snackbar:Snackbar = Snackbar.make(const_userDtlsLayout!!,"Something went wrong!",Snackbar.LENGTH_SHORT)
           val view1 : View = snackbar.view
           val textView = view1.findViewById<View>(com.google.android.material.R.id.text) as TextView
           textView.setTextColor(Color.RED)
           snackbar.show()
       }
    }

    override fun onResponseFailure(throwable: Throwable) {
        val snackbar:Snackbar = Snackbar.make(const_userDtlsLayout!!,""+throwable.message,Snackbar.LENGTH_SHORT)
        val view1 : View = snackbar.view
        val textView = view1.findViewById<View>(com.google.android.material.R.id.text) as TextView
        textView.setTextColor(Color.RED)
        snackbar.show()
    }

}
