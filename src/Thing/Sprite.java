package Thing;

import javax.swing.ImageIcon;

public class Sprite extends ImageIcon {
    public Sprite(String fileName) {
        super(Sprite.class.getResource(fileName));
    }

    public int getWidth() {
        return this.getIconWidth();
    }

    public int getHeight() {
        return this.getIconHeight();
    }
}
