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

public class MyPanel extends JPanel {
    public MyPanel(){
        panelDetails.details(this);
        creation();
        resultBoard.setupDifficultyButtons(this);
    }
    public static void creation(){
        resultBoard.setResult_boards(createResults.creating_result_board(resultBoard.getResultBoardCoordinates()));
        Player.setPlayer(PlayerCreation.create_player());
        if (!resultBoard.getDifficulty().isEmpty()){
            try {
                Enemycreation.create_TankEnemy();
                Enemycreation.create_thief();
                Enemycreation.createMissileLauncher();
                Enemycreation.createSniperEnemy();
                Enemycreation.createSoldierEnemy();
                obstacleCreation.create_obstacle(Wall.getWallCoordinates(),"Wall");
                obstacleCreation.create_obstacle(Laser.getLaser_coordinates(),"Laser");
                obstacleCreation.create_obstacle(Mine.getMineCoordinates(),"Mine");
            } catch (InvalidGameDataException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Enemycreation.drawAllEnemies(graphics);
        Enemycreation.drawThiefEnemy(graphics);
        obstacleCreation.obstacle_drawing(graphics);
        PlayerCreation.draw(graphics,Player.getPlayer());
        PlayerCreation.draw(graphics,BulletPlayer.getBullet_player_list());
        createResults.lableDrawing(graphics, resultBoard.getLabelCoordinates());
        createResults.ResultBoardDrawing(graphics);
    }
}
