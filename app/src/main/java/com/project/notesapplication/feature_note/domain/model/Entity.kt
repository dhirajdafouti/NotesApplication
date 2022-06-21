package com.project.notesapplication.feature_note.domain.model

import androidx.room.PrimaryKey

data class Entity(
    val title:String,
    val content:String,
    val timestamp: Long,
    val color:Int,
    @PrimaryKey val id:Int?=null
){
    companion object{

    }
}
