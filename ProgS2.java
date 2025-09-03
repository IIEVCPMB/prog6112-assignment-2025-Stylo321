package com.mycompany.progs2;

import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public int SeriesAge;
    public int SeriesNumberOfEpisodes;

    public SeriesModel(String id, String name, int age, int episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }

    // Convert to JSON
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("id", SeriesId);
        obj.put("name", SeriesName);
        obj.put("age", SeriesAge);
        obj.put("episodes", SeriesNumberOfEpisodes);
        return obj;
    }
}

class Series {

    // ...inside Series class...

public ArrayList<SeriesModel> getSeriesList() {
    return seriesList;
}

public SeriesModel findSeriesById(String id) {
    for (SeriesModel s : seriesList) {
        if (s.SeriesId.equals(id)) {
            return s;
        }
    }
    return null;
}

    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private JSONObject database = new JSONObject(); // fake DB
    private JSONArray seriesArray = new JSONArray(); // store all series
    private Scanner sc;

    public Series(Scanner scanner) {
        this.sc = scanner;
        database.put("series", seriesArray);
    }

    // Save the ArrayList into JSON database
    private void syncDatabase() {
        seriesArray = new JSONArray();
        for (SeriesModel s : seriesList) {
            seriesArray.put(s.toJSON());
        }
        database.put("series", seriesArray);
    }

    // 1. Capture new series
    public void CaptureSeries() {
        System.out.print("Enter the series ID: ");
        String id = sc.nextLine();

        System.out.print("Enter the series name: ");
        String name = sc.nextLine();

        int age = 0;
        while (true) {
            try {
                System.out.print("Enter the series age restriction (2–18): ");
                age = Integer.parseInt(sc.nextLine());
                if (age >= 2 && age <= 18) break;
                System.out.println("Invalid age! Enter between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        int episodes = 0;
        while (true) {
            try {
                System.out.print("Enter number of episodes for " + name + ": ");
                episodes = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        seriesList.add(new SeriesModel(id, name, age, episodes));
        syncDatabase(); // update DB
        System.out.println("Series captured successfully!\n");
    }

    // 2. Search series
    public void SearchSeries() {
        System.out.print("Enter the series ID to search: ");
        String id = sc.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                System.out.println("SERIES FOUND:");
                System.out.println("ID: " + s.SeriesId);
                System.out.println("Name: " + s.SeriesName);
                System.out.println("Age Restriction: " + s.SeriesAge);
                System.out.println("Episodes: " + s.SeriesNumberOfEpisodes + "\n");
                return;
            }
        }
        System.out.println("Series with ID " + id + " not found.\n");
    }

    // 3. Update series
    public void UpdateSeries() {
        System.out.print("Enter the series ID to update: ");
        String id = sc.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                System.out.print("Enter new series name (" + s.SeriesName + "): ");
                String name = sc.nextLine();
                if (!name.isEmpty()) s.SeriesName = name;

                while (true) {
                    try {
                        System.out.print("Enter new age restriction (2–18) [" + s.SeriesAge + "]: ");
                        String input = sc.nextLine();
                        if (!input.isEmpty()) {
                            int age = Integer.parseInt(input);
                            if (age >= 2 && age <= 18) {
                                s.SeriesAge = age;
                                break;
                            }
                            System.out.println("Invalid age! Enter between 2 and 18.");
                        } else break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number.");
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter new number of episodes [" + s.SeriesNumberOfEpisodes + "]: ");
                        String input = sc.nextLine();
                        if (!input.isEmpty()) {
                            s.SeriesNumberOfEpisodes = Integer.parseInt(input);
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a number.");
                    }
                }

                syncDatabase(); // update DB
                System.out.println("Series updated successfully!\n");
                return;
            }
        }
        System.out.println("Series with ID " + id + " not found.\n");
    }

    // 4. Delete series
    public void DeleteSeries() {
        System.out.print("Enter the series ID to delete: ");
        String id = sc.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + "? (y/n): ");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    seriesList.remove(s);
                    syncDatabase(); // update DB
                    System.out.println("Series deleted successfully.\n");
                } else {
                    System.out.println("Delete cancelled.\n");
                }
                return;
            }
        }
        System.out.println("Series with ID " + id + " not found.\n");
    }

    // 5. Report
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series data available.\n");
            return;
        }

        System.out.println("SERIES REPORT - 2025\n");
        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("Series " + count++);
            System.out.println("***************************");
            System.out.println("ID: " + s.SeriesId);
            System.out.println("Name: " + s.SeriesName);
            System.out.println("Age Restriction: " + s.SeriesAge);
            System.out.println("Episodes: " + s.SeriesNumberOfEpisodes + "\n");
            System.out.println("***************************");
        }


    }

    // 6. Exit
    public void ExitSeriesApplication() {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }
}

public class ProgS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Series seriesManager = new Series(sc);

        while (true) {
            // Entry screen before showing menu
            System.out.println("Welcome to SERIES APP 2025");
            System.out.println("***************************");
            System.out.print("Press 1 to go to the menu: ");
            String entry = sc.nextLine();

            if (!entry.equals("1")) {
                System.out.println("Invalid input. Please press 1 to go to the menu.\n");
                continue;
            }

            // Main menu
            System.out.println("\nLATEST SERIES - 2025");
            System.out.println("***************************");
            System.out.println("1. Capture a new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update a series");
            System.out.println("4. Delete a series");
            System.out.println("5. Print series report");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": seriesManager.CaptureSeries(); break;
                case "2": seriesManager.SearchSeries(); break;
                case "3": seriesManager.UpdateSeries(); break;
                case "4": seriesManager.DeleteSeries(); break;
                case "5": seriesManager.SeriesReport(); break;
                case "6": seriesManager.ExitSeriesApplication(); break;
                default: System.out.println("Invalid option! Try again.\n");
            }
        }
    }
}
