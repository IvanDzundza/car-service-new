public class Car extends Base implements Comparable<Car> {
    private String type;
    private boolean insureance;


    public Car() {

    }

    public Car(int id, String model, int year, int price, String registrationNumber, String type) {
        super(id, model, year, price, registrationNumber);
        this.type = type;
        this.insureance = insureance;
    }

    public boolean isInsureance() {return insureance;}

    public void setInsureance (boolean insureance) {this.insureance = insureance;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "insureance='" + insureance + '\'' +
                "type='" + type + '\'' +
                ", id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    @Override
    public int do1() {
        return 0;
    }

    @Override
    public int compareTo(Car car) {
        return this.model.compareTo(car.model);
    }

    public static String carModels[] = {
            "Passat", "Jetta", "Golf", "A4", "A3", "Octavia", "Fabia"
    };
}
