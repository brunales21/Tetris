import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Casilla extends JPanel {
    private Vector2 position;
    static final Color DEFAULT_BACKGROUND = Color.black;
    private Color bgColor = DEFAULT_BACKGROUND;
    private boolean ocupado = false;

    public Casilla(Vector2 vector2) {
        this.position = vector2;
        setBackground(bgColor);
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casilla casilla = (Casilla) o;
        return Objects.equals(position, casilla.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
