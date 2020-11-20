package ui;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class StudentTable extends JFrame {
    private JPanel mainPanel;
    private JTable table1;
    private JPanel filterPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitQuery1Button;
    private JTextField textField3;
    private JTextField textField4;
    private JButton submitQuery2Button;
    private JTextField textField5;
    private JTextField textField6;
    private JButton submitQuery3Button;
    private JTextField textField7;
    private JButton submitQuery4Button;
    private JTextField textField8;
    private JButton submitQuery5Button;
    private JScrollPane scrollPane1;
    DBCollection collection;

    public StudentTable(DBCollection collection) {
        super("Student Table");

        this.collection = collection;
        createTable("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        submitQuery1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable("query1");
            }
        });
        submitQuery2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable("query2");
            }
        });
        submitQuery3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable("query3");
            }
        });
        submitQuery4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable("query4");
            }
        });
        submitQuery5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable("query5");
            }
        });
    }

    private void createTable(String json) {

        if(json.equals("")) {
            DBCursor tempData = collection.find();
            setTableDataAndHeaders(tempData);

        }
        else if(json.equals("query1")) {
//            DBCursor tempData = collection.find({"SAFETY_SCORE":{$gt:'70'},"HEALTHY_SCHOOL_CERTIFIED":"Yes" });
            DBCursor tempData = collection.find();
            tempData.remove();
            setTableDataAndHeaders(tempData);

        }
//        else if(json.equals("query2")) {
//            DBCursor tempData = collection.find();
//            setTableDataAndHeaders(tempData);
//
//        }
//        else if(json.equals("query3")) {
//            DBCursor tempData = collection.find();
//            setTableDataAndHeaders(tempData);
//
//        }
//        else if(json.equals("query4")) {
//            DBCursor tempData = collection.find();
//            setTableDataAndHeaders(tempData);
//
//        }
//        else if(json.equals("query5")) {
//            DBCursor tempData = collection.find();
//            setTableDataAndHeaders(tempData);
//
//        }
    }

    private void setTableDataAndHeaders(DBCursor tempData) {
        String[] columnNames = {"NAME_OF_SCHOOL", "Street Address", "ZIP Code", "SAFETY_SCORE", "HEALTHY_SCHOOL_CERTIFIED", "Envioroment Score", "Students Enrolling in Courses %", "Students Passing in Courses %", "Parent Engagement Score", "ISAT Value Add Read"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while(tempData.hasNext()) {
            DBObject obj = tempData.next();
            String nameOfSchool = (String)obj.get("NAME_OF_SCHOOL");
            String streetAddress = (String)obj.get("Street Address");
            String zipCode = (String)obj.get("ZIP Code");
            String safetyScore = (String)obj.get("SAFETY_SCORE");
            String healthySchoolCertified = (String)obj.get("HEALTHY_SCHOOL_CERTIFIED");
            String envioromentScore = (String)obj.get("Environment Score");
            String studentsEnrollmentInCourses = (String)obj.get("Students Taking  Algebra %");
            String studentsPassingInCourses = (String)obj.get("Students Passing  Algebra %");
            String parentEngagementScore = (String)obj.get("Parent Engagement Score");
            String isatValueAddRead = (String)obj.get("ISAT Value Add Read");
            model.addRow(new Object[] { nameOfSchool, streetAddress, zipCode, safetyScore, healthySchoolCertified, envioromentScore, studentsEnrollmentInCourses, studentsPassingInCourses, parentEngagementScore, isatValueAddRead});
        }
        table1.setModel(model);
    }
}
