import java.awt.*;
import java.util.List;

public class Tetromino {
    private Tablero tablero;
    private Vector2 position;
    private Color color;
    private List<ParteDeTetromino> partes;


    public Tetromino(Color color, List<ParteDeTetromino> partes, Tablero tablero) {
        this.color = color;
        this.partes = partes;
        this.tablero = tablero;
    }

    public void move(Vector2 direction) {
        if (canMoveTowards(direction)) {
            show(false);
            setPosition(nextPosition(direction));
            show(true);
        } else if (direction == Vector2.DOWN) {
            partes.forEach(p -> tablero.getCasillaByPos(position.sum(p.getPosition())).setOcupado(true));
            tablero.tetrominoTermino();
        }
    }

    public Vector2 nextPosition(Vector2 direction) {
        return position.sum(direction);
    }

    public boolean canMoveTowards(Vector2 direction) {
        Vector2 nextPos = nextPosition(direction);
        return partes.stream()
                .allMatch(p -> {
                    Vector2 position = nextPos.sum(p.getPosition());
                    return position.isInBounds(tablero.getDimension()) &&
                            !tablero.getCasillaByPos(position).isOcupado();
                });
    }

    public void rotate() {
        if (canRotate()) {
            show(false);
            partes.forEach(ParteDeTetromino::setRotation);
            show(true);
        } else {
            System.out.println("no pudo rotar");
        }
    }

    public boolean canRotate() {
        return partes.stream()
                .allMatch(p -> {
                    Vector2 pos = position.sum(p.getPosition().rotationPosition());
                    return pos.isInBounds(tablero.getDimension()) &&
                            !tablero.getCasillaByPos(pos).isOcupado();
                });
    }

    public void show(boolean show) {
        var color = show? getColor():Casilla.DEFAULT_BACKGROUND;
        for (ParteDeTetromino parte: partes) {
            tablero.getCasillaByPos(position.sum(parte.getPosition())).setBackground(color);

        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public List<ParteDeTetromino> getPartes() {
        return partes;
    }
}
