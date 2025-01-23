
public class Default_values_InstancStatic 
{
    int instanceInt;
    double instanceDouble;
    boolean instanceBoolean;
    String instanceString;  

    static int staticInt;
    static double staticDouble;
    static boolean staticBoolean;
    static String staticString;  

    public static void main(String[] args) 
    {
        Default_values_InstancStatic obj = new Default_values_InstancStatic(); 

        System.out.println("Instance Variables:");
        System.out.println("Default value of instanceInt: " + obj.instanceInt);          
        System.out.println("Default value of instanceDouble: " + obj.instanceDouble);    
        System.out.println("Default value of instanceBoolean: " + obj.instanceBoolean);  
        System.out.println("Default value of instanceString: " + obj.instanceString);    

        System.out.println("\nStatic Variables:");
        System.out.println("Default value of staticInt: " + staticInt);                  
        System.out.println("Default value of staticDouble: " + staticDouble);            
        System.out.println("Default value of staticBoolean: " + staticBoolean);          
        System.out.println("Default value of staticString: " + staticString);    
    }
}