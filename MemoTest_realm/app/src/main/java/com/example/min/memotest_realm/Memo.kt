package com.example.min.memotest_realm

/**
 * Created by min on 2017. 12. 20..
 */

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
        open class Memo( //Memo라는 테이블이 추가되었다고 생각하자
        @PrimaryKey //db에서 참조되는 중복이 되지 않는 키값. 여기서는 id만 PrimaryKey가 된다.
        var id: Int = 0,
        var title: String = "",
        var text: String = "",
        var date: String = ""): RealmModel
