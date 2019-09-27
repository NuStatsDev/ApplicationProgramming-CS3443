public abstract class Shape {
private static int shapeCount =1;
protected String Name="";

        Shape(String name){
        Name = name+" "+shapeCount;
        shapeCount++;
        }
        abstract void Draw();
}
