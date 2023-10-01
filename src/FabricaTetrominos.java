import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FabricaTetrominos {

    public static List<Tetromino> getTetrominos(Tablero tablero) {
        List<Tetromino> tetrominos = new ArrayList<>();
        // Tetromino I (Cyan)
        List<ParteDeTetromino> tetrominoI = new ArrayList<>();
        tetrominoI.add(new ParteDeTetromino(new Vector2(0, 0)));
        tetrominoI.add(new ParteDeTetromino(new Vector2(1, 0)));
        tetrominoI.add(new ParteDeTetromino(new Vector2(2, 0)));
        tetrominoI.add(new ParteDeTetromino(new Vector2(3, 0)));
        tetrominos.add(new Tetromino(Color.CYAN, tetrominoI, tablero));

        // Tetromino J (Azul)
        List<ParteDeTetromino> tetrominoJ = new ArrayList<>();
        tetrominoJ.add(new ParteDeTetromino(new Vector2(0, 0)));
        tetrominoJ.add(new ParteDeTetromino(new Vector2(0, 1)));
        tetrominoJ.add(new ParteDeTetromino(new Vector2(1, 1)));
        tetrominoJ.add(new ParteDeTetromino(new Vector2(2, 1)));
        tetrominos.add(new Tetromino(Color.BLUE, tetrominoJ, tablero));

        // Tetromino L (Naranja)
        List<ParteDeTetromino> tetrominoL = new ArrayList<>();
        tetrominoL.add(new ParteDeTetromino(new Vector2(2, 0)));
        tetrominoL.add(new ParteDeTetromino(new Vector2(0, 1)));
        tetrominoL.add(new ParteDeTetromino(new Vector2(1, 1)));
        tetrominoL.add(new ParteDeTetromino(new Vector2(2, 1)));
        tetrominos.add(new Tetromino(Color.ORANGE, tetrominoL, tablero));

        // Tetromino O (Amarillo)
        List<ParteDeTetromino> tetrominoO = new ArrayList<>();
        tetrominoO.add(new ParteDeTetromino(new Vector2(0, 0)));
        tetrominoO.add(new ParteDeTetromino(new Vector2(1, 0)));
        tetrominoO.add(new ParteDeTetromino(new Vector2(0, 1)));
        tetrominoO.add(new ParteDeTetromino(new Vector2(1, 1)));
        tetrominos.add(new Tetromino(Color.YELLOW, tetrominoO, tablero));

        // Tetromino S (Verde)
        List<ParteDeTetromino> tetrominoS = new ArrayList<>();
        tetrominoS.add(new ParteDeTetromino(new Vector2(1, 0)));
        tetrominoS.add(new ParteDeTetromino(new Vector2(2, 0)));
        tetrominoS.add(new ParteDeTetromino(new Vector2(0, 1)));
        tetrominoS.add(new ParteDeTetromino(new Vector2(1, 1)));
        tetrominos.add(new Tetromino(Color.GREEN, tetrominoS, tablero));

        // Tetromino T (Magenta)
        List<ParteDeTetromino> tetrominoT = new ArrayList<>();
        tetrominoT.add(new ParteDeTetromino(new Vector2(1, 0)));
        tetrominoT.add(new ParteDeTetromino(new Vector2(0, 1)));
        tetrominoT.add(new ParteDeTetromino(new Vector2(1, 1)));
        tetrominoT.add(new ParteDeTetromino(new Vector2(2, 1)));
        tetrominos.add(new Tetromino(Color.MAGENTA, tetrominoT, tablero));

        // Tetromino Z (Rojo)
        List<ParteDeTetromino> tetrominoZ = new ArrayList<>();
        tetrominoZ.add(new ParteDeTetromino(new Vector2(0, 0)));
        tetrominoZ.add(new ParteDeTetromino(new Vector2(1, 0)));
        tetrominoZ.add(new ParteDeTetromino(new Vector2(1, 1)));
        tetrominoZ.add(new ParteDeTetromino(new Vector2(2, 1)));
        tetrominos.add(new Tetromino(Color.RED, tetrominoZ, tablero));
        return tetrominos;
    }
}
