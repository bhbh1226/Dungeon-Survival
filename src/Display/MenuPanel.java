package Display;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Menu.FontedLabel;
import Menu.HealthBar;
import Menu.LevelLabel;
import Menu.MapPanel;

public class MenuPanel extends JPanel {
    private FontedLabel levelLabel;
    private HealthBar healthBar;
    private MapPanel mapPanel;

    public MenuPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, Constants.SECTION_MENU_WIDTH, Constants.SECTION_MENU_HEIGHT);
        this.setBackground(new Color(99, 72, 51));

        // Player Level
        levelLabel = new LevelLabel();
        levelLabel.setLocation(60, 16);
        this.add(levelLabel);
        // HP Bar
        healthBar = new HealthBar();
        healthBar.setLocation(60, 58);
        this.add(healthBar);
        // Map
        mapPanel = new MapPanel();
        mapPanel.setLocation(60, 115);
        this.add(mapPanel);
        // Up Button
        // Down Button

        JLabel backgroundLabel = new JLabel(new ImageIcon("src/resources/background_menu.png"));
        backgroundLabel.setBounds(0, 0, Constants.SECTION_MENU_WIDTH, Constants.SECTION_MENU_HEIGHT);
        this.add(backgroundLabel);
    }
}
