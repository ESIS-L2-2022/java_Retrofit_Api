package cd.wayupdev.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubUserService {

    @GET("/users/{id}")
    Call<GithubUser> getUser(@Path("id") int id);
}
