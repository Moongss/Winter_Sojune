package com.example.min.winter_sojune

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.textChangedListener
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sss : String = ""
        var nullable_sss : String? = "" //nullable_Sss, ? = null이 가능하다는 소리임
        //전에 배웠던 let 이용해서 if/else문이 nullable을 사용하면 어케 쓸 수 있는지 알아봤음 ,?와 !!의 차이
        //! : not, !! : error
        // ? if(variable != null){}
        // !! ?변수를 그냥 변수에 위치시킬 때 null 검사를 안함
        // ex)
//        var a : Int? = 10
//        var b : Int = a!!
//        fun asdf(x : Int) = x + 1
//        asdf(a!!)
//     !!사용할 땐 변수가 null이 아님이 확실 할 때 사용(null이면 에러남 null pointer는 존재한다)

// ----------------------------------------------------------------------------------------------

        //Kotlin Anko의 사용. Build.gradle에서 수정합시당
        mainTv.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, "Toast", Toast.LENGTH_LONG).show()
            }
        })

        //kotlin
        mainTv.setOnClickListener{
            Toast.makeText(this@MainActivity, "Toast", Toast.LENGTH_LONG).show()
        }

        //anko
        mainTv.onClick{
            //Toast_anko
            toast("Toast")
        }

        //text변경될때 바로바로 변경가능한?
        mainEdt.textChangedListener{
            afterTextChanged{

            }
        }

        mainTv.onClick{
            startActivity<SecondActivity>()

            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            var intent : Intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("id", 5)
            startActivity(intent) //java

            startActivity<SecondActivity>("id" to 5) //kotlin
        }
    }
}
