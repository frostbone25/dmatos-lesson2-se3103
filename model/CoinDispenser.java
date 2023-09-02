package model;

import java.util.ArrayList;
import java.util.Stack;

public class CoinDispenser 
{
    public static final int SLOT_NICKELS = 0;
    public static final int SLOT_DIMES = 1;
    public static final int SLOT_QUARTERS = 2;

    private final ArrayList<Stack<Coin>> slots = new ArrayList<>(3);

    public final int maxNickels;
    public final int maxDimes;
    public final int maxQuarters;

    public int selectedSlotIndex = 0;

    public CoinDispenser(int maxNickels, int maxDimes, int maxQuarters)
    {
        this.maxNickels = maxNickels;
        this.maxDimes = maxDimes;
        this.maxQuarters = maxQuarters;

        slots.add(new Stack<Coin>());
        slots.add(new Stack<Coin>());
        slots.add(new Stack<Coin>());
    }

    public void insert(Coin c)
    {
        int slotIndex = -1;

        if(c instanceof Nickel)
        {
            assert getNickelCount() < maxNickels : "Nickel slot is full";

            slotIndex = SLOT_NICKELS;
        }
        else if(c instanceof Dime) 
        {
            assert getDimeCount() < maxDimes : "Dime slot is full";

            slotIndex = SLOT_DIMES;
        }
        else if(c instanceof Quarter)
        {
            assert getQuarterCount() < maxQuarters : "Quarter slot is full";

            slotIndex = SLOT_QUARTERS;
        }

        assert slotIndex >= 0 : "Wrong slot index to insert a coin";

        slots.get(slotIndex).push(c);
    }

    public void removeCoinByValue(int coinValue)
    {
        int slotIndex = - 1;

        switch(coinValue)
        {
            case Nickel.VALUE:
                assert getNickelCount() > 0 : "Nickel slot is empty";
                slotIndex = SLOT_NICKELS;
                break;
            case Dime.VALUE:
                assert getDimeCount() > 0 : "Dime slot is empty";
                slotIndex = SLOT_DIMES;
            case Quarter.VALUE:
                assert getQuarterCount() > 0 : "Quarter slot is empty";
                slotIndex = SLOT_QUARTERS;
        }

        assert slotIndex >= 0 : "Unknown coin value to remove";
        slots.get(slotIndex).pop();
    }

    public Stack<Coin> getSlot(int index)
    {
        return slots.get(index);
    }

    public int getNickelCount()
    {
        return slots.get(SLOT_NICKELS).size();
    }

    public int getDimeCount()
    {
        return slots.get(SLOT_DIMES).size();
    }

    public int getQuarterCount()
    {
        return slots.get(SLOT_QUARTERS).size();
    }

    public int getBalance()
    {
        int balance = 0;

        balance += getNickelCount() * Nickel.VALUE;
        balance += getDimeCount() * Dime.VALUE;
        balance += getQuarterCount() * Quarter.VALUE;

        return balance;
    }
}
