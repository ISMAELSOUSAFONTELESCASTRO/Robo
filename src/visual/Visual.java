package visual;

import entities.Robo;
import entities.RoboInteligente;
import exception.MovimentoInvalidoException;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visual {

    private JFrame telaInicial = new JFrame("Jogo do robô");
    private JFrame mesa = new JFrame("Jogo do robô");
    private JPanel plano = new JPanel();

    private ImageIcon logo = new ImageIcon(Visual.class.getResource("/imagens/robo.png"));
    private ImageIcon comida = new ImageIcon(Visual.class.getResource("/imagens/comida.png"));

    private JButton jogo1 = new JButton("Um robô");
    private JButton jogo2 = new JButton("Dois robôbos");
    private JButton jogo3 = new JButton("Intelibobo");
    private JButton jogo4 = new JButton("Com obstáculos");

    private JButton andar = new JButton("Andar");
    private JButton comecar2 = new JButton("Começar");
    private JButton comecar3 = new JButton("Começar");
    private JButton comecar4 = new JButton("Começar");

    private static JPanel[][] casasValidas = new JPanel[3][3];
    private JPanel[] casasInvalidas1 = new JPanel[3];
    private JPanel casaInvalida2 = new JPanel();
    private JPanel[] casasInvalidas3 = new JPanel[3];

    private static JLabel roboAzul = new JLabel(new ImageIcon(Visual.class.getResource("/imagens/roboAzul.png")));
    private static JLabel roboVerde = new JLabel(new ImageIcon(Visual.class.getResource("/imagens/roboVerde.png")));
    private JLabel alimento = new JLabel(new ImageIcon(Visual.class.getResource("/imagens/alimento.png")));
    private JLabel rochas = new JLabel(new ImageIcon(Visual.class.getResource("/imagens/pedras.png")));
    private JLabel explosao = new JLabel(new ImageIcon(Visual.class.getResource("/imagens/explosao.png")));

    private String cor;
    private Robo robo;
    private int[] lugarComida = new int[2];
    private int[][] lugarRocha = new int[2][2];
    private int[][] lugarExplosao = new int[2][2];

    public void telaInicial(){
        telaInicial.setIconImage(logo.getImage());
        telaInicial.setLayout(null);
        telaInicial.setResizable(false);
        telaInicial.setSize(400, 260);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.getContentPane().setBackground(new Color(0xB7D5E5));

        botaoJogo1();
        botaoJogo2();
        botaoJogo3();
        botaoJogo4();

        telaInicial.add(jogo1);
        telaInicial.add(jogo2);
        telaInicial.add(jogo3);
        telaInicial.add(jogo4);
        telaInicial.setVisible(true);
    }

    public void localAlimento(){
        String[] opcoes = {"0", "1", "2"};
        Object linha1 = JOptionPane.showInputDialog(null, "Escolha a linha", "Alimento", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
        Object coluna1 = JOptionPane.showInputDialog(null, "Escolha a coluna", "Alimento", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
        int linha2 = Integer.parseInt((String) linha1);
        int coluna2 = Integer.parseInt((String) coluna1);

        lugarComida[0] = linha2;
        lugarComida[1] = coluna2;
        casasValidas[linha2][coluna2].add(alimento);
        casasValidas[linha2][coluna2].repaint();
        casasValidas[linha2][coluna2].revalidate();
    }

    public void obstaculos(){
        String[] opcoes = {"0", "1", "2"};
        Object numPedra1 = JOptionPane.showInputDialog(null, "Escolha a quantia de pedras", "Obstáculos", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
        Object numBomba1 = JOptionPane.showInputDialog(null, "Escolha a quantia de bombas", "Obstáculos", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
        int numPedra2 = Integer.parseInt((String) numPedra1);
        int numBomba2 = Integer.parseInt((String) numBomba1);

        for(int i=0;i<numPedra2;i++){
            Object linha1 = JOptionPane.showInputDialog(null, "Escolha a linha da rocha "+i, "Obstáculos", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
            Object coluna1 = JOptionPane.showInputDialog(null, "Escolha a coluna da rocha "+i, "Obstáculos", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
            int linha2 = Integer.parseInt((String) linha1);
            int coluna2 = Integer.parseInt((String) coluna1);

            lugarRocha[i][0] = linha2;
            lugarRocha[i][1] = coluna2;
            casasValidas[linha2][coluna2].add(rochas);
            casasValidas[linha2][coluna2].repaint();
            casasValidas[linha2][coluna2].revalidate();
        }

        for(int i=0;i<numBomba2;i++){
            Object linha1 = JOptionPane.showInputDialog(null, "Escolha a linha da bomba "+i, "Obstáculos", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
            Object coluna1 = JOptionPane.showInputDialog(null, "Escolha a coluna da bomba "+i, "Obstáculos", JOptionPane.INFORMATION_MESSAGE, comida, opcoes, 0);
            int linha2 = Integer.parseInt((String) linha1);
            int coluna2 = Integer.parseInt((String) coluna1);

            lugarExplosao[i][0] = linha2;
            lugarExplosao[i][1] = coluna2;
            casasValidas[linha2][coluna2].add(explosao);
            casasValidas[linha2][coluna2].repaint();
            casasValidas[linha2][coluna2].revalidate();
        }
    }

    public static void removerRobo(int linha, int coluna, String cor){
        SwingUtilities.invokeLater(() -> {
            if(cor.equals("verde")){
                casasValidas[linha][coluna].remove(roboVerde);
            }
            else{
                casasValidas[linha][coluna].remove(roboAzul);
            }
            casasValidas[linha][coluna].repaint();
            casasValidas[linha][coluna].revalidate();
        });
    }

    public static void addRobo(int linha, int coluna, String cor) {
        SwingUtilities.invokeLater(() -> {
            if(cor.equals("verde")){
                casasValidas[linha][coluna].add(roboVerde);
            }
            else{
                casasValidas[linha][coluna].add(roboAzul);
            }
            casasValidas[linha][coluna].repaint();
            casasValidas[linha][coluna].revalidate();
        });
    }

    public String escolherCor(){
        String[] opcoes = {"azul", "verde"};
        Object cor = JOptionPane.showInputDialog(null, "Escolha a cor", "Cores", JOptionPane.INFORMATION_MESSAGE, logo, opcoes, 0);
        return cor.toString();
    }

    public void andar(){
        andar.setBounds(128, 449, 200, 40);
        andar.setForeground(Color.lightGray);
        andar.setBackground(new Color(0x000921));
        andar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object direcao = JOptionPane.showInputDialog(null, "Escolha a direção: \nup/1 pra cima, \ndown/2 pra baixo, \nright/3 pra direita, \nleft/4 pra esquerda");
                try {
                    robo.Mover(direcao.toString());
                } catch (MovimentoInvalidoException ex) {
                    throw new RuntimeException(ex);
                }
                if(robo.isFoodFound(lugarComida)){
                    JOptionPane.showMessageDialog(null, "ACHOU A COMIDA!!", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        });
        mesa.add(andar);
        mesa.repaint();
        mesa.revalidate();
    }

    public static void excessao(){
        JOptionPane.showMessageDialog(null, "Movimento inválido", "Inválido", JOptionPane.ERROR_MESSAGE);
    }

    public static void excessao(String mensagem){
        JOptionPane.showMessageDialog(null, "Movimento inválido: "+mensagem, "Inválido", JOptionPane.ERROR_MESSAGE);
    }

    public void comecar2(){
        comecar2.setBounds(128, 449, 200, 40);
        comecar2.setForeground(Color.lightGray);
        comecar2.setBackground(new Color(0x000921));
        comecar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Robo robo1 = new Robo("verde");
                Robo robo2 = new Robo("azul");

                while (true) {
                    Random rd = new Random();
                    int move1 = rd.nextInt(4) + 1;
                    try {
                        robo1.Mover(Integer.toString(move1));
                    } catch (MovimentoInvalidoException ex) {
                    }

                    if(robo1.isFoodFound(lugarComida)) {
                        JOptionPane.showMessageDialog(null, "VERDE ACHOU A COMIDA!! \nMovimentos válidos do verde: " + robo1.getMvRobo() + "\nMovimentos inválidos do verde: " + robo1.getMiRobo() + "\nMovimentos válidos do azul: " + robo2.getMvRobo() + "\nMovimentos inválidos do azul: " + robo2.getMiRobo(), "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }

                    int move2 = rd.nextInt(4) + 1;
                    try {
                        robo2.Mover(Integer.toString(move2));
                    } catch (MovimentoInvalidoException ex) {
                    }

                    if (robo2.isFoodFound(lugarComida)) {
                        JOptionPane.showMessageDialog(null, "AZUL ACHOU A COMIDA!! \nMovimentos válidos do azul: " + robo2.getMvRobo() + "\nMovimentos inválidos do azul: " + robo2.getMiRobo() + "\nMovimentos válidos do verde: " + robo1.getMvRobo() + "\nMovimentos inválidos do verde: " + robo1.getMiRobo(), "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }
            }
        });
        mesa.add(comecar2);
        mesa.repaint();
        mesa.revalidate();
    }

    public void comecar3(){
        comecar3.setBounds(128, 449, 200, 40);
        comecar3.setForeground(Color.lightGray);
        comecar3.setBackground(new Color(0x000921));
        comecar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoboInteligente robo1 = new RoboInteligente("verde");
                Robo robo2 = new Robo("azul");
                int primeiro=0;

                while (true) {
                    Random rd = new Random();
                    if(!robo1.isFoodFound(lugarComida)) {
                        int move1 = rd.nextInt(4) + 1;
                        try {
                            robo1.Mover(Integer.toString(move1));
                        } catch (MovimentoInvalidoException ex) {
                        }
                    } else {
                        primeiro = 1;
                    }

                    if(!robo2.isFoodFound(lugarComida)) {
                        int move2 = rd.nextInt(4) + 1;
                        try {
                            robo2.Mover(Integer.toString(move2));
                        } catch (MovimentoInvalidoException ex) {
                        }
                    } else {
                        primeiro = 2;
                    }

                    if(robo1.isFoodFound(lugarComida) && robo2.isFoodFound(lugarComida)){
                        if(primeiro == 1){
                            JOptionPane.showMessageDialog(null, "VERDE ACHOU A COMIDA PRIMEIRO!! \nMovimentos válidos do verde: " + robo1.getMvRobo() + "\nMovimentos inválidos do verde: " + robo1.getMvRobo() + "\nMovimentos válidos do azul: " + robo2.getMvRobo() + "\nMovimentos inválidos do azul: " + robo2.getMiRobo(), "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "AZUL ACHOU A COMIDA PRIMEIRO!! \nMovimentos válidos do azul: " + robo2.getMvRobo() + "\nMovimentos inválidos do azul: " + robo2.getMiRobo() + "\nMovimentos válidos do verde: " + robo1.getMvRobo() + "\nMovimentos inválidos do verde: " + robo1.getMiRobo(), "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }
                }
            }
        });
        mesa.add(comecar3);
        mesa.repaint();
        mesa.revalidate();
    }

    public void comecar4(){
        comecar4.setBounds(128, 449, 200, 40);
        comecar4.setForeground(Color.lightGray);
        comecar4.setBackground(new Color(0x000921));
        comecar4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mesa.add(comecar4);
        mesa.repaint();
        mesa.revalidate();
    }

    public void botaoJogo1(){
        jogo1.setBounds(34, 50, 150, 50);
        jogo1.setForeground(Color.lightGray);
        jogo1.setBackground(new Color(0x000921));
        jogo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plano();
                localAlimento();
                cor = escolherCor();
                robo = new Robo(cor);
                mesa();
                andar();
            }
        });
    }

    public void botaoJogo2(){
        jogo2.setBounds(34, 120, 150, 50);
        jogo2.setForeground(Color.lightGray);
        jogo2.setBackground(new Color(0x000921));
        jogo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plano();
                localAlimento();
                mesa();
                comecar2();
                addRobo(0,0,"verde");
                addRobo(0,0,"azul");
            }
        });
    }

    public void botaoJogo3(){
        jogo3.setBounds(200, 50, 150, 50);
        jogo3.setForeground(Color.lightGray);
        jogo3.setBackground(new Color(0x000921));
        jogo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plano();
                localAlimento();
                mesa();
                comecar3();
                addRobo(0,0,"verde");
                addRobo(0,0,"azul");
            }
        });
    }

    public void botaoJogo4(){
        jogo4.setBounds(200, 120, 150, 50);
        jogo4.setForeground(Color.lightGray);
        jogo4.setBackground(new Color(0x000921));
        jogo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plano();
                localAlimento();
                obstaculos();
                mesa();
                comecar4();
            }
        });
    }

    public void mesa(){
        mesa.setLayout(null);
        mesa.setIconImage(logo.getImage());
        mesa.setResizable(false);
        mesa.setSize(474, 538);
        mesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mesa.getContentPane().setBackground(new Color(0xB7D5E5));
        mesa.add(plano);
        mesa.setVisible(true);
    }

    public void plano(){
        plano.setLayout(null);
        int x=109, y=7;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                casasValidas[i][j] = new JPanel();
                casasValidas[i][j].setBounds(x, y, 100, 100);
                x += 101;
                casasValidas[i][j].setBackground(new Color(0xBDECB6));
                plano.add(casasValidas[i][j]);
            }
            y += 101;
            x = 109;
        }

        x = 7;
        y = 7;
        for(int i=0;i<3;i++) {
            casasInvalidas1[i] = new JPanel();
            casasInvalidas1[i].setBounds(x, y, 99, 100);
            y += 101;
            casasInvalidas1[i].setBackground(new Color(0xE09B9E));
            plano.add(casasInvalidas1[i]);
        }

        x = 7;
        y += 2;
        casaInvalida2.setBounds(x, y, 99, 99);
        casaInvalida2.setBackground(new Color(0xE09B9E));
        plano.add(casaInvalida2);
        x = 109;

        for(int j=0;j<3;j++){
                casasInvalidas3[j] = new JPanel();
                casasInvalidas3[j].setBounds(x, y, 100, 99);
                x += 101;
                casasInvalidas3[j].setBackground(new Color(0xE09B9E));
                plano.add(casasInvalidas3[j]);
            }

        plano.setBackground(new Color(0x000921));
        plano.setBounds(20,20, 418, 418);
    }
}
