public abstract class Vehicle {
    //FIELDS
    protected int id;
    private static int idGen = 1;
    private String model;
    private int year;
    protected double basePrice;
    private int currentYear = 2025;


    public Vehicle(String model, int year, double basePrice){
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    //SETTERS
    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }

    public void setYear(int year) {
        if (year > 2025 || year <= 1700) {
            throw new IllegalArgumentException("Invalid year provided: " + year);
        }
        this.year = year;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException();
        }
        this.basePrice = basePrice;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
       return model;
    }

    public double getBasePrice() {
        return basePrice;
    }

    //METHODS
    public int getAge(int currentYear){
        return currentYear-year;
    }

    // Things in General
    public abstract double calculateInsuranceFee();

    @Override
    public String toString(){
        return "Car ID: " + id + "\n" +
                "Model: " + model + "\n" +
                "Year: " + year + "\n" +
                "Base Price: " + basePrice;
    }
}