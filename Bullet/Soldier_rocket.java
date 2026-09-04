package Bullet;

import javax.swing.*;
import java.awt.*;

public class Soldier_rocket extends Rocket_Bullet{
    public Soldier_rocket(Image soldier_rocket,int coordinates_x, int coordinates_y, int final_coordinates_x,int final_coordinates_y){
        super(soldier_rocket,coordinates_x,coordinates_y,final_coordinates_x,final_coordinates_y);
    }
    private final static Image soldier_rocket = new ImageIcon("Assets/Soldier_rocket.png").getImage();
    private final static Object[][] soldierRocketCoordinates = {
        {soldier_rocket,660,320,660,50}
    };
    public static Object[][] getSoldierRocketCoordinates(){
        return soldierRocketCoordinates;
    }
}
