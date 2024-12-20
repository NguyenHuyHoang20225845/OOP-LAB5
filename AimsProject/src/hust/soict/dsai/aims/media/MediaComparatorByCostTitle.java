package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by cost (descending order)
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // If costs are equal, compare by title (alphabetical order)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}
