package info.hernanramirez.pentagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import info.hernanramirez.pentagram.R;
import info.hernanramirez.pentagram.api.models.SearchUser.Datum;
import info.hernanramirez.pentagram.api.models.SearchUser.SearchUser;
import info.hernanramirez.pentagram.api.models.SearchUser.StandardResolution;
import info.hernanramirez.pentagram.api.models.SearchUser.User;

/**
 * Created by Hernan Ramirez on 23/06/18.
 */
public class MascotaTagAdaptador extends RecyclerView.Adapter<MascotaTagAdaptador.MascotaTagViewHolder>{

    private SearchUser searchUsers;
    Activity activity;

    public MascotaTagAdaptador(SearchUser searchUsers, Activity activity) {
        this.searchUsers = searchUsers;
        this.activity = activity;
    }

    @Override
    public MascotaTagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota_tag, parent, false);
        return new MascotaTagViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaTagViewHolder MascotaTagViewHolder, int position) {
        final StandardResolution standardResolution = this.searchUsers.getData().get(position).getImages().getStandardResolution();
        final Datum datum = this.searchUsers.getData().get(position);
        final User user = this.searchUsers.getData().get(position).getUser();

        Picasso.get().load(standardResolution.getUrl()).into(MascotaTagViewHolder.imgMascota);

        MascotaTagViewHolder.tvLikes.setText(String.valueOf(datum.getLikes().getCount()));
        MascotaTagViewHolder.tvUser.setText(user.getUsername());

        String tagString = "";

        for (String s : datum.getTags())
        {
            tagString += s + "\t";
        }

        MascotaTagViewHolder.tvTag.setText(tagString);

    }

    @Override
    public int getItemCount() {
        return searchUsers.getData().size();
    }

    public static class MascotaTagViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvLikes;
        private TextView tvUser;
        private TextView tvTag;

        public MascotaTagViewHolder(View itemView) {
            super(itemView);

            imgMascota  = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);
            tvUser      = (TextView) itemView.findViewById(R.id.tvUser);
            tvTag       = (TextView) itemView.findViewById(R.id.tvTag);

        }
    }
}
