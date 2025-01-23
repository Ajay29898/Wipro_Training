public class ConstVar_StaticFinal
{
    // Constant for Pi
    static final double PI = 3.14159;

    public static void main(String[] args) 
    {
        
        double radius = 7.0;
        double area = PI * radius * radius;
        double circumference = 2 * PI * radius;

        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }
}