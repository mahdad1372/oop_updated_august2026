package Bullet;

import javax.swing.*;
import java.awt.*;

public class rocketBullet extends bullet {
    public rocketBullet(Image Rocket_bullet_img, int coordinates_x, int coordinates_y,
                        int width,int height,int final_coordinates_x, int final_coordinates_y ){
        super(Rocket_bullet_img,coordinates_x,coordinates_y,width,height);
        this.finalCoordinatesX= final_coordinates_x;
        this.finalCoordinatesY= final_coordinates_y;
        this.rocketBulletImg = Rocket_bullet_img;
    }
    private final int finalCoordinatesX;
    private final int finalCoordinatesY;
    private final Image rocketBulletImg;
    public Image getRocketBulletImg(){
        return rocketBulletImg;
    }
    public int getFinalCoordinatesX(){
        return finalCoordinatesX;
    }
    public int getFinalCoordinatesY(){
        return finalCoordinatesY;
    }
    private static final Image rocket = new ImageIcon("Assets/rocket.png").getImage();
    private static final Object[][] rocketCoordinatesList = {
            {rocket,400,130,30,30,400,400}
    };

    public static Object[][] getRocketCoordinatesList() {
        return rocketCoordinatesList;
    }

    @Override
    public void shootingDirection(String direction) {
        if (direction.equals("up")){
            setCoordinatesX(getCoordinatesX() != getFinalCoordinatesX()  ? getCoordinatesX() + 5 : getCoordinatesX());
            setCoordinatesY(getCoordinatesY() != getFinalCoordinatesY() ? getCoordinatesY() - 5 : getCoordinatesY());
        } else if(direction.equals("down")){
            setCoordinatesY(getCoordinatesY() != getFinalCoordinatesY() ? getCoordinatesY() + 5 : getCoordinatesY());
        }
    }
}
