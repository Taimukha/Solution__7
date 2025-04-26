import java.util.Queue;

public class FuelPriorityScheduler implements RunwayScheduler {
    @Override
    public Aircraft selectNextAircraft(Queue<Aircraft> landingQueue, Queue<Aircraft> takeoffQueue) {
        Aircraft minFuelAircraft = null;
        int minFuel = Integer.MAX_VALUE;
        for (Aircraft a : landingQueue) {
            if (a.fuelLevel < minFuel) {
                minFuel = a.fuelLevel;
                minFuelAircraft = a;
            }
        }
        if (minFuelAircraft != null) {
            landingQueue.remove(minFuelAircraft);
            return minFuelAircraft;
        }
        return !takeoffQueue.isEmpty() ? takeoffQueue.poll() : null;
    }
}