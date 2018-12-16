package es.usj.zaragozatricks;


import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmpadronarseFragment extends Fragment {


    public EmpadronarseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empadronarse, container, false);
    }

    public void openURLinBrowser(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.zaragoza.es/sede/portal/tramites-servicios/cita-previa"));
        startActivity(browserIntent);
    }



}
