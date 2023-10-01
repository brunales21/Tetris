import java.util.Objects;

public class Vector2 {
    public static final Vector2 RIGHT = new Vector2(0, 1);
    public static final Vector2 LEFT = new Vector2(0, -1);
    public static final Vector2 DOWN = new Vector2(1, 0);

    private int x;
    private int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 sum(Vector2 v1) {
        return new Vector2(v1.getX()+x, v1.getY()+y);
    }

    public Vector2 rotationPosition() {
        return new Vector2(-y, x);
    }

    public boolean isInBounds(Vector2 dimension) {
        return 0 <= x && x < dimension.getX() && 0 <= y && y < dimension.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return x == vector2.x && y == vector2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
