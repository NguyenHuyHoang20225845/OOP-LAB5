package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor with all fields
    public CompactDisc(String title, String category, float cost, String artist) {
        super(); // Call parent class constructor
        this.setTitle(title);       // Set title using parent class method
        this.setCategory(category); // Set category using parent class method
        this.setCost(cost);         // Set cost using parent class method
        this.artist = artist;
    }

    // Constructor with minimal fields
    public CompactDisc(String title, String artist) {
        super();
        this.setTitle(title); // Set title using parent class method
        this.artist = artist;
    }

    // Default constructor
    public CompactDisc() {
        super();
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // Add a track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Calculate total length of the CD
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // Use iterator to play all tracks in the CD
            java.util.Iterator<Track> iter = tracks.iterator();

            while (iter.hasNext()) {
                Track nextTrack = iter.next();
                try {
                    nextTrack.play();  // Play the next track
                } catch (PlayerException e) {
                    throw e;  // Rethrow the exception if it occurs during playback
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    
    @Override
    public String toString() {
        return "CD - " + super.toString() + ", Artist: " + artist + ", Tracks: " + tracks.size();
    }


}
