package Panel;

import Bullet.BulletPlayer;
import Enemy.*;
import Exceptions.InvalidGameDataException;
import Obstacles.Laser;
import Obstacles.Mine;
import Obstacles.obstacleCreation;
import Obstacles.Wall;
import Player.Player;
import Player.PlayerCreation;
import Results.createResults;
import Results.resultBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements KeyListener {
    public MyPanel(){
        panelDetails.details(this);
        creation();
        resultBoard.setupDifficultyButtons(this);
    }
    public void creation(){
        try {
            Enemycreation.create_TankEnemy();
            Enemycreation.create_thief();
        } catch (InvalidGameDataException e) {
            e.printStackTrace();
        }
        obstacleCreation.create_obstacle(Wall.wall_coordinates,"Wall");
        obstacleCreation.create_obstacle(Laser.getLaser_coordinates(),"Laser");
        obstacleCreation.create_obstacle(Mine.getMineCoordinates(),"Mine");
        Enemycreation.create_missile_launcher();
        resultBoard.setResult_boards(createResults.creating_result_board(resultBoard.getResultBoardCoordinates()));
        Enemycreation.createSniperEnemy();
        Player.setPlayer(PlayerCreation.create_player());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Enemycreation.drawAllEnemies(graphics);
        Enemycreation.drawThiefEnemy(graphics);
        obstacleCreation.obstacle_drawing(graphics);
        PlayerCreation.player_drawing(graphics,Player.getPlayer());
        PlayerCreation.Bullet_player_drawing(graphics,BulletPlayer.getBullet_player_list());
        createResults.lableDrawing(graphics, resultBoard.getLabelCoordinates());
        createResults.ResultBoardDrawing(graphics);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (resultBoard.getDisplay_name_menu()){
            char c = e.getKeyChar();
            if (Character.isLetterOrDigit(c) || c == ' '){
                resultBoard.appendTypedNameChar(c);
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (resultBoard.getDisplay_name_menu()){
            if (keycode == KeyEvent.VK_BACK_SPACE){
                resultBoard.removeLastTypedNameChar();
            } else if (keycode == KeyEvent.VK_ENTER){
                String name = resultBoard.getTypedName().trim();
                if (!name.isEmpty()){
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
