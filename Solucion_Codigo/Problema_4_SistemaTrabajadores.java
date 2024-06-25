package taller_9;

import java.util.ArrayList;
import java.util.Scanner;

public class Problema_4_SistemaTrabajadores {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Jefe jefe1 = new Jefe("Jean", "Cuenca", "Los Ceibos", "111");
        Jefe jefe2 = new Jefe("Carlos", "Alvarado", "AV.Nueva Loja", "222");

        FijoMensual fijomensual1 = new FijoMensual(jefe1, "Sofia", "Castillo", "Pileta", "333");
        FijoMensual fijomensual2 = new FijoMensual(jefe1, "Rene", "Conde", "Hipervalle", "444");

        Comisionista comisionista1 = new Comisionista(jefe2, 3, "Mauricio", "Zuniga", "Malacatos", "555");

        PorHoras porhoras1 = new PorHoras(jefe1, 48, "Juan", "LOPEZ", "Amable Maria", "666");

        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        listaTrabajadores.add(jefe1);
        listaTrabajadores.add(jefe2);
        listaTrabajadores.add(fijomensual1);
        listaTrabajadores.add(fijomensual2);
        listaTrabajadores.add(comisionista1);
        listaTrabajadores.add(porhoras1);
        NominaTrabajadores nomina = new NominaTrabajadores(listaTrabajadores);

        for (Trabajador trabajador : nomina.listaTrabajadores) {
            trabajador.calcularSueldo();
        }
        System.out.println("***Cedula del trabajador que desea dar de alta:***");
        String cedAlta = tcl.next();
        nomina.darAltaTrabajador(cedAlta);
        System.out.println("==================================================");
        nomina.fijarHorasRealizadas();
        nomina.fijarVentasRealizadas();
        System.out.println(nomina.imprimirNomina());
        System.out.println("==================================================");
    }
}

class NominaTrabajadores {

    public ArrayList<Trabajador> listaTrabajadores;
    public int horasRealizadas;
    public int ventasRealizadas;

    public NominaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public void darAltaTrabajador(String DNI) {
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i).DNI.equalsIgnoreCase(DNI)) {
                listaTrabajadores.remove(i);
            }
        }
    }

    public void fijarHorasRealizadas() {
        for (Trabajador trabajador : listaTrabajadores) {
            this.horasRealizadas += trabajador.horasTrabajadas();
        }
    }

    public void fijarVentasRealizadas() {
        for (Trabajador trabajador : listaTrabajadores) {
            this.ventasRealizadas += trabajador.ventasRealizadas();
        }
    }

    public String imprimirNomina() {
        String nomina = "NOMINA DE TRABAJADORES: \n";
        for (Trabajador trabajador : listaTrabajadores) {
            nomina += trabajador + "\n";
        }
        nomina += "HORAS TOTALES: " + horasRealizadas + "\n";
        nomina += "VENTAS REALIZADAS: " + ventasRealizadas + "\n";
        return nomina;
    }
}

class Trabajador {

    public String nombre;
    public String apellido;
    public String direccion;
    public String DNI;
    public double sueldo;

    public Trabajador(String nombre, String apellido, String direccion, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.DNI = DNI;
    }

    public int horasTrabajadas() {
        return 0;
    }

    public int ventasRealizadas() {
        return 0; // 
    }

    public void calcularSueldo() {
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", DNI=" + DNI + ", sueldo=" + sueldo;
    }
}

class FijoMensual extends Trabajador {

    public Jefe jefe;

    public FijoMensual(Jefe jefe, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.jefe = jefe;
    }

    @Override
    public void calcularSueldo() {
        this.sueldo = 425;
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre;
    }
}

class Comisionista extends Trabajador {

    public Jefe jefe;
    public int ventasRealizadas;

    public Comisionista(Jefe jefe, int ventasRealizadas, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.jefe = jefe;
        this.ventasRealizadas = ventasRealizadas;
    }

    
    @Override
    public int ventasRealizadas() {
        return ventasRealizadas; 
    }

    @Override
    public void calcularSueldo() {
        this.sueldo = (this.ventasRealizadas * 100) * 0.30;
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre + ", ventasRealiadas=" + ventasRealizadas;
    }
}

class PorHoras extends Trabajador {

    public Jefe jefe;
    public int horasTrabajadas;

    public PorHoras(Jefe jefe, int horasTrabajadas, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.jefe = jefe;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public int horasTrabajadas() {
        return horasTrabajadas;
    }

    @Override
    public void calcularSueldo() {
        this.sueldo = this.horasTrabajadas * 10;
        if (this.horasTrabajadas > 40) {
            this.sueldo = (40 * 10) + (this.horasTrabajadas - 40) * 20;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre + ", horasTrabajadas=" + horasTrabajadas;
    }
}

class Jefe extends Trabajador {

    public Jefe(String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
    }

    @Override
    public void calcularSueldo() {
        this.sueldo = 2000;
    }
}
