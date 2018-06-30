package info.hernanramirez.pentagram.api.remote;

import info.hernanramirez.pentagram.api.ConstantesRestApi;
import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by hernanr on 8/13/17.
 */

public interface ApiService {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<Mascota> getRecentMedia();

/*

    @GET("noticias/")
    Call<Noticia> noticia();

    @GET("noticias/{id}")
    Call<NoticiaResults> getNoticiasById(@Path("id") String id);


@GET("tasks/")
Call<Task> listTask(@Header("Authorization") String authToken);

@GET("tasks/{id}/")
Call<Result> getTaksById(@Header("Authorization") String authToken, @Path("id") Integer id);

@GET("tasks/")
Call<ResponseBody> listTask(@Header("Authorization") String authToken);
*/



}