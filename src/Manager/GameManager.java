package Manager;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

import Display.BackgroundPanel;
import Display.Constants;
import Display.Constants.PosY;
import Thing.AnimatedSprite;
import Thing.Enemy;
import Thing.Player;

public class GameManager {
    private static GameManager instance = null;

    public static enum GameState {
        WAITING,
        RUNNING,
        GAME_OVER
    }
    
    private GameState gameState = GameState.RUNNING;

    private BackgroundPanel backgroundPanel1;
    private BackgroundPanel backgroundPanel2;
    private Player player;
    private CopyOnWriteArrayList<Enemy> enemies = new CopyOnWriteArrayList<Enemy>();
    private CopyOnWriteArrayList<Integer> levelList = new CopyOnWriteArrayList<Integer>();
    private CopyOnWriteArrayList<ThreadListener> threadListeners = new CopyOnWriteArrayList<ThreadListener>();
    private boolean isEnemyIsAllOutOfWindow = false;

    private GameManager() {
        // player
        this.player = new Player();

        // enemy
        this.resetLevelList();
        this.enemies.add(new Enemy(getLevelPopped(), PosY.TOP));
        this.enemies.add(new Enemy(getLevelPopped(), PosY.MIDDLE));
        this.enemies.add(new Enemy(getLevelPopped(), PosY.BOTTOM));
        
        // background
        this.backgroundPanel1 = new BackgroundPanel(0, 0);
        this.backgroundPanel2 = new BackgroundPanel(Constants.SECTION_DUNGEON_WIDTH, 0);
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public CopyOnWriteArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public BackgroundPanel getBackgroundPanel1() {
        return backgroundPanel1;
    }

    public BackgroundPanel getBackgroundPanel2() {
        return backgroundPanel2;
    }

    public int getLevelPopped() {
        return levelList.remove(0);
    }

    public void resetLevelList() {
        levelList.clear();

        levelList.add(player.getLevel() + ((int) (Math.random() * 3 - 2)));
        levelList.add(player.getLevel() + ((int) (Math.random() * 5 - 2)));
        levelList.add(player.getLevel() + ((int) (Math.random() * 3)));

        Collections.shuffle(levelList);
    }

    public Player getPlayer() {
        return player;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void addThreadListener(ThreadListener listener) {
        threadListeners.add(listener);
    }

    public void removeThreadListener(ThreadListener listener) {
        threadListeners.remove(listener);
    }

    private void notifyThreadListeners() {
        for (ThreadListener listener : threadListeners) {
            listener.onThreadCalled();
        }
    }

    public boolean isEnemyIsAllOutOfWindow() {
        return isEnemyIsAllOutOfWindow;
    }

    public void startGame() {
        new Thread(() -> {
            while (true) {
                switch (gameState) {
                    case WAITING:
                        player.setIdle();
                        break;
                    case RUNNING:
                        // player
                        if (player.getCanMove()) {
                            player.setMoving();
                        }

                        ((AnimatedSprite) player.getCurrentSprite()).setFrameInterval(2);
                        
                        // enemies
                        isEnemyIsAllOutOfWindow = false;
                        for (Enemy enemy : enemies) {
                            enemy.move(2);

                            if (enemy.isColliding(player) && player.getCanMove()) {
                                enemy.interact(player);
                                player.setCanMove(false);
                            }
                        }
                        if (enemies.stream().allMatch(Enemy::isOutOfWindow)) {
                            isEnemyIsAllOutOfWindow = true;
                            resetLevelList();
                            enemies.forEach(enemy -> enemy.reset(getLevelPopped())); //level list를 생성하여 순서대로
                            player.setCanMove(true);
                        }

                        // background
                        backgroundPanel1.moveBackground(2);
                        backgroundPanel2.moveBackground(2);

                        // thread listener
                        notifyThreadListeners();
                        break;
                    case GAME_OVER:
                        break;
                    default:
                        break;
                }
                
                try {
                    Thread.sleep(1000 / 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void restartGame() {
        this.gameState = GameState.RUNNING;
        this.player.reset();
        this.resetLevelList();
        this.enemies.forEach(enemy -> enemy.reset(getLevelPopped()));
    }
}
