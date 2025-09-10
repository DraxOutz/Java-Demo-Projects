package Aula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCacador {

    private static Personagem cacador;

    public InterfaceCacador() {
        cacador = new Personagem();

        cacador.nome = JOptionPane.showInputDialog("Escreva o nome do personagem");
        main.print("Personagem: "+cacador.nome+" criado.");

        JFrame frame = new JFrame("Ações do Caçador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 220);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton botaoCacar = new JButton("Caçar");
        botaoCacar.setBounds(50, 20, 200, 30);
        botaoCacar.addActionListener(e -> cacador.cacar());
        frame.add(botaoCacar);

        JButton botaoComer = new JButton("Comer");
        botaoComer.setBounds(50, 60, 200, 30);
        botaoComer.addActionListener(e -> cacador.comerEbeber("Comer"));
        frame.add(botaoComer);

        JButton botaoBeber = new JButton("Beber");
        botaoBeber.setBounds(50, 100, 200, 30);
        botaoBeber.addActionListener(e -> cacador.comerEbeber("Beber"));
        frame.add(botaoBeber);

        JButton botaoDormir = new JButton("Dormir");
        botaoDormir.setBounds(50, 140, 200, 30);
        botaoDormir.addActionListener(e -> cacador.dormir());
        frame.add(botaoDormir);

        frame.setVisible(true);

        // Inicia o timer para reduzir fome e sede periodicamente
        iniciarTimer();
    }

    private void iniciarTimer() {
        // Timer que executa a cada 5 segundos (5000 ms)
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cacador.fome = Math.max(0, cacador.fome - 1);
                cacador.sede = Math.max(0, cacador.sede - 1);
                
                if ( (int) (Math.random() * 100) < 25) {
                    cacador.vida = Math.max(0, cacador.vida - 10);
                    main.print("Seu personagem foi atacado: "+cacador.vida+" de vida.");;
                }

                System.out.println("Fome: " + cacador.fome + " | Sede: " + cacador.sede + "| Energia: " + cacador.energia + "| Vida: " + cacador.vida + " | Nível: "+cacador.nivel + " | XP:"+cacador.XP+"/"+25*cacador.nivel);

                if (cacador.fome <= 0 || cacador.sede <= 0 || cacador.vida <= 0) {
                    System.out.println("Seu personagem morreu.");
                    cacador.vida = 0;
                    ((Timer) e.getSource()).stop(); // Para o timer
                    JOptionPane.showMessageDialog(null, "Seu personagem morreu.");
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        // Rodar na thread da interface gráfica
        SwingUtilities.invokeLater(() -> new InterfaceCacador());
    }
}
