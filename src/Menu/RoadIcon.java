package Menu;

import Display.Constants;

public class RoadIcon extends MapIcon {
    public RoadIcon() {
        super("src/resources/map_icon_road.png");
    }

    @Override
    public void move(int interval) {
        super.move(interval);

        if (this.getX() < 24) {
            this.setLocation(Constants.PANEL_MAP_PANEL_WIDTH - 50, this.getY());
        }
    }
}
