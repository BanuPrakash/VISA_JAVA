public class CharThread implements  Runnable{
    @Override
    public void run() {
        for(int i = 65; i < 500; i++) {
            System.out.println((char) i);
        }
    }
}
