public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;
    protected TowerMediator mediator;

    public Aircraft(String id, int fuelLevel, TowerMediator mediator) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.mediator = mediator;
    }

    public void send(String msg) {
        System.out.println(id + " sending: " + msg);
        mediator.broadcast(msg, this);
    }

    public abstract void receive(String msg);
    public abstract void requestAction();
    public boolean isEmergency() {
        return fuelLevel < 10;
    }

    public String getId() {
        return id;
    }
}