package analog;

import java.awt.*;
import java.util.Calendar;

public class Clock1 extends Canvas {

    public void start() {
        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        repaint();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }

            }
        };
        t.start();
    }

    public void paint(Graphics g) {

        //declare variables
        double angle;
        int x, y;

        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.BLACK);

        //draw numbers
        Font font = new Font("SansSerif", Font.PLAIN, 26);
        g.setFont(font);
        g.setColor(new Color(255, 255, 255));
        for (int i = 1; i <= 12; i++) {
            angle = i * Math.PI / 6;
            x = (int) (200 * Math.sin(angle));
            y = (int) (200 * Math.cos(angle));
            g.drawString(Integer.toString(i), 300 + x, 300 - y);
        }
        g.fillOval(295, 295, 10, 10);


        //get calendar instance
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        hour = hour % 6;

// Draw the hour hand
        angle = (3 * Math.PI / 6) +
                (min * Math.PI / (6 * 60)) +
                (sec * Math.PI / (360 * 60));
        x = (int) (160 * Math.sin(angle));
        y = (int) (160 * Math.cos(angle));
        g.drawLine(300, 300, 300 + x, 300 - y);

// Draw the minute hand
        angle = (min * Math.PI / 30) + (sec * Math.PI / (30 * 60));
        x = (int) (190 * Math.sin(angle));
        y = (int) (190 * Math.cos(angle));
        g.drawLine(300, 300, 300 + x, 300 - y);
//   Draw the second hand
        g.setColor(Color.red);

        g.setColor(new Color(255, 0, 0));
        angle = (sec * Math.PI / (30));
        x = (int) (190 * Math.sin(angle));
        y = (int) (190 * Math.cos(angle));
        g.drawLine(300, 300, 300 + x, 300 - y);
    }
}
