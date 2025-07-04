package modelo;

import java.util.ArrayList;

public class Curso {
    private String codigo;
    private String nombre;
    private String descripcion;
    private Profesor profesor;
    private int capacidadMaxima;
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso(String codigo, String nombre, String descripcion, Profesor profesor, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.capacidadMaxima = capacidadMaxima;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        if (listaEstudiantes.contains (e)){
            listaEstudiantes.add(e);
        }
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + descripcion + "," + profesor.getIdProfesor() + "," + capacidadMaxima;
    }
}
