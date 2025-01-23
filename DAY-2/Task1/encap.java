class encap 
{
    private int age;
    
    public void setAge(int age) 
    {
        if (age > 0 && age < 150) 
        {
            this.age = age;
            if (age >= 18) 
            {
                System.out.println("Age set to: " + age);
                System.out.println("You are eligible to vote.");
            }
            else 
            {
                System.out.println("Age set to: " + age);
                System.out.println("You are not eligible to vote.");
            }            
        } 
        else 
        {
            System.out.println("Invalid age. Age must be a positive number and less than 150.");
        }
    }
    
    public int getAge() 
    {
        return age;
    }
    public static void main(String[] args) 
    {
        encap voter = new encap();
        voter.setAge(20);
        voter.setAge(16);
        voter.setAge(-5);
        voter.setAge(200);
    }
}