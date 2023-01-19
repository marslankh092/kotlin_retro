package com.example.kotlin_retro

import androidx.room.*

@Dao
interface MoviesDao {
    //movies db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inAllMovies(searches: List<Search?>?)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun upsert(article: Search): Long


    @Update
    fun updateMovie(movies: Search?)

    @Delete
    fun deleteMovie(movies: Search?)

    @get:Query("Select * from Search")
    val storedSearches: List<Search?>?

    @Query("Select * from Search where :title= title")
    fun getSearchedDetail(title: String?): Search?
}