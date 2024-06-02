package Manager;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontManager {
    private static FontManager instance = null;

    private Font ThaleahFatFont;

    private FontManager() {
        try {
            ThaleahFatFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/ThaleahFat_TTF.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static FontManager getInstance() {
        if (instance == null) {
            instance = new FontManager();
        }
        return instance;
    }

    public Font getThaleahFatFont(float fontSize) {
        return ThaleahFatFont.deriveFont(fontSize);
    }
}
