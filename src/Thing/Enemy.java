package Thing;

import Display.Constants;

public class Enemy extends Living implements PlayerInteractable {
    private static final Sprite[] movingSprites = {
            new AnimatedSprite("/resources/enemy_bat_moving.png", 46, 30, 2, 4),
            new AnimatedSprite("/resources/enemy_bunny_moving.png", 34, 44, 2, 4),
            new AnimatedSprite("/resources/enemy_bluebird_moving.png", 32, 32, 2, 4),
            new AnimatedSprite("/resources/enemy_angrypig_moving.png", 36, 30, 2, 4),
            new AnimatedSprite("/resources/enemy_chicken_moving.png", 32, 34, 2, 4),
            new AnimatedSprite("/resources/enemy_mushroom_moving.png", 32, 32, 2, 4),
            new AnimatedSprite("/resources/enemy_radish_moving.png", 30, 38, 2, 4),
            new AnimatedSprite("/resources/enemy_slime_moving.png", 44, 30, 2, 4),
    };
    private static final Sprite[] hitSprites = {
            new AnimatedSprite("/resources/enemy_bat_hit.png", 46, 30, 2, 4),
            new AnimatedSprite("/resources/enemy_bunny_hit.png", 34, 44, 2, 4),
            new AnimatedSprite("/resources/enemy_bluebird_hit.png", 32, 32, 2, 4),
            new AnimatedSprite("/resources/enemy_angrypig_hit.png", 36, 30, 2, 4),
            new AnimatedSprite("/resources/enemy_chicken_hit.png", 32, 34, 2, 4),
            new AnimatedSprite("/resources/enemy_mushroom_hit.png", 32, 32, 2, 4),
            new AnimatedSprite("/resources/enemy_radish_hit.png", 30, 38, 2, 4),
            new AnimatedSprite("/resources/enemy_slime_hit.png", 44, 30, 2, 4),
    };
    public static final int typeCount = movingSprites.length;

    private int damage;
    private int type;

    public Enemy(int level, Constants.PosY positionY) {
        super(movingSprites[0 /* dummy value */], level, Constants.WINDOW_WIDTH, positionY, "LV. " + level);

        this.reset(level);
    }

    public void reset(int level) {
        this.type = (int) (Math.random() * typeCount);
        this.level = level;
        this.damage = 3;
        this.setTag("LV. " + level);
        this.setCurrentSprite(movingSprites[type]);
        this.setPosition(Constants.WINDOW_WIDTH, this.positionY);
    }

    public void die() {
        this.setCurrentSprite(hitSprites[type]);
    }

    public void attack(Player player) {
        player.takeDamage(this.damage);
    }

    public void move(int interval) {
        this.setLocation(this.getX() - interval, this.getY());
    }

    @Override
    public boolean isOutOfWindow() {
        return super.isOutOfWindow() && this.getX() + this.getWidth() < 0;
    }

    @Override
    public void interact(Player player) {
        if (this.level > player.getLevel()) {
            this.attack(player);
        } else {
            die();
            player.levelUp();
        }
    }
}
