package ProjectNew;

import java.util.Comparator;

public class PriceComparator1 implements Comparator<Plumbing>{
	public int compare(Plumbing o1, Plumbing o2) {
		return Double.compare(o2.getPriceUe(),o1.getPriceUe());
	}
}
