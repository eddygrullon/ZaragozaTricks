package es.usj.zaragozatricks.models;

public class Carrera {

    public String NombreCarrera;



    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        NombreCarrera = nombreCarrera;
    }



    public Carrera(String nombreCarrera) {
        NombreCarrera = nombreCarrera;
    }

    @Override
    public String toString() {
        return NombreCarrera;
    }
}
