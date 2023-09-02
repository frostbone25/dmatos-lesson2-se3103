package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Coin;
import model.CoinDispenser;
import model.Quarter;
import view.ApplicationCanvas;
import model.Nickel;
import model.Dime;

public class InsertButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Coin newCoin = null;
        CoinDispenser coinDispenser = Application.coinDispenser;
        int selectedIndex = coinDispenser.selectedSlotIndex;

        int x = 0;
        int y = 0;

        if(selectedIndex == CoinDispenser.SLOT_NICKELS)
        {
            assert coinDispenser.getNickelCount() < coinDispenser.maxNickels : "Nickel slot is full";

            newCoin = new Nickel();

            x = ApplicationCanvas.X_SLOT + coinDispenser.getNickelCount() * (Nickel.SIZE + 10);
            y = ApplicationCanvas.Y_NICKEL;
        }
        else if(selectedIndex == CoinDispenser.SLOT_DIMES)
        {
            assert coinDispenser.getDimeCount() < coinDispenser.maxDimes : "Dime slot is full";

            newCoin = new Dime();

            x = ApplicationCanvas.X_SLOT + coinDispenser.getDimeCount() * (Dime.SIZE + 10);
            y = ApplicationCanvas.Y_DIME;
        }
        else if(selectedIndex == CoinDispenser.SLOT_QUARTERS)
        {
            assert coinDispenser.getQuarterCount() < coinDispenser.maxQuarters : "Quarter slot is full";

            newCoin = new Quarter();

            x = ApplicationCanvas.X_SLOT + coinDispenser.getQuarterCount() * (Quarter.SIZE + 10);
            y = ApplicationCanvas.Y_QUARTER;
        }

        assert newCoin != null : "Unknown coin type to insert";
        newCoin.setLocation(x, y);
        coinDispenser.getSlot(selectedIndex).push(newCoin);
        Application.applicationWindow.updateWindow();
    }
}
