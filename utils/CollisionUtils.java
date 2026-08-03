package utils;


import Interfaces.Enemy_hit;

import java.awt.*;

public final class CollisionUtils {
    public static boolean Intersect(Enemy_hit first, Enemy_hit second) {
        Rectangle rectA = new Rectangle(first.getCoordinates_x(), first.getCoordinates_y(), first.getWidth(), first.getHeight());
        Rectangle rectB = new Rectangle(second.getCoordinates_x(), second.getCoordinates_y(), second.getWidth(), second.getHeight());
        return rectA.intersects(rectB);
    }

}
