package cd.wayupdev.retrofit.roomDB.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Promotion {
    @PrimaryKey(autoGenerate = true) public int id;
    public String nom;

    public Promotion() {
    }

    public Promotion(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
