package cd.wayupdev.retrofit.roomDB.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import cd.wayupdev.retrofit.roomDB.entity.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User WHERE id = :id")
    User findOne(int id);

    @Query("SELECT * FROM User")
    List<User> findAll();

    @Query("SELECT * FROM User ORDER BY id DESC")
    User getLastUser();
}
