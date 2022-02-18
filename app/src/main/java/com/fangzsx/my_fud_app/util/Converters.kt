package com.fangzsx.my_fud_app.util

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromAny(any : Any) : String{
        return any.toString()
    }

    @TypeConverter
    fun toAny(string :String) : Any{
        return string
    }

}