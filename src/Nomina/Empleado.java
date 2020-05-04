package Nomina;
/**
 * @author Alejandro Erazo
 */

public class Empleado {
    
    // Atributos
    private String nombre;
    private int cedula;
    private String cargo;
    private int salario;
    
    // Constructor
    public Empleado(String Nombre, int Cedula, String Cargo, int Salario) {
        this.nombre = Nombre;
        this.cedula = Cedula;
        this.cargo = Cargo;
        this.salario = Salario;
    }

    // Get & Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }


    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getCargo() {
        return cargo;
    }

    public int getSalario() {
        return salario;
    }
    
}
