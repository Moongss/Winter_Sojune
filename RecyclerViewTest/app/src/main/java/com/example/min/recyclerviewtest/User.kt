package com.example.min.recyclerviewtest

/**
 * Created by min on 2017. 12. 19..
 */
import android.databinding.BindingAdapter
import android.graphics.Color
import android.view.View

class User(var name: String, var email: String, var color: String){
    object CustomBindingAdapter{
        @BindingAdapter("android:background")
        @JvmStatic
        fun setBackgroundColor(layout: View?, colorCode: String){
            layout?.setBackgroundColor(Color.parseColor(colorCode))
        }
    }
}