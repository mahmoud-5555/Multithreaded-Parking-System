
public class Gate extends Thread {
    private Parking parkingLot;
    private PriorityQueue<Car> queue;  // Priority queue of cars waiting

    public Gate(Parking parkingLot) {
        this.parkingLot = parkingLot;
        this.queue = new PriorityQueue<>();  // By default, it will prioritize by arrival time
    }

    public synchronized void addCarToQueue(Car car) {
        queue.offer(car);  // Add car to the queue
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            Car car = queue.poll();  // Get the car with the highest priority (earliest arrival)
            if (!parkingLot.isFull()) {
                parkingLot.parkCar(car);  // Park the car in an available slot
            } else {
                System.out.println("Parking full, " + car.getName() + " can't park yet.");
            }
        }
    }
}