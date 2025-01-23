public class Final_Var
 {
    final int instanceVar = 100;

    public void FinalVar() 
    {
        final int localVar = 50;
        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Local Variable: " + localVar);

        // instanceVar = 200; // Error: Cannot assign a value to final variable
        // localVar = 60;     // Error: Cannot assign a value to final variable
    }

    public static void main(String[] args) 
    {
        Final_Var example = new Final_Var();
        example.FinalVar();
    }
}
