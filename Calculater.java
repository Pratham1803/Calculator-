import java.awt.*;
import java.awt.event.*;

import javax.print.DocFlavor.STRING;

class windowsEvents extends WindowAdapter {
    Frame f;

    public void windowClosing(WindowEvent e) {
        f = (Frame) e.getSource();
        f.dispose();
    }
}

public class Calculater extends Frame implements ActionListener {
    Label lblNum[];
    TextField txtNum[];
    Button btnOperation[];

    Calculater() {
        this.setTitle("Calculator");
        this.setBounds(50, 50, 500, 250);
        this.setLayout(null);
        this.setVisible(true);
        this.addWindowListener(new windowsEvents());
        setFields();
    }

    void setFields() {
        // x and y position and width and height of fields
        int lblxPoint = 100, lblyPoint = 50, lblWidth = 100, lblHeight = 25;
        int txtxPoint = lblxPoint + 10 + lblWidth, txtyPoint = 50, txtWidth = 200, txtHeight = 25;
        int btnxPoint = 50, btnyPoint = txtyPoint + (3 * (txtHeight + 15)), btnWidth = 100, btnHeight = 50;

        // Creating Labels
        lblNum = new Label[3];
        String arrLabelText[] = { "Enter Number 1:", "Enter Number 2:", "Result:" };
        for (int i = 0; i < 3; i++) {
            lblNum[i] = new Label(arrLabelText[i]);
            lblNum[i].setBounds(lblxPoint, lblyPoint, lblWidth, lblHeight);
            this.add(lblNum[i]);
            lblyPoint += lblHeight + 10;
        }

        // creating Textoxes
        txtNum = new TextField[3];
        for (int i = 0; i < 3; i++) {
            txtNum[i] = new TextField();
            txtNum[i].setBounds(txtxPoint, txtyPoint, txtWidth, txtHeight);
            this.add(txtNum[i]);
            txtyPoint += txtHeight + 10;
        }

        // creating buttons
        btnOperation = new Button[4];
        String[] arrBtnText = { "Addition", "Substraction", "Multiplication", "Division" };
        for (int i = 0; i < 4; i++) {
            btnOperation[i] = new Button(arrBtnText[i]);
            btnOperation[i].setBounds(btnxPoint, btnyPoint, btnWidth, btnHeight);
            btnOperation[i].addActionListener(this);
            this.add(btnOperation[i]);
            btnxPoint += btnWidth + 5;
        }
    }

    public static void main(String[] args) {
        new Calculater();
    }

    public void actionPerformed(ActionEvent e) {
        Button sourceBtn = (Button) e.getSource();
        float res = 0;

        try {
            float num1 = Float.parseFloat(txtNum[0].getText());
            float num2 = Float.parseFloat(txtNum[1].getText());

            if (sourceBtn.getLabel() == "Addition") {
                res = num1 + num2;
                txtNum[2].setText(Float.toString(res));
            } else if (sourceBtn.getLabel() == "Substraction") {
                res = num1 - num2;
                txtNum[2].setText(Float.toString(res));
            } else if (sourceBtn.getLabel() == "Multiplication") {
                res = num1 * num2;
                txtNum[2].setText(Float.toString(res));
            } else if (sourceBtn.getLabel() == "Division") {
                res = num1 / num2;
                txtNum[2].setText(Float.toString(res));
            }
            txtNum[0].setText("");
            txtNum[1].setText("");
        } catch (Exception ex) {
        }
    }
}