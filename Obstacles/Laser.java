package Obstacles;

import Interfaces.obstacle_measurement;

public class Laser extends Obstacle implements obstacle_measurement {
    public Laser(int coordinates_x, int coordinates_y, int width,int height){
        super(coordinates_x,coordinates_y,width,height);
    }
    private static final int[][] laser = {
            {725,250,200,10},
            {430,290,10,50},
    };
    public static int[][] getLaser_coordinates(){
        return laser;
    }
    @Override
    public int damage(){
        return   5;
    }
}
