public class Bus extends Vehicle implements Serviceable {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        //10% of base price
        return (basePrice * 0.10);
    }

    @Override
    public void performService() {
        System.out.println("Bus service (ID: " + id + "): Engine cheknut, zaremontil " +
                passengerCapacity + " seats.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Bus | Capacity: " + passengerCapacity;
    }
}