public class Var_Scope
{
    int instanceVar = 10;

    static int staticVar = 20;

    public void methodScope() 
    {
        int localVar = 30;

        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
        System.out.println("Local Variable: " + localVar);

        if (true) 
        {
            int blockVar = 40; 
            System.out.println("Block Variable: " + blockVar);
        }
    }

    public static void main(String[] args) 
    {
        System.out.println("Static Variable in main: " + staticVar);

        Var_Scope obj = new Var_Scope();
        obj.methodScope();

        System.out.println("Instance Variable in main (via object): " + obj.instanceVar);
    }
}