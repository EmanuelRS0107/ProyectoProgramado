package modelo;

public class Profesor extends Persona {
    private String idProfesor;
    private String especialidad;
    private String tipoContrato; 

    public Profesor(String idProfesor, String especialidad, String tipoContrato, String nombres, String apellidos, String email, String telefono) {
        // Esta clase hereda de Persona 
        super(nombres, apellidos, email, telefono);
        this.idProfesor = idProfesor;
        this.especialidad = especialidad;
        this.tipoContrato = tipoContrato;
    }
    
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
    //método toString para acceder a los datos
    @Override
    public String toString() {
        return idProfesor + "," + especialidad + "," + tipoContrato + "," +
               getNombres() + "," + getApellidos() + "," + getEmail() + "," + getTelefono();  
}
    
}
