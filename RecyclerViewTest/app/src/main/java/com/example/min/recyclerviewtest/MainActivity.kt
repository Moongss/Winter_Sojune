package com.example.min.recyclerviewtest

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.min.recyclerviewtest.databinding.ItemFruitBinding
import com.example.min.recyclerviewtest.databinding.ItemUserBinding
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_fruit.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var uList = arrayListOf<Any>(  //User변수형의 리스트를 만든다
                User("1번사람", "111@mail.com", "#f76363"),
                Fruit("사과", Color.RED),
                User("2번사람", "222@mail.com", "#ffbf00"),
                Fruit("수박", Color.GREEN),
                User("3번사람", "333@mail.com", "#a5d322"),
                User("4번사람", "444@mail.com", "#33b5e5"),
                Fruit("바나나", Color.YELLOW),
                User("5번사람", "555@mail.com", "#7e828e"),
                User("6번사람", "666@mail.com", "#e8cc35"),
                Fruit("블루베리", Color.BLACK)
        )
        // 임의의 유저 데이터를 넣어 줬다.


        mainRecycler.layoutManager = LinearLayoutManager(this).apply{
            orientation = LinearLayoutManager.HORIZONTAL
        }

        //일반적 세로방향 리스트를 위해 사용함
       mainRecycler.layoutManager = LinearLayoutManager(this)
//        mainRecycler.layoutManager = GridLayoutManager(this, 3)
        val into = LastAdapter(uList, BR.item)
                .map<User, ItemUserBinding>(R.layout.item_user) {
                    onClick {
                        var position = it.adapterPosition //포지션
                        var user = it.binding.item //아이템

                        uList.removeAt(position)
                        mainRecycler.adapter.notifyItemRemoved(position)
                        //사라졌다는 것을 알려줘야됨, DataSetChanged는 다돌아봄. 귀찮을때, itemChanged하면 메모리 관리는 좋겠지

                    } //클릭했을때
//                    onBind{} //기본생성. 생겼을때
//                    onLongClick { } //말그대로 길게 눌렀을때
                }
                .map<Fruit, ItemFruitBinding>(R.layout.item_fruit){
                    onClick{

                        var fruit = it.binding.item
                        if(fruit != null){
                            it.binding.itemFruitBg.setBackgroundColor(fruit.color)
                            it.binding.itemFruitName.setTextColor(Color.WHITE)
                        }

                        it.binding.run{
                            var fruit = item
                            if(fruit != null){
                                itemFruitBg.setBackgroundColor(fruit.color)
                                itemFruitName.setTextColor(Color.WHITE)
                            }
                        }


                        it.binding.run{
                            item?.let{ fruit ->
                                itemFruitBg.setBackgroundColor(fruit.color)
                                itemFruitName.setTextColor(Color.WHITE)
                            }
                        }

                    }

                }
                //---------------------------

                // u List를 한번 순서대로 도는데 유저면 item_user에 매핑시킴
                // ItemUserBinding : Custom Handling
                .into(mainRecycler)
    }
    //문서화
    /**
     * asdfasdf : 함수설명
     * @param a = 123123 : 파라미터
     *
     * */

    //kotlin async-await : web같은거에서 데이터를 받아오거나 백그라운드 작업을 돌때 그 동작이 끝난 시점을 받는 그런거임
    //await : 쓰레드가 종료되면 그뒤의 내용을 실행하는 것임
    //뭔지 모르겠지만 Node.js하는 서버개발자 친구들한테 좋을 것 같음
}
