package Manager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Thing.Player;

public class KeyInputManager extends KeyAdapter {
    Player player = GameManager.getInstance().getPlayer();
    
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                player.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                player.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
            case KeyEvent.VK_SPACE:
                break;
        }
    }
}
