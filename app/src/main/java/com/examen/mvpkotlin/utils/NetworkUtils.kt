package com.examen.kotlinretrofit.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity

class NetworkUtils {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun isNetworkConnected(context: FragmentActivity?): Boolean{
        var result = false
        (context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                result = isCapableNetwork(this,this.activeNetwork)
            } else {
                val networkInfos = this.allNetworks
                for (tempNetworkInfo in networkInfos) {
                    if(isCapableNetwork(this,tempNetworkInfo))
                        result =  true
                }
            }
        }

        return result
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isCapableNetwork(cm: ConnectivityManager, network: Network?): Boolean{
        cm.getNetworkCapabilities(network)?.also {
            if (it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            }
        }
        return false
    }



}