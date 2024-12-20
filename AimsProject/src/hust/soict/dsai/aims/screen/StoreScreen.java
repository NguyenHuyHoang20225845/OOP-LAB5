package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private	Store store;
	private Cart cart;
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
}
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension (100, 50)); 
		cart.setMaximumSize (new Dimension (100, 50));
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		
		return header;
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore(); 
		for (int i = 0; i < 9; i++) {
		MediaStore cell = new MediaStore (mediaInStore.get(i)); 
		center.add(cell);
		}
		return center;
}
	

	public class MediaStore extends JPanel { 
	    private Media media;

	    public MediaStore(Media media) {
	        this.media = media;
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	        
	        JLabel title = new JLabel(media.getTitle());
	        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
	        title.setAlignmentX(CENTER_ALIGNMENT);
	        
	        JLabel cost = new JLabel(media.getCost() + " $");
	        cost.setAlignmentX(CENTER_ALIGNMENT);
	        
	        JPanel container = new JPanel();
	        container.setLayout(new FlowLayout(FlowLayout.CENTER));
	        
	        JButton btnAddToCart = new JButton("Add to cart");
	        btnAddToCart.addActionListener(e -> handleAddToCart()); // Add event listener for Add to cart
	        container.add(btnAddToCart);
	        
	        if (media instanceof Playable) {
	            JButton btnPlay = new JButton("Play");
	            btnPlay.addActionListener(e -> handlePlay()); // Add event listener for Play
	            container.add(btnPlay);
	        }
	        
	        this.add(Box.createVerticalGlue());
	        this.add(title);
	        this.add(cost);
	        this.add(Box.createVerticalGlue());
	        this.add(container);
	        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    }
	//	private Cart cart; // Reference to the cart

	    private void handleAddToCart() {
		    cart.addMedia(media);
		    JOptionPane.showMessageDialog(this, 
		        media.getTitle() + " has been added to the cart.", 
		        "Add to Cart", 
		        JOptionPane.INFORMATION_MESSAGE);
		}

	    
	    
	    private void handlePlay() {
	        if (media instanceof Playable) {
	            JDialog dialog = new JDialog();
	            dialog.setTitle("Playing Media");
	            dialog.setSize(300, 200);
	            dialog.setLocationRelativeTo(this);
	            
	            JLabel message = new JLabel("Now playing: " + media.getTitle(), JLabel.CENTER);
	            message.setFont(new Font("Arial", Font.PLAIN, 16));
	            dialog.add(message);
	            
	            dialog.setVisible(true);
	        }
	    }
	}

	public StoreScreen(Store store, Cart cart) {
	    this.store = store;
	    this.cart = cart;

	    Container container = getContentPane();
	    container.setLayout(new BorderLayout());

	    container.add(createNorth(), BorderLayout.NORTH);
	    container.add(createCenter(), BorderLayout.CENTER);

	    setTitle("AIMS Store");
	    setSize(1024, 768);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




}