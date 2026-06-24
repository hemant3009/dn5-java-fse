public class SingletonDemo {
    public static void main(String[] args){
        Logger obj1 = Logger.getInstance();
        Logger obj2 = Logger.getInstance();

        System.err.println(obj1 == obj2);
    }
}
