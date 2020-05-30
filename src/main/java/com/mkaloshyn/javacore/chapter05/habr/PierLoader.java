package main.java.com.mkaloshyn.javacore.chapter05.habr;

public class PierLoader implements Runnable {
    private Tunnel tunnel;
    private Type shipType;

    public PierLoader(Tunnel tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType = shipType;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Loader " + shipType);
                Thread.sleep(500);//time to load the goods
                Ship ship = tunnel.get(shipType);
                if (ship != null) {
                    while (ship.loadingCheck()) {
                        Thread.sleep(100);
                        ship.add(10);
                        System.out.println(ship.getLoading() + " loaded ship. " + Thread.currentThread().getName());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

