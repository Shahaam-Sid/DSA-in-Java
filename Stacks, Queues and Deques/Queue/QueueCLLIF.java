public interface QueueCLLIF<E> extends Queue<E> {
    /**
     * Rotates the front element of Queue to the back
     * Does nothing if empty
     */
    void rotate();
}