class Data {
    private int value;
    private boolean available = false;

    synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.value = value;
        available = true;

        System.out.println("Producer produced: " + value);

        notifyAll();
    }

    synchronized int consume(String name) {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int result = value;
        available = false;

        System.out.println(name + " consumed: " + result);

        notifyAll();

        return result;
    }
}

class Producer extends Thread {
    private Data data;

    Producer(Data data) {
        this.data = data;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.produce(i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private Data data;
    private String name;

    Consumer(Data data, String name) {
        this.data = data;
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.consume(name);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Data data = new Data();

        Producer producer = new Producer(data);

        Consumer consumer1 = new Consumer(data, "Consumer 1");
        Consumer consumer2 = new Consumer(data, "Consumer 2");

        System.out.println("Inter-Thread Communication Started");

        producer.start();
        consumer1.start();
        consumer2.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All threads completed.");
    }
}
