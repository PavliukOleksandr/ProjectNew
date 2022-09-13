package ProjectNew;

import java.util.Comparator;

public class PriceComparator2 implements Comparator<Plumbing>{
	public int compare(Plumbing o1, Plumbing o2) {
		return Double.compare(o1.getPriceUe(),o2.getPriceUe());
	}
}
