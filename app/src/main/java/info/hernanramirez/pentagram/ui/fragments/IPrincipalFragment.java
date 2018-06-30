package info.hernanramirez.pentagram.ui.fragments;

import info.hernanramirez.pentagram.adapters.MascotaAdaptador;
import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;

public interface IPrincipalFragment {

    interface View{

        void showProgress();

        void hideProgress();

        void mostarDatosRecientes();

        void mostrarFotoPerfil(String perfilFoto);

        void mostarErrorDatosRecientes();

        void generarGridLayout();

        MascotaAdaptador crearAdaptador(Mascota mascota);

        void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    }

    interface Presenter{

        void mostarDatosRecientes(Mascota mascota);
        void mostrarFotoPerfil(String perfilFoto);
        void obtenerMediosRecientes();

    }

    interface Implementation {
        void obtenerMediosRecientes();
    }



}
