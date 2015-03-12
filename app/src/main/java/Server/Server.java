package Server;

/**
 * Created by Mikel on 26/02/2015.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class Server extends Thread
{
    ServerSocket wellcomeSocket;

    public void run ()
    {

        try {
            wellcomeSocket = new ServerSocket(2345);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            Socket.SocketManager sockManager = null;
            try {
                sockManager = new Socket.SocketManager(wellcomeSocket.accept());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                Server.Request request = null;
                try {
                    request = new Server.Request(sockManager);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Thread thre = new Thread(request);
                thre.start();


        }
    }

