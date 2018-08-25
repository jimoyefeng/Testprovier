package com.example.licheng.testprovider

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{



            /**
             * 对user表进行操作
             */

            // 设置URI
            val uri_user = Uri.parse("content://cn.scu.myprovider/user")

//            // 插入表中数据
//            val values = ContentValues()
//            values.put("_id", 3)
//            values.put("name", "Iverson")


            // 获取ContentResolver
            val resolver = contentResolver
            // 通过ContentResolver 根据URI 向ContentProvider中插入数据
//            resolver.insert(uri_user, values)

            // 通过ContentResolver 向ContentProvider中查询数据
            val cursor = resolver.query(uri_user, arrayOf("_id", "name"), null, null, null)
            while (cursor!!.moveToNext()) {
                System.out.println("query book:" + cursor.getInt(0) + " " + cursor.getString(1))
                // 将表中数据全部输出
            }
            cursor.close()

        }
    }
}
