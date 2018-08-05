// Fousekis Konstantinos
// 321/2013196

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

//Κλάση Οχημάτων προς κράτηση
public class Vehicles extends Reservation {

    protected static HashMap<String, Float> hotelIncome = new HashMap<String, Float>();
    private int vehicle_id;
    private String vehicle_type;
    private String wheels;
    private float price;

    public Vehicles(int id, String name, String surname, String startD, String endD, int vehicle_id, String vehicle_type, String wheels) {
        super(id, name, surname, startD, endD);
        this.vehicle_id = vehicle_id;
        this.vehicle_type = vehicle_type;
        this.wheels = wheels;
    }

    public float checkPrice() {
        int days = countDays();  // υπολογίζονται από τη μέθοδο count days
        if (wheels.equals("Τετράτροχο") && vehicle_type.equals("Αυτοκίνητο")) {
            price = 50;
        } else {
            price = 30;
        }
        if (wheels.equals("Δίτροχο") && vehicle_type.equals("Σκουτερ")) {
            price = 20;
        }
        // Η τιμή αντιστοιχεί στ τιμή του οχήματος επί τις ημέρες ενοικίασης
        return price * days;
    }

    public int countDays() {

        // Αρχικοποίηση δύο Date
        Date date1 = null;
        try {// Parse, string ημερομηνίων, στο παρκάτω format
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(startD);
        } catch (ParseException ex) {
            Logger.getLogger(SimpleRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat("yyyy-mm-dd").parse(endD);
        } catch (ParseException ex) {
            Logger.getLogger(SimpleRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Μετατροπή σε χρόνο και υπολογισμός της διαφοράς τους και επαναμετατροπή σε integer
        int milliseconds = (int) (date2.getTime() - date1.getTime());
        int days = milliseconds / (1000 * 60 * 60 * 24);
        return days;
    }

    // Μέθοδος υπολογισμού εσόδων ξενοδοχείου για όλους τους μήνες κρατήσεων
    public HashMap monthIncome() {
        //Για τις ημερομηνίες κράτησης ενός μήνα
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(startD);
        } catch (ParseException ex) {
            Logger.getLogger(SimpleRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat("yyyy-mm-dd").parse(endD);
        } catch (ParseException ex) {
            Logger.getLogger(SimpleRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Αποκοπή των μηνών απο τις ημερομηνίες κρατήσεων αρχή-τελος
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("mm");
        String result = simpleDateformat.format(date1);
        int month1 = Integer.parseInt(result);      // Μετατροπή τους σε integer
        //System.out.println("\n" + month1);

        String result2 = simpleDateformat.format(date2);
        int month2 = Integer.parseInt(result2);
        //System.out.println("\n" + month2);

        if (month1 == month2) {
            String monthString = MonthName(month1); // Μετατροπή του integer στο όνομα του μήνα με τη μέθοδο MonthName

            // Αν στο map υπάρχει ήδη ο μήνας που επίκειται προς καταχώρηση, τότε πρόσθεσε την τιμή του, σε αυτή του ήδη υπαρχοντα
            if (hotelIncome.containsKey(monthString)) {
                hotelIncome.put(monthString, hotelIncome.get(monthString) + checkPrice());
            } else {
                // Αλλιώς πραγματοποίησε απλή εισαγωγή του μήνα και τα έσοδά του sto map (key-value αντίστοιχα)
                hotelIncome.put(monthString, checkPrice());
            }

        }
        return hotelIncome;
    }

    //Μέθοδος μετατροπής Integer σε μήνα

    public String MonthName(int m) {
        String month = "invalid";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths(); // Δημιουργία ενός πίνακα months που ανάλογα το κελί θα δίνει το μήνα
        if (m >= 1 && m <= 12) {
            month = months[m];
        }
        return month;
    }

    @Override
    public String toString() {
        return (" ***VEHICLE*** " + " ResID: " + id + " Name: " + name+" Surname: "+surname+" Start Date: "+startD+" End Date: "+endD+ "ID: " + vehicle_id + " vehicle_type : " + vehicle_type + " wheels : " + wheels);
    }
}
