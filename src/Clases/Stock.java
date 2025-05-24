
package Clases;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Stock {
    private class Nodo{
        Cita cita;
        Nodo next;
        Nodo prev;
    
        public Nodo(Cita cita){
            this.cita = cita;  
            this.next = null;
            this.prev = null;
        }
    }
    
    //Atributos
    Nodo head;
    Nodo tail;
    
    public Stock(){this.head = this.tail = null;}
    
    public boolean estaVacia(){return this.head == null;}
    
    public void agregarFinal(Cita newCita){
        Nodo nuevo = new Nodo(newCita);
        if(nuevo.cita.getPrioridad()> 0)
        {
            if(this.estaVacia()){this.head = this.tail = nuevo;}
            else{
                this.tail.next = nuevo;
             nuevo.prev = this.tail;
             this.tail = nuevo;
            }
             JOptionPane.showMessageDialog(null, "Se agrego cita del paciente " + newCita.getNombrePaciente(), 
                 "Agregar cita", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Error en la prioridad de " + newCita.getNombrePaciente(), 
                 "Agregar cita", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void eliminar (String eliminado){
        Nodo aux = this.head;
        Nodo eli = null;
        if(this.estaVacia()){
            JOptionPane.showMessageDialog(null, "No se encuentran citas registradas.",
                    "Error al eliminar", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.head.cita.getNombrePaciente().equalsIgnoreCase(eliminado))
        {
            this.head = eli;
            this.head = this.head.next;
        }
        else
        {
            while(aux.next != null)
            {
                if(aux.cita.getNombrePaciente().equalsIgnoreCase(eliminado)){
                    aux.prev.next = aux.next;
                    aux.next.prev=aux.prev;
                    JOptionPane.showMessageDialog(null, "Cita del paciente " + eliminado + " ha sido eliminada con exito",
                    "Eliminar Cita", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }else{aux = aux.next;}       
            }
            if(aux.next == null)
            {
                JOptionPane.showMessageDialog(null, "No se encuentran citas registradas.",
                    "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
    
    
    @Override
    public String toString() {
        String txt = "----------- Citas ---------- \n";
        if(this.estaVacia()){txt = "La listas de citas esta vacia.";}
        else 
        {
            Nodo aux = this.head;
            while(aux != null)
            {
                txt += aux.cita.toString();
                aux = aux.next;
            }
        }
        return txt;
    }
    
   /* public String mostrar(){
        String txt = this.toString();
       JOptionPane.showMessageDialog(null, txt,
                "Mostrar citas programadas.",
                (this.estaVacia() ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE));
        return txt;
    }*/
    
   public void actualizarTabla(DefaultTableModel modelo){
       modelo.setRowCount(0); //recuerda limpiar la tabla anterior antes de actualizar
        Nodo actual = this.head;

        while(actual != null){
            Cita cita = actual.cita;
            
            modelo.addRow(new Object[]{
                cita.getNombrePaciente(),
                cita.getFecha(),
                cita.getHora(),
                cita.getMotivo(),
                cita.getPrioridad(),
                cita.getNombreDoctor()});
            
            actual = actual.next;
        }
    }
}

    
