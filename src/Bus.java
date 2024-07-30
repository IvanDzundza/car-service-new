public class Bus extends Base implements Comparable <Bus> {
    int places;
    boolean placesDisabilities;

    public Bus() {
    }

    public Bus(int id, String model, int year, int price, String registrationNumber, int places, boolean placesDisabilities) {
        super(id, model, year, price, registrationNumber);
        this.places = places;
        this.placesDisabilities = placesDisabilities;
    }

    public Bus (Bus p){
        this(p.id, p.model, p.year, p.price, p.registrationNumber, p.places, p.placesDisabilities);
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public boolean isPlacesDisabilities() {
        return placesDisabilities;
    }

    public void setPlacesDisabilities(boolean placesDisabilities) {
        this.placesDisabilities = placesDisabilities;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "places=" + places +
                ", placesDisabilities=" + placesDisabilities +
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
    public int compareTo(Bus bus) {
        return this.getPlaces() - bus.getPlaces();
    }
}
