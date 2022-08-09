package cd.wayupdev.retrofit.roomDB.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class EtudiantPromotion {
    @Embedded
    public Promotion promotion;

    @Relation(parentColumn = "id", entityColumn = "idPromotion")
    public Etudiant etudiant;
}
