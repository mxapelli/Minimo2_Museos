package edu.upc.dsa.minim2_museus;

import edu.upc.dsa.minim2_museus.models.Museums;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/dataset/museus/format/json/pag-ini/1/pag-fi/15")
    Call<Museums> getMuseums();
}
