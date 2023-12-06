package com.example.roomwordsample;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This class will describe the Entity (which represents the SQLite table) for my words.
 * Each property in the class represents a column in the table.
 */

@Entity(tableName = "word_table")       // Each Entity class represents a SQLite table
public class Word {
    @PrimaryKey                         // each entity needs a primary key. To keep things simple, each word acts as its own primary key
                                        // we could add (autoGenerate = true)
                                        //               private int id;
    @NonNull                            // @NonNull means that it can never be null
    @ColumnInfo(name = "word")          // specify the name of the column in the table if you want it to be different from the name of the member variable
    private String mWord;
    public Word(@NonNull String word) {
        this.mWord = word;
    }

    public String getWord(){
        return this.mWord;
    }
}
