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

//Κλάση κοινών δωματίων(isA οπότε κάνουν extend τη κλάση δωματίων)
public class SimpleRoom extends Rooms {

    protected static HashMap<String,Double> hotelIncome = new HashMap<String, Double>();//Static hashmap έτσι ώστε κάθε φορά που καλείται να κρατά προηγούμενες τιμές
    protected String beds;
    protected double price;
    protected String season;
    protected double season_per_day_price; //τιμή ανάλογα τη season

    // Constructor κοινων δωματίων
    public SimpleRoom(int id, String name, String surname, String startD, String endD, int room_id, String view, String beds, String season) {
        super(id, name, surname, startD, endD, room_id, view);
        this.beds = beds;
        this.season = season;

    }

    //Μέθοδος υπολογισμού τιμής Κοινού δωματίου
    public double checkPrice() {
        double days = countDays(); // υπολογίζονται από τη μέθοδο count days
        if (season.equals("Καλοκαίρι")==true ){ // Θερινή season
            season_per_day_price = 200;
            if (beds.equals("Μονόκλινο") && view.equals("Οχι")) { // Μονόκλινο χωρίς θέα
                price = season_per_day_price;
            } else if (beds.equals("Μονόκλινο") && view.equals("Ναι")) {// Με θέα
                price = season_per_day_price + season_per_day_price * (10 / 100);
            } else if (beds.equals("Δίκλινο") && view.equals("Οχι")) { // Δίκλινο χωρίς θέα
                price = season_per_day_price * (160 / 100);
            } else if (beds.equals("Δίκλινο") && view.equals("Ναι")) { // Δίκλινο με θέα
                price = season_per_day_price * (160 / 100) + season_per_day_price * (160 / 100) * (10 / 100);
            } else if (beds.equals("Τρίκλινο") && view.equals("Οχι")) { // Τρίκλινο χωρίς θέα
                price = season_per_day_price * (210 / 100);
            } else {
                price = season_per_day_price * (210 / 100) + season_per_day_price * (210 / 100) * (10 / 100);
            }
        }
        if (season.equals("Χειμώνας")==true ){ 
            season_per_day_price = 100;
            if (beds.equals("Μονόκλινο") && view.equals("Οχι")) { // Μονόκλινο χωρίς θέα
                price = season_per_day_price;
            } else if (beds.equals("Μονόκλινο") && view.equals("Ναι")) {// Με θέα
                price = season_per_day_price + season_per_day_price * (10 / 100);
            } else if (beds.equals("Δίκλινο") && view.equals("Οχι")) { // Δίκλινο χωρίς θέα
                price = season_per_day_price * (160 / 100);
            } else if (beds.equals("Δίκλινο") && view.equals("Ναι")) { // Δίκλινο με θέα
                price = season_per_day_price * (160 / 100) + season_per_day_price * (160 / 100) * (10 / 100);
            } else if (beds.equals("Τρίκλινο") && view.equals("Οχι")) { // Τρίκλινο χωρίς θέα
                price = season_per_day_price * (210 / 100);
            } else {
                price = season_per_day_price * (210 / 100) + season_per_day_price * (210 / 100) * (10 / 100);
            }
        }

        // Η τιμή αντιστοιχεί στ τιμή του δωματίου επί τις ημέρες διαμονής
        return price*days;
    }

    public double countDays() {

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
        double days = milliseconds / (1000 * 60 * 60 * 24);
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

// Μέθοδος tostring για την εμφάνιση στοιχείων δωματίου
    @Override
    public String toString() {
        return (" ***SIMPLEROOM*** "+ " ResID: " + id + " Name: " + name+" Surname: "+surname+" Start Date: "+startD+" End Date: "+endD+ " ROOMID:" + room_id + " view: " + view + " Beds: " + beds + " Season: " + season );
    }
}
