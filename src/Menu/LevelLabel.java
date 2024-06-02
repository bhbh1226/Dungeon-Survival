package Menu;

import Manager.FontManager;
import Manager.GameManager;
import Thing.LevelListener;

public class LevelLabel extends FontedLabel implements LevelListener {
    public LevelLabel() {
        super("LV. " + GameManager.getInstance().getPlayer().getLevel(),
                FontManager.getInstance().getThaleahFatFont(48f));
        
        GameManager.getInstance().getPlayer().addLevelListener(this);
    }

    @Override
    public void onLevelChanged(int level) {
        setText("LV. " + level);
    }
}
