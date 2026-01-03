public class Car extends Vehicle implements Serviceable {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice); // Calls the Vehicle constructor
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        // Example logic: 5% of base price + $50 per door
        return (basePrice * 0.05) + (numberOfDoors * 50);
    }

    @Override
    public void performService() {
        System.out.println("Servicing Car (ID: " + id + "): Checking tires, oil change, and door locks.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Car | Doors: " + numberOfDoors;
    }
}