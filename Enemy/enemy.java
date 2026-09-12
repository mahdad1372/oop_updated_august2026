package Enemy;

import Interfaces.hitBox;
import Interfaces.enemyDetails;
import java.awt.*;

public abstract class enemy implements enemyDetails, hitBox {
    public enemy(Image enemy_image , int coordinates_x, int coordinates_y, int width , int height){
        this.coordinatesX= coordinates_x;
        this.coordinatesY = coordinates_y;
        this.enemyImage = enemy_image;
        this.width = width;
        this.height = height;
    }
    private int coordinatesX;
    private int coordinatesY;
    private final Image enemyImage;
    private final int width;
    private final int height;

    public int getCoordinatesX(){
        return coordinatesX;
    }
    public int getCoordinatesY(){

        return coordinatesY;
    }
    public Image getEnemyImage(){

        return enemyImage;
    }
    public int getWidth(){

        return width;
    }
    public int getHeight(){

        return height;
    }


    public void setCoordinatesX(int coordinatesX){
        this.coordinatesX = coordinatesX;
    }
    public void setCoordinatesY(int coordinates_y){
        this.coordinatesY = coordinates_y;
    }

}
