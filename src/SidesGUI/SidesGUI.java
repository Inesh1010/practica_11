package SidesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SidesGUI implements MouseListener {

    private JFrame frame;
    private JPanel panel;

    private JLabel northLabel;
    private JLabel southLabel;
    private JLabel westLabel;
    private JLabel eastLabel;
    private JLabel centerLabel;

    public SidesGUI() {

        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);


        panel.setLayout(new BorderLayout());


        northLabel = new JLabel();
        northLabel.setBounds(0,0,800,100);
        northLabel.setPreferredSize(new Dimension(800,100));
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);
        northLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        northLabel.addMouseListener(this);
        panel.add(northLabel, BorderLayout.NORTH);

        eastLabel = new JLabel();
        eastLabel.setBounds(600,200,200,200);
        eastLabel.setPreferredSize(new Dimension(200,200));
        eastLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eastLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        eastLabel.addMouseListener(this);
        panel.add(eastLabel, BorderLayout.EAST);

        southLabel = new JLabel();
        southLabel.setBounds(0,400,800,100);
        southLabel.setPreferredSize(new Dimension(800,100));
        southLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);
        southLabel.addMouseListener(this);
        panel.add(southLabel, BorderLayout.SOUTH);

        westLabel = new JLabel();
        westLabel.setBounds(0, 200, 200, 200);
        westLabel.setPreferredSize(new Dimension(200,200));
        westLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        westLabel.setHorizontalAlignment(SwingConstants.CENTER);
        westLabel.addMouseListener(this);
        panel.add(westLabel, BorderLayout.WEST);

        centerLabel = new JLabel();
        centerLabel.setBounds(200,200,200,200);
        centerLabel.setPreferredSize(new Dimension(200,200));
        centerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerLabel.addMouseListener(this);
        panel.add(centerLabel, BorderLayout.CENTER);

        frame.setVisible(true);


    }




    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == northLabel)
            northLabel.setText("Добро пожаловать в САО");
        else if (e.getSource() == eastLabel)
            eastLabel.setText("Добро пожаловать в СВАО");
        else if (e.getSource() == southLabel)
            southLabel.setText("Добро пожаловать в ЮЗАО");
        else if (e.getSource() == westLabel)
            westLabel.setText("Добро пожаловать в ЗАО");
        else if (e.getSource() == centerLabel)
            centerLabel.setText("Добро пожаловать в ЦАО");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == northLabel)
            northLabel.setText("");
        else if (e.getSource() == eastLabel)
            eastLabel.setText("");
        else if (e.getSource() == southLabel)
            southLabel.setText("");
        else if (e.getSource() == westLabel)
            westLabel.setText("");
        else if (e.getSource() == centerLabel)
            centerLabel.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}



    public static void main(String args[]) {
        new SidesGUI();
    }

}
