import java.awt.*;

public class Block {
    private int id;
    private int x;
    private int y;
    private Color color;
    private boolean clicked;

    public Block(int id, int x, int y, Color color) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.color = color;
        this.clicked = false;
    }
    public int getId() {
        return id;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
    public void setClicked() {
        this.clicked = true;
    }
    public boolean isClicked() {
        return clicked;
    }
}
