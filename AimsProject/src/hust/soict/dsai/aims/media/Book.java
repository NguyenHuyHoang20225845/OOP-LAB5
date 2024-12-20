package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<>();
	
	public Book(String title, String category, float cost) {
		super(); // Call parent class constructor
      this.setTitle(title);       // Set title using parent class method
       this.setCategory(category); // Set category using parent class method
       this.setCost(cost);         // Set cost using parent class method
	}
	
	
	

	public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be null or empty.");
            return;
        }
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be null or empty.");
            return;
        }
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }
    @Override
    public String toString() {
		return "Book - " + super.toString() + ", Author: " + authors;
    }

}

