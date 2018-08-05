// Fousekis Konstantinos
// 321/2013196

// Κλάση δωματίων τα οποία κληρονομούν τις ιδιότητες της κλάσης Reservation
public class Rooms extends Reservation{

    protected int room_id;
    protected String view;

    // Constructor της κλάσης Rooms με τις ιδιότητες που κληρονομούνται στη super
    public Rooms(int id, String name, String surname, String startD, String endD, int room_id, String view) {
        super(id, name, surname, startD, endD);
        this.room_id = room_id;
        this.view = view;
        
    }



    
}
