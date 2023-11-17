import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    private Queue<Person> personQueue;
    private static Scanner scanner;

    public App() {
        personQueue = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        App app = new App();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add people\n2. Get next person\n3. Start Interview\n4. Exit");
            System.out.print("Enter your choice: ");
            String c = scanner.nextLine();
            
            try{
                int choice=Integer.parseInt(c);
            switch (choice) {
                case 1:
                    app.addPersons();
                    break;
                case 2:
                    app.printDetails();
                    break;
                case 3:
                    app.startInterviews();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2,3,or 4");
            }
        }catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a number");
        }
        
        }
    }

    public void startInterviews() {
        if (personQueue.isEmpty()) {
            System.out.println("No candidates in the queue!");
            return;
        }
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (!personQueue.isEmpty()) {
            Person currentCandidate = personQueue.poll();
            System.out.println("Interviewing " + currentCandidate.getName() + "...");
           Future<?> future= executor.submit(() -> {
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 7000) {
                      String s=scanner.next();
                    if ( s.trim().equalsIgnoreCase("add")) {
                        addPerson();
                    }
                }
            });

            try {
                Thread.sleep(7000);
                 future.cancel(true);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                  
            System.out.println("Interview finished with " + currentCandidate.getName());
        }
        executor.shutdownNow();
        

    }

    public void addPersons() {
        while (true) {
            System.out.println("\nEnter details of the canditate:");
            addPerson();
            System.out.print("Add another person? (y/n): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void addPerson() {
        System.out.print("Enter person's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter person's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Person person = new Person(name, age);
        personQueue.add(person);
    }

    public void printDetails() {
        if (personQueue.isEmpty()) {
            System.out.println("No Canditates are available!....");
            return;
        }
        System.out.println("\nDetails of people in the queue:");
        for (Person person : personQueue) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }

}
