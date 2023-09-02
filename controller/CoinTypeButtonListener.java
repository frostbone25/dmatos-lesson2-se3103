package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Coin;
import model.CoinDispenser;
import view.ApplicationWindow;

public class CoinTypeButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        String label = "dim";
        label = label + "e";

        if(command.equals(label))
        {
            System.out.println("dime selected");
        }
        else
        {
            System.out.println("dime is not selected");
        }

        int slotIndex = -1;

        switch(event.getActionCommand())
        {
            case ApplicationWindow.radioButtonActionNickel:
                slotIndex = CoinDispenser.SLOT_NICKELS;
                break;
            case ApplicationWindow.radioButtonActionDime:
                slotIndex = CoinDispenser.SLOT_DIMES;
                break;
            case ApplicationWindow.radioButtonActionQuarter:
                slotIndex = CoinDispenser.SLOT_QUARTERS;
                break;
        }

        assert slotIndex < 0 : "Unknown slot index for a coin type";
        Application.coinDispenser.selectedSlotIndex = slotIndex;
        Application.applicationWindow.updateWindow();
    }
}
