import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
        JFrame frame;
        JTextField txtfield;
        JButton[] num= new JButton[10];
        JButton[] fun= new JButton[9];
        JButton addButton,subButton,mulButton,divButton;
        JButton decButton,equButton,delButton,clrButton,negButton;
        JPanel panel;

        Font myfont= new Font("Ink Free",Font.BOLD,30);
        double num1=0,num2=0,result=0;
        char operator;

        Calculator() {
            frame=new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420,550);
            frame.setLayout(null);
            txtfield=new JTextField();
            txtfield.setBounds(50,25,300,50);
            txtfield.setFont(myfont);
            txtfield.setEditable(false);
            addButton=new JButton("+");
            subButton=new JButton("-");
            mulButton=new JButton("*");
            divButton=new JButton("/");
            decButton=new JButton(".");
            equButton=new JButton("=");
            delButton=new JButton("delete");
            clrButton=new JButton("clr");
            negButton=new JButton("-");

            fun[0]=addButton;
            fun[1]=subButton;
            fun[2]=mulButton;
            fun[3]=divButton;
            fun[4]=decButton;
            fun[5]=equButton;
            fun[6]=delButton;
            fun[7]=clrButton;
            fun[8]=negButton;

            for(int i=0;i<9;i++){
                fun[i].addActionListener(this);
                fun[i].setFont(myfont);
                fun[i].setFocusable(false);
            }

            for (int i=0;i<10;i++){
                num[i]= new JButton(String.valueOf(i));
                num[i].addActionListener(this);
                num[i].setFont(myfont);
                num[i].setFocusable(false);
            }
            negButton.setBounds(50,430,100,50);
            delButton.setBounds(150,430,100,50);
            clrButton.setBounds(235,430,100,50);

            panel= new JPanel();
            panel.setBounds(50,100,300,300);
            panel.setLayout(new GridLayout(4,4,10,10));
            panel.setBackground(null);

            panel.add(num[1]);
            panel.add(num[2]);
            panel.add(num[3]);
            panel.add(addButton);
            panel.add(num[4]);
            panel.add(num[5]);
            panel.add(num[6]);
            panel.add(subButton);
            panel.add(num[7]);
            panel.add(num[8]);
            panel.add(num[9]);
            panel.add(mulButton);
            panel.add(decButton);
            panel.add(num[0]);
            panel.add(equButton);
            panel.add(divButton);

            frame.add(panel);
            frame.add(negButton);
            frame.add(delButton);
            frame.add(clrButton);
            frame.add(txtfield);
            frame.setVisible(true);
        }

    public static void main(String[] args) {
        Calculator calc= new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if (e.getSource()==num[i]){
                txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton){
            txtfield.setText(txtfield.getText().concat("."));
        }
        if (e.getSource()==addButton){
            num1=Double.parseDouble(txtfield.getText());
            operator='+';
            txtfield.setText("");
        }
        if (e.getSource()==subButton){
            num1=Double.parseDouble(txtfield.getText());
            operator='-';
            txtfield.setText("");
        }
        if (e.getSource()==mulButton){
            num1=Double.parseDouble(txtfield.getText());
            operator='*';
            txtfield.setText("");
        }
        if (e.getSource()==divButton){
            num1=Double.parseDouble(txtfield.getText());
            operator='/';
            txtfield.setText("");
        }
        if (e.getSource()==equButton) {
            num2 = Double.parseDouble(txtfield.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }
            txtfield.setText(String.valueOf(result));
            num1 = result;
        }
            if (e.getSource()==clrButton){
                txtfield.setText("");
            }

            if (e.getSource()==delButton){
                String string=txtfield.getText();
                txtfield.setText("");
                for (int i=0;i<string.length()-1;i++){
                    txtfield.setText(txtfield.getText()+string.charAt(i));
                }
            }

            if (e.getSource()==negButton){
                double temp=Double.parseDouble(txtfield.getText());
                temp*=-1;
                txtfield.setText(String.valueOf(temp));
            }

        }
    }

