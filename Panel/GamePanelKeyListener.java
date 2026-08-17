package Panel;

import Player.PlayerCreation;
import Results.resultBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanelKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        if (resultBoard.getDisplay_name_menu()) {
            char c = e.getKeyChar();
            if (Character.isLetterOrDigit(c) || c == ' ') {
                resultBoard.appendTypedNameChar(c);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (resultBoard.getDisplay_name_menu()) {
            if (keycode == KeyEvent.VK_BACK_SPACE) {
                resultBoard.removeLastTypedNameChar();
            } else if (keycode == KeyEvent.VK_ENTER) {
                String name = resultBoard.getTypedName().trim();
                if (!name.isEmpty()) {
                    resultBoard.setPlayerName(name);
                    resultBoard.setDisplay_name_menu(false);
                    resultBoard.setDisplay_difficulty_menu(true);
                    resultBoard.showDifficultyButtons();
                }
            }
        } else {
            PlayerCreation.player_movement(keycode);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}