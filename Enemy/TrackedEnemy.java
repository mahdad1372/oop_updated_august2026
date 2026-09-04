package Enemy;

import java.util.ArrayList;

public class TrackedEnemy<E> {
    private final E enemy;
    private static final ArrayList<TrackedEnemy<?>> allEnemies = new ArrayList<>();

    public TrackedEnemy(E enemy) {
        this.enemy = enemy;
        allEnemies.add(this);
    }

    public E getEnemy() {
        return enemy;
    }

    public static ArrayList<TrackedEnemy<?>> getAllEnemies() {
        return allEnemies;
    }
    public static void removeEnemy(TrackedEnemy<?> enemy){
        allEnemies.remove(enemy);
    }
}