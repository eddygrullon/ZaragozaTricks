package es.usj.zaragozatricks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class ProfileInfo {

    public  String nombre;
    public  String fecha;
    public  String pais;
    public  String universidad;
    public  String carrera;

    public ProfileInfo(){}

    public ProfileInfo(String Nombre, String Fecha, String Pais, String Universidad, String Carrera){
        nombre = Nombre;
        fecha = Fecha;
        pais = Pais;
        universidad = Universidad;
        carrera = Carrera;
    }

    public static void setSharedProfile(Context context, ProfileInfo profileInfo ){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString("nombre",profileInfo.nombre);
        editor.putString("fecha",profileInfo.fecha);
        editor.putString("pais",profileInfo.pais);
        editor.putString("universidad",profileInfo.universidad);
        editor.putString("carrera",profileInfo.carrera);
        editor.apply();
    }

    public static ProfileInfo getSharedProfile(Context context){
        SharedPreferences sp = getSharedPreference(context);
        return new ProfileInfo(
                sp.getString("nombre",""),
                sp.getString("fecha",""),
                sp.getString("pais",""),
                sp.getString("universidad",""),
                sp.getString("carrera","")

        );
    }

    private static SharedPreferences getSharedPreference(Context ctx) {
        return ctx.getSharedPreferences("profileInfo", Activity.MODE_PRIVATE);
    }
}
