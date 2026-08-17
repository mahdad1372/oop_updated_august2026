package Panel;

import Results.resultBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class panelDetails {
    public static Timer executing_game_timer;
    public static Timer Game_Timer;
    public static void details(MyPanel panel){
        panel.addKeyListener(new GamePanelKeyListener());
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
        executing_game_timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        executing_game_timer.start();
        Game_Timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultBoard.setSeconds_Duration_Game(resultBoard.getSeconds_Duration_Game() +1);
            }
        });
        Game_Timer.start();
    }
}
