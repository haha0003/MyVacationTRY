package KindsOfAnimals2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Animal> animals = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    final String filename = "WeAreAllAnimals";

    public static void main(String[] args) {
        new Main().run();
    }


    private void run() {
        readFile();
        Menu menu = new Menu("\nMenu: \nEnter number of choice", new String[]{
                "1. View animals",
                "2. Create new animal",
                "3. Delete animal",
                "4. End program",
                "9. Delete file\n"
        });

        boolean running = true;

        while (running) {
            menu.menuPrint();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> viewAnimals();
                case 2 -> createAnimal();
                case 3 -> deleteAnimal();
                case 4 -> running = false;
                case 9 -> deleteFile();

                default -> System.out.println("INVALID!!!");
            }
        }
    }

    public void viewAnimals(){
        for(int i = 0; i < animals.size(); i++){
            Animal animal = animals.get(i);
            String animalType = (animal instanceof Dog) ? "Dog" : "Cat";
            System.out.println("#" + i + ". " + animalType + ": " + animal.getName());
        }
    }

    public void createAnimal(){
            System.out.println("Do you want a 'dog' or a 'cat'?");
            String ans = scanner.nextLine();
            if (ans.equalsIgnoreCase("dog")){
                Dog dog;
                System.out.println("What do you wish to name the dog?");
                String name = scanner.nextLine();
                dog = new Dog();
                dog.setName(name);
                animals.add(dog);
                saveFile("Dog: ", dog);

            } else if (ans.equalsIgnoreCase("cat")){
                Cat cat;
                System.out.println("What do you wish to name the cat?");
                String name = scanner.nextLine();
                cat = new Cat();
                cat.setName(name);
                animals.add(cat);
                saveFile("Cat: ", cat);

            } else {
                System.out.println("INVALID!!!");
            }
        }

    public void deleteAnimal(){
        viewAnimals();
        System.out.println("\nEnter # you wish deleted");
        int deleted = scanner.nextInt();
        scanner.nextLine();

        if (deleted >= 0 && deleted < animals.size()){
            Animal animalDeleted = animals.remove(deleted);
            SaveFileAfterDeleteAnimal(animalDeleted);
        } else {
            System.out.println("INVALID!!!");
        }
    }


    public void SaveFileAfterDeleteAnimal(Animal animalDeleted){
        try {
            PrintWriter print = new PrintWriter(new FileWriter(filename));
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                String animalType = (animal instanceof Dog) ? "Dog" : "Cat";
                print.println(animalType + ": " + animal.getName());
            }
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void saveFile(String animalType, Animal animal){
        try {
            PrintWriter print = new PrintWriter(new FileWriter(filename, true));
            print.println(animalType + animal.getName());
            print.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            Scanner scan = new Scanner(new File("WeAreAllAnimals"));
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] part = data.split(": ");
                if (part.length == 2) {
                    String animalType = part[0];
                    String animalName = part[1];
                    Animal animal = null;
                    if (animalType.equalsIgnoreCase("Dog")) {
                        animal = new Dog();
                    } else if (animalType.equalsIgnoreCase("Cat")) {
                        animal = new Cat();
                    }
                    if (animal != null) {
                        animal.setName(animalName);
                        animals.add(animal);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteFile(){
        System.out.println("Do you really wish to delete the entire file? Y/N");
        String ans = scanner.nextLine();
        if (ans.equalsIgnoreCase("Y")){
        File file = new File("WeAreAllAnimals");
        if (file.delete()){
            System.out.println("Deleted: " + file.getName());
        } else{
            System.out.println("Failed to delete");
        }} else {
            System.out.println("File was not deleted");
        }

    }






  /*  public void readFile(){
        try {
            Scanner scan = new Scanner(new File("WeAreAllAnimals"));
            while (scan.hasNextLine()){
                String data = scan.nextLine();
                System.out.println(data);
            } scan.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }*/



}