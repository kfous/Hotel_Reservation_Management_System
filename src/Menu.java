// Fousekis Konstantinos
// 321/2013196

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Κεντρικό μενου εφαρμογής
public class Menu extends JFrame implements ActionListener {

    private ObjectOutputStream out;
    private JButton insertRes;
    private JButton searchRes;

    private JPanel line1;
    private JPanel line2;


    public Menu(ObjectOutputStream out) {
        super("Hotel Mainpage");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Αρχικοποίηση κουμπίων αρχικής σελίδας
        insertRes = new JButton("Εισαφωγή Κράτησης");
        insertRes.addActionListener(this);

        searchRes = new JButton("Αναζήτηση Κράτησης");
        searchRes.addActionListener(this);



        Container con = getContentPane();
        //Δημιουργία ενός GridLayout 2 γραμμών και 1 στήλης
        con.setLayout(new GridLayout(2, 1));

        //Αρχικοποίηση των 1 γραμμών
        line1 = new JPanel();
        line2 = new JPanel();


        //Ορισμός layout γραμμών
        line1.setLayout(new FlowLayout());
        line2.setLayout(new FlowLayout());


        //Προσθήκη επιθυμητών κουμπιών στις ανάλογες γραμμές
        line1.add(insertRes);
        line2.add(searchRes);

        con.add(line1);
        con.add(line2);


        //στοίχιση παραθύρου
        pack();

    }

    public Menu() {
        Menu m = new Menu(out);
    }

    ;

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        //Περίπτωση επιλογής κουμπιού Εισαγωγής κράτησης
        if (obj == insertRes) {
            RoomOrVehiclePage rov = new RoomOrVehiclePage(out);
            this.dispose();
        }

        //Περίπτωση επιλογής κουμπιού Αναζήτησης κράτησης
        if (obj == searchRes) {
            ChooseSearch cs = new ChooseSearch(out);

            this.dispose();
        }

    }

}
