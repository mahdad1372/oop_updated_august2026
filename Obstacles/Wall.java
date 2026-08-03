package Obstacles;

public class Wall extends Obstacle{
    public Wall(int coordinates_x , int coordinates_y,int width, int height){
        super(coordinates_x,coordinates_y,width,height);
    }
    public static final int[][] wall_coordinates ={
            {130,0,20,140},
            {130,200,20,140},
            {150,40,120,20},
            {270,40,20,120},
            {270,100,180,20},
            {270,240,20,130},
            {270,345,180,20},
            {430,120,20,120},
            {530,190,20,170},
            {530,0,20,120},
            {550,300,100,20},
            {630,80,20,220},
            {630,20,300,20},
            {710,20,20,160},
            {710,270,20,100},
            {710,180,230,20}
    };
    @Override
    public int getWidth(){
        return super.getWidth();
    }
    @Override
    public int getHeight(){
        return super.getHeight();
    }
    @Override
    public int getCoordinates_x(){
        return super.getCoordinates_x();
    }
    @Override
    public int getCoordinates_y(){
        return super.getCoordinates_y();
    }

}
