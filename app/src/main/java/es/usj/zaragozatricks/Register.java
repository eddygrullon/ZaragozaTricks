package es.usj.zaragozatricks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class Register extends Activity {

    private SharedPreferences preferences;
    private EditText mNombre;
    private Button mEnter;
    private EditText txtDate;
    private ArrayList<String> mProfile;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mNombre = findViewById(R.id.editText4);
        txtDate = findViewById(R.id.txtDate);
        mEnter = findViewById(R.id.enter);
        ctx = this;
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProfile = new ArrayList<String>();
                mProfile.add(mNombre.getText().toString());
                mProfile.add(txtDate.getText().toString());
                UtilsHelper.setProfileInfo("profileInfo",ctx,mProfile);
                Intent i = new Intent(ctx,MainActivity.class);
                startActivity(i);
            }
        });

    }

}
