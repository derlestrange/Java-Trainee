public class Testing implements Runnable {
    @Override
    public void run() {
        for(;;){
            try {
                System.out.println("5000");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("10000");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}