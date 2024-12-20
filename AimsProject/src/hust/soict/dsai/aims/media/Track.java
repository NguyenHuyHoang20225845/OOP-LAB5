package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor with all fields
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Default constructor
    public Track() {
        this.title = "";
        this.length = 0;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same instance
        if (obj == null || getClass() != obj.getClass()) return false; // Check if object is not a Track instance

        Track track = (Track) obj; // Cast object to Track
        return length == track.length && title != null && title.equals(track.title); // Compare title and length for equality
    }

    @Override
    public int hashCode() {
        return title.hashCode(); // Consistent with equals
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength() + " seconds");
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
}