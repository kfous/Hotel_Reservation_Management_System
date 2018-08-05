// Fousekis Konstantinos
// 321/2013196

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertPageHighRoom extends JFrame implements ActionListener {

    public int rsID = 100;
    public int rmID = 1;
    private ObjectOutputStream out;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;

    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;

    private JPanel line1;
    private JPanel line2;
    private JPanel line3;
    private JPanel line4;
    private JPanel line5;
    private JPanel line6;
    private JPanel line7;
    private JPanel line8;
    private JPanel line9;

    private JButton Okbutton;
    private JButton Cancelbutton;
    private JComboBox box;
    private JComboBox box2;
    private JComboBox box3;
    private JComboBox box4;

    private String[] arr = {"Καλοκαίρι", "Χειμώνας"};
    private String[] arr2 = {"Δίκλινο"};
    private String[] arr3 = {"Ναι"};
    private String[] arr4 = {"Ναι", "Οχι"};

    Hotel h1 = new Hotel("Grande", "Paris", 5);
    public static HashMap<String, Double> hotelIncome = new HashMap<String, Double>();

    public InsertPageHighRoom(ObjectOutputStream out) {
        super("Κράτηση Κοινού Δωματίου");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Αρχικοποίηση Ετικέτών δίπλα από τα TextFields
        label1 = new JLabel("Όνομα:");
        label2 = new JLabel("Επώνυμο:");
        label3 = new JLabel("Ημ. Άφιξης:");
        label4 = new JLabel("Ημ. Αναχ/σης:");
        label5 = new JLabel("Season:");
        label6 = new JLabel("Τύπος Δωματίου:");
        label7 = new JLabel("Θέα:");
        label8 = new JLabel("Υδρομασαζ:");

        //Αρχικοποίηση των textfields 10 θέσεων
        txt1 = new JTextField(10);
        txt2 = new JTextField(10);
        txt3 = new JTextField(10);
        txt4 = new JTextField(10);

        //Αρχικοποίηση combobox επιλογής δωματίου, και πρωινού
        box = new JComboBox(arr);
        box2 = new JComboBox(arr2);
        box3 = new JComboBox(arr3);
        box4 = new JComboBox(arr4);

        //Αρχικοποίηση κουμπιών σελίδας
        Okbutton = new JButton("Καταχώρηση και ενοικίαση");
        Cancelbutton = new JButton("Άκυρο");
        Okbutton.addActionListener(this);
        Cancelbutton.addActionListener(this);

        Container con = getContentPane();
        //Δημιουργία ενός GridLayout 9 γραμμών και 1 στήλης
        con.setLayout(new GridLayout(9, 1));

        //Αρχικοποίηση γραμμών
        line1 = new JPanel();
        line2 = new JPanel();
        line3 = new JPanel();
        line4 = new JPanel();
        line5 = new JPanel();
        line6 = new JPanel();
        line7 = new JPanel();
        line8 = new JPanel();
        line9 = new JPanel();

        //Προσθήκη layout σε αυτές
        line1.setLayout(new FlowLayout());
        line2.setLayout(new FlowLayout());
        line3.setLayout(new FlowLayout());
        line4.setLayout(new FlowLayout());
        line5.setLayout(new FlowLayout());
        line6.setLayout(new FlowLayout());
        line7.setLayout(new FlowLayout());
        line8.setLayout(new FlowLayout());
        line9.setLayout(new FlowLayout());

        //Προσθήκη Επιθυμητών κουμπιών και ετικετών στις παραπάνω γραμμές
        line1.add(label1);
        line1.add(txt1);
        line2.add(label2);
        line2.add(txt2);
        line3.add(label3);
        line3.add(txt3);
        line4.add(label4);
        line4.add(txt4);
        line5.add(label5);
        line5.add(box);
        line6.add(label6);
        line6.add(box2);
        line7.add(label7);
        line7.add(box3);
        line8.add(label8);
        line8.add(box4);
        line9.add(Okbutton);
        line9.add(Cancelbutton);

        //Δίνονται components στiw γραμμές για να στοιχιστούν μέσω της παρακάτω pack
        con.add(line1);
        con.add(line2);
        con.add(line3);
        con.add(line4);
        con.add(line5);
        con.add(line6);
        con.add(line7);
        con.add(line8);
        con.add(line9);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        //Σε περίπτωση που επιλεχθεί το κουμπί καταχώρησης
        if (obj == Okbutton) {
            Random rand = new Random();
            rsID = rand.nextInt(40000) + 1;
            rmID++;

            //Τα στοιχεία της κράτησης αποθηκέυονται σε ένα αντικείμενο reser
            HighRoom hr = new HighRoom(rsID, txt1.getText(), txt2.getText(), txt3.getText(),
                    txt4.getText(), rmID, box3.getSelectedItem().toString(),
                    box2.getSelectedItem().toString(), box.getSelectedItem().toString(), box4.getSelectedItem().toString());

            //Ενημέρωση εδόδων ξενοδοχείου για τον μήνα κράτησης
            hotelIncome.putAll(hr.monthIncome());

            JOptionPane.showMessageDialog(null, "Εγινε κράτηση πολυτελους δωματίου \n" + hr.toString()
                    + "\n Ημέρες Διαμονής: " + hr.countDays() + "\n Με τιμή " + hr.checkPrice()
                    + "\n και Έσοδα Ξενοδοχείου " + hotelIncome);

            //Εισαγωγή κράτησης στο ανάλογο hashmap
            h1.stock(hr);

            //Επιστροφη σε αρχική σελίδα
            Menu m = new Menu();
            this.dispose();

        }
        //Επίσης
        if (obj == Cancelbutton) {
            Menu menu = new Menu(out);

            this.dispose();
        }

    }
}
