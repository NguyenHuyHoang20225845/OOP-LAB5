package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String category;
	private String title;
	private float cost;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	 public boolean equals(Object obj) {
	        if (this == obj) return true; // Check if the same instance
	        if (obj == null || getClass() != obj.getClass()) return false; // Check if object is not a Media instance

	        Media media = (Media) obj; // Cast object to Media
	        return title != null && title.equals(media.title); // Compare title for equality
	    }
	 @Override
	 public String toString() {
	     return "Title: " + title + ", Category: " + category + ", Cost: " + cost;
	 }

}
