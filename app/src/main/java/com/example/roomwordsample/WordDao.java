package com.example.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Data access object (DAO)
 * Validates your SQL at compile-time and associates it with a method.
 * Room uses DAO to create a clean API for your code.
 * DAO must be an interface or abstract class.
 * By default, all queries must be executed on a separate thread.
 *
 *
 * maps method calls to database queries, so that when the Repository calls a method such as
 * getAlphabetizedWords(), Room can execute SELECT * FROM word_table ORDER BY word ASC.
 */
@Dao
public interface WordDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)     // ignores a new word if it's already in the list
    void insert(Word word);                             // insert one word

    @Query("DELETE FROM word_table")                    // @Query requires that you provide a SQL
    void deleteAll();                                   // query as a string parameter to the annotation

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();                  // returns a List of all the words
                                                                  // LiveData is a lifecycle library class
                                                                    // Using a return value of type LiveData causes Room to generate all necessary code to update the LiveData when the database is updated
    
}
