import java.util.*;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Fleet Management System ---");
            System.out.println("1. Print all vehicles\n2. Add new car\n3. Add new bus");
            System.out.println("4. Show total yearly insurance fees\n5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles\n7. Quit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printVehicles();
                case 2 -> addVehicle("Car");
                case 3 -> addVehicle("Bus");
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThanN();
                case 6 -> performFleetService();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            vehicles.forEach(System.out::println);
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
        } else {
            System.out.print("Enter passenger capacity: ");
            int capacity = scanner.nextInt();
        }
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.printf("Total Yearly Insurance Fees: $%.2f%n", total);
    }

    private void showOlderThanN() {
        System.out.print("Enter current year: ");
        int current = scanner.nextInt();
        System.out.print("Enter N (years): ");
        int n = scanner.nextInt();

        vehicles.stream()
                .filter(v -> v.getAge(current) > n)
                .forEach(System.out::println);
    }

    private void performFleetService() {
        for (Vehicle v : vehicles) {
            if (v instanceof Serviceable) {
                ((Serviceable) v).performService();
            }
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}