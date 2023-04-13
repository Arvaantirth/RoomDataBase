package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var biniding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase
    lateinit var item: List<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biniding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biniding.root)
        appDatabase = AppDatabase.buildRoomDB(this)
        biniding.btninsert.setOnClickListener {

            if (intent.hasExtra("UserData")){
            }
            insertData()
        }

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun insertData() {


        GlobalScope.launch {

            val recordInsertOrNot = appDatabase.AppDao().insert(
                UserData(
                    id = 0,
                    firstname = biniding.evfirstname.text.toString(),
                    lastname = biniding.evlastname.text.toString(),
                    roll = biniding.evroll.text.toString()
                )
            )

            if (recordInsertOrNot != 6L) {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun update(stringExtra: UserData) {

     biniding.evfirstname.setText(stringExtra.firstname)
      biniding.evlastname.setText(stringExtra.lastname)
         biniding.evlastname.setText(stringExtra.roll)



            GlobalScope.launch(Dispatchers.IO) {
                appDatabase.AppDao().update(firstname = String(), lastname = String(), roll = String(), id = 0)
            }

            biniding.evfirstname.text.clear()
            biniding.evlastname.text.clear()
            biniding.evroll.text.clear()

            Toast.makeText(this@MainActivity, "Data is Update", Toast.LENGTH_SHORT).show()
    }
}