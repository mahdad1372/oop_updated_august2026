package Panel;

import Player.playerCreation;
import Results.resultBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gamePanelKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        if (resultBoard.getDisplayNameMenu()) {
            char c = e.getKeyChar();
            if (Character.isLetterOrDigit(c) || c == ' ') {
                resultBoard.appendTypedNameChar(c);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (resultBoard.getDisplayNameMenu()) {
            if (keycode == KeyEvent.VK_BACK_SPACE) {
                resultBoard.removeLastTypedNameChar();
            } else if (keycode == KeyEvent.VK_ENTER) {
                String name = resultBoard.getTypedName().trim();
                if (!name.isEmpty()) {
                    resultBoard.setPlayerName(name);
                    resultBoard.setDisplayNameMenu(false);
                    resultBoard.setDisplayDifficultyMenu(true);
                    resultBoard.showDifficultyButtons();
                }
            }
        } else {
            playerCreation.player_movement(keycode);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}