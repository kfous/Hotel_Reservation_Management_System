// Fousekis Konstantinos
// 321/2013196


import java.util.Date;



public class Reservation {
    protected int id;
    protected String name;
    protected String surname;
    protected String startD;
    protected String endD;

    
    // Constructor κρατήσεων
    Reservation(int id, String name, String surname, String startD, String endD){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.startD = startD;
        this.endD = endD;
    }
    
    // Επιστροφή μοναδικού κωδικού κράτησης
    public int getID(){
        return id;
    }
    
    // Getter της ημερομηνίας κράτησης
    public String getDate(){
        return startD;
    }
    
    // Μέθοδος tostring για την εμφάνιση των περιεχομένων μιας κράτησης
    @Override
    public String toString(){
        return (" ***RESERVATION*** "+" ID: " + id + " Name: " + name+" Surname: "+surname+" Start Date: "+startD+" End Date: "+endD);
    }
}
