import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterviewEvaluator {
    private static Queue<Person> personQueue;
    private static Scanner scanner;

    public InterviewEvaluator() {
        personQueue = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        InterviewEvaluator app = new InterviewEvaluator();

        while (true) {
            System.out.println("\n1. Add people\n2. Get canditate details\n3. Start InterviewEvaluator\n4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {

                switch (choice) {
                    case "1":
                        app.addPersons();
                        break;
                    case "2":
                        app.printDetails();
                        break;
                    case "3":
                        app.startInterviews();
                        break;
                    case "4":
                        System.out.println("Exiting the program.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2,3,or 4");
                }
            } catch (NumberFormatException e) {
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
        Scanner sc = new Scanner(System.in);

        while (!personQueue.isEmpty()) {
            Person currentCandidate = personQueue.poll();
            System.out.println("Interviewing " + currentCandidate.getName() + "...");

            Future<?> future = executor.submit(() -> {
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 7000) {
                    String s = sc.nextLine();
                    if (s.trim().equalsIgnoreCase("add")) {
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

            System.out.println("InterviewEvaluator finished with " + currentCandidate.getName());
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
        while (true) {
            try {
                System.out.print("Enter person's age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                Person person = new Person(name, age);
                personQueue.add(person);
                break;
            } catch (Exception e) {
                System.out.println("Invalid age input. Please enter a valid age (must be a number):");

                scanner.nextLine();
            }
        }

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
