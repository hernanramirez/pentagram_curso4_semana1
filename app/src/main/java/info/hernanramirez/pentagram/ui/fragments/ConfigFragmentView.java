package info.hernanramirez.pentagram.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import info.hernanramirez.pentagram.R;
import info.hernanramirez.pentagram.adapters.MascotaTagAdaptador;
import info.hernanramirez.pentagram.api.models.SearchUser.SearchUser;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConfigFragmentView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConfigFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfigFragmentView extends Fragment implements IConfigurarFragment.view {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ConfigFragmentPresenter presenter;
    private RecyclerView rvTagMascota;
    private ProgressBar progressBar;
    private Spinner spinner;

    private Button button;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ConfigFragmentView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfigFragmentView.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfigFragmentView newInstance(String param1, String param2) {
        ConfigFragmentView fragment = new ConfigFragmentView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_config, container, false);

        button = (Button) v.findViewById(R.id.bntConfig);
        rvTagMascota = (RecyclerView) v.findViewById(R.id.rvTagMascota);
        progressBar = (ProgressBar) v.findViewById(R.id.progressConfig);
        spinner = (Spinner) v.findViewById(R.id.spinnerTag);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarTagUsuario(spinner.getSelectedItem().toString());
            }
        });

        presenter = new ConfigFragmentPresenter(this);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void buscarTagUsuario(String tag) {
        presenter.buscarTagUsuario(tag);
    }

    @Override
    public void mostrarTagUsuario() {

    }


    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvTagMascota.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaTagAdaptador crearAdaptador(SearchUser searchUsers) {
        MascotaTagAdaptador adaptador = new MascotaTagAdaptador(searchUsers, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaTagAdaptador adaptador) {
        rvTagMascota.setAdapter(adaptador);
    }


    @Override
    public void mensajeUsuarioNoEncontrado() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
