import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class Tablero extends JPanel implements KeyListener {
    private Tetromino tetrominoActual;
    private List<Casilla> casillas;
    private List<Tetromino> tetrominos;
    private Vector2 dimension;
    private static final Map<Integer, Vector2> map = Map.of(KeyEvent.VK_RIGHT, Vector2.RIGHT, KeyEvent.VK_LEFT, Vector2.LEFT, KeyEvent.VK_DOWN, Vector2.DOWN);
    private Timer timer;
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            tetrominoActual.move(Vector2.DOWN);
        }
    };
    public Tablero() {
        init();
    }

    private void initTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 500, 50);
    }

    private void checkRomperFilas() {
        int rowOcupada = getRowOcupada();
        int cantidadRowsOcupadas = getCantRowsOcupadas().size();
        System.out.println(cantidadRowsOcupadas);
        for (int i = 0; i < cantidadRowsOcupadas; i++) {
            List<Casilla> row = getCasillasFromRow(rowOcupada);
            row.forEach(c -> {
                c.setOcupado(false);
                c.setBackground(Casilla.DEFAULT_BACKGROUND);
            });
            efectoGravedad(rowOcupada);
            repaint();

        }
    }

    private void caeFila(int row) {
        List<Casilla> casillas = getCasillasFromRow(row);
        List<Casilla> casillasArriba = getCasillasFromRow(row-1);
        for (int i = 0; i < casillas.size(); i++) {
            casillas.get(i).setOcupado(casillasArriba.get(i).isOcupado());
            casillas.get(i).setBackground(casillasArriba.get(i).getBackground());

        }
    }
    private void efectoGravedad(int row) {
        for (int i = row; i > 0; i--) {
            caeFila(i);
        }
    }

    private List<Casilla> getCasillasFromRow(int row) {
        return casillas.stream().filter(c -> c.getPosition().getX() == row).toList();
    }

    private List<Integer> getCantRowsOcupadas() {
        List<Integer> filasOcupadas = new ArrayList<>();
        for (int i = dimension.getX()-1; i >= 0; i--) {
            List<Casilla> actualRow = getCasillasFromRow(i);
            if (actualRow.stream().allMatch(Casilla::isOcupado)) {
                filasOcupadas.add(i);
            }
        }
        return filasOcupadas;
    }

    private int getRowOcupada() {
        for (int i = dimension.getX()-1; i >= 0; i--) {
            List<Casilla> actualRow = getCasillasFromRow(i);
            if (actualRow.stream().allMatch(Casilla::isOcupado)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            tetrominoActual.rotate();
        } else {
            tetrominoActual.move(map.get(e.getKeyCode()));

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Casilla getCasillaByPos(Vector2 position) {
        return casillas.stream().filter(c -> c.getPosition().equals(position)).findFirst().get();
    }

    private Random rand = new Random();
    private void setNextTetromino() {
        tetrominoActual = tetrominos.get(rand.nextInt(tetrominos.size()));
        tetrominoActual.setPosition(new Vector2(3, rand.nextInt(4, dimension.getY()-4)));
    }

    public void tetrominoTermino() {
        checkRomperFilas();
        setNextTetromino();
    }

    public void init() {
        dimension = new Vector2(30, 15);
        super.setSize(new Dimension(dimension.getX(), dimension.getY()));
        GridLayout gridLayout = new GridLayout(super.getWidth(), super.getHeight());
        setLayout(gridLayout);

        this.casillas = new ArrayList<>();
        meterCasillas();

        tetrominos = FabricaTetrominos.getTetrominos(this);

        setNextTetromino();

        initTimer();

    }

    private void meterCasillas() {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                addCasilla(new Casilla(new Vector2(i, j)));
            }
        }
    }

    private void addCasilla(Casilla c) {
        casillas.add(c);
        add(c);
    }

    private void removeCasilla(Casilla c) {
        casillas.remove(c);
        remove(c);
    }

    public Tetromino getTetrominoActual() {
        return tetrominoActual;
    }

    public void setTetrominoActual(Tetromino tetrominoActual) {
        this.tetrominoActual = tetrominoActual;
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(List<Casilla> casillas) {
        this.casillas = casillas;
    }

    public List<Tetromino> getTetrominos() {
        return tetrominos;
    }

    public void setTetrominos(List<Tetromino> tetrominos) {
        this.tetrominos = tetrominos;
    }

    public Vector2 getDimension() {
        return dimension;
    }
}
