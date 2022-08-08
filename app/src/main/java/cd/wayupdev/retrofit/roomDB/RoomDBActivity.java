package cd.wayupdev.retrofit.roomDB;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import cd.wayupdev.retrofit.R;

public class RoomDBActivity extends AppCompatActivity {

    private EditText etNom;
    private EditText etPostNom;
    private EditText etEmail;
    private EditText etMatricule;
    private Button btnSave;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        initialisation();
    }

    private void setEcouteurEvenement(){
        btnSave.setOnClickListener(v -> {
            String nom = etNom.getText().toString();
            String postNom = etPostNom.getText().toString();
            String email = etEmail.getText().toString();
            String matricule = etMatricule.getText().toString();

            if(nom.isEmpty()){
                Toast.makeText(this, "Le champ longitude ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(postNom.isEmpty()){
                Toast.makeText(this, "Le champ latitude ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(email.isEmpty()){
                Toast.makeText(this, "Le champ Acceleration ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(matricule.isEmpty()){
                Toast.makeText(this, "Le champ unit ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else {

            }
        });
    }

    private void initialisation(){
        etNom = findViewById(R.id.etNom);
        etPostNom = findViewById(R.id.etPostNom);
        etEmail = findViewById(R.id.etEmail);
        etMatricule = findViewById(R.id.etMatricule);
        btnSave = findViewById(R.id.btnSave);
        progressBar = findViewById(R.id.progressbar);
    }
}