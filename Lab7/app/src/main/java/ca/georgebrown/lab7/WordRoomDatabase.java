package ca.georgebrown.lab7;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static volatile WordRoomDatabase INSTANCE = null;

    private static RoomDatabase.Callback callback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{
        private WordDao dao;
        PopulateDbAsync(WordRoomDatabase db){
            this.dao = db.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            dao.insert(new Word("milk"));
            dao.insert(new Word("bread"));
            dao.insert(new Word("rice"));
            dao.insert(new Word("butter"));
           // dao.deleteWord("rice"); //this line works!!!
            return null;
        }
    }

    static WordRoomDatabase getDatabase(Context context){
        if(INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(
                          context.getApplicationContext(),
                          WordRoomDatabase.class,
                          "word_database"
                    ).addCallback(callback).build();
                }
            }
        }
        return INSTANCE;
    }

}
