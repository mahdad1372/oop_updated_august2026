package Enemy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class thief extends Enemy{
    public thief(Image enemy_img,int coordinates_x, int coordinates_y ,int width, int height,String direction, int final_position){
        super(enemy_img,coordinates_x,coordinates_y,width,height);
        this.direction= direction;
        this.final_position= final_position;
        if(direction == "Y"){
            this.current_position = coordinates_y;
        }else {
            this.current_position = coordinates_x;
        }
    }

    private int current_position;
    private String direction;
    private int final_position;
    private boolean increase_coordinates_y = true;
    private boolean increase_coordinates_x = true;
    public final static Image thief_img = new ImageIcon("Assets/thief.png").getImage();
    private final static Object[][] thief_coordinates = {
        {thief_img,200,70,30,30,"Y",320},
        {thief_img,390,165,30,30,"X",120},
        {thief_img,350,310,30,30,"Y",120},
        {thief_img,595,140,30,30,"X",450},
        {thief_img,580,10,30,30,"Y",180},
        {thief_img,665,50,30,30,"Y",210}
    };

    public void thief_movement(){
        if (direction == "Y"){
            int position = getCoordinates_y();
            int target = increase_coordinates_y ? final_position : current_position;
            if (position == target){
                increase_coordinates_y = !increase_coordinates_y;
                target = increase_coordinates_y ? final_position : current_position;
            }
            setCoordinates_y(position +(position < target ? 1: -1));
        }   else if (direction == "X"){
            int position = getCoordinates_x();
            int target = increase_coordinates_x ? final_position : current_position;
            if (position == target){
                increase_coordinates_x = !increase_coordinates_x;
                target = increase_coordinates_x ? final_position : current_position;
            }
            setCoordinates_x(position + (position < target ? 1:-1));
        }

    }
    public static Object[][] getThief_list(){
        return  thief_coordinates;
    }
    @Override
    public int killing_enemy_score(){
        return 10;
    }
}
