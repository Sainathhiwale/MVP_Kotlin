package com.examen.mvpkotlin.data.prefs


class DataManager {
  private var sharedPrefsHelper:SharedPrefsHelper?=null
    private var dataManager:DataManager?=null
    constructor()
   public constructor(sharedPrefsHelper: SharedPrefsHelper){
      this.sharedPrefsHelper=sharedPrefsHelper
  }



    public fun clears(){
        sharedPrefsHelper!!.clear();
    }

     fun setLoggedIn(){
        sharedPrefsHelper!!.setLoggedInMode(true)
    }

    fun getLoggedInMode(loggedIn:Boolean): Boolean? {
        return sharedPrefsHelper!!.getLoggedInMode(loggedIn)
    }
    fun setUserName(userName:String){
        sharedPrefsHelper!!.putUserName(userName)
    }
    fun getName(userName:String):String?{
        return sharedPrefsHelper!!.getUserName()
    }

    fun setEmail(emailId:String){
        sharedPrefsHelper!!.putUserName(emailId)
    }
    fun getEmail():String?{
        return sharedPrefsHelper!!.getUseremail()
    }

    fun getDataManager(): DataManager? {
       return dataManager
    }

}