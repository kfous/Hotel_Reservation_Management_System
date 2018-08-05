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
import javax.swing.JPanel;

public class RoomOrVehiclePage extends JFrame implements ActionListener {

    private ObjectOutputStream out;
    private JPanel line1;
    private JButton Roombutton;
    private JButton Vehiclebutton;

    RoomOrVehiclePage(ObjectOutputStream out) {
        super("Επιλογή ενοικιαζομένου");
        this.out = out;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Αρχικοποίηση κουμπιών σελίδας
        Roombutton = new JButton("Δωμάτιο");
        Vehiclebutton = new JButton("Όχημα");
        Roombutton.addActionListener(this);
        Vehiclebutton.addActionListener(this);

        Container con = getContentPane();

        //Αρχικοποίηση γραμμών
        line1 = new JPanel();

        //Προσθήκη layout σε αυτές
        line1.setLayout(new FlowLayout());
        line1.add(Roombutton);
        line1.add(Vehiclebutton);

        con.add(line1);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj= e.getSource();
       
        //Κράτηση δωματίου
       if(obj==Roombutton)
       {
            
            ChooseRoom crm = new ChooseRoom(out);
            this.dispose();
            
        }
        //Κράτηση οχήματος
        if(obj==Vehiclebutton)
        {
            ChooseVehicle cv = new ChooseVehicle(out);
            
            this.dispose();
        }    }

}
