package cd.wayupdev.retrofit.tpRetrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import cd.wayupdev.retrofit.GithubUser;
import cd.wayupdev.retrofit.GithubUserService;
import cd.wayupdev.retrofit.MainActivity;
import cd.wayupdev.retrofit.R;
import cd.wayupdev.retrofit.tpRetrofit.data.api.MeteoService;
import cd.wayupdev.retrofit.tpRetrofit.data.model.Dataseries;
import cd.wayupdev.retrofit.tpRetrofit.data.model.Meteo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private TextView tvProduct;
    private TextView tvInit;
    private TextView tvTransparency;
    private TextView tvTemperature;
    private TextView tvDirection;
    private TextView tvSpeed;
    private EditText edLongitude;
    private EditText edLatitude;
    private EditText edAcceleration;
    private EditText edUnit;
    private EditText edOutput;
    private EditText edTzshift;
    private Button btnSubmit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        initialisation();
        setEcouteurEvenement();
    }

    private void setEcouteurEvenement(){
        btnSubmit.setOnClickListener(v -> {
            Double longitudeTxt = Double.parseDouble(edLongitude.getText().toString());
            Double latitudeTXT = Double.parseDouble(edLatitude.getText().toString());
            Integer AcTxt = Integer.parseInt(edAcceleration.getText().toString());
            String unitTxt = edUnit.getText().toString();
            String output = edOutput.getText().toString();
            Integer tzshiftTxt = Integer.parseInt(edTzshift.getText().toString());

            if(longitudeTxt == null){
                Toast.makeText(this, "Le champ longitude ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(latitudeTXT == null){
                Toast.makeText(this, "Le champ latitude ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(AcTxt == null){
                Toast.makeText(this, "Le champ Acceleration ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(unitTxt.isEmpty()){
                Toast.makeText(this, "Le champ unit ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(output.isEmpty()){
                Toast.makeText(this, "Le champ output ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else if(tzshiftTxt == null){
                Toast.makeText(this, "Le champ tzshift ne peux etre vide", Toast.LENGTH_SHORT).show();
            }else {
                getMeteo(longitudeTxt, latitudeTXT, AcTxt, unitTxt, output, tzshiftTxt);
            }
        });
    }

    private void getMeteo(
            double longitudeTxt,
            double latitudeTXT,
            int AcTxt,
            String unitTxt,
            String output,
            int tzshiftTxt
    ){
        progressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.7timer.info")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MeteoService meteoService = retrofit.create(MeteoService.class);
        Call<Meteo> callback = meteoService.getMeteo(longitudeTxt, latitudeTXT, AcTxt, unitTxt, output, tzshiftTxt);

        callback.enqueue(new Callback<Meteo>() {
            @Override
            public void onResponse(@NonNull Call<Meteo> call, @NonNull Response<Meteo> response) {

                if(response.isSuccessful()){

                    Meteo meteo = response.body();
                    if (meteo == null){
                        Toast.makeText(RetrofitActivity.this, "L'utilisateur n'a pas été trouvé", Toast.LENGTH_LONG).show();
                    }
                    tvProduct.setText("Product : " + meteo.getProduct());
                    tvInit.setText("Init : " + meteo.getInit());
                    for (Dataseries data: meteo.getDataseries()) {
                        tvTransparency.setText("Transparency : " + data.getTransparency());
                        tvTemperature.setText("Temperature : " + data.getTemp2m());
                        tvDirection.setText("Direction : " + data.getWind().getDirection());
                        tvSpeed.setText("Direction : " + data.getWind().getSpeed());
                    }

                } else {
                    Toast.makeText(RetrofitActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<Meteo> call, @NonNull Throwable t) {
                Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initialisation(){
        tvProduct = findViewById(R.id.tvProduct);
        tvInit = findViewById(R.id.tvInit);
        tvTransparency = findViewById(R.id.tvTransparency);
        tvTemperature = findViewById(R.id.tvTemperature);
        tvDirection = findViewById(R.id.tvDirection);
        tvSpeed = findViewById(R.id.tvSpeed);

        edLongitude = findViewById(R.id.etLongitude);
        edLatitude = findViewById(R.id.etLatitude);
        edAcceleration = findViewById(R.id.etAcceleration);
        edUnit = findViewById(R.id.etUnit);
        edOutput = findViewById(R.id.etOutput);
        edTzshift = findViewById(R.id.etTzshift);

        btnSubmit = findViewById(R.id.btnSubmit);
        progressBar = findViewById(R.id.progressbar);
    }
}