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

public class ChooseVehicle extends JFrame implements ActionListener {

    private ObjectOutputStream out;
    private JPanel line1;
    private JButton Twobutton;
    private JButton Fourbutton;

    public ChooseVehicle(ObjectOutputStream out) {
        super("Επιλογή οχήματος");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Αρχικοποίηση κουμπιών σελίδας
        Twobutton = new JButton("Δίτροχο");
        Fourbutton = new JButton("Τετράτροχο");
        Twobutton.addActionListener(this);
        Fourbutton.addActionListener(this);

        Container con = getContentPane();

        //Αρχικοποίηση γραμμών
        line1 = new JPanel();

        //Προσθήκη layout σε αυτές
        line1.setLayout(new FlowLayout());
        line1.add(Twobutton);
        line1.add(Fourbutton);

        con.add(line1);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        //Μετάβαση για κράτηση δίτροχου
        if (obj == Twobutton) {

            InsertPageVehicleTwo vt = new InsertPageVehicleTwo(out);
            this.dispose();

        }
       //Μετάβαση για κράτηση τετράτροχου
        if (obj == Fourbutton) {
            InsertPageVehicleFour vf = new InsertPageVehicleFour(out);

            this.dispose();
        }
    }
}
