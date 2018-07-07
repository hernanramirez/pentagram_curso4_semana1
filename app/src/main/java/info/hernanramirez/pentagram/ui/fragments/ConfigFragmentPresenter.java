package info.hernanramirez.pentagram.ui.fragments;

import info.hernanramirez.pentagram.api.models.SearchUser.SearchUser;

public class ConfigFragmentPresenter implements IConfigurarFragment.presenter {

    private IConfigurarFragment.view view;
    private IConfigurarFragment.implementations implementations;

    public ConfigFragmentPresenter(IConfigurarFragment.view view) {
        this.view = view;
        implementations = new ConfigFragmentImp(this);
    }

    @Override
    public void buscarTagUsuario(String tag) {

        if(view != null){
            view.showProgress();
            implementations.buscarTagUsuario(tag);
            view.hideProgress();
        }

    }

    @Override
    public void mostrarTagUsuario(SearchUser searchUser) {

        if(view != null){
            mostrarTagMascotaRV(searchUser);
            view.mostrarTagUsuario();
            view.hideProgress();
            //System.out.println("Mostar datos recientes Presentador");
        }

    }

    public void mostrarTagMascotaRV(SearchUser searchUser) {
        view.inicializarAdaptadorRV(view.crearAdaptador(searchUser));
        view.generarGridLayout();
    }

}
