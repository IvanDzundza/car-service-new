import java.io.FileReader;
import java.nio.file.Files;
import java.util.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    static Scanner sca = new Scanner(System.in);
    static Scanner sca1 = new Scanner(System.in);
    static int scan = 1;
    static int i = 1;
    public Car[] cars;
    private Bus[] buses;


    public static void main(String[] args) {

        Base base = new Car();

        Main main = new Main();

        CarList cars = new CarList();

        main.initArray(10);

        int menuItem;
        try {
            while (scan != 8) {
                Scanner in = new Scanner(System.in);
                System.out.println("MENU Auto.Ria.ua App ");
                System.out.println("Write number: " +
                        "\n 1. Show list car" +
                        "\n 2. Show list bus" +
                        "\n 3. Search (by model: Passat)" +
                        "\n 4. Search (by model and year)" +
                        "\n 5. Search (by price and year)" +
                        "\n 6. Filter Cars With Insureance" +
                        "\n 7. Count cars by model" +
                        "\n 8. Help");
                System.out.println("0. Quit");

                menuItem = in.nextInt();

                switch (menuItem) {
                    case 1:
                        for (int i = 0; i < main.cars.length; i++) {
                            System.out.println(main.cars[i]);
                        }
                        break;
                    case 2:
                        for (Bus bus : main.buses) {
                            System.out.println(bus);
                        }
                        break;
                    case 3:
                        main.printByModel("Passat");
                    case 4:
                        main.printByModelAndNYears();
                        break;
                    case 5:
                        main.printByYearAndNPrice();
                        break;
                    case 6:
                        cars.filterCarsWithInsureanceByStream();
                        break;
                    case 7:
                        cars.countCarsWithModelByStream("Passat");
                        break;
                    case 8:
                        System.out.println("Else you need help call us 08003002001");
                        break;
                    case 0:
                        System.out.println("Good bye!");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Please enter a number from 1 to 8");
        }


        Arrays.sort(main.cars);
        Arrays.sort(main.buses);


        Arrays.sort(main.cars, new TransportPriceComparator().thenComparing(new TransportModelComparator()));
        Arrays.sort(main.buses, new TransportModelComparator().thenComparing(new Comparator<Base>() {
            @Override
            public int compare(Base o1, Base o2) {
                return o1.getYear() - o2.getYear();
            }
        }));

        for (int i = 0; i < main.cars.length; i++) {
            System.out.println(main.cars[i]);
        }

        for (Bus bus : main.buses) {
            System.out.println(bus);
        }


        main.printByModel("Passat");
        main.printByModelAndNYears();
        main.printByYearAndNPrice();

    }

    public void initArray(int arraySize) {

        cars = new Car[arraySize];
        buses = new Bus[arraySize];

        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(i, Car.carModels[random.nextInt(Car.carModels.length)], random.nextInt(2010, 2020), Base.transportPrice[random.nextInt(Base.transportPrice.length)], "AT8282AH", "Седан");
            buses[i] = new Bus(i, "Sprinter", random.nextInt(2000, 2020), random.nextInt(25000, 140000), "AT8290AH", random.nextInt(10, 30), random.nextBoolean());
        }

    }

    public void printByModel(String model) {
        for (int i = 0; i < cars.length; i++) {
            if (((Base) cars[i]).getModel().equalsIgnoreCase(model)) {
                System.out.println(cars[i]);
            }


        }

    }

    public void printByModelAndNYears(int start, String modelZadana) {
        int year;

        for (int i = 0; i < cars.length; i++) {
            year = cars[i].getYear();
            if ((((Car) cars[i]).getModel().equalsIgnoreCase(modelZadana)) && (year > start)) {
                System.out.println(cars[i]);
            }
        }
    }

    public void printByModelAndNYears() {
        int start;
        String modelZadana;

        System.out.println("Введіть модель:");
        Scanner scanner = new Scanner(System.in);
        modelZadana = scanner.nextLine();
        System.out.println("Автомобілі експлуатується від вказаного року:");
        start = scanner.nextInt();

        printByModelAndNYears(start, modelZadana);
    }

    public void printByYearAndNPrice(int priceZadano, int yearZadano) {
        int year;
        int price;

        for (int i = 0; i < cars.length; i++) {
            year = cars[i].getYear();
            price = cars[i].getPrice();
            if ((price > priceZadano) && (year == yearZadano)) {
                System.out.println(cars[i]);
            }
        }
    }

    public void printByYearAndNPrice() {
        int priceZadano;
        int yearZadano;

        System.out.println("Введіть ціну:");
        Scanner scanner = new Scanner(System.in);
        priceZadano = scanner.nextInt();
        System.out.println("Введіть рік:");
        yearZadano = scanner.nextInt();

        printByYearAndNPrice(priceZadano, yearZadano);
    }


}

