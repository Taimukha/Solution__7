import java.util.Queue;

public class DefaultScheduler implements RunwayScheduler {
    @Override
    public Aircraft selectNextAircraft(Queue<Aircraft> landingQueue, Queue<Aircraft> takeoffQueue) {
        if (!landingQueue.isEmpty()) return landingQueue.poll();
        if (!takeoffQueue.isEmpty()) return takeoffQueue.poll();
        return null;
    }
}