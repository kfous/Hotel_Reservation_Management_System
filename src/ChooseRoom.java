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

public class ChooseRoom extends JFrame implements ActionListener {

    private ObjectOutputStream out;
    private JPanel line1;
    private JButton SRbutton;
    private JButton HRbutton;

    public ChooseRoom(ObjectOutputStream out) {
        super("Επιλογή δωματίου");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Αρχικοποίηση κουμπιών σελίδας
        SRbutton = new JButton("Κοινό");
        HRbutton = new JButton("Πολυτελές");
        SRbutton.addActionListener(this);
        HRbutton.addActionListener(this);

        Container con = getContentPane();

        //Αρχικοποίηση γραμμών
        line1 = new JPanel();

        //Προσθήκη layout σε αυτές
        line1.setLayout(new FlowLayout());
        line1.add(SRbutton);
        line1.add(HRbutton);

        con.add(line1);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        //Μετάβαση για κράτηση κοινού δωματίου
        if (obj == SRbutton) {

            InsertPageSimpleRoom sr = new InsertPageSimpleRoom(out);
            this.dispose();

        }
        //Μετάβαση για κράτηση πολυτελούς δωματίου
        if (obj == HRbutton) {
            InsertPageHighRoom hr = new InsertPageHighRoom(out);

            this.dispose();
        }
    }

}
