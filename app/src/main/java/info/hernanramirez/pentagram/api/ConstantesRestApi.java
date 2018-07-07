package info.hernanramirez.pentagram.api;

/**
 * Created by anahisalgado on 25/05/16.
 */
public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com";
    public static final String ACCESS_TOKEN = "7813168670.7faab3d.21f324fe7372422e81f09c06e8d48244";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = VERSION + KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    public static final String URL_RECENT_MEDIA_USER_POR_ID = VERSION + "users/{user_id}/"+ KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String URL_TAGS_RECENT_MEDIA_USER = VERSION + "tags/{tag}/media/recent/"+ KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    // endpoin eleiminado
    public static final String URL_ID_DEL_USUARIO = "users/search";

    // Alternativa para buscar un nombre de usuario
    //https://www.instagram.com/web/search/topsearch/?context=user&count=0&query=solitario403
    public static final String URL_SEARCH_USUARIO = "web/search/topsearch/";

}
