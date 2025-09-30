import java.awt.*;
import javax.swing.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Main {

    private static boolean calculado = false;

    // Verifica se o número tem casas decimais
    public static boolean temDecimal(double numero) {
        return numero % 1 != 0;
    }

    // Função para calcular a expressão
    public static String calcular(String vlr) {
        try {
            calculado = true;
            Expression exp = new ExpressionBuilder(vlr).build();
            double resultado = exp.evaluate();

            // Retorna inteiro se não tiver decimal
            return temDecimal(resultado) ? String.valueOf(resultado) : String.valueOf((int) resultado);
        } catch (Exception e) { //Em caso de erros retornar erro
            return "Erro";
        }
    }

    public static boolean IsNumber(String str) {
        try {
            Double.parseDouble(str);
            return true; // é número decimal
        } catch (NumberFormatException e) {
            return false; // não é número
        }
    };

    public static void main(String[] args) {
        // Criar a janela
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.setLocationRelativeTo(null); // Centraliza na tela

        // Painel principal com layout vertical
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        // Campo de histórico (topo)
        JTextField campoHistorico = new JTextField();
        campoHistorico.setEditable(false);
        campoHistorico.setFont(new Font("Arial", Font.PLAIN, 18));
        campoHistorico.setHorizontalAlignment(JTextField.RIGHT);
        painelPrincipal.add(campoHistorico);

        // Campo principal (expressão e resultado)
        JTextField campo = new JTextField();
        campo.setEditable(false);
        campo.setFont(new Font("Arial", Font.PLAIN, 24));
        campo.setHorizontalAlignment(JTextField.RIGHT);
        painelPrincipal.add(campo);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "CE", "(", ")", "←" 
        };

   

        for (String textoBotao : botoes) {
            JButton botao = new JButton(textoBotao);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            painelBotoes.add(botao);

            botao.addActionListener(e -> {
                String textoAtual = campo.getText();

                //Deletar tudo que ta escrito 
                if (textoBotao.equals("CE")) {
                    campo.setText("");
                    campoHistorico.setText("");
                    calculado = false;
                    return;
                }


                //Deletar ultimo caracter
                if (textoBotao.equals("←")) {
                    if (!textoAtual.isEmpty()) {
                        campo.setText(textoAtual.substring(0, textoAtual.length() - 1));
                    }
                    return;
                }

                // se nao for um número, continuo o calculo 
                if (calculado && IsNumber(textoBotao)) {
                    campo.setText("");
                    campoHistorico.setText("");
                    calculado = false;
                } else if (!IsNumber(textoBotao)) {
                    calculado = false;
                }

                // evitar repetição de caracteres especiais
              if (textoAtual.length() > 0 
    && !IsNumber(textoAtual.substring(textoAtual.length() - 1))  // último caractere NÃO é número
    && !IsNumber(textoBotao)) {  // caractere atual NÃO é número
    return;  // não prossegue
}

// se for = calcula, se não continua calculando
                if (!textoBotao.equals("=")) {
                    campo.setText(campo.getText() + textoBotao);
                } else {
                    String expressao = campo.getText();
                    String resultado = calcular(expressao);
                    campoHistorico.setText(expressao + " =");
                    campo.setText(resultado);
                }
            });
        }

        painelPrincipal.add(painelBotoes);

        frame.setContentPane(painelPrincipal);
        frame.setVisible(true);
    }
}
