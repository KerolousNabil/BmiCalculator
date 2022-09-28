package com.example.bmicalculator
import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.reflect.KClass

class mytools(activity: Activity) {
    var currentActivity:Activity
    init {
        currentActivity = activity
    }

    fun Toastshort(text:String)
    {
        Toast.makeText(currentActivity,text,Toast.LENGTH_SHORT).show()
    }

    fun Toastlong(text:String)
    {
        Toast.makeText(currentActivity,text,Toast.LENGTH_LONG).show()
    }
    fun openactivity(activity:KClass<*>)
    {
        var i = Intent(currentActivity , activity.java)
        ContextCompat.startActivity(currentActivity , i , null)
    }

}
