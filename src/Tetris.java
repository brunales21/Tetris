public class Tetris implements Game {
    private Ventana ventana;

    @Override
    public void start() {
        this.ventana = new Ventana();
    }
}
