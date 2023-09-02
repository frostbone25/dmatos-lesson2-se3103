package model;

public abstract class Coin
{
    private int value;
    private int size;

    public Coin(int value, int size)
    {
        this.value = value;
        this.size = size;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int newValue)
    {
        this.value = newValue;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}