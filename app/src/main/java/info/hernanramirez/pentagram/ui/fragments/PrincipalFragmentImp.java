package info.hernanramirez.pentagram.ui.fragments;

import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;
import info.hernanramirez.pentagram.api.remote.ApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalFragmentImp implements IPrincipalFragment.Implementation {

    private PrincipalFragmentPresenter presenter;
    private Mascota mascota;

    public PrincipalFragmentImp(PrincipalFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void obtenerMediosRecientes() {

        Call<Mascota> call = ApiAdapter.getApiService().getRecentMedia();
        call.enqueue(new Callback<Mascota>() {
            @Override
            public void onResponse(Call<Mascota> call, Response<Mascota> response) {

                if(response.isSuccessful()){

                    mascota = response.body();
                    presenter.mostarDatosRecientes(mascota);

                    String perfilFoto = mascota.getData().get(0).getUser().getProfilePicture();
                    presenter.mostrarFotoPerfil(perfilFoto);

                }else{
                    System.out.println(response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<Mascota> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
