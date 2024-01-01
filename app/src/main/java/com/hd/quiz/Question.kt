package com.hd.quiz

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Question(
    @PrimaryKey val id: UUID,
    val typeOfQ : String,
    val question: String,
    val choice: String?,
    val choice2: String?,
    val choice3: String?,
    val choice4: String?,
    val category: String
    )