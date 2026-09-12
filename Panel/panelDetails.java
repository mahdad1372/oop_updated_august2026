package Panel;

import Results.resultBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class panelDetails {
    private static Timer executingGameTimer;
    private static Timer gameTimer;
    public static void details(myPanel panel){
        panel.addKeyListener(new gamePanelKeyListener());
        panel.setFocusable(true);
        panel.setVisible(true);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                panel.requestFocusInWindow();
            }
        });
        executingGameTimer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        executingGameTimer.start();
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultBoard.setSecondsDurationGame(resultBoard.getSecondsDurationGame() +1);
            }
        });
        gameTimer.start();
    }

    public static Timer getExecutingGameTimer() {
        return executingGameTimer;
    }

    public static Timer getGameTimer() {
        return gameTimer;
    }
}
