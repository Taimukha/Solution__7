import java.util.*;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayFree = true;
    private RunwayScheduler scheduler;

    public ControlTower(RunwayScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("Tower received from " + sender.getId() + ": " + msg);
        if (msg.equalsIgnoreCase("MAYDAY")) {
            System.out.println("EMERGENCY! " + sender.getId() + " needs immediate landing.");
            landingQueue.remove(sender);
            LinkedList<Aircraft> temp = new LinkedList<>(landingQueue);
            temp.addFirst(sender);
            landingQueue = temp;
            notifyAllAircrafts("HOLD POSITION - Emergency in progress!");
            runwayFree = true;
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a.isEmergency()) {
            landingQueue.add(a);
        } else if (new Random().nextBoolean()) {
            takeoffQueue.add(a);
        } else {
            landingQueue.add(a);
        }

        if (runwayFree) {
            runwayFree = false;
            Aircraft next = scheduler.selectNextAircraft(landingQueue, takeoffQueue);
            if (next != null && next.equals(a)) {
                System.out.println("Tower: " + next.getId() + " cleared to use runway.");
                return true;
            }
        }
        return false;
    }

    public void notifyAllAircrafts(String message) {
        System.out.println("=== CONTROL TOWER BROADCAST ===");
        System.out.println("Message to all aircrafts: " + message);
    }

    public void freeRunway() {
        runwayFree = true;
    }
}