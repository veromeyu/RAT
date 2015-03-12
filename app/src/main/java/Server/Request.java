package Server;
import Socket.SocketManager;

/**
 * Created by Mikel on 26/02/2015.
 */

    final class Request implements Runnable {

        final static String CRLF = "\r\n";
        SocketManager sockManager;

           // Constructor
        public Request(SocketManager sockMan) throws Exception {
            sockManager = sockMan;
        }

        public void run() {
            try {
                processRequest();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void processRequest() throws Exception {
        }
    }