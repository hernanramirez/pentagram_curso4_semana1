package info.hernanramirez.pentagram.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.hernanramirez.pentagram.R;
import info.hernanramirez.pentagram.api.models.SelfUser.Datum;
import info.hernanramirez.pentagram.api.models.SelfUser.Images;
import info.hernanramirez.pentagram.api.models.SelfUser.Mascota;
import info.hernanramirez.pentagram.api.models.SelfUser.StandardResolution;
import info.hernanramirez.pentagram.api.models.SelfUser.Thumbnail;

/**
 * Created by Hernan Ramirez on 23/06/18.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private Mascota mascota;
    Activity activity;

    public MascotaAdaptador(Mascota mascota, Activity activity) {
        this. mascota = mascota;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, int position) {
        final StandardResolution standardResolution = this.mascota.getData().get(position).getImages().getStandardResolution();
        final Datum datum = this.mascota.getData().get(position);
        //MascotaViewHolder.imgMascota.setImageResource(thumbnail.getUrl());

        Picasso.get().load(standardResolution.getUrl()).into(MascotaViewHolder.imgMascota);

        //MascotaViewHolder.tvNombre.setText(contacto.getNombre());
        //MascotaViewHolder.tvTelefono.setText(contacto.getTelefono());


        MascotaViewHolder.tvLikes.setText(String.valueOf(datum.getLikes().getCount()));
        
        /*
        MascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("url", contacto.getUrlFoto());
                intent.putExtra("like", contacto.getLikes());
                //intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });
        */

        /*MascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeCotnacto(contacto);
                MascotaViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto) + " Likes");


            }
        });*/


    }

    @Override
    public int getItemCount() {
        return mascota.getData().size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        //private TextView tvNombre;
        //private TextView tvTelefono;
        //private ImageButton btnLike;
        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota     = (ImageView) itemView.findViewById(R.id.imgMascota);
            /*tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
            */
            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
