package main.java.com.mkaloshyn.javacore.chapter05.habr;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {

    private List<Ship> store;
    private static final int maxShipsInTunnel = 5;
    private static final int minShipsInTunnel = 0;
    private int shipsCounter = 0;

    public Tunnel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Ship element) {

        try {
            if (shipsCounter < maxShipsInTunnel) {
                notifyAll();
                store.add(element);
                String info = String.format("%s + the ship arribed to the tunnel: %s %s %s",
                        store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;
            } else {
                System.out.println("There is no place for ship in the tunnel: " + Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ship get(Type shipType) {
        try {
            if (shipsCounter > minShipsInTunnel) {
                notifyAll();
                for (Ship ship : store) {
                    if (ship.getType() == shipType) {
                        shipsCounter--;
                        System.out.println(store.size() + "the ship is taken off from the tunnel: " +
                                Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }
                }
            }

            System.out.println("There are no ships in the tunnel");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }



}
