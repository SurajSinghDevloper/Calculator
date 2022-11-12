package Calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control extends JFrame implements ActionListener{
    JFrame frame;
    JTextField txt;
    Font fnt;
    Font babyfnt;
    Panel panel;
    JButton numberButton[]=new JButton[10];
    JButton FunctionButton[]=new JButton[9];

    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;

    double num1=0,num2=0,result=0;
    char operator;
    Control(){
        fnt=new Font("Ink free",Font.BOLD,60);
        babyfnt=new Font("Ink free",Font.BOLD,20);
        this.setTitle("Calculator");
        this.setVisible(true);
        this.setSize(400,550);
        this.setLocation(500,200);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(216, 75, 45 ));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt=new JTextField();
        txt.setBounds(15,15,350,80);
        txt.setBackground(new Color(218, 247, 166));
        txt.setFont(fnt);
        txt.setEditable(false);
        this.add(txt);

        addButton=new JButton("+");
        addButton.setBackground(new Color(13, 108, 229));
        subButton=new JButton("-");
        subButton.setBackground(new Color(13, 108, 229));
        mulButton=new JButton("X");
        mulButton.setBackground(new Color(13, 108, 229));
        divButton=new JButton("/");
        divButton.setBackground(new Color(13, 108, 229));
        decButton=new JButton(".");
        decButton.setBackground(new Color(13, 108, 229));
        equButton=new JButton("=");
        equButton.setBackground(new Color(13, 108, 229));
        delButton=new JButton("Del");
        delButton.setBackground(new Color(13, 108, 229));
        clrButton=new JButton("clr");
        clrButton.setBackground(new Color(13, 108, 229));
        negButton=new JButton("Neg");
        negButton.setBackground(new Color(13, 108, 229));

        

        FunctionButton[0]=addButton;
        FunctionButton[1]=subButton;
        FunctionButton[2]=mulButton;
        FunctionButton[3]=divButton;
        FunctionButton[4]=decButton;
        FunctionButton[5]=equButton;
        FunctionButton[6]=delButton;
        FunctionButton[7]=clrButton;
        FunctionButton[8]=negButton;

        for(int i=0;i<9;i++){
            FunctionButton[i].addActionListener(this);
            FunctionButton[i].setFont(babyfnt);
            FunctionButton[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(babyfnt);
            numberButton[i].setFocusable(false);
            numberButton[i].setBackground(new Color(132, 211, 236));
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        this.add(negButton);
        this.add(delButton);
        this.add(clrButton);

        panel=new Panel();
        panel.setBounds(15, 100, 350, 300);
        panel.setBackground(new Color(216, 75, 45 ));
        panel.setLayout(new GridLayout(4,4,10,10));
        this.add(panel);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(mulButton);
        panel.add(equButton);
        panel.add(divButton);

       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                txt.setText(txt.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            txt.setText(txt.getText().concat("."));
        }

        if(e.getSource()==addButton){
            num1=Double.parseDouble(txt.getText());
            operator='+';
            txt.setText(" ");
        }

        if(e.getSource()==subButton){
            num1=Double.parseDouble(txt.getText());
            operator= '-';
            txt.setText(" ");
        }

        if(e.getSource()==mulButton){
            num1=Double.parseDouble(txt.getText());
            operator= '*';
            txt.setText(" ");
        }

        if(e.getSource()==divButton){
            num1=Double.parseDouble(txt.getText());
            operator= '/';
            txt.setText(" ");
        }

        if(e.getSource()==equButton){
            num2=Double.parseDouble(txt.getText());

            switch(operator){
                case '+':
                result=num1+num2;
                break;

                case '-':
                result=num1-num2;
                break;

                case '*':
                result=num1*num2;
                break;

                case '/':
                result=num1/num2;
                break;

                
            }
            txt.setText(String.valueOf(result));
            num1=result;

            
        }

        if(e.getSource()==clrButton){
            txt.setText(" ");
        }

        if(e.getSource()==delButton){
            String string=txt.getText();
            txt.setText(" ");

                for(int i=0;i<string.length()-1;i++){
                    txt.setText(txt.getText()+string.charAt(i));
                }
        }

        if (e.getSource()==negButton){
            double temp=Double.parseDouble(txt.getText());
            temp *=-1;
            txt.setText(String.valueOf(temp));
        }
      
    }

  
    
 
}
