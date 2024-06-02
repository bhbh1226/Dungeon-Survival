package Menu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Manager.FontManager;
import Manager.GameManager;
import Thing.HealthListener;
import Thing.Player;

public class HealthBar extends JPanel implements HealthListener {
    private ImageIcon Background = new ImageIcon("src/resources/health_bar_background.png");
    private ImageIcon InnerLeft = new ImageIcon("src/resources/health_bar_inner_left.png");
    private ImageIcon InnerMiddle = new ImageIcon("src/resources/health_bar_inner_middle.png");
    private ImageIcon InnerRight = new ImageIcon("src/resources/health_bar_inner_right.png");
    private FontedLabel healthLabel;

    private Player player;

    public HealthBar() {
        this.player = GameManager.getInstance().getPlayer();
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, Background.getIconWidth(), Background.getIconHeight());

        // Health label
        healthLabel = new FontedLabel(player.getHealth() + " / " + player.getMaxHealth(), FontManager.getInstance().getThaleahFatFont(24f));
        healthLabel.setForeground(Color.WHITE);
        healthLabel.setLocation(Background.getIconWidth() / 2 - healthLabel.getWidth() / 2, Background.getIconHeight() / 2 - healthLabel.getHeight() / 2);
        this.add(healthLabel);

        player.addHealthListener(this);
    }

    public void update() {
        healthLabel.setText(Math.max(player.getHealth(), 0) + " / " + player.getMaxHealth());
        repaint();
    }

    @Override
    public void onHealthChanged(int health) {
        update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background
        g.drawImage(Background.getImage(), 0, 0, null);

        // Draw health bar
        if (player.getHealth() > 0) {
            double healthPercentage = (double) player.getHealth() / player.getMaxHealth();
            int barWidth = (int) (218 * healthPercentage);
        
            g.drawImage(InnerLeft.getImage(), 6, 4, InnerLeft.getIconWidth(), InnerLeft.getIconHeight(), null);
            g.drawImage(InnerMiddle.getImage(), 20, 4, barWidth, InnerMiddle.getIconHeight(), null);
            g.drawImage(InnerRight.getImage(), Background.getIconWidth() - InnerRight.getIconWidth() - 6 - (int) (218 * (1 - healthPercentage)), 4, InnerRight.getIconWidth(), InnerRight.getIconHeight(), null);
        }
    }
}
