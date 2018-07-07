package info.hernanramirez.pentagram.ui.fragments;

import info.hernanramirez.pentagram.api.models.SearchUser.SearchUser;
import info.hernanramirez.pentagram.api.remote.ApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigFragmentImp implements IConfigurarFragment.implementations {

    private SearchUser searchUsers;
    private ConfigFragmentPresenter presenter;

    public ConfigFragmentImp(ConfigFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void buscarTagUsuario(String tag) {

        Call<SearchUser> call = ApiAdapter.getApiService().searchByTag(tag);
        call.enqueue(new Callback<SearchUser>() {
            @Override
            public void onResponse(Call<SearchUser> call, Response<SearchUser> response) {

                if(response.isSuccessful()){

                    searchUsers = response.body();
                    presenter.mostrarTagUsuario(searchUsers);

                    //String userId = searchUsers.getUsers().get(0).getUser().getPk();
                    //buscarUsuarioById(userId);
                    //IConfigurarFragment.presenter.mostarDatosRecientes(User);

                    //String perfilFoto = user.getData().get(0).getUser().getProfilePicture();
                    //presenter.mostrarFotoPerfil(perfilFoto);

                }else{
                    System.out.println(response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<SearchUser> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
