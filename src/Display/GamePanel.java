package Display;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    public GamePanel() {
        this.setLayout(null);
        this.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        DungeonPanel dungeonPanel = new DungeonPanel();

        this.add(dungeonPanel);
        dungeonPanel.setLocation(0, 0);

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setLocation(0, Constants.SECTION_DUNGEON_HEIGHT);

        this.add(menuPanel);
    }
}