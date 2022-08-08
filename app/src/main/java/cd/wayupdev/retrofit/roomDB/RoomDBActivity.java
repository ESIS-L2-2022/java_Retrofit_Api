package cd.wayupdev.retrofit.roomDB;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cd.wayupdev.retrofit.R;
import cd.wayupdev.retrofit.roomDB.DB.AppDataBase;
import cd.wayupdev.retrofit.roomDB.DB.User;
import cd.wayupdev.retrofit.roomDB.DB.UserDao;

public class RoomDBActivity extends AppCompatActivity {

    private EditText etNom;
    private EditText etPostNom;
    private EditText etEmail;
    private EditText etMatricule;
    private Button btnSave;
    private TextView mat;
    private ProgressBar progressBar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        initialisation();
        setEcouteurEvenement();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setEcouteurEvenement(){
        btnSave.setOnClickListener(v -> {
            String nom = etNom.getText().toString();
            String postNom = etPostNom.getText().toString();
            String email = etEmail.getText().toString();
            String matricule = etMatricule.getText().toString();

            if(nom.isEmpty()){
                Toast.makeText(this, "Le champ Nom ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(postNom.isEmpty()){
                Toast.makeText(this, "Le champ Postnom ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(email.isEmpty()){
                Toast.makeText(this, "Le champ Email ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(matricule.isEmpty()){
                Toast.makeText(this, "Le champ Matricule ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else {
                saveData(nom, postNom, email, matricule);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void saveData(String nom, String postNom, String email, String matricule) {
        User user = new User(nom, postNom, email, matricule);
        AppDataBase db = Room
                .databaseBuilder(this, AppDataBase.class, "db")
                .allowMainThreadQueries()
                .build();

        UserDao dao = db.userDao();
        dao.insert(user);


        List<User> user1 = dao.findAll();

        List<String> josh = new ArrayList<>();
        StringBuilder sr = new StringBuilder();
        //user1.forEach(it -> josh.add(it.matricule));

        user1.forEach(it -> sr.append("\n" + it.matricule));
        mat.setText(sr);

        readData(josh);
    }

    private void readData(List<String> mat){

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.activity_listview, mat);

        ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    private void initialisation(){
        etNom = findViewById(R.id.etNom);
        etPostNom = findViewById(R.id.etPostNom);
        etEmail = findViewById(R.id.etEmail);
        etMatricule = findViewById(R.id.etMatricule);
        btnSave = findViewById(R.id.btnSave);
        mat = findViewById(R.id.mat);
        progressBar = findViewById(R.id.progressbar);
    }
}