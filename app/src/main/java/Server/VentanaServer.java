package Server;
/**
 * Created by Mikel on 26/02/2015.
 */
public class VentanaServer { // ventana que hara de interface para nuestro control y lanzara el hilo "malicioso".
    public VentanaServer(){
       Server serv = new Server();
        serv.start();
        System.out.print("vivoooo");
    }

}
