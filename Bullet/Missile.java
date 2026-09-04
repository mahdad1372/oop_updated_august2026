package Bullet;

import javax.swing.*;
import java.awt.*;

public class Missile extends Rocket_Bullet{
    public Missile(Image missile_img,int coordinate_x, int coordinates_y ,  int final_position_x, int final_position_y){
        super(missile_img,coordinate_x,coordinates_y,final_position_x,final_position_y);
    }

    private final static Image missile_img  = new ImageIcon ("Assets/missile.png").getImage();
    private static final Object[][] missile_coordinates = {
            {missile_img,160,310,270,200}
    };
    public static Object[][] getMissile_coordinates(){
        return missile_coordinates;
    }
    @Override
    public void shootingDirection(String direction){
        if (direction == "up"){
           if (getPosition_coordinates_x() != getFinal_coordinates_x()){
               setPosition_coordinates_x(getPosition_coordinates_x()+5);
           }
           if (getPosition_coordinates_y() != getFinal_coordinates_y()){
               setPosition_coordinates_y(getPosition_coordinates_y()-5);
           }
        }
    }
}
