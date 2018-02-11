package com.example.min.memotest_realm

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.min.memotest_realm.R.id.saveBtn
import com.example.min.memotest_realm.R.id.titleEdt
import com.vicpin.krealmextensions.query
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.queryLast
import com.vicpin.krealmextensions.save
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_memo.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        Realm.init(this) //초기화 - TF에서도 해봤지

        saveBtn.onClick{
            val dayTime = SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss")
            val date = dayTime.format(Date(System.currentTimeMillis()))
            val id = Memo().queryLast()?.id.let{ //.let : 앞에붙은걸 줄여줌
                if(it == null) 0 else it + 1 //id가 PrimaryKey이기 때문에 가장 마지막값이 없으면 0, 있으면 +1.

            }

            Memo(id, titleEdt.text.toString(), textEdt.text.toString(), date).save() //db에 자동저장
//            Memo().queryAll().forEach {
//                Log.d("TAG", it.title)
//            }
            setResult(Activity.RESULT_OK)
            finish() // activity 종료
        }
    }
}
