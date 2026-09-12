package utils;


import Interfaces.hitBox;

import java.awt.*;

public final class collisionUtils {
    public static boolean Intersect(hitBox firstbox, hitBox secondbox) {
        Rectangle rectA = new Rectangle(firstbox.getCoordinatesX(), firstbox.getCoordinatesY(), firstbox.getWidth(), firstbox.getHeight());
        Rectangle rectB = new Rectangle(secondbox.getCoordinatesX(), secondbox.getCoordinatesY(), secondbox.getWidth(), secondbox.getHeight());
        return rectA.intersects(rectB);
    }
}
