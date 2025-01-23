public class Static_NonStaticVar 
{
    static int staticVar = 0;
    int nonStaticVar = 0;

    public Static_NonStaticVar() 
    {
        staticVar++;
        nonStaticVar++;
    }
    public void displayValues() 
    {
        System.out.println("Static Variable (shared): " + staticVar);
        System.out.println("Non-Static Variable (unique): " + nonStaticVar);
    }

    public static void main(String[] args) 
    {
        Static_NonStaticVar obj1 = new Static_NonStaticVar();
        System.out.println("After creating obj1:");
        obj1.displayValues();

        Static_NonStaticVar obj2 = new Static_NonStaticVar();
        System.out.println("\nAfter creating obj2:");
        obj2.displayValues();

        Static_NonStaticVar obj3 = new Static_NonStaticVar();
        System.out.println("\nAfter creating obj3:");
        obj3.displayValues();
    }
}
