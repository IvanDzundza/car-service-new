import java.util.Comparator;

public class TransportPriceComparator implements Comparator<Base> {
    @Override
    public int compare(Base a1, Base a2) {
        return a1.getPrice() - a2.getPrice();
    }

}
