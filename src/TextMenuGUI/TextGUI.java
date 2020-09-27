package TextMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextGUI implements ActionListener {


    private JFrame frame;
    private JPanel panel;

    private JMenuBar menuBar;

    private JMenu font, color;

    private JMenuItem timesFont, sansFont, courierFont;
    private JMenuItem redColor, blueColor, blackColor;

    private JTextArea textArea;


    public TextGUI() {

        frame = new JFrame();
        panel = new JPanel();
        menuBar = new JMenuBar();

        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.add(panel);


        font = new JMenu("Font");
        color = new JMenu("Color");

        menuBar.add(font);
        menuBar.add(color);


        timesFont = new JMenuItem("Times New Roman");
        timesFont.addActionListener(this);

        sansFont = new JMenuItem("MS Comic Sans");
        sansFont.addActionListener(this);

        courierFont = new JMenuItem("Courier New");
        courierFont.addActionListener(this);

        font.add(timesFont); font.add(sansFont); font.add(courierFont);


        redColor = new JMenuItem("Red");
        redColor.addActionListener(this);

        blueColor = new JMenuItem("Blue");
        blueColor.addActionListener(this);

        blackColor = new JMenuItem("Black");
        blackColor.addActionListener(this);

        color.add(redColor); color.add(blueColor); color.add(blackColor);


        textArea = new JTextArea("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, " +
                "pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. " +
                "In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. " +
                "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. " +
                "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. " +
                "Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. " +
                "Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, " +
                "luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. " +
                "Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. " +
                "Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. " +
                "Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit " +
                "fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia.");
        textArea.setBounds(135,50,500,350);
        textArea.setForeground(Color.BLACK);
        textArea.setFont( new Font( "Times New Roman", Font.PLAIN, textArea.getFont().getSize() ) );
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        textArea.setEditable(false);
        panel.add(textArea);

        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timesFont)
            textArea.setFont( new Font( "Times New Roman", Font.PLAIN, textArea.getFont().getSize() ) );
        else if (e.getSource() == sansFont)
            textArea.setFont( new Font( "MS Comic Sans", Font.PLAIN, textArea.getFont().getSize() ) );
        else if (e.getSource() == courierFont)
            textArea.setFont( new Font( "Courier New", Font.PLAIN, textArea.getFont().getSize() ) );
        else if (e.getSource() == redColor)
            textArea.setForeground(Color.RED);
        else if (e.getSource() == blueColor)
            textArea.setForeground(Color.BLUE);
        else if (e.getSource() == blackColor)
            textArea.setForeground(Color.BLACK);
    }



    public static void main(String[] args) {
        new TextGUI();
    }

}
