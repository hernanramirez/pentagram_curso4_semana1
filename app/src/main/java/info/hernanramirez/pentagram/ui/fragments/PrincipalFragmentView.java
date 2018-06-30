package info.hernanramirez.pentagram.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import info.hernanramirez.pentagram.R;
import info.hernanramirez.pentagram.adapters.MascotaAdaptador;
import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PrincipalFragmentView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PrincipalFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrincipalFragmentView extends Fragment implements IPrincipalFragment.View{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Mascota mascota;
    private PrincipalFragmentPresenter presenter;
    private ProgressBar progressBar;
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView rvMascota;
    private Snackbar snackbar;
    CircularImageView circularImageView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PrincipalFragmentView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrincipalFragmentView.
     */
    // TODO: Rename and change types and number of parameters
    public static PrincipalFragmentView newInstance(String param1, String param2) {
        PrincipalFragmentView fragment = new PrincipalFragmentView();
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
        View v = inflater.inflate(R.layout.fragment_principal, container, false);

        coordinatorLayout = (CoordinatorLayout) v.findViewById(R.id.coordinatorLayoutPrincipal);
        rvMascota = (RecyclerView) v.findViewById(R.id.rvMascota);
        progressBar = (ProgressBar) v.findViewById(R.id.progress);

        circularImageView = (CircularImageView) v.findViewById(R.id.imgMascota);


        presenter = new PrincipalFragmentPresenter(this);
        obtenerDatosRecientes(v);


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

    public void obtenerDatosRecientes(View view){
        presenter.obtenerMediosRecientes();
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
    public void mostarDatosRecientes() {

        System.out.println("Mostar datos recientes vista");

        Snackbar.make(getActivity().findViewById(R.id.coordinatorLayoutPrincipal),
                "Datos recientes del usuario", Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void mostrarFotoPerfil(String perfilFoto) {


        //Picasso.get().load(perfilFoto).into(circularImageView);
        Picasso.get().load(Uri.parse(perfilFoto)).placeholder(R.drawable.logoperro).into(circularImageView);

        

        System.out.println(perfilFoto);

    }

    @Override
    public void mostarErrorDatosRecientes() {

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMascota.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(Mascota mascota) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, getActivity());
        return adaptador;
    }


    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascota.setAdapter(adaptador);
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
