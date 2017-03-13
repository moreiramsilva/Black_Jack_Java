
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Interface extends javax.swing.JFrame {

    private Baralho NovoBaralho;
    private ExecutorService executor; // Onde será executado os Jogadores
    private ServerSocket server; // Server socket
    private Interface.SockServer[] sockServer; // Array de objetos de thread
    private int contador = 1; // Conta o numero de conexoes
    private int MAXCONEXAO = 4; // Maximo de player permitido para Jogar
    private String dcard1, dcard2;
    private ArrayList<RegrasBJ> jogadores; //Lista de jogadores conectados
    private RegrasBJ dcards;
    private int jogadoresleft; // 
    private boolean roundover = true;
    private int Jogando = 1;
    private int Ausente = 0; // VARIAVEL PARA CONTAR JOGADORES AUSENTES E NA FILA DE ESPERA
    private ArrayList<String> nickjogadores = null; // NOME DOS JOGADORES 

    public Interface() {
        initComponents();
        setSize(530, 525);//Tamanho da Tela
        setResizable(false); // Bloqueia o redimensionamento 

        //super( "Interface" );
        jogadores = new ArrayList(); //Array de Player
        nickjogadores = new ArrayList<String>();
        sockServer = new Interface.SockServer[100]; // 
        executor = Executors.newFixedThreadPool(10); // criação das thread

        setVisible(true);// Abilita interface
    }

    @SuppressWarnings("Nao verificado")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Carta2 = new javax.swing.JLabel();
        Carta1 = new javax.swing.JLabel();
        Carta3 = new javax.swing.JLabel();
        Carta4 = new javax.swing.JLabel();
        Carta5 = new javax.swing.JLabel();
        Carta6 = new javax.swing.JLabel();
        Carta7 = new javax.swing.JLabel();
        Carta8 = new javax.swing.JLabel();
        Carta9 = new javax.swing.JLabel();
        Carta11 = new javax.swing.JLabel();
        Carta12 = new javax.swing.JLabel();
        Carta13 = new javax.swing.JLabel();
        Cartas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayArea = new javax.swing.JTextArea();
        Fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta2.setText("jLabel1");
        Carta2.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta2.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta2.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta2);
        Carta2.setBounds(40, 350, 78, 108);

        Carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta1.setText("jLabel1");
        Carta1.setMaximumSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta1);
        Carta1.setBounds(10, 370, 78, 108);

        Carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta3.setText("jLabel1");
        Carta3.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta3.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta3.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta3);
        Carta3.setBounds(170, 350, 78, 108);

        Carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta4.setText("jLabel1");
        Carta4.setMaximumSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta4);
        Carta4.setBounds(140, 370, 78, 108);

        Carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta5.setText("jLabel1");
        Carta5.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta5.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta5.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta5);
        Carta5.setBounds(300, 350, 78, 108);

        Carta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta6.setText("jLabel1");
        Carta6.setMaximumSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta6);
        Carta6.setBounds(270, 370, 78, 108);

        Carta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta7.setText("jLabel1");
        Carta7.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta7.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta7.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta7);
        Carta7.setBounds(430, 350, 78, 108);

        Carta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta8.setText("jLabel1");
        Carta8.setMaximumSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta8);
        Carta8.setBounds(400, 370, 78, 108);

        Carta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta9.setText("jLabel1");
        Carta9.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta9.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta9.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta9);
        Carta9.setBounds(30, 220, 78, 108);

        Carta11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta11.setText("jLabel1");
        Carta11.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta11.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta11.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta11);
        Carta11.setBounds(170, 220, 78, 108);

        Carta12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta12.setText("jLabel1");
        Carta12.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta12.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta12.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta12);
        Carta12.setBounds(290, 220, 78, 108);

        Carta13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/images (1).jpg"))); // NOI18N
        Carta13.setText("jLabel1");
        Carta13.setMaximumSize(new java.awt.Dimension(101, 68));
        Carta13.setMinimumSize(new java.awt.Dimension(101, 68));
        Carta13.setPreferredSize(new java.awt.Dimension(101, 68));
        getContentPane().add(Carta13);
        Carta13.setBounds(420, 220, 78, 108);

        Cartas.setText("Dar as Cartas");
        Cartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartasActionPerformed(evt);
            }
        });
        getContentPane().add(Cartas);
        Cartas.setBounds(50, 160, 430, 23);

        jScrollPane1.setAutoscrolls(true);

        displayArea.setEditable(false);
        displayArea.setColumns(20);
        displayArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        displayArea.setRows(5);
        jScrollPane1.setViewportView(displayArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 10, 430, 140);

        Fundo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Fundo.png"))); // NOI18N
        Fundo.setInheritsPopupMenu(false);
        getContentPane().add(Fundo);
        Fundo.setBounds(0, 0, 540, 500);
        Fundo.getAccessibleContext().setAccessibleName("Fundo1");

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Açao feita quando clicar no botao Dar cartas
    private void CartasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartasActionPerformed

        Cartas.setEnabled(false); // Desabilita o botao dar as cartas
        NovoBaralho = new Baralho();// Cria novo baralho0
        roundover = false;
        DealCards(); // Chama funçao de dar as cartas
        displayMessage("\nCartas Distribuidas\n"); //Aparece no display Cartas Distribuidas


    }//GEN-LAST:event_CartasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Carta1;
    private javax.swing.JLabel Carta11;
    private javax.swing.JLabel Carta12;
    private javax.swing.JLabel Carta13;
    private javax.swing.JLabel Carta2;
    private javax.swing.JLabel Carta3;
    private javax.swing.JLabel Carta4;
    private javax.swing.JLabel Carta5;
    private javax.swing.JLabel Carta6;
    private javax.swing.JLabel Carta7;
    private javax.swing.JLabel Carta8;
    private javax.swing.JLabel Carta9;
    private javax.swing.JButton Cartas;
    private javax.swing.JLabel Fundo;
    private javax.swing.JTextArea displayArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void runDeal() {

        try // Rcebebe as conexoes e processa elas
        {
            server = new ServerSocket(1993, 100); // Cria ServerSocket com dados da porta e quantidade de sockets permissiveis

            while (true) {
                try {
                    //Cria um novo objeto para o cliente que chamar
                    sockServer[contador] = new SockServer(contador);
                    // Espera um cliente se conectar
                    sockServer[contador].waitForConnection();
                    // Iniciar objeto do servidor em uma nova Thread
                    executor.execute(sockServer[contador]);

                } // Fim try
                catch (EOFException eofException) {
                    displayMessage("\nServidor encerrou a conexão");
                } // Fim catch
                finally {
                    ++contador;
                } // Fim finally
            } // Fim while
        } // Fim try
        catch (IOException ioException) {
        } // Fim catch
    } // Fim metodo runServer

    private void displayMessage(final String messageToDisplay)//Metodo de manipulaçao do que aparece no Display
    {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // Atualizar displayArea
                    {
                        displayArea.append(messageToDisplay); // Inserir mensagem

                    }
                }
        );
    } //Fim do metodo displayMessage

    private void DealCards() { // Funçao chamada após apertas botao de Dar as Cartas

        try {

            Jogando = 1; // Manter controle de que todos estão prontos para jogar
            jogadoresleft = contador - 1;
            NovoBaralho.shuffle(); //Novo Baralho embaralhado
            dcard1 = NovoBaralho.dealCard(); //Pega uma carta
            dcard2 = NovoBaralho.dealCard(); // Pega outra carta

            displayMessage("\n Carta1 = " + dcard1 + "     Carta2 = " + dcard2); // Exibe o nome das cartas recebidas

            for (int i = 1; i <= contador; i++) { // Distribui cartas para todos os Players que estao no jogo

                if (i == 1) {
                    sockServer[i].sendData("\nComeçou"); // Envia para os Players que a partida começou
                    String c1, c2;
                    c1 = NovoBaralho.dealCard(); // Recebe carta 1
                    c2 = NovoBaralho.dealCard(); // Recebe carta 2

                    ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + c1 + ".png"));// Imagem da carta 1
                    Carta1.setIcon(iic);//Modifica a carta
                    ImageIcon iic2 = new ImageIcon(getClass().getResource("/Imagens/" + c2 + ".png"));// Imagem da Carta 2
                    Carta2.setIcon(iic2);//Modifica a carta   
                    RegrasBJ p = new RegrasBJ(c1, c2); // Classe com as regras do jogo
                    jogadores.add(p); // 
                    sockServer[i].sendData("Você Possui:\n" + c1 + " " + c2); //Envia para o Player qual carta ele recebeu
                    sockServer[i].sendData("Total de Pontos: " + p.GetCardTotal()); // Envia para o Player quantos pontos ele tem
                } else if (i == 2) {
                    sockServer[i].sendData("\nComeçou"); // Envia para os Players que a partida começou
                    String c1, c2;
                    c1 = NovoBaralho.dealCard(); // Recebe carta 1
                    c2 = NovoBaralho.dealCard(); // Recebe carta 2

                    ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + c1 + ".png"));// Imagem da carta 1
                    Carta3.setIcon(iic);//Modifica a carta
                    ImageIcon iic2 = new ImageIcon(getClass().getResource("/Imagens/" + c2 + ".png"));// Imagem da Carta 2
                    Carta4.setIcon(iic2);//Modifica a carta   
                    RegrasBJ p = new RegrasBJ(c1, c2); // Classe com as regras do jogo
                    jogadores.add(p); // 
                    sockServer[i].sendData("Você Possui:\n" + c1 + " " + c2); //Envia para o Player qual carta ele recebeu
                    sockServer[i].sendData("Total de Pontos: " + p.GetCardTotal()); // Envia para o Player quantos pontos ele tem
                } else if (i == 3) {
                    sockServer[i].sendData("\nComeçou"); // Envia para os Players que a partida começou
                    String c1, c2;
                    c1 = NovoBaralho.dealCard(); // Recebe carta 1
                    c2 = NovoBaralho.dealCard(); // Recebe carta 2

                    ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + c1 + ".png"));// Imagem da carta 1
                    Carta5.setIcon(iic);//Modifica a carta
                    ImageIcon iic2 = new ImageIcon(getClass().getResource("/Imagens/" + c2 + ".png"));// Imagem da Carta 2
                    Carta6.setIcon(iic2);//Modifica a carta   
                    RegrasBJ p = new RegrasBJ(c1, c2); // Classe com as regras do jogo
                    jogadores.add(p); // 
                    sockServer[i].sendData("Você Possui:\n" + c1 + " " + c2); //Envia para o Player qual carta ele recebeu
                    sockServer[i].sendData("Total de Pontos: " + p.GetCardTotal()); // Envia para o Player quantos pontos ele tem
                } else if (i == 4) {
                    sockServer[i].sendData("\nComeçou"); // Envia para os Players que a partida começou
                    String c1, c2;
                    c1 = NovoBaralho.dealCard(); // Recebe carta 1
                    c2 = NovoBaralho.dealCard(); // Recebe carta 2

                    ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + c1 + ".png"));// Imagem da carta 1
                    Carta7.setIcon(iic);//Modifica a carta
                    ImageIcon iic2 = new ImageIcon(getClass().getResource("/Imagens/" + c2 + ".png"));// Imagem da Carta 2
                    Carta8.setIcon(iic2);//Modifica a carta   
                    RegrasBJ p = new RegrasBJ(c1, c2); // Classe com as regras do jogo
                    jogadores.add(p); // 
                    sockServer[i].sendData("Você Possui:\n" + c1 + " " + c2); //Envia para o Player qual carta ele recebeu
                    sockServer[i].sendData("Total de Pontos: " + p.GetCardTotal()); // Envia para o Player quantos pontos ele tem
                }
            }
        } catch (NullPointerException n) {
        }
    }

    private void Resultado() { // Classe que exibe os resuldo do jogo

        try {
            for (int i = 1; i <= contador; i++) { // For para enviar o resultado para todos os jogadores
                sockServer[i].sendData("Mesa possui " + dcards.GetCardTotal());

                if ((dcards.GetCardTotal() <= 21) && (jogadores.get(i - 1).GetCardTotal() <= 21)) {// Compara com a Mesa

                    if (dcards.GetCardTotal() > jogadores.get(i - 1).GetCardTotal()) {
                        sockServer[i].sendData("\n Você Perdeu!");

                    }

                    if (dcards.GetCardTotal() < jogadores.get(i - 1).GetCardTotal()) {
                        sockServer[i].sendData("\n Você Ganhou!");

                    }

                    if (dcards.GetCardTotal() == jogadores.get(i - 1).GetCardTotal()) {
                        sockServer[i].sendData("\n Tie!");
                    }

                }//Fim se a mesa e o Jogador tiver menos que 21

                if (dcards.CheckBust()) { //Compara se o player estourou

                    if (jogadores.get(i - 1).CheckBust()) {
                        sockServer[i].sendData("\n Empatou!");

                    }
                    if (jogadores.get(i - 1).GetCardTotal() <= 21) {
                        sockServer[i].sendData("\n Você Ganhou!");

                    }
                }

                if (jogadores.get(i - 1).CheckBust() && dcards.GetCardTotal() <= 21) {
                    sockServer[i].sendData("\n Você Perdeu!");

                }

                sockServer[i].sendData("Fim"); // Envia que a partida terminou
            }//Fim do loop
        } catch (NullPointerException n) {
        }
    }

    private class SockServer implements Runnable {

        private ObjectOutputStream output; // Saida para o Cliente
        private ObjectInputStream input; // Entrada do que o cliente envia
        private Socket connection; // Connexao com o cliente
        private int myConID;

        public SockServer(int counterIn) {
            myConID = counterIn;  //ID que o Jogador recebe   

        }

        public void run() {
            try {
                try {
                    getStreams(); // get input & output streams
                    processConnection(); // Processando Conexao

                } // Fim try
                catch (EOFException eofException) {
                    displayMessage("\nServer" + myConID + " terminated connection");

                } finally {
                    closeConnection(); //  fecha connection
                }// Fim catch
            } // Fim try
            catch (IOException ioException) {
            } // Fim catch
        } // Fim try

        //espera por conexão de jogarores
        private void waitForConnection() throws IOException {

            displayMessage("\nEsperando conexão " + myConID);

            if (myConID <= MAXCONEXAO) { // AQUI e ONDE LIMITA O NUMERO DE PPL QUE SERAM ACEITO PARA ESTABELECER CONEX�O
                connection = server.accept(); // Permite que o servidor aceite a conexão         

                displayMessage("\nConexao " + myConID + " recebida de: "
                        + connection.getInetAddress().getHostName()); // Fala o ID e o IP do jogador que se conectou

                System.out.println(connection.getLocalAddress().getHostName());

            } else {
                ++Ausente;
                closeConnection();
            }

        } // Fim do Metodo que espera as conexoes

        private void getStreams() throws IOException {
            // Configura a saida para objetos
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();

            // Configura entrada para objetos
            input = new ObjectInputStream(connection.getInputStream());

            displayMessage("\nEntrada e saída ativado\n");
        } // Fim Metodo getStreams

        // Processa conxao com o cliente
        private void processConnection() throws IOException {
            // Envia para o Player que ele conectou com sucesso
            String Mensagem = "Seu ID é: " + myConID + "\nConexão com Sucesso";
            sendData(Mensagem); //Envia para o cliente seu ID e diz que conectou com sucesso
            sendData("Recebendo Informação");

            do // Processa meensagens enviadas pelos jogadores
            {
                try // Le as mensagens enviadas pelos jogadores
                {

                    if (Mensagem.startsWith("-")) { // PARA ADICIONAR O NOME DO JOGADOR NO ARRAYLIST
                        nickjogadores.add(Mensagem); // ARRAYLIST DE NOMES DE JOGADORES
                        displayMessage(Mensagem + " SE CONECTOU");

                    }
                    if (Mensagem.startsWith("Lista")) { // PARA ADICIONAR O NOME DO JOGADOR NO ARRAYLIST
                        this.sendData("Jogadores Conectados \n" + nickjogadores.toString());

                    }

                    if (Mensagem.contains("pedir")) { // Pede Carta	
                        cardpedir();
                    }

                    if (Mensagem.contains("esperar")) { // Diz que nao que mais cartas
                        this.sendData("Por Favor Espere");
                        jogadoresleft--;// Indica que o player n esta mais no jogo
                        CheckDone();
                    }
                    if (Mensagem.contains("Jogar")) { // Diz que o player ira jogar o proximo jogo
                        Jogando++;// quantidade de jogadores tem que ser a quantidade de conectados

                        if (Jogando + Ausente == contador) { // JOGADOR + AUSENTE = HABILITA O BOT�O DO DAR CARTAS
                            jogadores.clear();//Limpa os dados dos jogadores
                            Cartas.setEnabled(true);

                        }
                    }

                    Mensagem = (String) input.readObject(); // Ler nova mensagem

                } // Fim try
                catch (ClassNotFoundException classNotFoundException) {
                    displayMessage("\nTipo de objeto desconhecido recebido");
                } // Fim catch

            } while (!Mensagem.equals("CLIENT>>> TERMINATE"));
        } // Fim do metodo processamento de cliente

        private void DealerGo() {
            dcards = new RegrasBJ(dcard1, dcard2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (dcards.GetCardTotal() < 16) {
                while (dcards.GetCardTotal() < 16) {
                    String Carta1 = NovoBaralho.dealCard();
                    dcards.CardHit(Carta1);
                    displayMessage("Cartas da Mesa..." + Carta1 + "\n" + "Total:" + dcards.GetCardTotal() + "\n");
                }
            }
            if (dcards.CheckBust()) {
                displayMessage("Mesa Estourou!");
            } else {
                displayMessage("Mesa Possui" + " " + dcards.GetCardTotal());
            }

            Resultado();
        }

        private void cardpedir() {

            if (myConID - 1 == 0) {

                String nextc = NovoBaralho.dealCard();
                sendData(nextc);
                ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + nextc + ".png"));// Imagem da carta 1
                Carta9.setIcon(iic);
                jogadores.get(this.myConID - 1).CardHit(nextc);
                sendData("Seu Total: " + jogadores.get(this.myConID - 1).GetCardTotal());
                System.out.println("Jogador: " + myConID);
                if (jogadores.get(this.myConID - 1).CheckBust()) {			//Se o player estourar
                    sendData("Estorou!\n");
                    jogadoresleft--;
                    System.out.println("Ausente: " + Ausente);
                    if ((jogadoresleft - Ausente) == 0) { // LIMITADOR DE PPL -> COMPARAR JOGADORES LEFT - JOGADORES AUSENTE SE DA 0
                        DealerGo();
                    }
                }
            }

            if (myConID - 1 == 1) {

                String nextc = NovoBaralho.dealCard();
                sendData(nextc);
                ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + nextc + ".png"));// Imagem da carta 1
                Carta11.setIcon(iic);
                jogadores.get(this.myConID - 1).CardHit(nextc);
                sendData("Seu Total: " + jogadores.get(this.myConID - 1).GetCardTotal());
                System.out.println("Jogador: " + myConID);
                if (jogadores.get(this.myConID - 1).CheckBust()) {			//Se o player estourar
                    sendData("Estorou!\n");
                    jogadoresleft--;
                    System.out.println("Ausente: " + Ausente);
                    if ((jogadoresleft - Ausente) == 0) { // LIMITADOR DE PPL -> COMPARAR JOGADORES LEFT - JOGADORES AUSENTE SE DA 0
                        DealerGo();
                    }
                }
            }

            if (myConID - 1 == 2) {

                String nextc = NovoBaralho.dealCard();
                sendData(nextc);
                ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + nextc + ".png"));// Imagem da carta 1
                Carta12.setIcon(iic);
                jogadores.get(this.myConID - 1).CardHit(nextc);
                sendData("Seu Total: " + jogadores.get(this.myConID - 1).GetCardTotal());
                System.out.println("Jogador: " + myConID);
                if (jogadores.get(this.myConID - 1).CheckBust()) {			//Se o player estourar
                    sendData("Estorou!\n");
                    jogadoresleft--;
                    System.out.println("Ausente: " + Ausente);
                    if ((jogadoresleft - Ausente) == 0) { // LIMITADOR DE PPL -> COMPARAR JOGADORES LEFT - JOGADORES AUSENTE SE DA 0
                        DealerGo();
                    }
                }
            }

            if (myConID - 1 == 3) {

                String nextc = NovoBaralho.dealCard();
                sendData(nextc);
                ImageIcon iic = new ImageIcon(getClass().getResource("/Imagens/" + nextc + ".png"));// Imagem da carta 1
                Carta13.setIcon(iic);
                jogadores.get(this.myConID - 1).CardHit(nextc);
                sendData("Seu Total: " + jogadores.get(this.myConID - 1).GetCardTotal());
                System.out.println("Jogador: " + myConID);
                if (jogadores.get(this.myConID - 1).CheckBust()) {			//Se o player estourar
                    sendData("Estorou!\n");
                    jogadoresleft--;
                    System.out.println("Ausente: " + Ausente);
                    if ((jogadoresleft - Ausente) == 0) { // LIMITADOR DE PPL -> COMPARAR JOGADORES LEFT - JOGADORES AUSENTE SE DA 0
                        DealerGo();
                    }
                }
            }
        }

        private void CheckDone() {

            if ((jogadoresleft - Ausente) == 0) { // LIMITADOR DE PPL -> COMPARAR JOGADORES LEFT - JOGADORES AUSENTE SE DA 0

                DealerGo();
            }
        }

        // close streams and socket
        private void closeConnection() {
            displayMessage("\nTerminating connection " + myConID + "\n"); // indica que um jogador saiu do jogo
            contador--; //Se o player sai do servidor ele é desconsiderado
            nickjogadores.remove(myConID - 1); // Remove o nome dele da lista de Jogadores
            try {
                output.close(); //Fecha saida de dados
                input.close(); // Fecha entrada de dados
                connection.close(); // Fecha socket
            } // Fim try
            catch (IOException ioException) {
            } // Fim catch
        } // Fim metodo closeConnection

        private void sendData(String Mensagem) // Classe q controla o envio de mensagem para os Players
        {
            try // 
            {
                output.writeObject(Mensagem);
                output.flush();

            } // Fim try
            catch (IOException ioException) {
                displayArea.append("\nErro ao ler Objeto");
            } // Fim catch
        } // Fim Medoto sendData
    } // Fim Classe SockServer
} //Fim da Classe Interface
