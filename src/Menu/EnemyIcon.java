package Menu;

import Display.Constants;
import Manager.GameManager;

public class EnemyIcon extends MapIcon {
    public EnemyIcon() {
        super("/resources/map_icon_enemy.png");
    }

    @Override
    public void move(int interval) {
        super.move(interval);
        
        if (GameManager.getInstance().isEnemyIsAllOutOfWindow()) {
            this.setLocation(Constants.PANEL_MAP_PANEL_WIDTH - 50, this.getY());
        }
    }
}
