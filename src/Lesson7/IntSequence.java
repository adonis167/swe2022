package Lesson7;

public interface IntSequence {
    int next();
    default boolean hasNext() {
        return true;
    }
}
