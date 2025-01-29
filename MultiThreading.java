/*
New: The thread has been created but the start() method has not yet been called. 
Runnable: The thread is eligible to run and is waiting for its turn based on the JVM's scheduling algorithm. 
Running: A sub-state of the Active state. 
Blocked: The thread is temporarily inactive and is waiting for a signal to proceed. 
Waiting: The thread is waiting for a specific condition to be met so it can synchronize its execution with other threads. 
Timed Waiting: The thread is waiting for a specified period of time. 
Terminated: The thread's run() method has completed or an uncaught exception occurred. 
Thread class static method
sleep()
yield()
currentThread()

 * wait()
Purpose: Causes the current thread to wait until another thread invokes notify() or notifyAll() 
on the same object.
Used with: Synchronized blocks or methods (must hold the object's monitor).
Throws: IllegalMonitorStateException if not in a synchronized context

notifyAll()
Purpose: Wakes up all threads waiting on the object's monitor.
Used with: Synchronized blocks or methods.

threadObj.join()
This implies that no further instruction siwll be executed unless threadObj is finished.
If threadobj

 yield():

The yield() method pauses the execution of current thread and allows another thread of equal or higher priority 
that are waiting to execute. Currently executing thread give up the control of the CPU.

 */
class InterruptExample extends Thread {
    public void run() {
        // here as interpput is called in the main method even if the thread is sleeping
        // as it is interrputed expection is thrown
        try {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " finished.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}

class YieldExample extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield(); // Yielding control
        }
    }
}

class ThreadJoining extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(5000);
                System.out.println("Current Thread: "
                        + Thread.currentThread().getName());
            }

            catch (Exception ex) {
                System.out.println("Exception has" +
                        " been caught" + ex);
            }
            System.out.println(i);
        }
    }
}

class NotifyAllExample {
    private final Object lock = new Object();

    public void waitForSignal() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                System.out.println(Thread.currentThread().isDaemon());// false
                System.out.println(Thread.currentThread().isInterrupted());// false
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " resumed.");
        }
    }

    public void signalAll() {
        synchronized (lock) {
            System.out.println("Notifying all threads...");
            lock.notifyAll();
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        NotifyAllExample example = new NotifyAllExample();

        // Runnable is a functional interafec it has only method run
        // So we can provide implmentation to it as shown below
        Thread t1 = new Thread(example::waitForSignal, "Thread-1");
        Thread t2 = new Thread(example::waitForSignal, "Thread-2");

        // here bith the threads have actuireed lock on the lock object and after wait
        // have released the
        // lock are waiting to get the control back
        t1.start();
        t2.start();

        Thread.sleep(1000);
        new Thread(example::signalAll).start();

        // this is an example of join
        // here the main thread waits till t11 has finised its compltes execution
        // then only its will resume running
        ThreadJoining t11 = new ThreadJoining();
        ThreadJoining t21 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        // thread t1 starts
        t11.start();

        // starts second thread after when
        // first thread t1 has died.
        try {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            t11.join();
        }

        catch (Exception ex) {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        // t2 starts
        t21.start();

        // starts t3 after when thread t2 has died.
        try {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            t21.join();
        }

        catch (Exception ex) {
            System.out.println("Exception has been" +
                    " caught" + ex);
        }

        // t3 starts
        t3.start();

        // After t2 has dead, t3 starts
        try {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            t3.join();
        }

        catch (Exception ex) {
            System.out.println("Exception has been" +
                    " caught" + ex);
        }
        System.out.println("NISHAD");

        // Interrupt example
        InterruptExample thread = new InterruptExample();
        thread.start();

        Thread.sleep(2000); // Main thread sleeps
        thread.interrupt(); // Interrupt the thread
    }
}
