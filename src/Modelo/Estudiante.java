package modelo;

public class Estudiante extends Persona {
    private String carnet;
    private String carrera;
    private int nivel;

    public Estudiante(String nombres, String apellidos, String email, String telefono,
                      String carnet, String carrera, int nivel) {
        super(nombres, apellidos, email, telefono);
        this.carnet = carnet;
        this.carrera = carrera;
        this.nivel = nivel;
    }

    public String getCarnet() { return carnet; }
    public void setCarnet(String carnet) { this.carnet = carnet; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    @Override
    public String toString() {
        return carnet + "," + carrera + "," + nivel + "," +
               nombres + "," + apellidos + "," + email + "," + telefono;
    }
}
