import java.util.ArrayList;

public class Main {


    public static void main(String[] args){

        ArrayList<Shape> s = new ArrayList<Shape>();

        s.add(new Rectangle("A"));
        s.add(new Rectangle("B"));
        s.add(new Cylinder("C"));
        s.add(new Circle("D"));
        s.add(new Rectangle("E"));
        s.add(new Rectangle("F"));
        s.add(new Circle("G"));
        s.add(new Cylinder("H"));
        s.add(new Cylinder("I"));
        s.add(new Rectangle("J"));
        s.add(new Cylinder("K"));
        s.add(new Circle("L"));


        for (int i =0; i<s.size();i++){

            s.get(i).Draw();

        }
    }


}
