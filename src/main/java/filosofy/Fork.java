package filosofy;

public class  Fork {
    private volatile boolean fork;

    public boolean isFork() {
        return fork;
    }

    public  void setFork(boolean fork) {
        this.fork = fork;
    }
}
