package Display;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Thing.Block;
import Thing.Thing;

public class BackgroundPanel extends JPanel {
    public BackgroundPanel(int x, int y) {
        this.setLayout(null);
        this.setBounds(x, y, Constants.SECTION_DUNGEON_WIDTH, Constants.SECTION_DUNGEON_HEIGHT);

        drawMap();
    }

    private void drawMap() {
        // grass block (bottom)
        for (int i = 0; i < Constants.SECTION_DUNGEON_WIDTH; i += Constants.DEFAULT_BLOCK_PIECE_WIDTH) {
            Thing grass_block = new Block(Block.TYPE_GRASS_BLOCK_BOTTOM_MIDDLE);
            grass_block.setLocation(i, Constants.DEFAULT_BLOCK_Y_BOTTOM);
            this.add(grass_block);
        }

        // copper block (middle)
        // 1x1, 1x3, 2x2, 3x1 블럭을 화면이 꽉 찰 때까지 채우기
        int middle_length = 0;

        while (middle_length < Constants.WINDOW_WIDTH) {
            int[] typeList = { Block.TYPE_COPPER_BLOCK_BOTTOM_1x1, Block.TYPE_COPPER_BLOCK_BOTTOM_3x1 };
            int type = typeList[(int) (Math.random() * typeList.length)];

            Thing copper_block = new Block(type);
            copper_block.setLocation(middle_length, Constants.DEFAULT_BLOCK_Y_MIDDLE);
            middle_length += copper_block.getWidth();
            this.add(copper_block);
        }

        // copper block (top)
        int top_length = 0;

        while (top_length < Constants.WINDOW_WIDTH) {
            int[] typeList = { Block.TYPE_COPPER_BLOCK_BOTTOM_1x1, Block.TYPE_COPPER_BLOCK_BOTTOM_3x1 };
            int type = typeList[(int) (Math.random() * typeList.length)];

            Thing copper_block = new Block(type);
            copper_block.setLocation(top_length, Constants.DEFAULT_BLOCK_Y_TOP);
            top_length += copper_block.getWidth();
            this.add(copper_block);
        }

        // draw background
        ImageIcon background_image = new ImageIcon("src/resources/background_brown.png");

        for (int i = 0; i < Constants.WINDOW_HEIGHT; i += background_image.getIconWidth()) {
            for (int j = 0; j < Constants.WINDOW_WIDTH; j += background_image.getIconHeight()) {
                JLabel background = new JLabel(background_image);
                background.setLocation(j, i);
                background.setSize(background_image.getIconWidth(), background_image.getIconHeight());
                this.add(background);
            }
        }
    }

    public void moveBackground(int interval) {
        this.setLocation(this.getX() - interval, 0);
        
        if (this.getX() <= -Constants.WINDOW_WIDTH) {
            this.setLocation(Constants.WINDOW_WIDTH, 0);
        }
    }
}
