// Fousekis Konstantinos
// 321/2013196

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchReservationID extends JFrame implements ActionListener {

    private ObjectOutputStream out;
    private JButton searchRes;
    private JPanel line1;
    private JLabel label1;
    private JTextField txt1;

    Hotel h1 = new Hotel("Grande", "Paris", 5);

    public SearchReservationID(ObjectOutputStream out) {
        super("Αναζήτηση με βάση το id κράτησης");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        label1 = new JLabel("Κωδικός κράτησης: ");

        //Αρχικοποίηση των textfields 10 θέσεων
        txt1 = new JTextField(10);

        //Αρχικοποίηση κουμπίων αρχικής σελίδας
        searchRes = new JButton("Αναζήτηση Κράτησης");
        searchRes.addActionListener(this);

        Container con = getContentPane();
        //Δημιουργία ενός GridLayout 1 γραμμών και 1 στήλης
        con.setLayout(new GridLayout(1, 1));

        //Αρχικοποίηση των 1 γραμμών
        line1 = new JPanel();

        //Ορισμός layout γραμμών
        line1.setLayout(new FlowLayout());

        //Προσθήκη επιθυμητών κουμπιών στις ανάλογες γραμμές
        line1.add(label1);
        line1.add(txt1);
        line1.add(searchRes);

        con.add(line1);

        //στοίχιση παραθύρου
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();

       //Περίπτωση αναζήτησης κράτησης με βάση το id
        if (obj == searchRes) {
            //χρήση αντικειμένου ξενοδοχείου για την υλοποίηση απαραίτητης μεθόδου έυρεσης κράτησης
            JOptionPane.showMessageDialog(null,(h1.search_Reservation_ID(Integer.parseInt(txt1.getText()))));
            
            Menu m = new Menu();
            this.dispose();
        }
    }

}
