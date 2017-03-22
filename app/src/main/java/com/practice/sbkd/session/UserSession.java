package com.practice.sbkd.session;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by User on 20-03-2017.
 */
public class UserSession {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context  _context;
    int PRIVATE_MODE =0;
    private static final String PREFER_NAME="appuser";
    private static final String IS_USER_LOGIN="IsUserLoggedIN";
    private static final String KEY_NAME="email";
    private static final String KEY_PASS="pass";
    public UserSession(Context context){
        this._context=context;
        pref=context.getSharedPreferences(PREFER_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }
    public void createUserLoginSession(String uname,String pass){
        editor.putBoolean(IS_USER_LOGIN,true);
        editor.putString(KEY_NAME,uname);
        editor.putString(KEY_PASS,pass);
        editor.commit();
    }
    public HashMap<String,String>getUserDetails(){
        HashMap<String,String>user=new HashMap<>();
        user.put(KEY_NAME,pref.getString(KEY_NAME,null));
        user.put(KEY_PASS,pref.getString(KEY_PASS,null));
        return user;
    }
     public boolean checkLogin(){
         if(!this.isUserLoggedIn()){
             return  true;
         }
         return false;
     }

    private boolean isUserLoggedIn() {
        return pref.getBoolean(IS_USER_LOGIN,false);
    }
    public void LogoutUser(){
        editor.clear();
        editor.commit();
    }
}
