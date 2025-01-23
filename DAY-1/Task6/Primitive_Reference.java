public class Primitive_Reference 
{
    public static void main(String[] args) 
    {
        int num1 = 10;
        int num2 = num1;  
        num2 = 20; 

        System.out.println("Primitive Variables:");
        System.out.println("num1: " + num1); 
        System.out.println("num2: " + num2);

        String str1 = "Hello";
        String str2 = str1;
        str2 = "World"; 

        System.out.println("\nReference Variables:");
        System.out.println("str1: " + str1); 
        System.out.println("str2: " + str2);
    }
}