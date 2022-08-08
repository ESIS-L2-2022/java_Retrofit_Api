package cd.wayupdev.retrofit.roomDB.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true) public int id;
    public String nom;
    public String postNom;
    public String email;
    public String matricule;
}
