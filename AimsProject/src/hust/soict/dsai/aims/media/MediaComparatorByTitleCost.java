package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by title (alphabetical order)
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // If titles are equal, compare by cost (descending order)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
