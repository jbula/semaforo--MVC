/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

//import Vista.SemaforoInterfaz;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author DAVID
 */
public class ServidorSemaforoDavid {

    /**
     * @param args the command line arguments
     */
    private static ServerSocket ServidorSockets;    
    private static Socket SocketCliente;
    private static ThreadSend ThreadEnviar;
    private static ArrayList<ThreadSend> ListaClientes;

    public static void main(String[] args) {
//        SemaforoInterfaz miSemaforo = SemaforoInterfaz.getInstance();
        ExecutorService PoolExecutor = Executors.newCachedThreadPool();
        try {
            ServidorSockets = new ServerSocket(11112, 100);
            ListaClientes = new ArrayList<ThreadSend>();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "1.1 Error Thread Send Servidor: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
        }
  //      miSemaforo.setVisible(true);
        int NroClientes = 0;
        while (true) {
            try {
                SocketCliente = ServidorSockets.accept();
                
                ThreadEnviar = new ThreadSend(SocketCliente);
                PoolExecutor.execute(ThreadEnviar);
                ThreadEnviar.SendMessage();
               // ThreadEnviar.run();
                ListaClientes.add(ThreadEnviar);
                NroClientes++;
                //miSemaforo.setNroClientes(NroClientes);
                //miSemaforo.setClientesConectados(ListaClientes);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "1.2 Error Thread Send Servidor: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
            }
        }
        
    }
    
}
