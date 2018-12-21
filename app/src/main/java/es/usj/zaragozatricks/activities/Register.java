package es.usj.zaragozatricks.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

import es.usj.zaragozatricks.R;
import es.usj.zaragozatricks.ProfileInfo;
import es.usj.zaragozatricks.models.Carrera;
import es.usj.zaragozatricks.models.Universidad;

public class Register extends Activity implements AdapterView.OnItemSelectedListener {

    private SharedPreferences preferences;
    private EditText etNombre;
    private Button btnEnter;
    private Context ctx = this;
    private Spinner sp_Universidad, spPais, spCarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etNombre = findViewById(R.id.editText4);
        btnEnter = findViewById(R.id.enter);


        ArrayList<Carrera> listaCarreraUni_1 = new ArrayList<Carrera>();
        listaCarreraUni_1.add((new Carrera(getString(R.string.ingenieria_de_software))));
        listaCarreraUni_1.add((new Carrera(getString(R.string.enfermeria))));

        ArrayList<Carrera> listaCarreraUni_2 = new ArrayList<Carrera>();
        listaCarreraUni_2.add((new Carrera("Ingieneria de Civil")));
        listaCarreraUni_2.add((new Carrera("Albanil")));

        Universidad universidad_1 = new Universidad("Universidad San Jorge",listaCarreraUni_1);
        Universidad universidad_2 = new Universidad("Universidad de Zaragoza", listaCarreraUni_2);

        ArrayList<Universidad> listUniversidad = new ArrayList<Universidad>();
        listUniversidad.add(universidad_1);
        listUniversidad.add(universidad_2);


        sp_Universidad = findViewById(R.id.sp_Universidad);
        ArrayAdapter<Universidad> adapter = new ArrayAdapter<Universidad>(this, android.R.layout.simple_spinner_dropdown_item,listUniversidad);
        sp_Universidad.setAdapter(adapter);
        sp_Universidad.setOnItemSelectedListener(this);

        spPais = findViewById(R.id.spPais);
        ArrayAdapter<CharSequence> adapterPaises = ArrayAdapter.createFromResource(this,R.array.Paises, android.R.layout.simple_spinner_item);
        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPais.setAdapter(adapterPaises);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ProfileInfo profile = new ProfileInfo(
                        etNombre.getText().toString(),
                        Calendar.getInstance().getTime().toString(),
                        spPais.getSelectedItem().toString(),
                        sp_Universidad.getSelectedItem().toString(),
                        spCarrera.getSelectedItem().toString()
                );

                ProfileInfo.setSharedProfile(ctx,profile);
                Intent i = new Intent(ctx,MainActivity.class);
                startActivity(i);
            }
        });

        spCarrera = findViewById(R.id.spCarrera);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      Universidad uni= (Universidad)sp_Universidad.getSelectedItem();
      spCarrera.setAdapter(new ArrayAdapter<Carrera>(this, android.R.layout.simple_spinner_dropdown_item,uni.getListaDeCarreras()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
