package cd.wayupdev.retrofit.tpRetrofit.data.api;

import cd.wayupdev.retrofit.tpRetrofit.data.model.Meteo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MeteoService {

    @GET("/bin/astro.php")
    Call<Meteo> getMeteo(
            @Query("lon") double lon,
            @Query("lat") double lat,
            @Query("ac") int ac,
            @Query("unit") String unit,
            @Query("output") String output,
            @Query("tzshift") int tzshift
    );
}
