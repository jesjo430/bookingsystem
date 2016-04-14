import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The chair sections, a 2-dimensional array representing the chairs.
 */
public class Section
{
    private int height, width;
    private Seat[][] seats;
    private int totalSeats;


    public Section(final int height, final int width) {
	this.height = height;
	this.width = width;
	this.totalSeats = height*width;
	initialize();
    }

    private void initialize() {
	seats = new Seat[height][width];
	for (int h = 0; h < seats.length; h++) {
	    for (int w = 0; w < seats[0].length; w++) {
		seats[h][w] = new Seat(h, w);
	    }
	}
    }

    public void book(int row, int seat, String name) {
	Seat place = seats[row][seat];
	if (!place.getIsBooked()) {
	    place.setStatus(true);
	    place.setName(name);
	}
    }

    public int getHeight() {
	return height;
    }

    public int getWidth() {
	return width;
    }

    public Seat[][] getSeats() {
	return seats;
    }

    public Seat getSeatAt(int row, int seat) {
	return seats[row][seat];
    }

    public int getAmountOfFreeSeats() {
	int amount = 0;
	for (Seat[] row : seats) {
	    for (Seat seat : row) {
		if (!seat.getIsBooked()) {
		    amount += 1;
		}
	    }
	}
	return amount;
    }

    public int getTotalSeats() {
	return totalSeats;
    }

    public String writeSectionToFile() {
	StringBuilder text = new StringBuilder();
	for (Seat[] row : seats) {
	    text.append("'");
	    for (Seat seat : row) {
		text.append(seat.getIsBooked() + "¤");
		System.out.println(seat.getRow());

	    }
	}
	String res = text.toString();
	System.out.println(res);
	return res;
    }

   public String getBookedChairsCordinates() {
       StringBuilder string = new StringBuilder();
       for (Seat[] row : seats) {
	   for (Seat seat : row) {
	       string.append(seat.getIsBooked() + " ");
	   }
       }
       return string.toString();
   }
}
