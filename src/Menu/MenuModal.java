package Menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Display.Constants;
import Manager.GameManager;
import Manager.ThreadListener;

public class MenuModal extends JPanel implements ThreadListener {
    private JLabel iconLabel;
    private ImageIcon checkIcon = new ImageIcon(getClass().getResource("/resources/modal_check.png"));
    private ImageIcon crossIcon = new ImageIcon(getClass().getResource("/resources/modal_cross.png"));
    private ImageIcon restartIcon = new ImageIcon(getClass().getResource("/resources/modal_restart.png"));

    public MenuModal() {
        this.setLayout(null);
        this.setSize(Constants.PANEL_MENU_MODAL_WIDTH, Constants.PANEL_MENU_MODAL_HEIGHT);
        this.setOpaque(false);

        this.iconLabel = new JLabel();
        this.add(iconLabel);
        this.setVisible(false);
        GameManager.getInstance().addThreadListener(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (GameManager.getInstance().getGameState() == GameManager.GameState.GAME_OVER) {
                    GameManager.getInstance().restartGame();
                    setVisible(false);
                }
            }
        });
    }

    @Override
    public void onThreadCalled() {
        if (GameManager.getInstance().getGameState() == GameManager.GameState.GAME_OVER) {
            this.setIcon("restart");
            this.setVisible(true);
        }
    }

    public void setIcon(String icon) {
        switch (icon) {
            case "check":
                this.iconLabel.setIcon(checkIcon);
                break;
            case "cross":
                this.iconLabel.setIcon(crossIcon);
                break;
            case "restart":
                this.iconLabel.setIcon(restartIcon);
                break;
            default:
                break;
        }

        this.iconLabel.setBounds(Constants.PANEL_MENU_MODAL_WIDTH / 2 - this.iconLabel.getIcon().getIconWidth() / 2,
                Constants.PANEL_MENU_MODAL_HEIGHT / 2 - this.iconLabel.getIcon().getIconHeight() / 2,
                this.iconLabel.getIcon().getIconWidth(), this.iconLabel.getIcon().getIconHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cutSize = 40;
        int width = Constants.PANEL_MENU_MODAL_WIDTH;
        int height = Constants.PANEL_MENU_MODAL_HEIGHT;
        
        g.setColor(Color.WHITE);
        g.fillPolygon(new int[] { cutSize, width - cutSize, width, width, width - cutSize, cutSize, 0, 0 },
                new int[] { 0, 0, cutSize, height - cutSize, height, height, height - cutSize, cutSize }, 8);
    }
}
