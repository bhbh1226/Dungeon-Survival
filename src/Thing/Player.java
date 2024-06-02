package Thing;

import java.util.ArrayList;

import Display.Constants;
import Manager.GameManager;

public class Player extends Living {
    private static final Sprite playerIdleSprite = new AnimatedSprite("src/resources/player_idle.png", 32, 32, 1, 4); 
    private static final Sprite playerMovingSprite = new AnimatedSprite("src/resources/player_moving.png", 32, 32, 1, 4);
    private static final Sprite playerHitSprite = new AnimatedSprite("src/resources/player_hit.png", 32, 32, 1, 4);

    private ArrayList<HealthListener> healthListeners = new ArrayList<HealthListener>();
    private ArrayList<LevelListener> levelListeners = new ArrayList<LevelListener>();

    private int maxHealth = 10;
    private int health = 10;
    private boolean canMove = true;

	public Player() {
        super(playerIdleSprite, 3, 16, Constants.PosY.MIDDLE);
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean getCanMove() {
        return this.canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void reset() {
        this.level = 3;
        this.health = this.maxHealth;
        notifyHealthChanged();
        this.setCanMove(true);
    }

    @Override
    public void moveUp() {
        if (canMove) {
            super.moveUp();
        }
    }

    @Override
    public void moveDown() {
        if (canMove) {
            super.moveDown();
        }
    }

    public void setMoving() {
        if (!currentSprite.equals(playerMovingSprite)) {
            setCurrentSprite(playerMovingSprite);
        }
    }

    public void setIdle() {
        if (!currentSprite.equals(playerIdleSprite)) {
            setCurrentSprite(playerIdleSprite);
        }
    }

    public void levelUp() {
        this.level += (int)(Math.random() * 2 + 1);
        notifyLevelChanged();
    }

    public void addHealthListener(HealthListener listener) {
        healthListeners.add(listener);
    }

    public void removeHealthListener(HealthListener listener) {
        healthListeners.remove(listener);
    }

    public void addLevelListener(LevelListener listener) {
        levelListeners.add(listener);
    }

    public void removeLevelListener(LevelListener listener) {
        levelListeners.remove(listener);
    }

    private void notifyHealthChanged() {
        for (HealthListener listener : healthListeners) {
            listener.onHealthChanged(this.health);
        }
    }

    private void notifyLevelChanged() {
        for (LevelListener listener : levelListeners) {
            listener.onLevelChanged(this.level);
        }
    }

    public void die() {
        setIdle();
        GameManager.getInstance().setGameState(GameManager.GameState.GAME_OVER);
    }

    public void takeDamage(int damage) {
        setCurrentSprite(playerHitSprite);
        this.health -= damage;
        notifyHealthChanged();

        if (this.health <= 0) {
            this.die();
        }

        // set sprite to moving after being hit
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    if (GameManager.getInstance().getGameState() == GameManager.GameState.RUNNING) {
                        setMoving();
                    }
                }
            }, 
            2000 
        );
    }
}
