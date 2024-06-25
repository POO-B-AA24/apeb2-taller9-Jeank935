
package taller_9;

public class Problema_3_SistemaMensajes {
    public static void main(String[] args) {
        String remitente = "Jean";
        String destinatario = "Paula";
        Movil rem = new Movil("0988989089", remitente);
        Movil des = new Movil("0987654321", destinatario);
        String mensajeSms = "HOLA "+ destinatario+ " ,como estas?";
        Sms sms = new Sms(mensajeSms, remitente, destinatario);
        System.out.println(sms.enviarMensaje());
        System.out.println(sms.visualizarMensaje());;
        String archImagen = "pdf.informesOficina";
        Mms mms = new Mms(archImagen, remitente, destinatario);
        System.out.println(mms.enviarMensaje());
        System.out.println(mms.visualizarMensaje());
    }
}
class Movil{
    public String numeroCelular;
    public String guardarNombre;

    public Movil(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Movil(String numeroCelular, String guardarNombre) {
        this.numeroCelular = numeroCelular;
        this.guardarNombre = guardarNombre;
    }
}
class Mensaje{
    public String remitente;
    public String destinatario;

    public Mensaje(String remitente, String destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
    public String enviarMensaje(){
        String mensaje = remitente+" Esta enviando mensaje..."+" para: "+destinatario;
        return mensaje;
    }
    public String visualizarMensaje(){
        String vMensaje = "Mensaje de; "+remitente;
        return vMensaje;
    }
}
class Sms extends Mensaje{
    public String texto;

    public Sms(String texto, String remitente, String destinatario) {
        super(remitente, destinatario);
        this.texto = texto;
    }
    @Override
    public String enviarMensaje(){
        super.enviarMensaje();
        String enviarSms= "Mensaje de texto: "+ texto;
        return enviarSms;
    }
    @Override
    public String visualizarMensaje(){
        super.visualizarMensaje();
        String visualizarSms = "Mensaje de texto"+ texto;
        return visualizarSms;
    }
}
class Mms extends Mensaje{
    public String imagen;

    public Mms(String imagen, String remitente, String destinatario) {
        super(remitente, destinatario);
        this.imagen = imagen;
    }
    @Override
    public String enviarMensaje(){
        super.enviarMensaje();
        String enviarMms= "Archivo de Imagen: "+ imagen;
        return enviarMms;
    }
    @Override
    public String visualizarMensaje(){
        super.visualizarMensaje();
        String visualizarMms = "Archivo de Imagen: "+ imagen;
        return visualizarMms;
    }
}

