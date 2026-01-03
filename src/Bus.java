public class Bus extends Vehicle implements Serviceable {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        // Example logic: 10% of base price + $10 per passenger seat
        return (basePrice * 0.10) + (passengerCapacity * 10);
    }

    @Override
    public void performService() {
        System.out.println("Servicing Bus (ID: " + id + "): Engine overhaul, safety inspection for " +
                passengerCapacity + " seats.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Bus | Capacity: " + passengerCapacity;
    }
}