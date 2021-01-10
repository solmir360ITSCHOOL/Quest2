package net.rsnode.quest;

public class Situation {
    Situation[] direction;
    String subject, text;
    int dPower, dHealth, dMoney;

    public Situation (String subject, String text, int variants, int dPower, int dHealth, int dMoney) {
        this.subject = subject;
        this.text = text;
        this.dPower = dPower;
        this.dHealth = dHealth;
        this.dMoney = dMoney;
        direction = new Situation[variants];
    }
}