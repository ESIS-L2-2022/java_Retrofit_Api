package cd.wayupdev.retrofit.roomDB.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Etudiant {
    @PrimaryKey(autoGenerate = true) public int id;
    public String nom;
    public String postNom;
    public String matricule;
    public int idPromotion;

    public Etudiant() {
    }

    public Etudiant(String nom, String postNom, String matricule, int idPromotion) {
        this.nom = nom;
        this.postNom = postNom;
        this.matricule = matricule;
        this.idPromotion = idPromotion;
    }

    public Etudiant(int id, String nom, String postNom, String matricule, int idPromotion) {
        this.id = id;
        this.nom = nom;
        this.postNom = postNom;
        this.matricule = matricule;
        this.idPromotion = idPromotion;
    }
}
