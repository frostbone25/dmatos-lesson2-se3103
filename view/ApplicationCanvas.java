package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import controller.Application;
import model.CoinDispenser;
import model.Coin;

public class ApplicationCanvas extends JPanel
{
    public static final int WIDTH = 700;
    public static final int HEIGHT = 300;

    public static final int X_SLOT = 90;
    public static final int Y_TITLE = 50;
    public static final int Y_NICKEL = 100;
    public static final int Y_DIME = 170;
    public static final int Y_QUARTER = 240;

    final Font titleFont = new Font("Courier New", Font.BOLD, 30);
    final Font coinTypeFont = new Font("Courier New", Font.ITALIC, 14);

    final Color nickelColor = Color.RED;
    final Color dimeColor = Color.BLUE;
    final Color quarterColor = Color.GREEN;

    public ApplicationCanvas()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void drawCoin(Graphics2D graphics2d, Coin coin)
    {
        var e = new Ellipse2D.Float(coin.getX(), coin.getY(), coin.getSize(), coin.getSize());
        graphics2d.fill(e);
    }

    private void drawCoinSlots(Graphics2D graphics2d)
    {
        graphics2d.setColor(nickelColor);

        for(Coin coin: Application.coinDispenser.getSlot(CoinDispenser.SLOT_NICKELS))
        {
            drawCoin(graphics2d, coin);
        }

        graphics2d.setColor(dimeColor);

        for(Coin coin: Application.coinDispenser.getSlot(CoinDispenser.SLOT_DIMES))
        {
            drawCoin(graphics2d, coin);
        }

        graphics2d.setColor(quarterColor);

        for(Coin coin: Application.coinDispenser.getSlot(CoinDispenser.SLOT_QUARTERS))
        {
            drawCoin(graphics2d, coin);
        }
    }

    private void drawTextStrings(Graphics2D graphics2D)
    {
        CoinDispenser coinDispenser = Application.coinDispenser;

        graphics2D.setFont(titleFont);
        graphics2D.drawString(String.format("Coin Dispenser (balance = %dc)", coinDispenser.getBalance()), X_SLOT, Y_TITLE);

        graphics2D.setFont(coinTypeFont);
        graphics2D.drawString(String.format("Nickles (%d of %d)", coinDispenser.getNickelCount(), coinDispenser.maxNickels), X_SLOT, Y_NICKEL);
        graphics2D.drawString(String.format("Dimes (%d of %d)", coinDispenser.getDimeCount(), coinDispenser.maxDimes), X_SLOT, Y_DIME);
        graphics2D.drawString(String.format("Quarters (%d of %d)", coinDispenser.getQuarterCount(), coinDispenser.maxQuarters), X_SLOT, Y_QUARTER);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2d = (Graphics2D)graphics;
        drawTextStrings(graphics2d);
        drawCoinSlots(graphics2d);
    }
}