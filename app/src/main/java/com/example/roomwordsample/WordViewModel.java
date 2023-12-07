package com.example.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * provides methods for accessing the data layer, and it returns LiveData so that
 * MainActivity can set up the observer relationship.
 */
public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private final LiveData<List<Word>> mAllWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }


    /**
     * Makes possible the automatic updates in the UI components. In the MainActivity,
     * there is an Observer that observes the words LiveData from the database and is
     * notified when they change.
     */
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

}
