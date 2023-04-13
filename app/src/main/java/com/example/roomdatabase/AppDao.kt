package com.example.roomdatabase


import androidx.room.*
import com.example.roomdatabase.Const.FIRSTNAME
import com.example.roomdatabase.Const.LASTNAME
import com.example.roomdatabase.Const.ROLL

@Dao
@Entity(tableName = "user_table")
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userData: UserData):Long

    @Query("SELECT * FROM user_table")
    suspend fun getAll():List<UserData>


    @Query("UPDATE user_table SET $FIRSTNAME=:firstname,$LASTNAME=:lastname,$ROLL=:roll WHERE id=:id")
    suspend fun update(firstname:String, lastname:String, roll:String, id:Int)

    @Delete
    suspend fun delete(userData: UserData)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()


}