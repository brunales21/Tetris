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
        timer.scheduleAtFixedRate(timerTask, 0, 150);
    }

    private void romperFila() {
        int row = getFilledRow();
        if (row != -1) {
            System.out.println("fila full = "+row);
            casillas.stream()
                    .filter(c -> c.getPosition().getX() == row)
                    .forEach(c -> {
                        System.out.println("entra");
                                c.setOcupado(false);
                                c.setBackground(Casilla.DEFAULT_BACKGROUND);
                            }
                    );
        }
        
    }
    
    private void efectoGravedad() {

    }
    private int getFilledRow() {
        int contador;
        for (int i = dimension.getX()-1; i >= 0; i--) {
            contador = 0;
            for (int j = dimension.getY()-1; j >= 0; j--) {
                if (getCasillaByPos(new Vector2(i, j)).isOcupado()) {
                    contador++;
                }
            }
            if (contador == dimension.getY()) {
                System.out.println("fila "+i);
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
        tetrominoActual = tetrominos.get(rand.nextInt(7));
        tetrominoActual.setPosition(new Vector2(4, rand.nextInt(4, dimension.getY()-4)));
    }

    public void tetrominoTermino() {
        romperFila();
        efectoGravedad();
        setNextTetromino();
    }

    public void init() {
        dimension = new Vector2(30, 10);
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
