package Main;

import javax.swing.JFrame;

import Display.Constants;
import Display.GamePanel;
import Manager.KeyInputManager;

public class GameFrame extends JFrame {
    public GameFrame() {
        super("Dungeon Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT + 36);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        GamePanel panel = new GamePanel();
        panel.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        this.add(panel);
        this.setVisible(true);

        this.addKeyListener(new KeyInputManager());
    }
}
