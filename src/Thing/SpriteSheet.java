package Thing;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpriteSheet {
    private BufferedImage spriteSheet;
    private int spriteWidth;
    private int spriteHeight;

    public SpriteSheet(String fileName, int spriteWidth, int spriteHeight) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;

        try {
            this.spriteSheet = ImageIO.read(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int xGrid, int yGrid) {
        return spriteSheet.getSubimage(xGrid * spriteWidth, yGrid * spriteHeight, spriteWidth, spriteHeight);
    }

    public int getTotalFrameCount() {
        return spriteSheet.getWidth() / spriteWidth;
    }
}
