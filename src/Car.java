public class Car extends Vehicle implements Serviceable {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        // 5% of base price
        return (basePrice * 0.5);
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