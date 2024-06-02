package Thing;

import Display.Constants;
import Display.Constants.PosY;

public class Living extends TaggedThing {
    protected int level;
    protected PosY positionY;
    
    public Living(Sprite sprite, int level, int positionX, PosY positionY) {
        super(sprite);

        this.level = level;
        this.setPosition(positionX, positionY);
    }

    public Living(Sprite sprite, int level, int positionX, PosY positionY, String tag) {
        super(sprite, tag);

        this.level = level;
        this.setPosition(positionX, positionY);
    }

    public int getLevel() {
        return this.level;
    }

    public PosY getPositionY() {
        return this.positionY;
    }

    public void setPosition(int positionX, PosY positionY) {
        this.positionY = positionY;
        this.setLocation(positionX, Constants.getLivingY(positionY, this.getStartY()));
    }

    // check collision
    public boolean isColliding(Thing thing) {
        return this.getBounds().intersects(thing.getBounds());
    }

    public void moveUp() {
        switch (this.positionY) {
            case TOP:
                break;
            case MIDDLE:
                this.setPosition(getX(), PosY.TOP);
                break;
            case BOTTOM:
                this.setPosition(getX(), PosY.MIDDLE);
                break;
        }
    }

    public void moveDown() {
        switch (this.positionY) {
            case TOP:
                this.setPosition(getX(), PosY.MIDDLE);
                break;
            case MIDDLE:
                this.setPosition(getX(), PosY.BOTTOM);
                break;
            case BOTTOM:
                break;
        }
    }
}
