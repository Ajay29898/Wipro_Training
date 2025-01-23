public class Exception 
{
    public static void validateAge(int age) throws IllegalArgumentException 
    {
        if (age < 18) 
        {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) 
    {
        try 
        {
            validateAge(16); 
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Caught exception: " + e.getMessage());
        } 
        finally 
        {
            System.out.println("This will always execute, whether an exception occurred or not.");
        }
    }
}
        