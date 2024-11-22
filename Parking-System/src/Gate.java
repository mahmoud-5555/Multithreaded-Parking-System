package src;

import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gate extends Thread {
    private Parking parkingLot;
    private PriorityQueue<Car> sharedQueue;  // Shared priority queue of cars waiting
    private String filePath;

    public Gate(Parking parkingLot, PriorityQueue<Car> sharedQueue, String filePath) {
        this.parkingLot = parkingLot;
        this.sharedQueue = sharedQueue;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                int gateNumber = Integer.parseInt(parts[0].split(" ")[1]);
                String carName = parts[1].split(" ")[1];
                int arriveTime = Integer.parseInt(parts[2].split(" ")[1]);
                int parkTime = Integer.parseInt(parts[3].split(" ")[1]);

                Car car = new Car(carName, arriveTime, parkTime, gateNumber);
                synchronized (sharedQueue) {
                    sharedQueue.offer(car);
                    sharedQueue.notifyAll();
                }
                System.out.println("Car " + carName + " from Gate " + gateNumber + " arrived at time " + arriveTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}