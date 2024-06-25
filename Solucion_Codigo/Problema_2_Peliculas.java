import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problema_2_Peliculas {
    public static void main(String[] args) {
        //INSTANCIAR EL OBJETO PARA LA GENERACION ALEATORIA
        Random aleatorio = new Random();

        String[] estreno = {"KING KONG", "MIB 3", "SPIDER-MAN"};
        String[] cartelera = {"DEADPOOL", "WOLVERINE","INTENSAMENTE 2"};
        String[] autores = {"Jennifer Aniston","Lucinda Alvarado","Ramiro Acaro"};

        DVD soporteP1 = new DVD(4.9); 
        VHS soporteP2 = new VHS("MAGNETICA");
        
        ArrayList<String> idiomaP1 = new ArrayList<>(Arrays.asList("ESPANIOL","INGLES","ALEMAN")); 
        ArrayList<String> idiomaP2 = new ArrayList<>(Arrays.asList("INGLES")); 
        
        ArrayList<Pelicula> listaPelis = new ArrayList<>();
        listaPelis.add(new Pelicula(estreno[aleatorio.nextInt(3)], 
                autores[aleatorio.nextInt(3)], 2021, idiomaP1, "ESTRENO", soporteP1));
        listaPelis.add(new Pelicula(estreno[aleatorio.nextInt(3)], 
                autores[aleatorio.nextInt(3)], 1998, idiomaP2, "ESTRENO", soporteP2));
        listaPelis.add(new Pelicula(cartelera[aleatorio.nextInt(3)], 
                autores[aleatorio.nextInt(3)], 2018, idiomaP1, "CARTELERA", soporteP1));

        for (Pelicula peli : listaPelis){
            peli.calcularCostoAlquiler();
        }
        
        Scanner tc = new Scanner(System.in);
        int seguir = 0,opcion = 0, numPelicula = 0, pago = 0;
        double total = 0;
        ArrayList<String>pelisElegidas = new ArrayList<>();
        
        System.out.println("*************************");
        do{
            System.out.println("ESCOJA UNA OPCION");
            System.out.println("[1] --> MOSTRAR PELICULAS DISPONIBLES");
            System.out.println("[2] --> AGREGAR UNA PELICULA AL CARRITO");
            System.out.println("[3] --> PAGAR Y SALIR");
            opcion = tc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("PELICULAS DISONIBLES PARA ALQUILAR:");
                    for (int i = 0; i < listaPelis.size(); i++) {
                        System.out.println("PELICULA "+(i+1));
                        System.out.println(listaPelis.get(i));
                    }
                    break;
                case 2:
                    System.out.println("INGRESA EL NUMERO DE PELICULA QUE DESEAS AGEGAR:");
                    numPelicula = tc.nextInt();
                    System.out.println("HAS AGREGADO LA PELICULA: ");
                    System.out.println(listaPelis.get(numPelicula-1).titulo);
                    
                    //ACUMULAR PARA EL TOTAL
                    pelisElegidas.add(listaPelis.get(numPelicula-1).titulo);
                    total += listaPelis.get(numPelicula-1).costoAlquiler;
                    break;
                case 3:
                    System.out.println("HAZ ELEGIDO LAS PELICULAS:");
                    for (String titulo : pelisElegidas){
                        System.out.println(titulo);
                    }
                    System.out.println("EL TOTAL ES: "+total);
                    break;
                default:
                    System.out.println("***OPCION INCORRECTA***");
                    break;
            }
            if(opcion == 3){
                seguir = 1;
                System.out.println("Saliendo...");
            }
        }while(seguir == 0);
        
        
    }
}class Pelicula {
    //ATRIBUTOS
    public String titulo;
    public String autor;
    public int anioedicion;
    public ArrayList<String> idioma;
    public String tipo;
    public double costoAlquiler;
    public Soporte soporte;

    public Pelicula(String titulo, String autor, int anioedicion, ArrayList<String> idioma, String clasificacion, Soporte soporte) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioedicion = anioedicion;
        this.idioma = idioma;
        this.tipo = clasificacion;
        this.soporte = soporte;
    }

    public void calcularCostoAlquiler() {
        
        if(this.tipo.equalsIgnoreCase("ESTRENO"))
            this.costoAlquiler = 15;
        else if(this.tipo.equalsIgnoreCase("CARTELERA"))
            this.costoAlquiler = 5;
        
        if (soporte instanceof DVD) {
            this.costoAlquiler *= 1.1;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }
    
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("TITULO: ").append(this.titulo).append("\n");
        cadena.append("AUTOR: ").append(this.autor).append("\n");
        cadena.append("CLASIFICACION: ").append(this.tipo).append("\n");
        cadena.append("ANIO EDICION: ").append(this.anioedicion).append("\n");
        cadena.append("IDIOMA(S): ").append(this.idioma).append("\n");
        cadena.append("COSTO DE ALQUILER: ").append(this.costoAlquiler).append("\n");
        cadena.append("SOPORTE: ").append(this.soporte).append("\n");
        return cadena.toString();
    }
}

class Soporte {

}

class DVD extends Soporte {

    private double capacidadGB;

    public DVD(double capacidadGB) {
        this.capacidadGB = capacidadGB;
    }

    @Override
    public String toString() {
        return "DVD{" + "CAPACIDAD EN GB = " + capacidadGB + '}';
    }
}

class VHS extends Soporte {

    private String tipoCinta;

    public VHS(String tipoCinta) {
        this.tipoCinta = tipoCinta;
    }

    @Override
    public String toString() {
        return "VHS{" + "TIPO DE CINTA = " + tipoCinta + '}';
    }
}