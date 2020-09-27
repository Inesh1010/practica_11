package GuessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;

public class GuessGUI implements ActionListener, KeyListener {


    private JFrame frame;
    private JPanel panel;

    private JLabel tries;
    private JLabel result;
    private JLabel tip;
    private JLabel guessedNumLabel;
    private JTextField userInput;

    private JButton submitButton;
    private JButton retryButton;

    private final int maxNumberLimit = 21;
    private int numberToGuess = (int)(Math.random() * maxNumberLimit);

    private int numberOfTries = 3;

    private boolean gameFinished = false;
    private boolean gameWon = false;



    public GuessGUI() {

        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);


        JLabel gameTitle = new JLabel("Угадай число");
        gameTitle.setBounds(364,150,100,25);
        panel.add(gameTitle);


        userInput = new JTextField();
        userInput.setBounds(355,180,20,25);
        userInput.addKeyListener(this);
        panel.add(userInput);


        submitButton = new JButton("Ввод");
        submitButton.setBounds(385,180,70,25);
        submitButton.addActionListener(this);
        panel.add(submitButton);


        tries = new JLabel("Осталось попыток: 3");
        tries.setBounds(345,205,200,25);
        panel.add(tries);


        tip = new JLabel(); // Загаданное число ... введенного
        tip.setBounds(300,230,250,25);
        panel.add(tip);


        result = new JLabel();
        result.setFont(new Font(result.getFont().getName(), Font.PLAIN, 24));
        panel.add(result);


        guessedNumLabel = new JLabel("ЗАГАДАНО ЧИСЛО: " + numberToGuess);
        guessedNumLabel.setBounds(280,285,300,25);
        guessedNumLabel.setFont(new Font(guessedNumLabel.getFont().getName(), Font.PLAIN, 24));
        guessedNumLabel.setVisible(false);
        panel.add(guessedNumLabel);


        retryButton = new JButton("ПОВТОР");
        retryButton.setBounds(385,180,70,25);
        retryButton.setFont(new Font(retryButton.getFont().getName(), Font.PLAIN, 8));
        retryButton.setForeground(Color.GREEN);
        retryButton.addActionListener(this);
        retryButton.setVisible(false);
        panel.add(retryButton);

        frame.setVisible(true);

    }



    private void trackGame() {

        int userGuess;


        try
        {
            userGuess = Integer.parseInt(userInput.getText());
        }
        catch (NumberFormatException nfe)
        {
            return;
        }


        if (gameFinished)
            return;


        numberOfTries -= 1;
        tries.setText("Осталось попыток: " + numberOfTries);

        if (userGuess > numberToGuess)
        {
            tip.setText("Загаднное число меньше введенного");
        }
        else if (userGuess < numberToGuess)
        {
            tip.setText("Загаданное число больше введенного");
        }
        else
        {
            gameFinished = true;
            gameWon = true;
        }


        if (numberOfTries == 0)
            gameFinished = true;

    }



    private void gameResults() {

        if (gameFinished)
        {

            submitButton.setVisible(false);
            tip.setText("");

            if (gameWon)
            {
                result.setText("ВЫ ВЫИГРАЛИ");
                result.setForeground(Color.GREEN);
                result.setBounds(320,250,200,25);
            }
            else
            {
                result.setText("ВЫ ПРОИГРАЛИ");
                result.setForeground(Color.RED);
                result.setBounds(315,250,200,25);
            }

            guessedNumLabel.setVisible(true);
            retryButton.setVisible(true);

        }

    }



    private void restartGame() {
        guessedNumLabel.setVisible(false);
        retryButton.setVisible(false);
        submitButton.setVisible(true);

        numberToGuess = (int)(Math.random() * maxNumberLimit);
        numberOfTries = 3;

        tries.setText("Осталось попыток: 3");
        result.setText("");
        userInput.setText("");
        guessedNumLabel.setText("ЗАГАДАНО ЧИСЛО: " + numberToGuess);

        gameFinished = false;
        gameWon = false;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton)
        {
            this.trackGame();
            this.gameResults();
        }
        else if (e.getSource() == retryButton)
        {
            this.restartGame();
        }
    }



    @Override
    public void keyTyped(KeyEvent ke) {
        if (userInput.getText().length() >= 2)
           ke.consume();
    }


    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.trackGame();
            this.gameResults();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}



    public static void main(String[] args) {
        new GuessGUI();
    }


}
