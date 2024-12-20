package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor with all fields
    public Disc(String title, String category, String director, int length, float cost) {
        super(); // Call parent constructor
        this.setTitle(title); // Set title using parent class setter
        this.setCategory(category); // Set category using parent class setter
        this.setCost(cost); // Set cost using parent class setter
        this.director = director;
        this.length = length;
    }

    // Constructor with minimal fields
    public Disc(String title, String director, int length) {
        super();
        this.setTitle(title);
        this.director = director;
        this.length = length;
    }

    // Default constructor
    public Disc() {
        super();
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }
}
