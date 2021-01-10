package net.rsnode.quest;

public class Character {
    public int Health;
    public int Power;
    public int Money;
    public String name;

    public Character(String name) {
        Health = 100;
        Power = 100;
        Money = 0;
        this.name = name;
    }
}
