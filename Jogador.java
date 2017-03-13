
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class Jogador extends JFrame {

    private JButton Pedir_Cartas;
    private JButton Esperar;
    private JButton Jogar;
    private JButton Lista;
    private JButton Sair;
    private JPanel buttons;
    private JTextArea displayArea; // display information to user
    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String message = ""; // message from server
    private String chatServer; // host server for this application
    private Socket client; // socket to communicate with server
    private int cardamt = 0;
    private String Nome; // NOMEEEE
    Toolkit toolkit;
    Timer timer;
    int ContadorTime = 1; // contador do time do game

    public Jogador(String host, String Nick) {
        super( "Jogador" );
        chatServer = host; // endereço servidor
        Nome = Nick;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new Jogador.RemindTask(),
                0, //initial delay
                15 * 1000);

        buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        Pedir_Cartas = new JButton("Pedir Cartas");
        Esperar = new JButton("Esperar");
        Jogar = new JButton("Jogar");
        Lista = new JButton("Lista");
        Sair =   new JButton("Desconectar");

        Pedir_Cartas.addActionListener(
                new ActionListener() {
                    // envia mensagem pro servidor
                    public void actionPerformed(ActionEvent event) {
                        sendData("pedir");
                    } // fim method actionPerformed
                } // fim anonymous inner class
        ); // fim da chamada addActionListener

        Esperar.addActionListener(
                new ActionListener() {
                    // envia message para server
                    public void actionPerformed(ActionEvent event) {
                        sendData("esperar");
                    } // fim method actionPerformed
                } // fim anonymous inner class
        ); // fim call to addActionListener

        Jogar.addActionListener(
                new ActionListener() {
                    // envia message para server
                    public void actionPerformed(ActionEvent event) {
                        sendData("Jogar");
                        Jogar.setEnabled(false);
                    } // fim method actionPerformed
                } // fim anonymous inner class
        );
        Lista.addActionListener(
                new ActionListener() {
                    // envia message para server
                    public void actionPerformed(ActionEvent event) {
                        sendData("Lista");
                    } // fim method actionPerformed
                } // fim anonymous inner class
        );
        Sair.addActionListener(
                new ActionListener() {
                    // envia message para server
                    public void actionPerformed(ActionEvent event) {
                        closeConnection();
                    } // fim method actionPerformed
                } // fim anonymous inner class
        );

        buttons.add(Pedir_Cartas, BorderLayout.SOUTH);
        buttons.add(Jogar, BorderLayout.SOUTH);
        buttons.add(Esperar, BorderLayout.SOUTH);
        buttons.add(Lista, BorderLayout.SOUTH);
        buttons.add(Sair, BorderLayout.SOUTH);
        buttons.setVisible(false);
        Jogar.setEnabled(false);
        add(buttons, BorderLayout.SOUTH);
        displayArea = new JTextArea(); // cria o display
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(500, 300); // tamanho janela
        setVisible(true); // exibição janela
    } // fim Client constructor

    // conexão coms ervidor processo de envio de mensagem
    public void runClient() {
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        try // conexão com servidor processo de conexão, getstrams
        {
            connectToServer(); // cria Socket para connection
            getStreams(); // obtem a entrada e saida de mensagems
            processConnection(); // processso conexão
        } // fim try
        catch (EOFException eofException) {
            displayMessage("\nConexão encerrada do Cliente");
        } // fim catch
        catch (IOException ioException) {
        } // fim catch
        finally {
            closeConnection(); // fecha conexão
        } // fim finally
    } // fim method runClient

    // conexão para server
    private void connectToServer() throws IOException {
        displayMessage("Tentativa de Conexão\n");

        // cria socket para realizar conexão com servidor
        client = new Socket(InetAddress.getByName(chatServer), 1993);// entrada do endereço servidor e porta de conexão
        // mensagems display
        displayMessage("Conectado  : "
                + client.getInetAddress().getHostName());

    } // fim method connectToServer

    // obtem stream de recebimento e envio de mensagens
    private void getStreams() throws IOException {
        // objeto de entradas
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // buffer

        // objetos de saida
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nConseguiu I/O streams\n");
    } // fim method getStreams

    // processo de conexão com servidor
    private void processConnection() throws IOException {

        do // processo de conexão coms ervidor
        {
            try // ler mensagem e display
            {
                message = (String) input.readObject(); // leia nova mensagem
                displayMessage("\n" + message); // display de mensagem
                String nome = new String("-" + Nome);
                if (message.contains("Recebendo Informação")) {
                    sendData(nome);
                }
                if (message.contains("Começou")) {
                    buttons.setVisible(true);
                    Pedir_Cartas.setEnabled(true);
                    Esperar.setEnabled(true);
                    ContadorTime = 3;
                }
                if (message.contains("Bust!") || message.contains("Please Wait")) {
                    buttons.setVisible(false);
                }

                if (message.contains("Fim")) {
                    buttons.setVisible(true);
                    Pedir_Cartas.setEnabled(false);
                    Esperar.setEnabled(false);
                    Jogar.setEnabled(true);
                }

            } // fim try // fim try // fim try // fim try
            catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nObjeto desconhecido");
            } // fim catch

        } while (!message.equals("SERVER>>> TERMINATE"));
    } // fim method processConnection

    // fechar streams and socket
    private void closeConnection() {
        displayMessage("\nConexão fechada");

        try {
            output.close(); // fechar output stream
            input.close(); // fechar input stream
            client.close(); // fechar socket
        } // fim try
        catch (IOException ioException) {
        } // fim catch
    } // fim method closeConnection

    // senvia message para o server
    private void sendData(String message) {
        try //enviar objeto para o server
        {
            output.writeObject(message);
            output.flush();

        } // fim try
        catch (IOException ioException) {
            displayArea.append("\nErro em escrever Objeto");
        } // fim catch
    } // fim method sendData

    // manipula mensagems no display
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // atualização display
                    {
                        displayArea.append(messageToDisplay);
                    } // fim method run
                } // fim anonymous inner class
        ); // fim da chamada para SwingUtilities.invokeLater
    } // fim method displayMessage

    class RemindTask extends TimerTask {// toda vez que as cartas são dadas o jogador tem o tempo de 45s para terminar seu turno

        public void run() {
            if (ContadorTime > 0) {// verifica se o contador é maior que 0 caso seja ele decrescenta 1 no contador
                System.out.println("Tempo Restante: " + ContadorTime * 15 + " segundos");
                ContadorTime--;
            } else {
                toolkit.beep();// caso contador seja menor ou igual a 0 ele realiza a operação de esperar e imprimi a mensagem de tempo esgotado
                sendData("esperar");
                displayMessage("\nTempo Esgotado....");
        
            }
        }
    }
}//fim player class
