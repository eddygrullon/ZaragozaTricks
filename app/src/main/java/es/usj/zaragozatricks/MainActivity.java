package es.usj.zaragozatricks;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;



public class MainActivity extends AppCompatActivity  {

    private CardView cv_empadronarse, cv_nie,cv_transporte, cv_deInteres,cv_universidad,cv_lugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
/*
        cv_empadronarse = (CardView) findViewById(R.id.cv_empadronarse);
        cv_nie = (CardView) findViewById(R.id.cv_nie);
        cv_transporte = (CardView) findViewById(R.id.cv_transporte);
        cv_deInteres = (CardView) findViewById(R.id.cv_deInteres);
        cv_universidad = (CardView) findViewById(R.id.cv_universidad);
        cv_lugares = (CardView) findViewById(R.id.cv_lugares);

        cv_empadronarse.setOnClickListener(this);
        cv_nie.setOnClickListener(this);
        cv_transporte.setOnClickListener(this);
        cv_deInteres.setOnClickListener(this);
        cv_universidad.setOnClickListener(this);
        cv_lugares.setOnClickListener(this);

*/
    }


}
