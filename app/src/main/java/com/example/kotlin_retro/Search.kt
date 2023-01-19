package com.example.kotlin_retro

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Search")
data class  Search(
    @PrimaryKey(autoGenerate = true) // variable for our id.
    public val id: Int = 0,

    @SerializedName("Title")
    @Expose val title: String ,

    @SerializedName("Year")
    @Expose
    public val year: String ,

    @SerializedName("imdbID")
    @Expose
    public val imdbID: String ,

    @SerializedName("Type")
    @Expose
    public val type: String ,

    @SerializedName("Poster")
    @Expose val poster: String
)