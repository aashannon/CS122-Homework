public class Garage {
    Car onLft;
    Car onRgt;

    void setLft(Car l){
        l.year -= 5;
        onLft = l;
    }

    void setOnRgt(Car r){
        onRgt = r;
    }

    public static void main(String[] args){
        Garage g = new Garage();

        Car c = new Car(1990);
        Car d = new Car(2000);

        System.out.println("Year: " + c.year);
        g.setLft(c);
        System.out.println("Year: " + c.year);

        g.setOnRgt(d);

    }
}
