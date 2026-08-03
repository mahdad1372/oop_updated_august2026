package Bullet;

import javax.swing.*;
import java.awt.*;

public class Missile extends Rocket_Bullet{
    public Missile(int coordinate_x, int coordinates_y , Image missile_img, int final_position_x, int final_position_y){
        super(coordinate_x,coordinates_y,missile_img,final_position_x,final_position_y);
    }

    private final static Image missile_img  = new ImageIcon ("Assets/missile.png").getImage();
    private static final Object[][] missile_coordinates = {
            {160,310,missile_img , 270,200}
    };
    public static Image getmissile_img(){
        return missile_img;
    }
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
