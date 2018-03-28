/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author DAVID
 */
public class ClienteSemaforoDavid {

    /**
     * @param args the command line arguments
     */
    private static Socket Servidor;
    private static String IpServidor = "127.0.0.1";
    public static void main(String[] args) {
        ExecutorService PoolExecutor = Executors.newCachedThreadPool();
        try {
            Servidor = new Socket(InetAddress.getByName(IpServidor), 11112);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "1.3 Error Thread Recibe Cliente: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
        }
        ThreadReceive mi = new ThreadReceive(Servidor);
        PoolExecutor.execute(mi);
        
        //mi.run();
    }
    
}
