package info.hernanramirez.pentagram.ui.fragments;

import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;

public class PrincipalFragmentPresenter implements IPrincipalFragment.Presenter {

    private IPrincipalFragment.View view;
    private IPrincipalFragment.Implementation implementation;

    public PrincipalFragmentPresenter(IPrincipalFragment.View view) {
        this.view = view;
        implementation = new PrincipalFragmentImp(this);

    }

    @Override
    public void mostarDatosRecientes(Mascota mascota) {

        if(view != null){
            mostrarMascotaRV(mascota);
            view.mostarDatosRecientes();
            view.hideProgress();
            //System.out.println("Mostar datos recientes Presentador");
        }

    }

    @Override
    public void mostrarFotoPerfil(String perfilFoto) {

        if(view != null){
            view.mostrarFotoPerfil(perfilFoto);
        }

    }

    public void mostrarMascotaRV(Mascota mascota) {
        view.inicializarAdaptadorRV(view.crearAdaptador(mascota));
        view.generarGridLayout();
    }

    @Override
    public void obtenerMediosRecientes() {

        if(view != null){
            view.showProgress();
            implementation.obtenerMediosRecientes();
            //view.hideProgress();
        }

    }
}
