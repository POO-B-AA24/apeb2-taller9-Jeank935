package taller_9;

import java.util.Scanner;

public class Problema_6_Banco {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        boolean opcion = true;

        do {
            System.out.println("Que tipo de cuenta bancaria tiene: \n"
                    + "1. Cuenta Cheques\n"
                    + "2. Cuenta Ahorros\n"
                    + "3. Cuenta Platino");
            int nC = tcl.nextInt();
            switch (nC) {
                case 1:
                    CuentaCheque cCheques = new CuentaCheque("1111", "JEAN", 10000);
                    boolean subOpcion1 = true;
                    while (subOpcion1) {
                        System.out.println("QUE DESEA REALIZAR?\n"
                                + "1. DEPOSITAR\n"
                                + "2. RETIRAR\n"
                                + "3. SALIR y Mostrar Balance");
                        int n = tcl.nextInt();
                        switch (n) {
                            case 1:
                                System.out.println("Ingrese la cantidad que desea depositar");
                                double cantidad = tcl.nextDouble();
                                cCheques.depositar(cantidad);
                                break;
                            case 2:
                                System.out.println("Ingrese la cantidad que desea retirar");
                                cantidad = tcl.nextDouble();
                                cCheques.retirar(cantidad);  // Se cambió depositar por retirar
                                break;
                            case 3:
                                System.out.println("Balance cuenta cheques: " + cCheques.getBalance());
                                subOpcion1 = false;
                                opcion = false;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;  // Salir del switch principal
                case 2:
                    CuentaAhorros cAhorros = new CuentaAhorros(0.10, "222", "Julieta", 0);
                    boolean subOpcion2 = true;
                    while (subOpcion2) {
                        System.out.println("QUE DESEA REALIZAR?\n"
                                + "1. DEPOSITAR\n"
                                + "2. RETIRAR\n"
                                + "3. SALIR y Mostrar Balance");
                        int n = tcl.nextInt();
                        switch (n) {
                            case 1:
                                System.out.println("Ingrese la cantidad que desea depositar");
                                double cantidad = tcl.nextDouble();
                                cAhorros.depositar(cantidad);
                                break;
                            case 2:
                                System.out.println("Ingrese la cantidad que desea retirar");
                                cantidad = tcl.nextDouble();
                                cAhorros.retirar(cantidad);  // Se cambió depositar por retirar
                                break;
                            case 3:
                                System.out.println("Balance cuenta ahorros: " + cAhorros.getBalance());
                                subOpcion2 = false;
                                opcion = false;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;  // Salir del switch principal
                case 3:
                    CuentaPlatino cPlatino = new CuentaPlatino("333", "Sofia", 0);
                    boolean subOpcion3 = true;
                    while (subOpcion3) {
                        System.out.println("QUE DESEA REALIZAR?\n"
                                + "1. DEPOSITAR\n"
                                + "2. RETIRAR\n"
                                + "3. SALIR y Mostrar Balance");
                        int n = tcl.nextInt();
                        switch (n) {
                            case 1:
                                System.out.println("Ingrese la cantidad que desea depositar");
                                double cantidad = tcl.nextDouble();
                                cPlatino.depositar(cantidad);
                                break;
                            case 2:
                                System.out.println("Ingrese la cantidad que desea retirar");
                                cantidad = tcl.nextDouble();
                                cPlatino.retirar(cantidad);  // Se cambió depositar por retirar
                                break;
                            case 3:
                                System.out.println("Balance cuenta platino: " + cPlatino.getBalance());
                                subOpcion3 = false;
                                opcion = false;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;  // Salir del switch principal
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion);

    
        }
}
class Cuenta {

    public String numeroCuenta;
    public String nombreCliente;
    public double balance;

    public Cuenta(String numeroCuenta, String nombreCliente, double balance) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + '}';
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0) {
            balance -= cantidad;
            return true;
        }
        return false;
    }

    public double obtenerBalanceActual() {
        return 4;
    }
}

class CuentaCheque extends Cuenta {

    public CuentaCheque(String numeroCuenta, String nombreCliente, double balance) {
        super(numeroCuenta, nombreCliente, balance);
    }

    @Override
    public String toString() {
        return "CuentaCheque{" + '}';
    }

    @Override
    public boolean retirar(double cantidad) {
        return super.retirar(cantidad);
    }
}

class CuentaAhorros extends Cuenta {

    public double interes;

    public CuentaAhorros(double interes, String numeroCuenta, String nombreCliente, double balance) {
        super(numeroCuenta, nombreCliente, balance);
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" + "interes=" + interes + '}';
    }

    @Override
    public boolean retirar(double cantidad) {
        if (balance >= cantidad) {
            return super.retirar(cantidad);
        }
        return false;
    }

    public void calcularInteres() {
        if (balance > 0) {
            balance += balance * interes / 100;
        }
    }
}

class CuentaPlatino extends Cuenta {

    public CuentaPlatino(String numeroCuenta, String nombreCliente, double balance) {
        super(numeroCuenta, nombreCliente, balance);
    }

    @Override
    public boolean retirar(double cantidad) {
        return super.retirar(cantidad);
    }

    public void calcularInteres() {
        if (balance > 0) {
            balance += balance * 0.10 / 100;
        }
    }

    @Override
    public String toString() {
        return "CuentaPlatino{" + '}';
    }
}
