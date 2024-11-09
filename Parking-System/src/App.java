package src;

import src.Car;
import src.Gate;
import src.Parking;

// Add your package here
public class App {
    public static void main(String[] args) {
        // Create a parking lot with 3 spots
        Parking parkingsLot = new Parking(3);

        // Create gates (threads)
        Gate gate1 = new Gate(parkingsLot);
        Gate gate2 = new Gate(parkingsLot);
        Gate gate3 = new Gate(parkingsLot);

        // Add cars to the queue at each gate
        gate1.addCarToQueue(new Car("Car1", 1, 5));
        gate1.addCarToQueue(new Car("Car2", 2, 3));
        gate2.addCarToQueue(new Car("Car3", 1, 4));
        gate2.addCarToQueue(new Car("Car4", 3, 2));

        // Start the gates (threads)
        gate1.start();
        gate2.start();
        gate3.start();

        try {
            // Wait for all gates to finish processing
            gate1.join();
            gate2.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

