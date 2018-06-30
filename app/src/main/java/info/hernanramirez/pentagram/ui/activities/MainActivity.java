package info.hernanramirez.pentagram.ui.activities;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import info.hernanramirez.pentagram.R;
import info.hernanramirez.pentagram.ui.fragments.PrincipalFragmentView;


public class MainActivity extends AppCompatActivity implements PrincipalFragmentView.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.dog_paw);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, new PrincipalFragmentView())
                    .commit();
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_acerca:

                View messageView = getLayoutInflater().inflate(R.layout.dialogo_acerca, null, false);

                AlertDialog.Builder dialogo_acerca = new AlertDialog.Builder(MainActivity.this);
                //dialogo_acerca.setIcon(R.drawable.footprint_black);
                dialogo_acerca.setTitle(R.string.app_name);
                dialogo_acerca.setView(messageView);
                dialogo_acerca.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();

                    }
                });
                dialogo_acerca.create();

                dialogo_acerca.show();

                break;


            /*
            case R.id.mFavoritos:
                Intent i = new Intent(this, MascotasFavoritas.class);
                startActivity(i);
                break;
            */

        }
        return super.onOptionsItemSelected(item);
    }


}
