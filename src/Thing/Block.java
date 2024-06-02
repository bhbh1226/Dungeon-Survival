package Thing;

public class Block extends Thing {
    public static final int TYPE_GRASS_BLOCK_BOTTOM = 0;
    public static final int TYPE_GRASS_BLOCK_BOTTOM_LEFT = 1;
    public static final int TYPE_GRASS_BLOCK_BOTTOM_MIDDLE = 2;
    public static final int TYPE_GRASS_BLOCK_BOTTOM_RIGHT = 3;
    public static final int TYPE_COPPER_BLOCK_BOTTOM_1x1 = 4;
    public static final int TYPE_COPPER_BLOCK_BOTTOM_1x3 = 5;
    public static final int TYPE_COPPER_BLOCK_BOTTOM_2x2 = 6;
    public static final int TYPE_COPPER_BLOCK_BOTTOM_3x1 = 7;

    private static final Sprite[] blockSprites = new Sprite[8];

    private int width;
    private int height;

    static {
        blockSprites[TYPE_GRASS_BLOCK_BOTTOM] = new Sprite("/resources/grass_block_bottom.png");
        blockSprites[TYPE_GRASS_BLOCK_BOTTOM_LEFT] = new Sprite("/resources/grass_block_bottom_left.png");
        blockSprites[TYPE_GRASS_BLOCK_BOTTOM_MIDDLE] = new Sprite("/resources/grass_block_bottom_middle.png");
        blockSprites[TYPE_GRASS_BLOCK_BOTTOM_RIGHT] = new Sprite("/resources/grass_block_bottom_right.png");
        blockSprites[TYPE_COPPER_BLOCK_BOTTOM_1x1] = new Sprite("/resources/copper_block_bottom_1x1.png");
        blockSprites[TYPE_COPPER_BLOCK_BOTTOM_1x3] = new Sprite("/resources/copper_block_bottom_1x3.png");
        blockSprites[TYPE_COPPER_BLOCK_BOTTOM_2x2] = new Sprite("/resources/copper_block_bottom_2x2.png");
        blockSprites[TYPE_COPPER_BLOCK_BOTTOM_3x1] = new Sprite("/resources/copper_block_bottom_3x1.png");
    }

    public Block(int type) {
        super(blockSprites[type]);

        this.width = blockSprites[type].getWidth();
        this.height = blockSprites[type].getHeight();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
