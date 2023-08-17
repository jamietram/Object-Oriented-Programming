package Dictionary;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
/**
 * EECS 40
 * Assignment 4 Dictionary
 * @author Tram Le
 * @version 11/29/2022
 */

/**
 * This is the constructor for InvalidWordError
 * This class is a subclass of RuntimeException
 */
class InvalidWordError extends RuntimeException{
    InvalidWordError() {
        super("ERROR! Invalid Word.");
    }
}
/**
 * This is the constructor for WordNotFoundError
 * This class is a subclass of RuntimeException
 */
class WordNotFoundError extends RuntimeException{
    WordNotFoundError() {
        super("ERROR! Word Not Found.");
    }
}
/**
 * This is the constructor for InvalidFrequencyError
 * This class is a subclass of RuntimeException
 */
class InvalidFrequencyError extends RuntimeException{
    InvalidFrequencyError() {
        super("ERROR! Invalid Frequency.");
    }
}
/**
 * This is the constructor for WordDuplicatedError
 * This class is a subclass of RuntimeException
 */
class WordDuplicatedError extends RuntimeException{
    WordDuplicatedError() {
        super("ERROR! Word Duplicated.");
    }
}
/**
 * This is the constructor for FileNotFoundError
 * This class is a subclass of RuntimeException
 */
class FileNotFoundError extends RuntimeException{
    FileNotFoundError() {
        super("ERROR! File Not Found.");
    }
}
/**
 * This is the constructor for Words
 */
class Words {
    public String wordName;
    public String meaning;
    int frequency;

    /**
     * parameterized constructor
     */
    Words(String wordName, String meaning, int frequency) {
        this.wordName = wordName;
        this.meaning = meaning;
        this.frequency = frequency;
    }
}
public class Dictionary {
    public JPanel Dictionary;
    public JButton FINDButton;
    public JButton EXPORTButton;
    public JTextArea TextArea;
    public JButton CLEARButton;
    public JButton REMOVEButton;
    public JButton ADDButton;
    public JButton IMPORTButton;
    public JTextField TextWord;
    public JTextField TextFrequency;
    public JTextField TextFreqWord1;
    public JTextField TextFreqWord3;
    public JTextField TextFreqWord2;
    public JTextField TextFilePath;

    /**
     * Constructor for Dictionary, all the button operations
     * were initialized in this constructor
     */
    public Dictionary() {
        ArrayList<Words> wordsArrayList = new ArrayList<Words>();
        /**
         * Add the word
         */
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = TextWord.getText();
                String meaning = TextArea.getText();
                String frequency = TextFrequency.getText();

                TextWord.setText("");
                TextFrequency.setText("");
                TextArea.setText("");

                //Default frequency
                if (frequency.equals("")) {
                    frequency = "1";
                }

                //Handle Invalid Word Error
                for (char c : word.toCharArray()) {
                    if (!Character.isLetter(c) || Character.isWhitespace(c)) {
                        TextArea.setText("ERROR! Invalid Word.");
                        throw new InvalidWordError();
                    }
                }

                //Handle Invalid Frequency Error
                for (char c: frequency.toCharArray()){
                    if(!Character.isDigit(c) || Character.isWhitespace(c)) {
                        TextArea.setText("ERROR! Invalid Frequency.");
                        throw new InvalidFrequencyError();
                    }
                }

                //Handle Word Duplicated Error
                for (int i = 0; i < wordsArrayList.size(); i++) {
                    if (word.equals(wordsArrayList.get(i).wordName)) {
                        TextArea.setText("ERROR! Word Duplicated.");
                        throw new WordDuplicatedError();
                    }
                }

                wordsArrayList.add(new Words(word, meaning, Integer.parseInt(frequency)));
                wordsArrayList.sort(Comparator.comparing(Words -> Words.frequency));
                Collections.reverse(wordsArrayList);
            }
        });
        /**
         * Find the word
         */
        FINDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Words> wordsFoundArray = new ArrayList<Words>();
                String word = TextWord.getText();
                TextWord.setText("");
                TextFrequency.setText("");
                TextFreqWord1.setText("");
                TextFreqWord2.setText("");
                TextFreqWord3.setText("");
                TextArea.setText("");
                TextFilePath.setText("");

                if (TextWord.getText() == ""){
                    TextArea.setText("ERROR! Word Not Found.");
                    throw new WordNotFoundError();
                }

                for (char c : word.toCharArray()) {
                    if (!Character.isLetter(c) || Character.isWhitespace(c)) {
                        TextArea.setText("ERROR! Invalid Word.");
                        throw new InvalidWordError();
                    }
                }

                //Add the word found to the found array
                for (int i = 0; i < wordsArrayList.size(); i++) {
                    if ((wordsArrayList.get(i).wordName).startsWith(word)) {
                        wordsFoundArray.add(new Words(wordsArrayList.get(i).wordName,
                                wordsArrayList.get(i).meaning,wordsArrayList.get(i).frequency));
                    }
                }

                if (wordsFoundArray.size() == 0) {
                    TextArea.setText("ERROR! Word Not Found.");
                    throw new WordNotFoundError();
                }

                if (wordsFoundArray.size() > 0) {
                    TextFreqWord1.setText(wordsFoundArray.get(0).wordName);
                    TextArea.append(wordsFoundArray.get(0).meaning + System.getProperty("line.separator"));
                }

                if (wordsFoundArray.size() > 1){
                    TextFreqWord2.setText(wordsFoundArray.get(1).wordName);
                    TextArea.append(wordsFoundArray.get(1).meaning + System.getProperty("line.separator"));
                }
                if (wordsFoundArray.size() > 2) {
                    TextFreqWord3.setText(wordsFoundArray.get(2).wordName);
                    TextArea.append(wordsFoundArray.get(2).meaning + System.getProperty("line.separator"));
                }
            }
        });
        /**
         * Import file
         */
        IMPORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = TextFilePath.getText();
                File fileIn = new File(("C:\\Users\\traml\\OneDrive\\Desktop\\eecs40\\").concat(filePath));
                Scanner input = null;
                try {
                    input = new Scanner(fileIn);
                }
                catch (Exception FileNotFoundError) {
                    TextArea.setText("ERROR! The file path provided does not exist.");
                    throw new FileNotFoundError();
                }

                while (input.hasNext()) {
                    String word = input.nextLine();
                    int frequency = Integer.parseInt(input.nextLine());
                    String meaning = input.nextLine();
                    wordsArrayList.add(new Words(word, meaning, frequency));
                    if (input.hasNext())
                        input.nextLine();
                }
                wordsArrayList.sort(Comparator.comparing(Words -> Words.frequency));
                Collections.reverse(wordsArrayList);
            }
        });
        /**
         * Export file
         */
        EXPORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = TextFilePath.getText();
                File fileOut = new File(("C:\\Users\\traml\\OneDrive\\Desktop\\eecs40\\").concat(filePath));
                try {
                    FileWriter fileWriter = new FileWriter(fileOut);
                    for (int i = 0; i < wordsArrayList.size(); i++) {
                        fileWriter.write(wordsArrayList.get(i).wordName + System.getProperty("line.separator"));
                        fileWriter.write(String.valueOf(wordsArrayList.get(i).frequency) + System.getProperty("line.separator"));
                        fileWriter.write(wordsArrayList.get(i).meaning + System.getProperty("line.separator"));
                        fileWriter.write(System.getProperty("line.separator"));
                    }
                    fileWriter.close();
                }
                catch (Exception FileNotFoundError) {
                    TextArea.setText("ERROR! The file path provided does not exist.");
                    throw new FileNotFoundError();
                }
            }
        });
        /**
         * Clears all fields.
         */
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextWord.setText("");
                TextFrequency.setText("");
                TextFreqWord1.setText("");
                TextFreqWord2.setText("");
                TextFreqWord3.setText("");
                TextArea.setText("");
                TextFilePath.setText("");
            }
        });
        /**
         * Remove the word
         */
        REMOVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = TextWord.getText();
                TextWord.setText("");
                TextFrequency.setText("");
                TextFreqWord1.setText("");
                TextFreqWord2.setText("");
                TextFreqWord3.setText("");
                TextArea.setText("");
                TextFilePath.setText("");

                for (char c : word.toCharArray()) {
                    if (!Character.isLetter(c) || Character.isWhitespace(c)) {
                        TextArea.setText("ERROR! Invalid Word.");
                        throw new InvalidWordError();
                    }
                }

                int wordsArraySize = wordsArrayList.size();
                int wordsCount = wordsArrayList.size();
                for (int i = 0; i < wordsArrayList.size(); i++) {
                    if ((wordsArrayList.get(i).wordName).equals(word)) {
                        wordsArrayList.remove(i);
                        wordsCount--;
                    }
                }

                if (wordsArraySize == wordsCount) {
                    TextArea.setText("ERROR! Word Not Found.");
                    throw new WordNotFoundError();
                }
            }
        });
    }

    /**
     * This main method is used to run the DictionaryGUI
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dictionary");
        frame.setContentPane(new Dictionary().Dictionary);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

