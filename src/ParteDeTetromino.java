import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Parameter;

public class ParteDeTetromino extends JPanel {
    private Vector2 position;

    public ParteDeTetromino(Vector2 position) {
        this.position = position;
    }
    public void setRotation() {
        setPosition(new Vector2(-position.getY(), position.getX()));
    }
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
