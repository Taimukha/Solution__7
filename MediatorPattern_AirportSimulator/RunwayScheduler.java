import java.util.Queue;

public interface RunwayScheduler {
    Aircraft selectNextAircraft(Queue<Aircraft> landingQueue, Queue<Aircraft> takeoffQueue);
}