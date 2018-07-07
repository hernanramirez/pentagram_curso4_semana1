package info.hernanramirez.pentagram.api.remote;

import info.hernanramirez.pentagram.api.ConstantesRestApi;
import info.hernanramirez.pentagram.api.models.SearchUser.SearchUser;
import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by hernanr on 8/13/17.
 */

public interface ApiService {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<Mascota> getRecentMedia();

    @GET(ConstantesRestApi.URL_RECENT_MEDIA_USER_POR_ID)
    Call<Mascota> getRecentMediaByUserId(@Path("user_id") String userId);

    //@GET(ConstantesRestApi.URL_ID_DEL_USUARIO)
    //public Call<Mascota> search(@Query("q") String query, @Query("access_token") String accessToken);

    @GET(ConstantesRestApi.URL_TAGS_RECENT_MEDIA_USER)
    Call<SearchUser> searchByTag(@Path("tag") String tag);

}