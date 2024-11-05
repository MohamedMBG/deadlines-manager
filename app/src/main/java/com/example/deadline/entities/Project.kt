package com.example.deadline.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "projects",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["UserId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class Project(
    @PrimaryKey(autoGenerate = true) val ProjectId : Int = 0,
    val title : String,
    val description : String,
    val deadline : String,
    @ColumnInfo(name = "userId") val userId: Int
)