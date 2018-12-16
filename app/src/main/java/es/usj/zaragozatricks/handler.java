package es.usj.zaragozatricks;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;


public class handler extends AppCompatActivity {

    public final int fragment_container = R.id.fragment_container;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        Intent i = getIntent();
        int fragmentID = i.getIntExtra("fragmentID",0);
        title = findViewById(R.id.txtTitle2);
        manageFragment(fragmentID);



    }

    public void manageFragment(int fragment){
        if (fragment == R.layout.fragment_lugares){
            title.setText("Lugares");
            LugaresFragment lugaresFragment = new LugaresFragment();
            FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(fragment_container, lugaresFragment);
            fragmentTransaction.commit();
        }else if (fragment == R.layout.fragment_universidad){
            title.setText("Universidad");
            UniversidadFragment universidadFragment = new UniversidadFragment();
            FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(fragment_container, universidadFragment);
            fragmentTransaction.commit();
        }else if (fragment == R.layout.fragment_transporte) {
            title.setText("Transporte");
            TransporteFragment transporteFragment = new TransporteFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(fragment_container, transporteFragment);
            fragmentTransaction.commit();
        }else if (fragment == R.layout.fragment_nie) {
            title.setText("N.I.E");
            NIEFragment nieFragment = new NIEFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(fragment_container, nieFragment);
            fragmentTransaction.commit();
        }else if (fragment == R.layout.fragment_empadronarse) {
            title.setText("Empadronarse");
            EmpadronarseFragment empadronarseFragment = new EmpadronarseFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(fragment_container, empadronarseFragment);
            fragmentTransaction.commit();
        }

    }

}
