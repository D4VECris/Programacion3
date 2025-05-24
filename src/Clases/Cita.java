
package Clases;
public class Cita {
    
    private String nombrePaciente;
    private String fecha;   // Formato YYYY-MM-DD
    private String hora;    // Formato HH:mm
    private String motivo;
    private int prioridad;  // 1: Alta, 2: Media, 3: Baja
    private String nombreDoctor;

    public Cita(String nombrePaciente, String fecha, String hora, String motivo, int prioridad, String nombreDoctor) {
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.setPrioridad1(prioridad);
        this.nombreDoctor = nombreDoctor;
    }
    private void setPrioridad1(int prioridad){this.setPrioridad(prioridad);}
    
    public void setPrioridad (int prioridad){
        if(prioridad > 0 && prioridad <= 3){this.prioridad = prioridad;}
        else {this.prioridad = -1;}
    }
    
    //Getters 
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }
    
    //Metodos de uso 

    @Override
    public String toString() {
        String txt = "- Nombre paciente " + this.nombrePaciente +
                "\n - Fecha " + this.fecha +
                "\n - Hora " + this.hora +
                "\n - Motivo " + this.motivo +
                "\n - Prioridad " + this.prioridad +
                "\n - Nombre doctor " + this.nombreDoctor + "\n\n";
        return txt;
    }
}
