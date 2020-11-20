package ui;

import com.mongodb.DBCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
    private JPanel panel1;
    private JButton displayTableButton;

    public HomeScreen(DBCollection collection) {
        super("Home Screen : School Preference System");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        displayTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentTable st = new StudentTable(collection);
            }
        });
    }
}
