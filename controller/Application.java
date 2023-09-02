package controller;

import javax.swing.JFrame;

import model.CoinDispenser;
import view.ApplicationWindow;

public class Application 
{
    public static final ApplicationWindow applicationWindow = new ApplicationWindow();
    public static final CoinDispenser coinDispenser = new CoinDispenser(10, 12, 8);

    public static void main(String[] args)
    {
        applicationWindow.initalize();
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setLocation(300, 200);

        applicationWindow.pack();
        applicationWindow.setVisible(true);
    }
}
