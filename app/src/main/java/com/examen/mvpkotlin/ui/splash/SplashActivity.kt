package com.examen.mvpkotlin.ui.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.examen.kotlinretrofit.utils.GeneralHelper
import com.examen.kotlinretrofit.utils.NetworkUtils
import com.examen.mvpkotlin.R
import com.examen.mvpkotlin.ui.login.SignInActivity
import kotlinx.coroutines.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor

class SplashActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        GeneralHelper.hideStatusbar(this)
        // do task using background thread CoroutineScope(Dispatchers.IO).launch with suspend method
        CoroutineScope(Dispatchers.IO).launch {
            checkNetwork()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    suspend fun checkNetwork() {
        delay(1000L)
        val  status = NetworkUtils().isNetworkConnected(this)
        if (status){
            finish()
            startActivity(intentFor<SignInActivity>())
        }else{
//android mainui thread calling here using withContext(Dispatchers.main) to update result on main ui thread
            withContext(Dispatchers.Main) {
                showAlertDialog()
            }
        }
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
}
