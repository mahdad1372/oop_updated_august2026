package Bullet;

import javax.swing.*;
import java.awt.*;

public class Tank_rocket extends Rocket_Bullet{
    public Tank_rocket(int coordinate_x , int coordinate_y, Image tank_rocket, int final_position_x, int final_position_y){
        super(coordinate_x,coordinate_y,tank_rocket,final_position_x,final_position_y);
    }

    private static final Image Tank_rocket = new ImageIcon("Assets/tank_rocket.png").getImage();
    private static final Object[][] Tanks_rocket_coordinates = {
            {580,230,Tank_rocket , 580,50}
    };
    public static Object[][] getTanks_rocket_coordinates(){
        return Tanks_rocket_coordinates;
    }
}
