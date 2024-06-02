package Menu;

import Display.Constants;
import Display.Constants.PosY;
import Manager.GameManager;

public class PlayerIcon extends MapIcon {
    public PlayerIcon() {
        super("src/resources/map_icon_player.png");
    }

    public void updatePosition() {
        PosY playerPosY = GameManager.getInstance().getPlayer().getPositionY();

        switch (playerPosY) {
            case TOP:
                this.setLocation(getX(), Constants.DEFAULT_MENU_ICON_Y_TOP - this.getHeight() - 5);
                break;
            case MIDDLE:
                this.setLocation(getX(), Constants.DEFAULT_MENU_ICON_Y_MIDDLE - this.getHeight() - 5);
                break;
            case BOTTOM:
                this.setLocation(getX(), Constants.DEFAULT_MENU_ICON_Y_BOTTOM - this.getHeight() - 5);
                break;
        }
    }
}
