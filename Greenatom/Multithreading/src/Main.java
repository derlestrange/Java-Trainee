public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Testing(), "Runnable");
        thread.start();
        for (; ; ) {
            System.out.println("main (1000)");
            Thread.sleep(1000);
        }
    }
}
