package rat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vero on 24/02/2015.
 */


public class client {
    private Socket mySocket;
    static ServerSocket ss;
    private DataOutputStream bufferEscritura;
    private BufferedReader bufferLectura;


    public client(InetAddress address, int port)throws IOException {
            mySocket = new Socket(address, port);
            InicializaStreams();
          // iniciado programa
    }


        /**
         * Inicialización de los bufferes de lectura y escritura del socket
         * @throws java.io.IOException
         */
    public void InicializaStreams() throws IOException {
        bufferEscritura = new DataOutputStream(mySocket.getOutputStream());
        bufferLectura = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        System.out.println("canales creados");
    }

    public void CerrarStreams() throws IOException {
        bufferEscritura.close();
        bufferLectura.close();
        System.out.println("canales cerrados");
    }

    public void CerrarSocket() throws IOException {
        mySocket.close();
    }

    /**
     * @return String
     * @throws java.io.IOException
     * Metodos de entrada salida del los sockets
     */
    public String Leer() throws IOException {
        return (bufferLectura.readLine());
    }

    public void Escribir(String contenido) throws IOException {
        bufferEscritura.writeBytes(contenido);
    }

    public void Escribir(byte[] buffer, int bytes) throws IOException {
        bufferEscritura.write(buffer, 0, bytes);
    }
    public void EscribirBytes(byte[] buffer, int bytes) throws IOException{

        bufferEscritura = new DataOutputStream(mySocket.getOutputStream());
        bufferEscritura.writeInt(bytes);
        System.out.println("escribir bytes");
        if(bytes > 0)
            bufferEscritura.write(buffer, 0, bytes);
    }
    public byte[] LeerBytes() throws IOException{

        DataInputStream dis = new DataInputStream(mySocket.getInputStream());


        int bytes = dis.readInt();
        System.out.println(bytes);
        byte[] data = new byte[bytes];
        System.out.println("leer ");
        if (bytes > 0) {
            dis.readFully(data);
        }
        return data;

    }
    public static void main(String[] args) throws Exception {
    client a;
        try {
            //entro en mikel
            InetAddress ip = InetAddress.getByName("192.168.85.1");
            a=  new client(ip,2345);
            System.out.println("entra en mikel");
        } catch (Exception e) {
            //entro en vero
            InetAddress ip = InetAddress.getByName("10.164.53.134");
            a=  new client(ip,2345);
            System.out.println("entra en vero");
        }

    }
}

