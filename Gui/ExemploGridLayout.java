import java.awt.*;
import javax.swing.*;

public class ExemploGridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Exemplo");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Configura o layout do frame como uma grade 2x3 (2 linhas, 3 colunas)
        frame.setLayout(new GridLayout(2, 3, 5, 5)); // 5 px de espaço horizontal e vertical

        // Adiciona 6 botões
        for (int i = 1; i <= 6; i++) {
            frame.add(new JButton("Botão " + i));
        }

        frame.setVisible(true);
    }
}
