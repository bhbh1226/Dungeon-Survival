package Menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MapIcon extends JLabel {
    public MapIcon(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        this.setIcon(icon);
        this.setSize(icon.getIconWidth(), icon.getIconHeight());
    }

    public void move(int interval) {
        this.setLocation(this.getX() - interval, this.getY());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(((ImageIcon) this.getIcon()).getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}
