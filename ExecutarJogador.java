
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 TRABALHO DE REDES DE COMPUTADOR 1
 GRUPO:
 ALEXANDRE MACIEL
 MATHEUS MOREIRA 
 NAYARA CRISTINA

 */

public class ExecutarJogador {

    public static void main(String[] args) {
        Jogador aplicacao; // declaração de cliente da aplicação
        String nome;
        JOptionPane.showMessageDialog(null, "Trabalho BlackJack da Disciplina de Rede I\n\n[Alexandre.M  |  Matheus.M  |  Nayara.C]");
        nome = JOptionPane.showInputDialog("Insira o nome do jogador: ");

        // if no command line args
        if (args.length == 0) {
            aplicacao = new Jogador("127.0.0.1", nome); // parametros de conexão cliente servidor
        } else {
            aplicacao = new Jogador(args[0], "Sem nome"); // argumento para conexão
        }
        
        aplicacao.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacao.runClient(); // executa aplicacao
      
    } // fim Main.
} // fim class ClientTest

