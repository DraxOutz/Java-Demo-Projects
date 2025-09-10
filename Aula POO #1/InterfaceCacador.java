package Aula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class InterfaceCacador {

    private static Personagem cacador;
    private JFrame frame; // <-- variável de instância para o JFrame

    public InterfaceCacador() {
        // Opções para o jogador
        String[] opcoes = {"Novo personagem", "Carregar personagem"};
        int select = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Início do jogo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (select == 0) {
            // Criar novo personagem
            cacador = new Personagem();
            cacador.nome = JOptionPane.showInputDialog("Escreva o nome do personagem");
            main.print("Personagem: " + cacador.nome + " criado.");

            salvarPersonagem(cacador);

        } else if (select == 1) {
            // Carregar personagem existente
            cacador = carregarPersonagem();
            if (cacador == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível carregar personagem. Criando novo.");
                cacador = new Personagem();
                cacador.nome = JOptionPane.showInputDialog("Escreva o nome do personagem");
                main.print("Personagem: " + cacador.nome + " criado.");
                salvarPersonagem(cacador);
            } else {
                main.print("Personagem carregado: " + cacador.nome);
            }
        } else {
            // Cancelou ou fechou
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada. Encerrando.");
            System.exit(0);
        }

        criarInterface();
    }

    private void criarInterface() {
        frame = new JFrame("Ações do Caçador"); // <-- sem 'JFrame' antes, usa a variável da classe
        frame.setResizable(false);
        frame.setSize(300, 220);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        frame,
                        "Deseja salvar o personagem antes de sair?",
                        "Salvar e Sair",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    salvarPersonagem(cacador); // chama seu método de salvar
                    System.exit(0); // fecha o programa
                } else if (option == JOptionPane.NO_OPTION) {
                    System.exit(0); // fecha sem salvar
                }
                // se cancelar, não faz nada e mantém a janela aberta
            }
        });

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

        iniciarTimer();
    }

    private void iniciarTimer() {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cacador.fome = Math.max(0, cacador.fome - 1);
                cacador.sede = Math.max(0, cacador.sede - 1);
                cacador.energia = Math.max(0, cacador.energia - 1);

                if ((int) (Math.random() * 100) < 25) {
                    cacador.vida = Math.max(0, cacador.vida - 10);
                    main.print("Seu personagem foi atacado: " + cacador.vida + " de vida.");
                }

                System.out.println("Fome: " + cacador.fome + " | Sede: " + cacador.sede + "| Energia: " + cacador.energia + "| Vida: " + cacador.vida + " | Nível: " + cacador.nivel + " | XP:" + cacador.XP + "/" + 25 * cacador.nivel);

                if (cacador.fome <= 0 || cacador.sede <= 0 || cacador.vida <= 0) {
                    System.out.println("Seu personagem morreu.");
                    cacador.vida = 0;
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(frame, "Seu personagem morreu."); // usa o frame para o diálogo modal
                    frame.dispose(); // fecha a janela
                    System.exit(0);  // encerra o programa
                }
            }
        });
        timer.start();
    }

    private void salvarPersonagem(Personagem p) {
        String json = p.salvarComoJSON();
        try (FileWriter writer = new FileWriter("personagem.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar personagem.");
        }
    }

    private Personagem carregarPersonagem() {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("personagem.json");
            String json = java.nio.file.Files.readString(path);
            return Personagem.carregarDeJSON(json);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Arquivo personagem.json não encontrado ou inválido.");
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceCacador());
    }
}
