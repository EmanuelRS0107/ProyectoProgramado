package archivo;

import modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class ManejoDeArchivos {

    private static final String ESTUDIANTES_FILE = "estudiantes.txt";
    private static final String PROFESORES_FILE = "profesores.txt";
    private static final String CURSOS_FILE = "cursos.txt";
    private static final String MATRICULAS_FILE = "matriculas.txt";

    public static void guardarEstudiantes(ArrayList<Estudiante> estudiantes) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ESTUDIANTES_FILE));
        for (Estudiante e : estudiantes) {
            bw.write(e.toString());
            bw.newLine();
        }
        bw.close();
    }

 public static ArrayList<Estudiante> leerEstudiantes() throws IOException {
    ArrayList<Estudiante> lista = new ArrayList<>();
    File archivo = new File(ESTUDIANTES_FILE);
    if (!archivo.exists()) archivo.createNewFile();

    BufferedReader br = new BufferedReader(new FileReader(archivo));
    String linea;
    while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(",");
        String carnet = datos[0];
        String carrera = datos[1];
        int nivel = Integer.parseInt(datos[2]);
        String nombres = datos[3];
        String apellidos = datos[4];
        String email = datos[5];
        String telefono = datos[6];

        Estudiante estudiante = new Estudiante(nombres, apellidos, email, telefono,
                                               carnet, carrera, nivel);
        lista.add(estudiante);
    }

    br.close();
    return lista;
}

    public static void guardarProfesores(ArrayList<Profesor> profesores) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PROFESORES_FILE));
        for (Profesor p : profesores) {
            bw.write(p.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static ArrayList<Profesor> leerProfesores() throws IOException {
    ArrayList<Profesor> lista = new ArrayList<>();
    File archivo = new File(PROFESORES_FILE);
    if (!archivo.exists()) archivo.createNewFile();

    BufferedReader br = new BufferedReader(new FileReader(archivo));
    String linea;
    while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(",");
        if (datos.length < 7) {
            continue;
        }
        String idProfesor = datos[0];
        String especialidad = datos[1];
        String tipoContrato = datos[2];
        String nombres = datos[3];
        String apellidos = datos[4];
        String email = datos[5];
        String telefono = datos[6];

        Profesor profesor = new Profesor(idProfesor, especialidad, tipoContrato, nombres, apellidos, email, telefono);
        lista.add(profesor);
    }
    br.close();
    return lista;
}

    public static void guardarCursos(ArrayList<Curso> cursos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(CURSOS_FILE));
        for (Curso c : cursos) {
            bw.write(c.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static ArrayList<Curso> leerCursos(ArrayList<Profesor> profesores) throws IOException {
        ArrayList<Curso> lista = new ArrayList<>();
        File archivo = new File(CURSOS_FILE);
        if (!archivo.exists()) archivo.createNewFile();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String codigo = datos[0];
            String nombre = datos[1];
            String descripcion = datos[2];
            String idProfesor = datos[3];
            int capacidad = Integer.parseInt(datos[4]);

            Profesor profe = buscarProfesorPorId(profesores, idProfesor);
            if (profe != null) {
                lista.add(new Curso(codigo, nombre, descripcion, profe, capacidad));
            }
        }
        br.close();
        return lista;
    }

    private static Profesor buscarProfesorPorId(ArrayList<Profesor> profesores, String id) {
        for (Profesor p : profesores) {
            if (p.getIdProfesor().equals(id)) return p;
        }
        return null;
    }

    public static void guardarMatriculas(ArrayList<Matricula> matriculas) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(MATRICULAS_FILE));
        for (Matricula m : matriculas) {
            bw.write(m.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static ArrayList<Matricula> leerMatriculas(ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos) throws IOException {
        ArrayList<Matricula> lista = new ArrayList<>();
        File archivo = new File(MATRICULAS_FILE);
        if (!archivo.exists()) archivo.createNewFile();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String carnet = datos[0];
            String codigoCurso = datos[1];
            LocalDate fecha = LocalDate.parse(datos[2]);

            Estudiante est = buscarEstudiantePorCarnet(estudiantes, carnet);
            Curso cur = buscarCursoPorCodigo(cursos, codigoCurso);
            if (est != null && cur != null) {
                lista.add(new Matricula(est, cur, fecha));
                cur.getListaEstudiantes().add(est);
            }
        }
        br.close();
        return lista;
    }

    private static Estudiante buscarEstudiantePorCarnet(ArrayList<Estudiante> estudiantes, String carnet) {
        for (Estudiante e : estudiantes) {
            if (e.getCarnet().equals(carnet)) return e;
        }
        return null;
    }

    private static Curso buscarCursoPorCodigo(ArrayList<Curso> cursos, String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) return c;
        }
        return null;
    }
}
