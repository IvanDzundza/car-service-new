import java.util.*;
import java.util.stream.Collectors;

public class CarList {
    private List<Car> cars = new LinkedList<Car>();

    public List<String> getCarModelsUnique() {
        List<String> carModelsUnique = new LinkedList<>();
        for (Car car : cars) {
            if (!carModelsUnique.contains(Car.carModels)) {
                carModelsUnique.add(Arrays.toString(Car.carModels));
            }
        }
        return carModelsUnique;
    }

    public List<String> getCarModelsUniqueByStream() {
        return cars.stream()
                .map(car -> car.getModel())
                .distinct()
                .collect(Collectors.toList());
    }

    public long countCarsWithModelByStream(String models) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(models))
                .count();
    }

    public Map<String, Integer> getMapModels() {
        Map<String, Integer> mapModels = new HashMap<>();
        for (Car car : cars) {
            if (mapModels.containsKey(car.getModel())) {
                mapModels.replace(car.getModel(), mapModels.get(car.getModel()) + 1);
            } else {
                mapModels.put(car.getModel(), 1);
            }
        }
        return mapModels;
    }

    public Map<String, List<Car>> getMapModelsCar() {
        Map<String, List<Car>> mapMapModelsListCar = new HashMap<>();
        for (Car car : cars) {
            if (mapMapModelsListCar.containsKey(car.getModel())) {
                mapMapModelsListCar.get(car.getModel()).add(car);
            } else {
                List<Car> list = new LinkedList<>();
                list.add(car);
                mapMapModelsListCar.put(car.getModel(), list);
            }
        }
        return mapMapModelsListCar;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car).append(",\n");
        }
        return "CarList{" +
                "cars=" + stringBuilder +
                '}';
    }

    public List<Car> filterByModels(String models) {
        List<Car> result = new LinkedList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(models)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> filterByModelsByStream(String models) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(models))
                .toList();
    }

    public List<Car> filterByModel() {
        String model;
        System.out.println("Введіть модель авто для фільтрування:");
        Scanner scanner = new Scanner(System.in);
        model = scanner.nextLine();
        return filterByModelsByStream(model);
    }

    public List<Car> filterCarsWithInsureance() {
        List<Car> carsArrayList = new ArrayList<>();

        for (Car car : cars) {
            if (car.isInsureance()) {
                carsArrayList.add(car);
            }
        }
        return carsArrayList;
    }

    public List<Car> filterCarsWithInsureanceByStream() {
        return cars.stream()
                .filter(car -> car.isInsureance())
                .toList();
    }

    public List<Car> filterByCarYear (int start, int end) {
        int year;
        List<Car> carYear = new ArrayList<>();

        for (Car car : cars) {
            year = car.getYear();
            if(year > start && year < end) {
                carYear.add(car);
            }
        } return carYear;
    }

}