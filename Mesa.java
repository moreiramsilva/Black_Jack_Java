
import javax.swing.JFrame;


public class Mesa {
    /*
     TRABALHO DE REDES DE COMPUTADOR 1
     GRUPO:
     ALEXANDRE MACIEL
     MATHEUS MOREIRA 
     NAYARA CRISTINA

     */

    public static void main(String[] args) {
        Interface servidor = new Interface(); // criar servidor
        servidor.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        servidor.runDeal();
    } // fim main
} // fim class ServerTest
