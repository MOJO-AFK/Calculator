import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class CalculatorYT implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    Color myColor = new Color(0,0,0);
    Color textColor = new Color(194, 196, 149);


    double num1 = 0, num2= 0, result = 0;
    char operator;

    void Caculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBackground(textColor);

        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.PINK);

        }
        functionButtons[5].setBackground(Color.orange);
        functionButtons[4].setBackground(Color.lightGray);
        for (int i = 0; i < 10; i++){
           numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
           numberButtons[i].setFocusable(false);
           numberButtons[i].setBackground(Color.LIGHT_GRAY);

        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);


        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(myColor);
        //panel.setBackground(Color.GRAY);

        //adding buttons to the pannel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // adding components to the frame
        frame.getContentPane().setBackground(Color.black);
        frame.add(panel);
        frame.add(negButton);
        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }


// reads the button actoins
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<10; i++){
            if (e.getSource()== numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
                //sets the button number to match the text input.

            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()== addButton){
            num1 = Double.parseDouble(textField.getText());
            //converts the string input to a double.
            operator = '+';
            textField.setText("");
        }
        if (e.getSource()== subButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        } if (e.getSource()== mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }if (e.getSource()== divButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }
        if (e.getSource()== equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                result = num1 + num2;
                break;
                case '-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1/num2;
                    break;
            }
            num1 = result;
            textField.setText(String.valueOf(result));


        }
        if (e.getSource()== clrButton){
            textField.setText("");// resets the text field
        }
        if (e.getSource()== delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource()== negButton){
          double temp = Double.parseDouble(textField.getText());// temporarily stores negative numbers
          temp*=-1;
          textField.setText(String.valueOf(temp));//adds the negative sign to the input in the text field

        }

    }
}
