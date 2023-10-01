import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Tablero tablero;
    private final Dimension dimension = new Dimension(500, 1000);

    public Ventana() {
        init();
    }

    private void init() {
        setSize(dimension);
        tablero = new Tablero();
        this.add(tablero);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revalidate();
        addKeyListener(tablero);

    }

    public Tablero getTablero() {
        return tablero;
    }
}
