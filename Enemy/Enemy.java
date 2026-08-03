package Enemy;

import Interfaces.Enemy_hit;
import Interfaces.enemy_details;

import java.awt.*;

public abstract class Enemy implements enemy_details, Enemy_hit {
    public Enemy(Image enemy_image ,int coordinates_x,int coordinates_y, int width , int height){
        this.coordinates_x= coordinates_x;
        this.coordinates_y = coordinates_y;
        this.enemyimage = enemy_image;
        this.width = width;
        this.height = height;
    }
    private int coordinates_x;
    private int coordinates_y;
    private final Image enemyimage;
    private final int width;
    private final int height;

    public int getCoordinates_x(){
        return coordinates_x;
    }
    public int getCoordinates_y(){
        return coordinates_y;
    }

    public void setCoordinates_x(int coordinates_x){
        this.coordinates_x = coordinates_x;
    }

    public void setCoordinates_y(int coordinates_y){
        this.coordinates_y = coordinates_y;
    }
    public Image getEnemyimage(){
        return enemyimage;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}
