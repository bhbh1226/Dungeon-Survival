package Display;

public class Constants {
    public static final int WINDOW_WIDTH = 16 * 24;
    public static final int WINDOW_HEIGHT = 16 * 36;

    public static final int SECTION_DUNGEON_WIDTH = WINDOW_WIDTH;
    public static final int SECTION_DUNGEON_HEIGHT = WINDOW_HEIGHT * 14 / 36;

    public static final int SECTION_MENU_WIDTH = WINDOW_WIDTH;
    public static final int SECTION_MENU_HEIGHT = WINDOW_HEIGHT * 22 / 36;

    public static final int PANEL_MAP_PANEL_WIDTH = 265;
    public static final int PANEL_MAP_PANEL_HEIGHT = 180;

    public static final int PANEL_MENU_MODAL_WIDTH = 225;
    public static final int PANEL_MENU_MODAL_HEIGHT = 140;

    public static final int DEFAULT_BLOCK_PIECE_WIDTH = 16;
    public static final int DEFAULT_BLOCK_PLATFORM_HEIGHT = 16;
    public static final int DEFAULT_BLOCK_BASEMENT_HEIGHT = 48;
    public static final int DEFAULT_BLOCK_X_START = 0;
    public static final int DEFAULT_BLOCK_X_PIECE_END = WINDOW_WIDTH - DEFAULT_BLOCK_PIECE_WIDTH;
    public static final int DEFAULT_BLOCK_Y_TOP = 48;
    public static final int DEFAULT_BLOCK_Y_MIDDLE = (SECTION_DUNGEON_HEIGHT / 2) - (DEFAULT_BLOCK_PLATFORM_HEIGHT / 2) + 8;
    public static final int DEFAULT_BLOCK_Y_BOTTOM = SECTION_DUNGEON_HEIGHT - DEFAULT_BLOCK_BASEMENT_HEIGHT;

    public static final int DEFAULT_MENU_ICON_Y_TOP = PANEL_MAP_PANEL_HEIGHT / 4;
    public static final int DEFAULT_MENU_ICON_Y_MIDDLE = PANEL_MAP_PANEL_HEIGHT / 2;
    public static final int DEFAULT_MENU_ICON_Y_BOTTOM = PANEL_MAP_PANEL_HEIGHT * 3 / 4;


    public static enum PosY {
        TOP, MIDDLE, BOTTOM
    };

    public static final int getLivingY(PosY pos, int height) {
        switch (pos) {
            case TOP:
                return DEFAULT_BLOCK_Y_TOP - height;
            case MIDDLE:
                return DEFAULT_BLOCK_Y_MIDDLE - height;
            case BOTTOM:
                return DEFAULT_BLOCK_Y_BOTTOM - height;
            default:
                return 0;
        }
    }
}
