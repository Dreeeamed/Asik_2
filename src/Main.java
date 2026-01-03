public class Main {
    public static void main(String[] args) {
        // Testing Car
        Car myCar = new Car("Toyota Camry", 2022, 25000, 4);
        System.out.println(myCar.toString());
        System.out.println("Car Age (in 2025): " + myCar.getAge(2025) + " years");
        System.out.println("Car Insurance: $" + myCar.calculateInsuranceFee());

        System.out.println("-----------------------------");

        // Testing Bus
        Bus myBus = new Bus("Mercedes Sprinter", 2018, 50000, 20);
        System.out.println(myBus.toString());
        System.out.println("Bus Age (in 2025): " + myBus.getAge(2025) + " years");
        System.out.println("Bus Insurance: $" + myBus.calculateInsuranceFee());

        System.out.println("-----------------------------");

        Car invalidCar = new Car("", 1800, -500, 4);
    }
}