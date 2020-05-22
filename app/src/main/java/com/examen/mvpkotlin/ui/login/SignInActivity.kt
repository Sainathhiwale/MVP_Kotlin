package com.examen.mvpkotlin.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.examen.kotlinretrofit.utils.NetworkUtils
import com.examen.kotlinretrofit.utils.Validation
import com.examen.mvpkotlin.MainActivity
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.data.model.LoginRequest
import com.examen.mvpkotlin.data.prefs.SharedPrefsHelper
import com.examen.mvpkotlin.utils.AppConstants
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor

class SignInActivity : AppCompatActivity() ,LoginContract.LoginView,View.OnClickListener{
     var btSignIn:Button?=null
     var presenterImpl:LoginPresenterImpl?= null
     var prefSharedHelpler:SharedPrefsHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        btSignIn = findViewById(R.id.btSignIn) as Button
        btSignIn!!.setOnClickListener(this)
        prefSharedHelpler = SharedPrefsHelper(this)

    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(p0: View?) {
        val  ids = p0!!.id
        when(ids){
            R.id.btSignIn ->{
                if(checkNetwork()){
                    if (checkValidation()){
                        val name = etUserEmail.text.toString().trim()
                        val pass = etPassword.text.toString().trim()
                        presenterImpl = LoginPresenterImpl(this, GetLoginIntractorImpl(this, name,pass));
                        presenterImpl!!.validateLoginFromServer()
                    }else{
                        Toast.makeText(this@SignInActivity,"Please enter the email and password!",Toast.LENGTH_LONG).show()
                    }
                }else{
                 showAlertDialog()
                }

            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public fun checkNetwork():Boolean{
        var status:Boolean?= true
          status = NetworkUtils().isNetworkConnected(this)
        if(status){
            Toast.makeText(this@SignInActivity,"Internet is connected!",Toast.LENGTH_LONG).show()
        }else{
            showAlertDialog()
        }
        return status
    }


    //code clean up
    fun showAlertDialog(){
        alert {
            isCancelable = false
            title = getString(R.string.error_no_internet)
            message = getString(R.string.error_no_internet_msg)
            positiveButton("OK") {
                it.dismiss()
                val settingIntent = Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
                startActivity(settingIntent)
            }
        }.show()
    }
    //when you goes to internet setting we want to know the has user started net or not so we can check this using onRestart() activity method
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onRestart() {
        super.onRestart()
        CoroutineScope(Dispatchers.IO).launch{
            checkNetwork()
        }

    }
    fun checkValidation():Boolean{
        var ret = true
        if (!Validation.hasText(etUserEmail)) ret = false
        if (!Validation.hasText(etPassword)) ret = false
        return ret
    }
    override fun setLoginInfoData(loginRequest: LoginRequest) {
         if(loginRequest!=null){
             prefSharedHelpler!!.putUserName(loginRequest.password.toString())
             prefSharedHelpler!!.putUserEmail(loginRequest.userName.toString())
             val intent = Intent(this@SignInActivity,MainActivity::class.java)
             intent.putExtra(AppConstants.EMAIL,loginRequest.userName)
           /*  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)*/
             startActivity(intent)
             //startActivity(intentFor<MainActivity>())
             Toast.makeText(this@SignInActivity,""+loginRequest.userName,Toast.LENGTH_LONG).show()
         }else{
             Toast.makeText(this@SignInActivity,"Something went wrong!",Toast.LENGTH_LONG).show()

         }

    }

    override fun onResponseFailure(throwable: Throwable) {
        Toast.makeText(this@SignInActivity,""+throwable.message,Toast.LENGTH_LONG).show()
    }
}
