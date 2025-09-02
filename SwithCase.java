import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

/**
 * É um projeto para aprendizado inicial, pois cobre os fundamentos e boas práticas básicas, 
 * mas ainda está longe de ser um sistema complexo ou uma aplicação avançada.
 * Uma calculadora simples utilizando Java Swing com suporte a múltiplos operadores matemáticos.
 */
public class SwithCase extends JFrame {

    // Construtor da classe
    public SwithCase() {
        // Define o título da janela
        setTitle("Calculadora");

        // Define o tamanho mínimo da janela
        setMinimumSize(new Dimension(300, 180));

        // Encerra o programa ao fechar a janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Define o layout como FlowLayout (componentes organizados em linha)
        setLayout(new FlowLayout());

        // Criação dos componentes de interface
        JLabel label = new JLabel("Digite o número 1:");
        JTextField campoTexto = new JTextField(10); // Campo para número 1

        JLabel label2 = new JLabel("Digite o número 2:");
        JTextField campoTexto2 = new JTextField(10); // Campo para número 2

        JLabel label3 = new JLabel("Digite o operador (+, -, *, /, ^, %):");
        JTextField campoTexto3 = new JTextField(5); // Campo para operador

        JButton botao = new JButton("Calcular"); // Botão para executar o cálculo

        // Adiciona os componentes à janela
        add(label);
        add(campoTexto);
        add(label2);
        add(campoTexto2);
        add(label3);
        add(campoTexto3);
        add(botao);

        // Adiciona ação ao botão
        botao.addActionListener(a -> {
            try {
                // Converte o texto dos campos para números
                double num1 = Double.parseDouble(campoTexto.getText());
                double num2 = Double.parseDouble(campoTexto2.getText());
                String operador = campoTexto3.getText().trim(); // Remove espaços

                double resultado;

                // Realiza a operação com base no operador informado
                switch (operador) {
                    case "+": // Soma
                        resultado = num1 + num2;
                        break;
                    case "-": // Subtração
                        resultado = num1 - num2;
                        break;
                    case "%": // Porcentagem (num2% de num1)
                        resultado = (num2 / 100) * num1;
                        break;
                    case "^": // Potência (num1 elevado a num2)
                        resultado = Math.pow(num1, num2);
                        break;
                    case "*":
                    case "x": // Multiplicação (aceita * ou x)
                        resultado = num1 * num2;
                        break;
                    case "/": // Divisão
                        if (num2 == 0) {
                            print("Erro: divisão por zero!");
                            return; // Sai do método se tentar dividir por zero
                        }
                        resultado = num1 / num2;
                        break;
                    default: // Operador inválido
                        print("Operador inválido!");
                        return;
                }

                // Exibe o resultado
                print("Resultado: " + resultado);

            } catch (NumberFormatException ex) {
                // Caso o usuário insira um valor que não seja número
                print("Por favor, digite números válidos.");
            }
        });
    }

    /**
     * Exibe uma mensagem usando JOptionPane.
     * @param vlr Mensagem a ser exibida
     */
    public static void print(String vlr) {
        JOptionPane.showMessageDialog(null, vlr);
    }

    /**
     * Método principal que inicia a aplicação GUI.
     * Usa SwingUtilities para garantir que a interface seja criada na thread correta.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwithCase().setVisible(true); // Cria e exibe a janela
        });
    }
}
