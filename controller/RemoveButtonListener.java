package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CoinDispenser;

public class RemoveButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        CoinDispenser coinDispenser = Application.coinDispenser;
        int selectedIndex = coinDispenser.selectedSlotIndex;
        assert 0 <= selectedIndex && selectedIndex <= 2 : "Invalid coin slot to remove";
        assert coinDispenser.getSlot(selectedIndex).size() > 0 : "Empty coin slot: error to remove";
        coinDispenser.getSlot(selectedIndex).pop();
        Application.applicationWindow.updateWindow();
    }
}