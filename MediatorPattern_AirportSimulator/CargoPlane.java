public class CargoPlane extends Aircraft {
    public CargoPlane(String id, int fuelLevel, TowerMediator mediator) {
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("CargoPlane " + id + " received: " + msg);
    }

    @Override
    public void requestAction() {
        if (fuelLevel < 5) send("MAYDAY");
        else if (mediator.requestRunway(this)) System.out.println("CargoPlane " + id + " is using the runway.");
        else System.out.println("CargoPlane " + id + " is waiting.");
    }
}