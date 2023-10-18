package KindsOfAnimals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Cat cat1 = new Cat("Peter P. Pedersen");

        cat1.playing();



        Scanner scanner = new Scanner(System.in);

        Animal animal = null;

       do {
        System.out.println("Which animal do you wish to create? Dog or Cat?");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Dog")){
            System.out.println("What do you wish to name the dog?");
            String doggieName = scanner.nextLine();
            animal = new Dog(doggieName);
        } else if (answer.equalsIgnoreCase("Cat")) {
            System.out.println("What do you wish to name the cat?");
            String cattieName = scanner.nextLine();
            animal = new Cat(cattieName);
        } else {
            System.out.println("Invalid!!!");
        }
    } while (animal == null);
    }




}
