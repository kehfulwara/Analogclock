package analog;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Clock clock=new Clock();
        JFrame f=new JFrame();
        Clock1 c2=new Clock1();
        JFrame f2= new JFrame();
        f.add(clock);
        f.setSize(600,600);
        f.setLocation(500,100);
        f.setTitle("Java Clock");
        f.setUndecorated(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f2.add(c2);
        f2.setSize(600,600);
        f2.setLocation(500,100);
        f2.setTitle("Java Austrailia Clock");
        f2.setUndecorated(false);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setVisible(true);
        clock.start();
        c2.start();
    }
}
