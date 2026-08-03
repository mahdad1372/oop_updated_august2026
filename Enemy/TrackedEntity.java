package Enemy;

import java.util.ArrayList;

public class TrackedEntity<T> {
    private final T content;
    private static final ArrayList<TrackedEntity<?>> allEntity = new ArrayList<>();

    public TrackedEntity(T content) {
        this.content = content;
        allEntity.add(this);
    }

    public T getContent() {
        return content;
    }

    public static ArrayList<TrackedEntity<?>> getAllEntity() {
        return allEntity;
    }
    public static void removeEntity(TrackedEntity<?> enemy){
        allEntity.remove(enemy);
    }
}