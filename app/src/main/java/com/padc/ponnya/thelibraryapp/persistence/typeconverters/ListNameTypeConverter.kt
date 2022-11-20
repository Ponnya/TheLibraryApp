package com.padc.ponnya.thelibraryapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListNameTypeConverter {

    @TypeConverter
    fun toString(listName: List<String?>?): String {
        return Gson().toJson(listName)
    }

    @TypeConverter
    fun toListName(listNameJsonString: String): List<String?>? {
        val listNameType = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(listNameJsonString, listNameType)
    }
}