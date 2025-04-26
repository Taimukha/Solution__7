public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuelLevel, TowerMediator mediator) {
        super(id, fuelLevel, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("PassengerPlane " + id + " received: " + msg);
    }

    @Override
    public void requestAction() {
        if (fuelLevel < 5) send("MAYDAY");
        else if (mediator.requestRunway(this)) System.out.println("PassengerPlane " + id + " is using the runway.");
        else System.out.println("PassengerPlane " + id + " is waiting.");
    }
}