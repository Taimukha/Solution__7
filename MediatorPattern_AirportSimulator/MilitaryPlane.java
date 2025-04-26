public class MilitaryPlane extends Aircraft implements AircraftPlugin {
    public MilitaryPlane() {
        super(null, 0, null);
    }

    @Override
    public Aircraft create(String id, int fuelLevel, TowerMediator mediator) {
        return new MilitaryPlane(id, fuelLevel, mediator);
    }

    public MilitaryPlane(String id, int fuelLevel, TowerMediator mediator) {
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("MilitaryPlane " + id + " received: " + msg);
    }

    @Override
    public void requestAction() {
        if (fuelLevel < 5) send("MAYDAY");
        else if (mediator.requestRunway(this)) System.out.println("MilitaryPlane " + id + " is using the runway.");
        else System.out.println("MilitaryPlane " + id + " is waiting.");
    }
}