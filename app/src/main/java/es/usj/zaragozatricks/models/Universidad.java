package es.usj.zaragozatricks.models;

import java.util.ArrayList;

public class Universidad {


    private String NombreUniversidad;
    private ArrayList<Carrera> ListaDeCarreras;

    public Universidad(String nombreUniversidad, ArrayList<Carrera> listaDeCarreras) {
        NombreUniversidad = nombreUniversidad;
        ListaDeCarreras = listaDeCarreras;
    }

    public String getNombreUniversidad() {
        return NombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        NombreUniversidad = nombreUniversidad;
    }



    public ArrayList<Carrera> getListaDeCarreras() {
        return ListaDeCarreras;
    }

    public void setListaDeCarreras(ArrayList<Carrera> listaDeCarreras) {
        ListaDeCarreras = listaDeCarreras;
    }


    @Override
    public String toString() {
        return NombreUniversidad;
    }
}
