package es.usj.zaragozatricks.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import es.usj.zaragozatricks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LugaresFragment extends Fragment {


    public LugaresFragment() {
        // Required empty public constructor
    }

    ListView list;
    ImageView img1, img2, img3;
    String[] AndroidOS = new String[]{"Plaza del Pilar", "Palacio de la Aljafería", "Acuario Fluvial", "Puerto Venecia"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lugares, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = view.findViewById(R.id.list);
        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, AndroidOS);

        list.setAdapter(adapter);
        list.setSelector(R.color.colorPrimaryDark);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:
                        img1.setImageResource(R.drawable.pilar_img1_lonja_y_seo);
                        img2.setImageResource(R.drawable.pilar_img2_fuente_hispanidad_zgz);
                        img3.setImageResource(R.drawable.pilar_img3_pilar_ebro_2004);
                        break;
                    case 1:
                        img1.setImageResource(R.drawable.img_aljaferia1);
                        img2.setImageResource(R.drawable.img_aljaferia2);
                        img3.setImageResource(R.drawable.img_aljaferia3);
                        break;
                    case 2:
                        img1.setImageResource(R.drawable.img_acuario1);
                        img2.setImageResource(R.drawable.img_acuario2);
                        img3.setImageResource(R.drawable.img_acuario3);
                        break;
                    case 3:
                        img1.setImageResource(R.drawable.img_puertovenecia1);
                        img2.setImageResource(R.drawable.img_puertovenecia2);
                        img3.setImageResource(R.drawable.img_puertovenecia3);
                        break;
                }
            }
        });
    }



}
