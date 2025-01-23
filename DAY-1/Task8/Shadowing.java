public class Shadowing 
{
    int num = 10;

    public void methodLevelShadowing() 
    {
        int num = 20;

        System.out.println("Inside methodLevelShadowing - Local num: " + num);  
        System.out.println("Inside methodLevelShadowing - Instance num: " + this.num);
    }

    public void blockLevelShadowing() 
    {
        int num = 30;

        {
            int num1 = 40; 
            System.out.println("Inside blockLevelShadowing - Block-level num: " + num1);
        }

        System.out.println("Inside blockLevelShadowing - Method-level num: " + num);  
        System.out.println("Inside blockLevelShadowing - Instance num: " + this.num); 
    }

    public static void main(String[] args) 
    {
        Shadowing obj = new Shadowing();

        obj.methodLevelShadowing();

        obj.blockLevelShadowing();
    }
}
