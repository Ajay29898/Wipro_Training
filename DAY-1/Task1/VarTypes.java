public class VarTypes 
{
    int a=10;
    static int b=20;

    public void Local_var()
    {
        int c=30;
        System.out.println(c);
    }

    public static void main(String args[])
    {
        VarTypes obj1 = new VarTypes();
        obj1.Local_var();

        VarTypes obj2 = new VarTypes();
        System.out.println(obj2.a);

        System.out.println(VarTypes.b);
    }
}
