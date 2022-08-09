package cd.wayupdev.retrofit.roomDB.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import cd.wayupdev.retrofit.roomDB.entity.EtudiantPromotion;
import cd.wayupdev.retrofit.roomDB.entity.Promotion;

@Dao
public interface PromotionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Promotion promotion);

    @Query("SELECT * FROM Promotion")
    List<Promotion> findAll();

    @Transaction
    @Query("SELECT * FROM Promotion")
    List<EtudiantPromotion> findPromotionAndEtudiant();
}
