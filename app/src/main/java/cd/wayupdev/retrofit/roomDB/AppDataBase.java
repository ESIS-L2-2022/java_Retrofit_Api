package cd.wayupdev.retrofit.roomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cd.wayupdev.retrofit.roomDB.dao.EtudiantDao;
import cd.wayupdev.retrofit.roomDB.dao.PromotionDao;
import cd.wayupdev.retrofit.roomDB.entity.Etudiant;
import cd.wayupdev.retrofit.roomDB.entity.Promotion;
import cd.wayupdev.retrofit.roomDB.entity.User;
import cd.wayupdev.retrofit.roomDB.dao.UserDao;

@Database(
    entities = {
        User.class,
        Etudiant.class,
        Promotion.class
    },
    version = 1
)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract EtudiantDao etudiantDao();
    public abstract PromotionDao promotionDao();
}