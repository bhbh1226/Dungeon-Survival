package Menu;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Display.Constants;

import Manager.GameManager;
import Manager.ThreadListener;

public class MapPanel extends JPanel implements ThreadListener {
    private PlayerIcon playerIcon;
    private CopyOnWriteArrayList<EnemyIcon> enemyIcons = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<RoadIcon> roadIcons = new CopyOnWriteArrayList<>();
    private MenuModal menuModal;

    public MapPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, Constants.PANEL_MAP_PANEL_WIDTH, Constants.PANEL_MAP_PANEL_HEIGHT);
        this.setOpaque(false);

        // Menu Modal
        menuModal = new MenuModal();
        menuModal.setLocation((Constants.PANEL_MAP_PANEL_WIDTH - Constants.PANEL_MENU_MODAL_WIDTH) / 2,
                (Constants.PANEL_MAP_PANEL_HEIGHT - Constants.PANEL_MENU_MODAL_HEIGHT) / 2);
        this.add(menuModal);

        // Player Icon
        playerIcon = new PlayerIcon();
        playerIcon.setLocation(20, Constants.DEFAULT_MENU_ICON_Y_MIDDLE - playerIcon.getHeight() - 5);
        this.add(playerIcon);

        // Enemy Icon add
        EnemyIcon enemyIconTop = new EnemyIcon();
        enemyIconTop.setLocation(Constants.PANEL_MAP_PANEL_WIDTH - 50,
                Constants.PANEL_MAP_PANEL_HEIGHT / 4 - enemyIconTop.getHeight() - 5);
        enemyIcons.add(enemyIconTop);
        this.add(enemyIconTop);

        EnemyIcon enemyIconMid = new EnemyIcon();
        enemyIconMid.setLocation(Constants.PANEL_MAP_PANEL_WIDTH - 50,
                Constants.PANEL_MAP_PANEL_HEIGHT / 2 - enemyIconMid.getHeight() - 5);
        enemyIcons.add(enemyIconMid);
        this.add(enemyIconMid);

        EnemyIcon enemyIconBot = new EnemyIcon();
        enemyIconBot.setLocation(Constants.PANEL_MAP_PANEL_WIDTH - 50,
                Constants.PANEL_MAP_PANEL_HEIGHT * 3 / 4 - enemyIconBot.getHeight() - 5);
        enemyIcons.add(enemyIconBot);
        this.add(enemyIconBot);

        // Road Icon add
        for (int i = 0; i < Constants.PANEL_MAP_PANEL_WIDTH - 50; i += 12) {
            RoadIcon roadIconTop = new RoadIcon();
            roadIconTop.setLocation(i, Constants.PANEL_MAP_PANEL_HEIGHT / 4 - roadIconTop.getHeight() / 2);
            roadIcons.add(roadIconTop);
            this.add(roadIconTop);

            RoadIcon roadIconMid = new RoadIcon();
            roadIconMid.setLocation(i, Constants.PANEL_MAP_PANEL_HEIGHT / 2 - roadIconMid.getHeight() / 2);
            roadIcons.add(roadIconMid);
            this.add(roadIconMid);

            RoadIcon roadIconBot = new RoadIcon();
            roadIconBot.setLocation(i, Constants.PANEL_MAP_PANEL_HEIGHT * 3 / 4 - roadIconBot.getHeight() / 2);
            roadIcons.add(roadIconBot);
            this.add(roadIconBot);
        }

        // Map Border
        ImageIcon mapBorderIcon = new ImageIcon(getClass().getResource("/resources/map_border.png"));
        JLabel mapBorderLabel = new JLabel(mapBorderIcon);
        mapBorderLabel.setBounds(0, 0, Constants.PANEL_MAP_PANEL_WIDTH, Constants.PANEL_MAP_PANEL_HEIGHT);
        this.add(mapBorderLabel);

        // Add Thread Listener
        GameManager.getInstance().addThreadListener(this);
    }

    @Override
    public void onThreadCalled() {
        this.update();
    }

    public void update() {
        playerIcon.updatePosition();

        for (EnemyIcon enemyIcon : enemyIcons) {
            enemyIcon.move(1);
        }

        for (RoadIcon roadIcon : roadIcons) {
            roadIcon.move(1);
        }

        this.repaint();
    }
}
