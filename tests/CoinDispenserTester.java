package tests;

import model.CoinDispenser;
import model.Dime;
import model.Nickel;
import model.Quarter;

public class CoinDispenserTester 
{
    public static void main(String[] args)
    {
        CoinDispenser coinDispenser = new CoinDispenser(5, 6, 4);
        
        coinDispenser.insert(new Dime());
        coinDispenser.insert(new Dime());
        coinDispenser.insert(new Dime());

        coinDispenser.insert(new Quarter());
        coinDispenser.insert(new Quarter());

        coinDispenser.insert(new Nickel());
        coinDispenser.insert(new Nickel());
        coinDispenser.insert(new Nickel());
        coinDispenser.insert(new Nickel());
        coinDispenser.insert(new Nickel());
        coinDispenser.insert(new Nickel());

        assert coinDispenser.getDimeCount() == 3;
        assert coinDispenser.getQuarterCount() == 2;
        assert coinDispenser.getNickelCount() == 5;

        coinDispenser.removeCoinByValue(Nickel.VALUE);

        assert coinDispenser.getNickelCount() == 4;
    }
}
