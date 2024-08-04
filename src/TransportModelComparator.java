import java.util.Comparator;

public class TransportModelComparator implements Comparator<Base> {
    @Override
    public int compare(Base b1, Base b2) {
        return b1.getModel().compareTo(b2.getModel());
    }
}
