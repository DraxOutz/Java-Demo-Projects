import java.awt.*;
import javax.swing.*;

public class ExemploGridBagLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Exemplo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // margem comum

        // Botão 1 - ocupa 1 célula, cresce horizontalmente
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;          // cresce horizontalmente com peso 0.5
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton botao1 = new JButton("Botão 1");
        frame.add(botao1, gbc);

        // Botão 2 - ocupa 2 colunas, cresce horizontalmente
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;          // cresce mais que o botao1
        JButton botao2 = new JButton("Botão 2 (2 colunas)");
        frame.add(botao2, gbc);

        // Botão 3 - ocupa 1 célula, não cresce
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        JButton botao3 = new JButton("Botão 3");
        frame.add(botao3, gbc);

        // Botão 4 - ocupa 2 colunas, cresce em ambas as direções
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;          // permite crescer verticalmente também
        gbc.fill = GridBagConstraints.BOTH;
        JButton botao4 = new JButton("Botão 4 (preenche)");
        frame.add(botao4, gbc);

        frame.setVisible(true);
    }
}
