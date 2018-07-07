package info.hernanramirez.pentagram.ui.fragments;

import info.hernanramirez.pentagram.adapters.MascotaTagAdaptador;
import info.hernanramirez.pentagram.api.models.SearchUser.SearchUser;

public interface IConfigurarFragment {

    interface view{

        void showProgress();

        void hideProgress();

        void buscarTagUsuario(String tag);

        void mostrarTagUsuario();

        void generarGridLayout();

        MascotaTagAdaptador crearAdaptador(SearchUser searchUsers);

        void inicializarAdaptadorRV(MascotaTagAdaptador adaptador);

        void mensajeUsuarioNoEncontrado();

    }

    interface presenter {

        void buscarTagUsuario(String tag);
        void mostrarTagUsuario(SearchUser searchUsers);

    }

    interface implementations {
        void buscarTagUsuario(String tag);
    }
}
