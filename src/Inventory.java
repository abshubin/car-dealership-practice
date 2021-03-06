/**
 * Created by Andrew Shubin on 9/21/16.
 */

import java.io.Serializable;
import java.util.*;
import java.text.*;

public class Inventory implements Serializable {
    private List<Vehicle> inv;

    public Inventory() {
        inv = new ArrayList<Vehicle>();
    }

    public void add(Vehicle v) {
        inv.add(v);
    }

    public void remove(Vehicle v) {
        if (!isEmpty()) {
            inv.remove(v);
        }
    }

    public Vehicle findCheapestVehicle() {
        if (isEmpty()) {
            return null;
        }
        Vehicle cheapest = inv.get(0);
        for (Vehicle v : inv) {
            if ( v.getPrice() < cheapest.getPrice() ) {
                cheapest = v;
            }
        }
        return cheapest;
    }

    public Vehicle findMostExpensiveVehicle() {
        if (isEmpty()) {
            return null;
        }
        Vehicle mostExp = new Vehicle(null, 0, false, 0, 0);
        for (Vehicle v : inv) {
            if ( v.getPrice() > mostExp.getPrice() ) {
                mostExp = v;
            }
        }
        return mostExp;
    }

    public void printAveragePriceOfAllVehicles() {
        if (!isEmpty()) {
            double sum = 0;
            int n = 0;
            for (Vehicle v : inv) {
                sum += v.getPrice();
                n++;
            }
            String ave = new DecimalFormat("#.##").format(sum / (double) n);
            System.out.print("$" + ave);
        }
    }

    private boolean isEmpty() {
        boolean empty = inv.isEmpty();
        if (empty) {
            System.out.println("Inventory is empty...");
        }
        return empty;
    }
}
