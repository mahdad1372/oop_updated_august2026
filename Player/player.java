package Player;
import Interfaces.hitBox;

import javax.swing.*;
import java.awt.*;

public final class player implements hitBox {
    public player(int coordinatesX, int coordinatesY,int width,int height){
        this.coordinatesX= coordinatesX;
        this.coordinatesY= coordinatesY;
        this.width = width;
        this.height = height;
    }

    private int coordinatesX;
    private int coordinatesY;
    private final int width;
    private final int height;
    private static player player;
    private static final Image playerLeft = new ImageIcon("Assets/soldier_l.png").getImage();
    private static final Image playerDown = new ImageIcon("Assets/soldier_d.png").getImage();
    private static final Image playerUp = new ImageIcon("Assets/soldier_u.png").getImage();
    private static final Image playerRight = new ImageIcon("Assets/soldier.png").getImage();
    private static Image playerImg =  new ImageIcon("Assets/soldier.png").getImage();;
    private final static Object[][] coordinatesPlayer ={
            {0,0,30,30}
    };

    public static Object[][] getCoordinatesPlayer(){
        return coordinatesPlayer;
    }
    @Override
    public int getWidth(){
        return width;
    }
    @Override
    public int getHeight(){
        return height;
    }
    public static void setPlayer(player player) {
        Player.player.player = player;
    }
    public static player getPlayer(){
        return player;
    }

    public static Image getPlayerImg() {
        return playerImg;
    }
    public static void setPlayerImgRight(){
        playerImg = playerRight;
    }
    public static void setPlayerImgLeft(){
        playerImg = playerLeft;
    }
    public static void setPlayerImgUp(){
        playerImg = playerUp;
    }
    public static void setPlayerImgDown(){
        playerImg = playerDown;
    }


    public  void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinates_x) {
        this.coordinatesX = coordinates_x;
    }
    public void playerMoveRight(){
        coordinatesX+=5;
    }
    public void playerMoveLeft(){
        coordinatesX-=5;
    }
    public void playerMoveUp(){
        coordinatesY-=5;
    }
    public void playerMoveDown(){
        coordinatesY+=5;
    }
}
