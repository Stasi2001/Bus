import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus();
        bus1.addPassenger(new Passenger("Алиса", 25, 60.5));
        bus1.addPassenger(new Passenger("Боб", 30, 70.2));

        Bus bus2 = new Bus();
        bus2.addPassenger(new Passenger("Вася", 35, 80.1));
        bus2.addPassenger(new Passenger("Диана", 40, 55.3));

        List<Bus> buses = new ArrayList<>();
        buses.add(bus1);
        buses.add(bus2);

        // Сортировка автобусов по суммарному весу пассажиров
        buses.sort(Comparator.comparingDouble(Bus::getTotalWeight));
        System.out.println("Сортировка по суммарному весу пассажиров:");
        for (Bus bus : buses) {
            System.out.println("Общий вес шины: " + bus.getTotalWeight());
        }

        // Сортировка автобусов по медианному весу пассажиров
        buses.sort(Comparator.comparingDouble(Bus::getMedianWeight));
        System.out.println("Сортировка по медианному весу пассажиров:");
        for (Bus bus : buses) {
            System.out.println("Средний вес автобуса: " + bus.getMedianWeight());
        }
    }
}

class Passenger {
    String name;
    int age;
    double weight;

    public Passenger(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Bus {
    List<Passenger> passengers = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Passenger passenger : passengers) {
            totalWeight += passenger.weight;
        }
        return totalWeight;
    }

    public double getMedianWeight() {
        List<Double> weights = new ArrayList<>();
            for (Passenger passenger : passengers) {
            weights.add(passenger.weight);
        }
        Collections.sort(weights);
            int middle = weights.size() / 2;
            if (weights.size() % 2 == 1) {
            return weights.get(middle);
        } else {
            return (weights.get(middle - 1) + weights.get(middle)) / 2.0;
        }
    }
}

