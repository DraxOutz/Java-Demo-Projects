import java.awt.*;
import javax.swing.*;

public class ExemploBorderLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Exemplo");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JButton botaoNorte = new JButton("Norte");
        JButton botaoSul = new JButton("Sul");
        JButton botaoLeste = new JButton("Leste");
        JButton botaoOeste = new JButton("Oeste");
        JButton botaoCentro = new JButton("Centro");

        frame.add(botaoNorte, BorderLayout.NORTH);
        frame.add(botaoSul, BorderLayout.SOUTH);
        frame.add(botaoLeste, BorderLayout.EAST);
        frame.add(botaoOeste, BorderLayout.WEST);
        frame.add(botaoCentro, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
