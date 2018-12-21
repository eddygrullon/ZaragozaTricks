package es.usj.zaragozatricks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.BubbleIconFactory;
import com.google.maps.android.ui.IconGenerator;

import es.usj.zaragozatricks.ProfileInfo;
import es.usj.zaragozatricks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UniversidadFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;


//    BubbleIconFactory klk = new BubbleIconFactory();
    public UniversidadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_universidad, container, false);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance( );

        mapFragment.getMapAsync(this);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.map_university,mapFragment).commit();

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        IconGenerator iconFactory = new IconGenerator(this.getContext());
        iconFactory.setStyle(IconGenerator.STYLE_GREEN);
        LatLng tuFacultad = new LatLng(41.7567506, -0.8331442);
        switch (ProfileInfo.getSharedProfile(this.getContext()).carrera){
            case "Ingieneria de Software":
                tuFacultad = new LatLng(41.7571537, -0.8324628);
                break;
            case"Enfermeria":
                tuFacultad = new LatLng(41.7576541, -0.8318201);
                break;
                default: tuFacultad = null;
        }

        if(tuFacultad != null)
        mMap. addMarker(new MarkerOptions().position(tuFacultad).icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(getString(R.string.esta_es_tu_facultad)))));

        LatLng initCamera = new LatLng(41.7567506, -0.8331442);
        LatLng usj = new LatLng(41.756199, -0.8331459);
        mMap.addMarker(new MarkerOptions().position(usj));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initCamera, 17));

    }
}
