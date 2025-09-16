import java.awt.*;
import javax.swing.*;

public class ExemploFlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Exemplo");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Define o layout do content pane como FlowLayout
        frame.setLayout(new FlowLayout());

        // Adiciona vários botões
        for (int i = 1; i <= 8; i++) {
            frame.add(new JButton("Botão " + i));
        }

        frame.setVisible(true);
    }
}
