package ca.georgebrown.lab7;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM words")
    void deleteAll();

    @Query("DELETE FROM words WHERE word=:word")
    void deleteWord(String word);

    @Query("SELECT * FROM words ORDER BY word ASC")
    LiveData<List<Word>> getAll();

}
