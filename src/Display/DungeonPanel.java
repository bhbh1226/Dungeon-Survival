package Display;

import javax.swing.JPanel;

import Manager.GameManager;
import Thing.Enemy;
import Thing.Player;

public class DungeonPanel extends JPanel {
    public DungeonPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, Constants.SECTION_DUNGEON_WIDTH, Constants.SECTION_DUNGEON_HEIGHT);

        GameManager gameManager = GameManager.getInstance();

        Player player = gameManager.getPlayer();
        add(player);

        for (Enemy enemy : gameManager.getEnemies()) {
            this.add(enemy);
        }

        add(gameManager.getBackgroundPanel1());
        add(gameManager.getBackgroundPanel2());

        gameManager.startGame();
    }
}
