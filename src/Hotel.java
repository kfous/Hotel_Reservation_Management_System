// Fousekis Konstantinos
// 321/2013196

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hotel {

    protected String name;
    protected String location;
    protected int stars;
    protected Reservation rs;     // Το ξενοδοχείο έχει κρατήσεις

    protected static HashMap<Reservation, Integer> reserved = new HashMap<Reservation, Integer>(); // Συλλογή ρατήσεων με βάση το id
    protected static ArrayList<Rooms> booked_Room = new ArrayList<Rooms>();                  // Συλλογή ενοικιαζόμενων δωματίων 
    protected static ArrayList<Vehicles> booked_Vehicle = new ArrayList<Vehicles>();         //και οχημάτων

    //Constructor ξενοδοχείου
    Hotel(String name, String location, int stars) { 
        this.name = name;
        this.location = location;
        this.stars = stars;
    }

    // Μέθοδος προσθήκης ενοικιαζομένου
    public void addBooking(Rooms rm) {
        booked_Room.add(rm);
    }

    // Μέθοδος αφαίρεσης ενοικιαζομένου
    public void removeBooking(Rooms rm) {
        booked_Room.remove(rm);
    }

    // Μέθοδος προσθήκης ενοικιαζομένου οχήματος
    public void addBooking(Vehicles ve) {
        booked_Vehicle.add(ve);
    }

    // Μέθοδος αφαίρεσης ενοικιαζομένου οχήματος
    public void removeBooking(Vehicles ve) {
        booked_Vehicle.remove(ve);
    }

    // Μέθοδος προσθήκης κρατήσεων στο ανάλογο map, με κλειδί το ίδιο το reservation που δέχεται
    //και ως τιμή το id του
    public void stock(Reservation rs) {
        reserved.put(rs, rs.getID());

    }

    // Μέθοδος αναζήτησης κρατήσεων με βάση το id
    public String search_Reservation_ID(int id) {
        // Iterator που πραγματοποιεί προσπέλαση στο map
        Iterator<Reservation> keySetIterator = reserved.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Reservation key = keySetIterator.next();
            if (key.id == id) {     // και ελέγχει αν το id που δίνεται αντιστοιχεί σε κάποιο reservation-key
                return key.toString();
            }

        }
        return "Reservation not found";

    }

    // Μέθοδος αναζήτησης κρατήσεων με βάση το όνομα πελάτη
    public String search_Reservation_Name(String name) {
        Iterator<Reservation> keySetIterator = reserved.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Reservation key = keySetIterator.next();
            if (key.name.equals(name) ) { // Έλεγχος αν το όνομα αντιστοιχεί στο όνομα κάποιας κράτησης
                return key.toString();
            }

        }
        return "Reservation not found";

    }

    //Μέθοδος αναζήτησης κρατήσεων με βάση την ημερομηνία κράτησης
    public String search_Reservation_Date(String date) {
        Iterator<Reservation> keySetIterator = reserved.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Reservation key = keySetIterator.next();
            if (key.startD.equals(date)) {  // Έλεγχος αν υπάρχει κράτηση σε συγκεκριμένη ημερομηνία που δίνεται
                return key.toString();
            }

        }
        return "Reservation not found";

    }

    // Μέθοδος αφαίρεσης κρατήσεων με βάση το id
    public String remove_Reservation(int id) {
        Iterator<Reservation> keySetIterator = reserved.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Reservation key = keySetIterator.next();
            if (key.id == id) {
                reserved.remove(key);
                return "Αφαιρέθηκε η κράτηση:" + key.toString();
            }

        }
        return "reservation not found";
    }

    public void displayBooked() {
        System.out.println(reserved);
//        for (int i = 0; i < booked_Room.size(); i++) {
//            System.out.println(booked_Room.get(i).toString());
//        }
//
//        for (int i = 0; i < booked_Vehicle.size(); i++) {
//            System.out.println(booked_Vehicle.get(i).toString());
//        }
    }


}
