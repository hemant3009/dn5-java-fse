public class factoryDemo{
   public static void main(String[] args) {
       Shape s1 = shapeFactory.getShape("circle");
       s1.draw();

       Shape s2 = shapeFactory.getShape("rectangle");
       s2.draw();
   }
}