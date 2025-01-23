public class Volatile_multithreading 
{
    static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException 
    {
        Thread writer = new Thread(() -> 
        {
            try 
            {
                Thread.sleep(1000); // Simulate some work
            } 
            catch (InterruptedException e) 
            {
                Thread.currentThread().interrupt();
            }
            flag = true;
            System.out.println("Writer thread: flag is set to true");
        });

        Thread reader = new Thread(() -> {
            while (!flag) 
            {
                
            }
            System.out.println("Reader thread: flag is now true");
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }
}