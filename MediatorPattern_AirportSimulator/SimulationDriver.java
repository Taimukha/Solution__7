import java.util.*;
import java.util.concurrent.*;
import java.util.ServiceLoader;

public class SimulationDriver {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower(new FuelPriorityScheduler());
        List<Aircraft> aircrafts = new ArrayList<>();
        Random rand = new Random();

        System.out.println("WELCOME TO GRAND AIRPORT CONTROL SIMULATION!");
        System.out.println("============================================");

        for (int i = 0; i < 8; i++) {
            int fuel = rand.nextInt(20) + 1;
            int type = rand.nextInt(3);
            Aircraft a;
            switch (type) {
                case 0: a = new PassengerPlane("Passenger-" + i, fuel, tower); break;
                case 1: a = new CargoPlane("Cargo-" + i, fuel, tower); break;
                default: a = new Helicopter("Heli-" + i, fuel, tower); break;
            }
            aircrafts.add(a);
        }


        ServiceLoader<AircraftPlugin> plugins = ServiceLoader.load(AircraftPlugin.class);
        int count = 0;
        for (AircraftPlugin plugin : plugins) {
            Aircraft military = plugin.create("Military-" + count++, rand.nextInt(20) + 1, tower);
            aircrafts.add(military);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            for (Aircraft a : aircrafts) {
                a.requestAction();
                tower.freeRunway();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}