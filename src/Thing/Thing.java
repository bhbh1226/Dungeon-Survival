package Thing;

import javax.swing.JLabel;

import Display.Constants;
import Manager.AnimationManager;

public class Thing extends JLabel {
    protected Sprite currentSprite = null;

    public Thing(Sprite sprite) {
        setCurrentSprite(sprite);
    }
        
    public void setCurrentSprite(Sprite sprite) {
        if (currentSprite instanceof AnimatedSprite) {
            AnimationManager.getInstance().removeThing(this);
        }

        this.currentSprite = sprite;
        setIcon(sprite);
        setSize(sprite.getWidth(), sprite.getHeight());

        if (sprite instanceof AnimatedSprite) {
            AnimationManager.getInstance().addThing(this);
        }
    }

    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    public int getWidth() {
        return getSize().width;
    }

    public int getHeight() {
        return getSize().height;
    }

    public int getStartX() {
        return getWidth();
    }

    public int getStartY() {
        return getHeight();
    }

    public boolean isOutOfWindow() {
        return getX() + getWidth() < 0 || getX() > Constants.WINDOW_WIDTH || getY() + getHeight() < 0 || getY() > Constants.WINDOW_HEIGHT;
    }
}
