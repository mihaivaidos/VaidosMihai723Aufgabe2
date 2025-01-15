import Model.Spieler;
import Model.Vereine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AppUI {

    private final AppController controller;
    private final Scanner scanner = new Scanner(System.in);

    public AppUI(AppController controller) {
        this.controller = controller;
    }

    public void start(){
        while (true) {
            System.out.println("\nX Management System");
            System.out.println("1. Manage Spielers");
            System.out.println("2. Manage Vereins");
            System.out.println("3. Filter vereins by city");
            System.out.println("4. Players in a team");
            System.out.println("5. Players in a team sorted by value");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manageSpielers();
                    break;
                case 2:
                    manageVerein();
                    break;
                case 3:
                    filterVereineByCity();
                    break;
                case 4:
                    playersByVereine();
                    break;
                case 5:
                    sortByValue();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageSpielers() {
        while (true) {
            System.out.println("\nX Management");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter position: ");
                    String  position = scanner.nextLine();
                    System.out.println("Enter value: ");
                    int value = Integer.parseInt(scanner.nextLine());
                    controller.addSpieler(name, age, position, value);
                    break;
                case 2:
                    System.out.println("Spieler List: ");
                    controller.getAllSpielers().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter the name of the spieler: ");
                    String nameUpt = scanner.nextLine();
                    Spieler spieler = controller.getAllSpielers().stream()
                            .filter(c -> Objects.equals(c.getName(), nameUpt))
                            .findFirst()
                            .orElse(null);
                    if(spieler != null) {
                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new age: ");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter new position: ");
                        String newPosition = scanner.nextLine();
                        System.out.println("Enter new value: ");
                        int newValue = Integer.parseInt(scanner.nextLine());
                        controller.updateSpieler(newName, newAge, newPosition, newValue);
                        System.out.println("Updated!");
                    }
                    break;
                case 4:
                    System.out.println("Enter the name of the spieler: ");
                    String nameDel = scanner.nextLine();
                    controller.deleteSpieler(nameDel);
                    System.out.println("Deleted!");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageVerein() {
        while (true) {
            System.out.println("\nX Management");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter city: ");
                    String city = scanner.nextLine();
                    List<Spieler> spielers = new ArrayList<>();
                    controller.addVereine(name, city, spielers);
                    System.out.println("added!");
                    break;
                case 2:
                    System.out.println("Vereins List: ");
                    controller.getAllVereines().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter the id of the verein: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Vereine vereine = controller.getAllVereines().stream().filter(c -> c.getID() == id).findFirst().orElse(null);
                    if (vereine != null) {
                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new city: ");
                        String newCity = scanner.nextLine();
                        List<Spieler> spielers2 = new ArrayList<>();
                        controller.updateVereine(id, newName, newCity,spielers2);
                    }
                    break;
                case 4:
                    System.out.println("Enter the id of the verein: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    controller.deleteVereine(deleteId);
                    System.out.println("deleted!");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void filterVereineByCity() {
        System.out.println("Enter city for filtering: ");
        String city = scanner.nextLine();
        controller.filterVereineByCity(city).forEach(System.out::println);
    }

    private void playersByVereine() {
        System.out.println("Enter the name of the vereine: ");
        String name = scanner.nextLine();
        controller.vereinePlayers(name).forEach(System.out::println);
    }

    private void sortByValue() {
        System.out.println("Enter the type of filtering, asc for 'ascending', desc for 'descending': ");
        String type = scanner.nextLine();
        System.out.println("Enter the id for the Vereine you want to sort players by value: ");
        int idClient = Integer.parseInt(scanner.nextLine());
        switch (type){
            case "asc" -> controller.sortByValue(idClient,"asc").forEach(System.out::println);
            case "desc" -> controller.sortByValue(idClient,"desc").forEach(System.out::println);
        }
    }

    private void addPlayerToVerein() {
        System.out.println("Enter the id of the verein: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the name of the player: ");
        String name = scanner.nextLine();
        controller.addPlayerToVerein(name, id);
    }

}
