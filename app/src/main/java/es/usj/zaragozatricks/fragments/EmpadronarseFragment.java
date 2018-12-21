package es.usj.zaragozatricks.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.usj.zaragozatricks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmpadronarseFragment extends Fragment {

    Button btnOpenUrl;

    public EmpadronarseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_empadronarse, container, false);
    }

    public void openURLinBrowser(){
        String url = "https://www.zaragoza.es/sede/portal/tramites-servicios/cita-previa";

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnOpenUrl= view.findViewById(R.id.btnCitaPrevia);
        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURLinBrowser();
            }
        });
    }
}
