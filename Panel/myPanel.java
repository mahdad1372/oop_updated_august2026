package Panel;

import Bullet.bulletPlayer;
import Enemy.*;
import Exceptions.InvalidGameDataException;
import Obstacles.laser;
import Obstacles.mine;
import Obstacles.obstacleCreation;
import Obstacles.wall;
import Player.player;
import Player.playerCreation;
import Results.createResults;
import Results.resultBoard;
import javax.swing.*;
import java.awt.*;

public class myPanel extends JPanel {
    public myPanel(){
        panelDetails.details(this);
        creation();
        resultBoard.setupDifficultyButtons(this);
    }
    public static void creation(){
        createResults.creatingResultBoard();
        playerCreation.createPlayer();
        if (!resultBoard.getDifficulty().isEmpty()){
            try {
                enemyCreation.createTankEnemy();
                enemyCreation.createThief();
                enemyCreation.createMissileLauncher();
                enemyCreation.createSniperEnemy();
                enemyCreation.createSoldierEnemy();
                enemyCreation.createArmyEnemy();
                obstacleCreation.createObstacle();
            } catch (InvalidGameDataException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        enemyCreation.drawAllEnemies(graphics);
        enemyCreation.drawThiefEnemy(graphics);
        obstacleCreation.obstacleDrawing(graphics);
        playerCreation.draw(graphics, player.getPlayer());
        playerCreation.draw(graphics, bulletPlayer.getBulletPlayerList());
        createResults.lableDrawing(graphics, resultBoard.getLabelCoordinates());
        createResults.resultBoardDrawing(graphics);
    }
}
