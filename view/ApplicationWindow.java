package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument.Content;

import controller.Application;
import controller.CoinTypeButtonListener;
import controller.InsertButtonListener;
import controller.RemoveButtonListener;
import model.CoinDispenser;

public class ApplicationWindow extends JFrame
{
    public static final String radioButtonActionNickel = "nickel";
    public static final String radioButtonActionDime = "dime";
    public static final String radioButtonActionQuarter = "quarter";
    public static final String buttonActionInsert = "Insert";
    public static final String buttonActionRemove = "Remove";

    private ApplicationCanvas applicationCanvas = new ApplicationCanvas();
    private JButton insertButton;
    private JButton removeButton;

    public void initalize()
    {
        Container contentPane = getContentPane();
        contentPane.add(applicationCanvas, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        contentPane.add(southPanel, BorderLayout.SOUTH);

        southPanel.setLayout(new GridLayout(2, 1));

        JPanel coinTypePanel = new JPanel();
        coinTypePanel.setBorder(new TitledBorder("Coin type"));

        int selectedIndex = Application.coinDispenser.selectedSlotIndex;
        JRadioButton nickelButton = new JRadioButton(radioButtonActionNickel, selectedIndex == CoinDispenser.SLOT_NICKELS);
        JRadioButton dimeButton = new JRadioButton(radioButtonActionDime, selectedIndex == CoinDispenser.SLOT_DIMES);
        JRadioButton quarterButton = new JRadioButton(radioButtonActionQuarter, selectedIndex == CoinDispenser.SLOT_QUARTERS);
        ButtonGroup coinGroup = new ButtonGroup();
        coinGroup.add(nickelButton);
        coinGroup.add(dimeButton);
        coinGroup.add(quarterButton);
        coinTypePanel.add(nickelButton);
        coinTypePanel.add(dimeButton);
        coinTypePanel.add(quarterButton);
        southPanel.add(coinTypePanel);

        CoinTypeButtonListener coinTypeButtonListener = new CoinTypeButtonListener();
        nickelButton.addActionListener(coinTypeButtonListener);
        dimeButton.addActionListener(coinTypeButtonListener);
        quarterButton.addActionListener(coinTypeButtonListener);

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(new TitledBorder("Action"));
        insertButton = new JButton(buttonActionInsert);
        removeButton = new JButton(buttonActionRemove);
        actionPanel.add(insertButton);
        actionPanel.add(removeButton);
        southPanel.add(actionPanel);

        InsertButtonListener insertButtonListener = new InsertButtonListener();
        RemoveButtonListener removeButtonListener = new RemoveButtonListener();
        insertButton.addActionListener(insertButtonListener);
        removeButton.addActionListener(removeButtonListener);

        updateWindow();
    }

    public void updateWindow()
    {
        int selectedIndex = Application.coinDispenser.selectedSlotIndex;
        int coinCount = 0;
        int maxAllowed = 0;

        switch(selectedIndex)
        {
            case CoinDispenser.SLOT_NICKELS:
                coinCount = Application.coinDispenser.getNickelCount();
                maxAllowed = Application.coinDispenser.maxNickels;
                break;
            case CoinDispenser.SLOT_DIMES:
                coinCount = Application.coinDispenser.getDimeCount();
                maxAllowed = Application.coinDispenser.maxDimes;
                break;
            case CoinDispenser.SLOT_QUARTERS:
                coinCount = Application.coinDispenser.getQuarterCount();
                maxAllowed = Application.coinDispenser.maxQuarters;
                break;
        }

        insertButton.setEnabled(coinCount < maxAllowed);
        removeButton.setEnabled(coinCount > 0);
        
        applicationCanvas.repaint();
    }
}
