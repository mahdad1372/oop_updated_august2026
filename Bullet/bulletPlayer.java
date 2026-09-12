package Bullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class bulletPlayer extends bullet {
    public bulletPlayer(Image bulletImg , int x , int y,int width , int height){
        super(bulletImg,x,y,width,height);
    }
    private final static  ArrayList<bulletPlayer> bulletPlayerList = new ArrayList<>();
    private static String playerDirection;

    public static ArrayList<bulletPlayer> getBulletPlayerList(){
        return bulletPlayerList;
    }
    private final static Image playerBullet  = new ImageIcon("Assets/bulletplayer_right.png").getImage();
    private final static Image playerBulletLeft  = new ImageIcon("Assets/bulletplayer_left.png").getImage();
    private final static Image playerBulletUp  = new ImageIcon("Assets/bulletplayer_up.png").getImage();
    private final static Image playerBulletDown  = new ImageIcon("Assets/bulletplayer_down.png").getImage();
    public static void setDirection(String direction){
        playerDirection = direction;
    }
    public static String getDirection(){
        return playerDirection;
    }
    private final static int[][] bulletPlayerDimension ={
            {30,30}
    };

    public static int[][] getBulletPlayerDimension() {
        return bulletPlayerDimension;
    }

    public static Image getPlayerBullet() {
        if (playerDirection.equals("right")){
            return playerBullet;
        }else if (playerDirection.equals("left")){
            return playerBulletLeft;
        }else if (playerDirection.equals("up")){
            return playerBulletUp;
        }else {
            return playerBulletDown;
        }
    }
    public static void removeBullet(bulletPlayer bulletPlayer){
        bulletPlayerList.remove(bulletPlayer);
    }

    @Override
    public void shootingDirection(String direction){
        int speed = 20;
        if (direction.equals("left")){
            setCoordinatesX(getCoordinatesX() - speed);
        }else if (direction.equals("right")){
            setCoordinatesX(getCoordinatesX() + speed);
        }else if (direction.equals("up")){
            setCoordinatesY(getCoordinatesY() - speed);
        }else if (direction.equals("down")){
            setCoordinatesY(getCoordinatesY() + speed);
        }
    }

}
