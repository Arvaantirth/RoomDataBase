package com.example.roomdatabase


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SecondActivity : AppCompatActivity(){
    lateinit var appDatabase: AppDatabase
    lateinit var roomDataAdpter: RoomDataAdpter
    private lateinit var biniding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biniding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(biniding.root)

        appDatabase = AppDatabase.buildRoomDB(this)

        getall()
    }

    private fun getall() {

        GlobalScope.launch {

            val data=appDatabase.AppDao().getAll()
            setAdapter(

                data

            )
        }
    }

    private fun delete(){

        GlobalScope.launch (Dispatchers.IO){

             val delete=appDatabase.AppDao() .deleteAll()


        }

    }
    private fun update(firstname: String, lastname: String, roll: String, id: Int) {

        startActivity(Intent(this@SecondActivity,MainActivity::class.java)
            .putExtra("userData",firstname.toInt())
            .putExtra("firstname",firstname.toString())
            .putExtra("lastname",lastname.toString())
            .putExtra("roll",roll.toString())
            .putExtra("id",id.toInt()))
       startActivity(intent)
    }
    private val onclick=fun (id: Int, type: Int, user:UserData){


     if (type==0){
         update(user.firstname,user.lastname,user.roll,user.id)
     } else {
         delete()
  }

     }

    private fun setAdapter(data: List<UserData>) {

        roomDataAdpter = RoomDataAdpter(this,data,onclick)
        biniding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = roomDataAdpter
        }


    }


}