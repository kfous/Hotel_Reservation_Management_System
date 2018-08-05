// Fousekis Konstantinos
// 321/2013196

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChooseSearch extends JFrame implements ActionListener {

    private ObjectOutputStream out;
    private JPanel line1;
    private JButton IDbutton;
    private JButton Namebutton;
    private JButton Datebutton;

    public ChooseSearch(ObjectOutputStream out) {
        super("Επιλογή αναζήτησης");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Αρχικοποίηση κουμπιών σελίδας
        IDbutton = new JButton("Αναζήτηση με ID");
        Namebutton = new JButton("Αναζήτηση με όνομα");
        Datebutton = new JButton("Αναζήτηση με ημερομηνία");

        IDbutton.addActionListener(this);
        Namebutton.addActionListener(this);
        Datebutton.addActionListener(this);

        Container con = getContentPane();

        //Αρχικοποίηση γραμμών
        line1 = new JPanel();

        //Προσθήκη layout σε αυτές
        line1.setLayout(new FlowLayout());
        line1.add(IDbutton);
        line1.add(Namebutton);
        line1.add(Datebutton);

        con.add(line1);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

       //Μετάβαση για αναζήτηση με βάση το id
        if (obj == IDbutton) {

        SearchReservationID s = new SearchReservationID(out);
            this.dispose();

        }
       //Μετάβαση για αναζήτηση με βάση το ονομα
        if (obj == Namebutton) {
            SearchReservationName sn = new SearchReservationName(out);

            this.dispose();
        }

        //Μετάβαση για αναζήτηση με βάση την ημερομηνία
        if (obj == Datebutton) {
           SearchReservationDate sd = new SearchReservationDate(out);

            this.dispose();
        }
    }
}
