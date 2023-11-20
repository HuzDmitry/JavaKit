package filosofy;

public class Filosof extends Thread{
    private Fork leftFork;
    private Fork richtFork;
    private String name;

    Filosof(String name, Fork leftFork, Fork richtFork){
        this.leftFork = leftFork;
        this.richtFork = richtFork;
        this.name = name;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag){
            if (leftFork.isFork() || richtFork.isFork()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                leftFork.setFork(true);
                richtFork.setFork(true);
            }
        };
    }
}
