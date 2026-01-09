import java.util.*;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Fleet Management System ---");
            System.out.println("1. Print all vehicles" + "\n"+
                    "2. Add new car" + "\n" +
                    "3. Add new bus" + "\n" +
                    "4. Show total yearly insurance fees" +"\n"
                    + "5. Show vehicles older than N years" + "\n" +
                    "6. Perform service for all vehicles" + "\n" +
                    "7. Quit");
            System.out.println("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //again fixing the bug with Java

            switch (choice) {
                case 1:
                    printVehicles();
                    break;
                case 2:
                    addVehicle("Car");
                    break;
                case 3:
                    addVehicle("Bus");
                    break;
                case 4:
                    showTotalInsurance();
                    break;
                case 5:
                    showOlderThanN();
                    break;
                case 6:
                    performFleetService();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("no choise like this");
                    System.out.println("Choose: ");
                    break;
            }
        }
    }

    private void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            for(Vehicle x : vehicles){
                System.out.println(x);
            }
        }
    }

    private void addVehicle(String type) {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter base price: ");
        double price = scanner.nextDouble();

        if (type.equals("Car")) {
            System.out.print("Enter number of doors: ");
            int doors = scanner.nextInt();
            vehicles.add(new Car(model, year, price, doors));
        } else {
            System.out.print("Enter passenger capacity: ");
            int capacity = scanner.nextInt();
            vehicles.add(new Bus(model, year, price, capacity));
        }
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total Yearly Insurance Fees: " + total);
    }

    private void showOlderThanN() {
        System.out.print("Enter current year: ");
        int current = scanner.nextInt();
        System.out.print("Enter N (years): ");
        int n = scanner.nextInt();

        System.out.println("--- Vehicles older than " + n + " years ---");
        boolean found = false;

        for (Vehicle x : vehicles) {
            if (x.getAge(current) > n) {
                System.out.println(x);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles match the criteria.");
        }
    }

    private void performFleetService() {
        if (vehicles.isEmpty()) {
            System.out.println("Fleet is empty lol");
            return;
        }
        for (Vehicle x : vehicles) {
            x.performService();
        }

    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}