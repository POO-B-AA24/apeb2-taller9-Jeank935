package taller_9;

import java.util.Scanner;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Random;

public class Problema_5_Entradas {

    public static void main(String[] args) {

        Scanner tcl = new Scanner(System.in);
        int opcion = 0, seguir = 0, numZona = 0, tipoEntrada = 0, IDconsulta = 0;
        Zona principal = new Zona("PRINCIPAL", 200, 25, 17.5);
        Zona palcoB = new Zona("PALCOB", 40, 70, 40);
        Zona central = new Zona("CENTRAL", 400, 20, 14);
        Zona lateral = new Zona("LATERAL", 100, 15.5, 10);
        ArrayList<Zona> listaZonas = new ArrayList<>();
        listaZonas.add(principal);
        listaZonas.add(palcoB);
        listaZonas.add(central);
        listaZonas.add(lateral);

        ArrayList<Entrada> compradas = new ArrayList<>();

        System.out.println("*******SISTEMA VENTAS ENTRADAS*******");
        do {
            System.out.println("QUE DESEAS HACER??");
            System.out.println("[1] --> VENDER ENTRADA");
            System.out.println("[2] --> CONSULTAR ENTRADA");
            System.out.println("[3] --> SALIR");
            opcion = tcl.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("QUE ZONA DESEAS?");
                    System.out.println("[1] -> PRINCIPAL");
                    System.out.println("[2] -> PALCOB");
                    System.out.println("[3] -> CENTRAL");
                    System.out.println("[4] -> LATERAL");
                    numZona = tcl.nextInt();
                    switch (numZona) {
                        case 1:
                            if (principal.verificarPuesto()) {
                                System.out.println("INGRESA EL NOMBRE DEL CLIENTE: ");
                                String nombreCliente = tcl.next();

                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tcl.nextInt();

                                switch (tipoEntrada) {
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(principal, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(principal, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(principal, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            } else {
                                System.out.println("SE TERMINARON LOS BOLETOS PARA ESA ZONA");
                            }
                            break;
                        case 2:
                            if (palcoB.verificarPuesto()) {
                                System.out.println("INGRESA EL NOMBRE DEL CLIENTE: ");
                                String nombreCliente = tcl.next();
                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tcl.nextInt();
                                switch (tipoEntrada) {
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(palcoB, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(palcoB, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(palcoB, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            } else {
                                System.out.println("SE TERMINARON LOS BOLETOS PARA ESA ZONA");
                            }
                            break;
                        case 3:
                            if (central.verificarPuesto()) {
                                System.out.println("INGRESA EL NOMBRE DEL CLIENTE: ");
                                String nombreCliente = tcl.next();

                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tcl.nextInt();

                                switch (tipoEntrada) {
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(central, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(central, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(central, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            } else {
                                System.out.println("NO HAY CUPOS PARA EZA ZONA");
                            }
                            break;
                        case 4:
                            if (lateral.verificarPuesto()) {
                                System.out.println("INGRESA EL NOMBRE DEL CLIENTE: ");
                                String nombreCliente = tcl.next();

                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tcl.nextInt();

                                switch (tipoEntrada) {
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(lateral, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(lateral, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(lateral, nombreCliente);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            } else {
                                System.out.println("SE TERMINARON LOS BOLETOS PARA ESA ZONA");
                            }
                            break;
                        default:
                            System.out.println("ZONA INCORRECTA");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("INGRESA EL ID DE LA ENTRADA QUE VAS A CONSULTAR");
                    IDconsulta = tcl.nextInt();
                    for (int i = 0; i < compradas.size(); i++) {
                        if (compradas.get(i).id == IDconsulta) {
                            if (tipoEntrada == 1) {
                                System.out.println("ENTRADA: NORMAL");
                            } else if (tipoEntrada == 2) {
                                System.out.println("ENTRADA: ABONADO");
                            } else if (tipoEntrada == 3) {
                                System.out.println("ENTRADA: REDUCIDO");
                            }
                            System.out.println("COMPRADOR: " + compradas.get(i).nombreCliente);
                            System.out.println("PRECIO: " + compradas.get(i).precio);
                            System.out.println("ZONA: " + compradas.get(i).zona.nombre);
                        }
                    }
                    break;
                case 3:
                    System.out.println("GRACIAS POR USAR ESTE PROGRAMA");
                    seguir = 1;
                    break;
            }
        } while (seguir == 0);
    }
}

class Zona {

    public String nombre;
    public int capacidad;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombre, int capacidad, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    public boolean verificarPuesto() {
        if (this.capacidad > 0) {
            return true;
        }
        return false;
    }

    public void ocuparPuesto() {
        this.capacidad -= 1;
    }

}

class Entrada {

    public Zona zona;
    public int id;
    public String nombreCliente;
    public double precio;

    public Entrada(Zona zona, String nombreCliente) {
        this.zona = zona;
        this.nombreCliente = nombreCliente;
    }

    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioNormal;
        return precio;
    }

    public void asignarID() {
        Random random = new Random();
        int numeroAleatorio = 10000 + random.nextInt(90000);
        this.id = numeroAleatorio;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + '}';
    }

}

class EntradaNormal extends Entrada {

    public EntradaNormal(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }
}

class EntradaReducida extends Entrada {

    public EntradaReducida(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);

    }

    @Override
    public double calcularPrecioEntrada() {
        this.precio = super.calcularPrecioEntrada() * 0.85;
        return precio;
    }
}

class EntradaAbonado extends Entrada {

    public EntradaAbonado(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
    }

    @Override
    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioAbonado;
        return precio;
    }
}
