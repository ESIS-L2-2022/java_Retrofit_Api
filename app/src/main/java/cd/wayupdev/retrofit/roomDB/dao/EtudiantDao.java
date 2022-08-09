package cd.wayupdev.retrofit.roomDB.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cd.wayupdev.retrofit.roomDB.entity.Etudiant;
import cd.wayupdev.retrofit.roomDB.entity.Promotion;

@Dao
public interface EtudiantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Etudiant etudiant);

    @Query("SELECT * FROM Etudiant")
    List<Etudiant> findAll();
}
