/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progs2sb;

// File: ProgS2SB.java
import java.util.Scanner;

// File: FoodItem.java
class FoodItem {
    private int id;
    private String name;
    private double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " - R" + price;
    }
}

// Subclasses for inheritance
class Starter extends FoodItem {
    public Starter(int id, String name, double price) {
        super(id, name, price);
    }
}

class MainCourse extends FoodItem {
    public MainCourse(int id, String name, double price) {
        super(id, name, price);
    }
}

class Dessert extends FoodItem {
    public Dessert(int id, String name, double price) {
        super(id, name, price);
    }
}
/******************Main Method underneath */

public class ProgS2SB {
    private static FoodItem[] menu = new FoodItem[50]; // advanced array (array of objects)
    private static int count = 0; // track menu size

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("🍴 Welcome to EvoLabs Restaurant System (ProgS2SB) 🍴");

        do {
            System.out.println("\n=== MENU OPTIONS ===");
            System.out.println("1. Add Dish");
            System.out.println("2. Delete Dish (by ID)");
            System.out.println("3. Show Full Menu");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addDish(sc);
                case 2 -> deleteDish(sc);
                case 3 -> showMenu();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    // Add Dish
    private static void addDish(Scanner sc) {
        if (count >= menu.length) {
            System.out.println("Menu is full!");
            return;
        }

        System.out.print("Enter Dish ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Dish Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Dish Price: ");
        double price = sc.nextDouble();

        System.out.println("Select Course: 1. Starter | 2. Main Course | 3. Dessert");
        int type = sc.nextInt();

        FoodItem dish = null;
        switch (type) {
            case 1 -> dish = new Starter(id, name, price);
            case 2 -> dish = new MainCourse(id, name, price);
            case 3 -> dish = new Dessert(id, name, price);
            default -> {
                System.out.println("Invalid course type. Dish not added.");
                return;
            }
        }

        menu[count++] = dish;
        System.out.println("✅ " + dish.getName() + " added to menu!");
    }

    // Delete Dish
    private static void deleteDish(Scanner sc) {
        if (count == 0) {
            System.out.println("Menu is empty!");
            return;
        }

        System.out.print("Enter Dish ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (menu[i].getId() == id) {
                found = true;
                System.out.println("❌ " + menu[i].getName() + " deleted.");
                // Shift array elements
                for (int j = i; j < count - 1; j++) {
                    menu[j] = menu[j + 1];
                }
                menu[count - 1] = null;
                count--;
                break;
            }
        }

        if (!found) {
            System.out.println("Dish with ID " + id + " not found.");
        }
    }

    // Show Menu
    private static void showMenu() {
        if (count == 0) {
            System.out.println("Menu is empty!");
            return;
        }

        System.out.println("\n📋 FULL MENU:");
        for (int i = 0; i < count; i++) {
            System.out.println(menu[i]);
        }
    }
}
