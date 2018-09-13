import java.util.Arrays;

public class Human {
    private Head head;
    private Leg[] legs;
    private Hand[] hands;
    private int amountLeg, amountHand;
    private double growth, weight;
    Human(){
        growth = 180.0;
        weight = 70.0;
        amountHand = 2;
        amountLeg = 2;
        head = new Head();
        legs = new Leg[amountLeg];
        hands = new Hand[amountHand];
    }

    Human(int amountHand, int amountLeg){
        this();
        this.amountHand = amountHand;
        hands = new Hand[amountHand];
        this.amountLeg = amountLeg;
        legs = new Leg[amountLeg];
    }

    Human(double growth, double weight){
        this();
        this.growth = growth;
        this.weight = weight;
    }

    Human(int amountHand, int amountLeg, double growth, double weight) {
        this.growth = growth;
        this.weight = weight;
        this.amountHand = amountHand;
        this.amountLeg = amountLeg;
        head = new Head();
        legs = new Leg[amountLeg];
        hands = new Hand[amountHand];
    }

    Human(Human human){
        setGrowth(human.getGrowth());
        setWeight(human.getWeight());
        setAmountHand(human.getAmountHand());
        setAmountLeg(human.getAmountLeg());
        setHead(human.getHead());
        setHands(human.getHands());
        setLegs(human.getLegs());
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAmountHand(int amountHand) {
        this.amountHand = amountHand;
        hands = new Hand[amountHand];
        for (int i = 0; i < hands.length; i++)
            hands[i] = new Hand();
    }

    public void setAmountLeg(int amountLeg) {
        this.amountLeg = amountLeg;
        legs = new Leg[amountLeg];
        for (int i = 0; i < legs.length; i++)
            legs[i] = new Leg();
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void setHands(Hand[] hands) {
        this.hands = hands;
    }

    public void setLegs(Leg[] legs) {
        this.legs = legs;
    }

    public void setParts(Head head, Hand[] hands, Leg[] legs){
        setHead(head);
        setHands(hands);
        setLegs(legs);
    }

    public double getGrowth() {
        return growth;
    }

    public double getWeight() {
        return weight;
    }

    public int getAmountHand() {
        return amountHand;
    }

    public int getAmountLeg() {
        return amountLeg;
    }

    public Head getHead() {
        return head;
    }

    public Hand[] getHands() {
        return hands;
    }

    public Leg[] getLegs() {
        return legs;
    }

    public boolean isFat(){
        if (weight > growth-110)
            return true;
        else
            return false;
    }

    public boolean isBlind(){
        if (head.getEyes() == 0)
            return true;
        else
            return false;
    }

    public boolean isDeaf(){
        if (head.getEars() == 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        String string = new String("Рост: " + growth + " | Вес: " + weight + " | Количество рук: " + amountHand + " | Количество ног:  " + amountLeg + "\n");
        string += head;
        for (Leg i : legs)
            string += i;
        for (Hand i : hands)
            string += i;
        return string;
    }
}

abstract class Limb{
    protected int fingers;
    protected double length;
    protected double[] lengthFingers;
    Limb(){
        fingers = 5;
        length = 100.0;
        lengthFingers = new double[fingers];
        for (int i = 0; i < lengthFingers.length; i++)
            lengthFingers[i] = 2.0 + i;
    }

    Limb(int fingers){
        this.fingers = fingers;
        lengthFingers = new double[fingers];
        for (int i = 0; i < lengthFingers.length; i++)
            lengthFingers[i] = 2.0 + i;
    }

    Limb(double length){
        this();
        this.length = length;
    }

    Limb(int fingers, double length, double[] lengthFingers){
        this.fingers = fingers;
        this.length = length;
        this.lengthFingers = lengthFingers;
    }

    Limb(Limb a){
        setFingers(a.getFingers());
        setLength(a.getLength());
        setLengthFingers(a.getLengthFingers());
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setLengthFingers(double[] lenth) {
       this.lengthFingers = lenth;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
        lengthFingers = new double[this.fingers];
    }

    public int getFingers() {
        return fingers;
    }

    public double[] getLengthFingers() {
        return lengthFingers;
    }

    public double getLength() {
        return length;
    }
}

class Leg extends  Limb{
    Leg(){ super(); }
    Leg(int k){ super(k);}
    Leg(double k){ super(k);}
    Leg(int k, double l, double[] a){ super(k, l, a);}
    Leg(Leg a){ super(a);}

    @Override
    public String toString() {
        String string = new String("Длина Ноги: " + length + " | Количество пальцев на ноге: " + fingers + "\nДлины пальцев: " );
        for (double i : lengthFingers)
            string += i + " ";
        string += "\n";
        return string;
    }
}

class Hand extends Limb{
    Hand(){ super(); }
    Hand(int k){ super(k);}
    Hand(double k){ super(k);}
    Hand(int k, double l, double[] a){ super(k, l, a);}
    Hand(Hand a){ super(a);}

    @Override
    public String toString() {
        String string = new String("Длина Руки: " + length + " | Количество пальцев на руке: " + fingers + "\nДлины пальцев: " );
        for (double i : lengthFingers)
            string += i + " ";
        string += "\n";
        return string;
    }
}

class Head{
    private  int eyes, ears;

    Head(){
        eyes = 2;
        ears = 2;
    }

    Head(int eyes, int ears){
        this.eyes = eyes;
        this.ears = ears;
    }

    public void setEars(int ears) {
        this.ears = ears;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getEars() {
        return ears;
    }

    public int getEyes() {
        return eyes;
    }

    @Override
    public String toString() {
        String string = new String("Зрящих глаз: " + eyes + " | Слышащих ушей: " + ears + "\n");
        return string;
    }
}
