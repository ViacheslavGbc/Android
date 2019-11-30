package ca.georgebrown.lab7;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAll();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    void insert(Word word){
        new InsertAsyc(mWordDao).execute(word);
    }

    private static class InsertAsyc extends AsyncTask<Word, Void, Void>{

        private WordDao dao;

        InsertAsyc(WordDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            dao.insert(words[0]);
            return null;
        }
    }

}
