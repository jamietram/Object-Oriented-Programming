package calculator;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * EECS40
 * Assignment 3: CalculatorGUI
 * @author Tram Le
 * @version 11/08/2022
 */
public class Calculator {
    private JPanel Calculator;
    private JTextField textField;
    private JButton squareBtn;
    private JButton percentageBtn;
    private JButton nineBtn;
    private JButton sixBtn;
    private JButton threeBtn;
    private JButton digitBtn;
    private JButton logBtn;
    private JButton clearBtn;
    private JButton sevenBtn;
    private JButton fourBtn;
    private JButton oneBtn;
    private JButton zeroBtn;
    private JButton sqrBtn;
    private JButton divideBtn;
    private JButton mulBtn;
    private JButton minusBtn;
    private JButton addBtn;
    private JButton equalBtn;
    private JButton powerBtn;
    private JButton signBtn;
    private JButton eightBtn;
    private JButton fiveBtn;
    private JButton twoBtn;

    double num1, num2, result;
    String operation;

    /**
     * This is the base class for number button clicked, it will be inherited by 10 number
     * button clicked subclasses
     */
    public class numberBtnClicked {
    }

    /**
     * This is the constructor for zeroBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class zeroBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(zeroBtn.getText());
            } else {
                textField.setText(textScreen + zeroBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for oneBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class oneBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(oneBtn.getText());
            } else {
                textField.setText(textScreen + oneBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for twoBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class twoBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(twoBtn.getText());
            } else {
                textField.setText(textScreen + twoBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for threeBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class threeBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(threeBtn.getText());
            } else {
                textField.setText(textScreen + threeBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for fourBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class fourBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(fourBtn.getText());
            } else {
                textField.setText(textScreen + fourBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for fiveBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class fiveBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(fiveBtn.getText());
            } else {
                textField.setText(textScreen + fiveBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for sixBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class sixBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(sixBtn.getText());
            } else {
                textField.setText(textScreen + sixBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for sevenBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class sevenBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(sevenBtn.getText());
            } else {
                textField.setText(textScreen + sevenBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for eightBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class eightBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(eightBtn.getText());
            } else {
                textField.setText(textScreen + eightBtn.getText());
            }
        }
    }
    /**
     * This is the constructor for nightBtnClicked
     * This class is a subclass of numBtnClicked
     */
    public class nineBtnClicked extends numberBtnClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String textScreen = textField.getText();
            if ((textScreen.equals("")) || (textScreen.charAt(0) == '0')) {
                textField.setText(nineBtn.getText());
            } else {
                textField.setText(textScreen + nineBtn.getText());
            }
        }
    }
    /**
     * Constructor for Calculator, all the arithmetic operations of the Calculator
     * were initialized in this constructor
     */
    public Calculator() {
        zeroBtn.addActionListener(new zeroBtnClicked());
        oneBtn.addActionListener(new oneBtnClicked());
        twoBtn.addActionListener(new twoBtnClicked());
        threeBtn.addActionListener(new threeBtnClicked());
        fourBtn.addActionListener(new fourBtnClicked());
        fiveBtn.addActionListener(new fiveBtnClicked());
        sixBtn.addActionListener(new sixBtnClicked());
        sevenBtn.addActionListener(new sevenBtnClicked());
        eightBtn.addActionListener(new eightBtnClicked());
        nineBtn.addActionListener(new nineBtnClicked());

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });
        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().contains(".")){
                    double pm = Double.parseDouble(textField.getText());
                    pm = pm*-1;
                    textField.setText(String.valueOf(pm));
                }
                else {
                    long PM = Long.parseLong(textField.getText());
                    PM = PM*-1;
                    textField.setText(String.valueOf(PM));
                }
            }
        });
        digitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().contains(".")) {
                    textField.setText(textField.getText() + digitBtn.getText());
                }
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "+";
                textField.setText("");
            }
        });
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "-";
                textField.setText("");
            }
        });
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "*";
                textField.setText("");
            }
        });
        divideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "/";
                textField.setText("");
            }
        });
        squareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "^2";
                result = Math.pow(num1, 2);
                int i = (int)result;
                if( i == result) {
                    textField.setText(String.valueOf(i));
                }
                else {
                    textField.setText(String.valueOf(result));
                }
            }
        });
        powerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "^y";
                textField.setText("");
            }
        });
        percentageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "%";
                result = num1/100;
                int i = (int)result;
                if( i == result) {
                    textField.setText(String.valueOf(i));
                }
                else {
                    textField.setText(String.valueOf(result));
                }
            }
        });
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "ln";
                result = Math.log(num1);
                int i = (int)result;
                if( i == result) {
                    textField.setText(String.valueOf(i));
                }
                else {
                    textField.setText(String.valueOf(result));
                }
            }
        });
        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operation = "sqrt";
                if(num1 >= 0) {
                    result = Math.sqrt(num1);
                    int i = (int) result;
                    if (i == result) {
                        textField.setText(String.valueOf(i));
                    } else {
                        textField.setText(String.valueOf(result));
                    }
                }
                else{
                    textField.setText("ERROR");
                }
            }
        });
        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());
                if(operation == "+"){
                    result = num1 + num2;
                    int i = (int)result;
                    if( i == result) {
                        textField.setText(String.valueOf(i));
                    }
                    else {
                        textField.setText(String.valueOf(result));
                    }
                }
                else if(operation == "-"){
                    result = num1 - num2;
                    int i = (int)result;
                    if( i == result) {
                        textField.setText(String.valueOf(i));
                    }
                    else {
                        textField.setText(String.valueOf(result));
                    }
                }
                else if(operation == "*"){
                    result = num1 * num2;
                    int i = (int)result;
                    if( i == result) {
                        textField.setText(String.valueOf(i));
                    }
                    else {
                        textField.setText(String.valueOf(result));
                    }
                }
                else if(operation == "/"){
                    if(num2 != 0) {
                        result = num1 / num2;
                        int i = (int)result;
                        if( i == result) {
                            textField.setText(String.valueOf(i));
                        }
                        else {
                            textField.setText(String.valueOf(result));
                        }
                    }
                    else{
                        textField.setText("ERROR");
                    }
                }
                else if(operation == "^y"){
                    result = Math.pow(num1, num2);
                    int i = (int)result;
                    if( i == result) {
                        textField.setText(String.valueOf(i));
                    }
                    else {
                        textField.setText(String.valueOf(result));
                    }
                }
            }
        });
    }

    /**
     * This method will test the button clicked
     * @param button
     */
    public void test( String button){
        switch (button){
            case "0": zeroBtn.doClick();break;
            case "1": oneBtn.doClick();break;
            case "2": twoBtn.doClick();break;
            case "3": threeBtn.doClick();break;
            case "4": fourBtn.doClick();break;
            case "5": fiveBtn.doClick();break;
            case "6": sixBtn.doClick();break;
            case "7": sevenBtn.doClick();break;
            case "8": eightBtn.doClick();break;
            case "9": nineBtn.doClick();break;
            case "%": percentageBtn.doClick();break;
            case "-/+": signBtn.doClick();break;
            case "AC": clearBtn.doClick();break;
            case "*2": squareBtn.doClick();break;
            case "sqr": sqrBtn.doClick();break;
            case "log": logBtn.doClick();break;
            case ".": digitBtn.doClick();break;
            case "+": addBtn.doClick();break;
            case "-": minusBtn.doClick();break;
            case "*": mulBtn.doClick();break;
            case "/": divideBtn.doClick();break;
            case "**": powerBtn.doClick();break;
            case "=": equalBtn.doClick();break;
            case "txt": System.out.println("The result is: " + textField.getText());break;
            default:System.out.println("invalid input");break;
        }
    }

    /**
     * This main method is used to run the CalculatorGUI
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
