package es.usj.zaragozatricks.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import es.usj.zaragozatricks.R;
import es.usj.zaragozatricks.ProfileInfo;

public class MainActivity extends AppCompatActivity  {

    static final int REQUEST_IMAGE_CAPTURE = 55;
    private CardView cv_empadronarse, cv_nie,cv_transporte, cv_deInteres,cv_universidad,cv_lugares;
    private int fragment_id;
    private TextView tvNombre;
    private ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNombre = findViewById(R.id.txtSecondTitle);
        cv_empadronarse = findViewById(R.id.cv_empadronarse);
        cv_nie =  findViewById(R.id.cv_nie);
        cv_transporte =  findViewById(R.id.cv_transporte);
        cv_deInteres = findViewById(R.id.cv_deInteres);
        cv_universidad =  findViewById(R.id.cv_universidad);
        cv_lugares = findViewById(R.id.cv_lugares);
        ivProfile = findViewById(R.id.iv_profile);

        setProfileData();

        cv_nie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callHandler(R.layout.fragment_nie);
            }
        });

        cv_empadronarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_empadronarse);

            }
        });
        cv_transporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_transporte);

            }
        });
        cv_deInteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callHandler(R.layout.);

            }
        });
        cv_universidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_universidad);
            }
        });
        cv_lugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_lugares);
            }
        });
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    private void callHandler(int fragment){

        Intent intent = new Intent(this,handler.class);
        intent.putExtra("fragmentID", fragment);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void setProfileData(){
        ProfileInfo  profile = ProfileInfo.getSharedProfile(this);
        tvNombre.setText("Bienvenido "+ profile.nombre );

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivProfile.setImageBitmap(imageBitmap);
        }
    }

}
