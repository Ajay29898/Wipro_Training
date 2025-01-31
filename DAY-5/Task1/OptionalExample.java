import java.util.Optional;

public class OptionalExample 
{
    public static void main(String[] args) 
    {
        String value1 = null;
        Optional<String> optional1 = Optional.ofNullable(value1);
        System.out.println("Optional.ofNullable(): " + optional1.orElse("Value is null"));

        String value2 = "Hello, World!";
        Optional<String> optional2 = Optional.ofNullable(value2);
        System.out.println("Optional.ofNullable() with non-null: " + optional2.get());


        String value3 = "Java";
        Optional<String> optional3 = Optional.of(value3);
        System.out.println("Optional.of(): " + optional3.get());

        try 
        {
            String value4 = null;
            Optional<String> optional4 = Optional.of(value4); 
            System.out.println("Optional.of(): " + optional4.get());
        } 
        catch (NullPointerException e) 
        {
            System.out.println("Optional.of() throws NullPointerException when the value is null");
        }
    }
}
