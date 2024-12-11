import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        double[] coord = {2.332, 4.666};

        Geolocation test = new Geolocation("Point", coord);

        LocalDateTime testDate = LocalDateTime.now();

        Meteorite testMeteor = new Meteorite("Hailey's", 1, "nametype", "recclass", 5.2, "fell", testDate, 5.220000, 6.220000, test);


        UserInterface ui = new UserInterface();
        ui.go();

    }

    public void go()
    {
        Scanner scnr = new Scanner(System.in);
        int choice;

        //Output menu
        System.out.println("Welcome to the NASA meteorite tracking database\n");
        do {
            System.out.println("Here's the menu of choices-");
            System.out.println("0) Quit");
            System.out.println("1) Import meteorite data from a JSON file");
            System.out.println("2) Display the meteorite data");
            System.out.println("3) Export the meteorite data to a file");
            System.out.println("4) Find a meteorite by name");
            System.out.println("5) Find a meteorite by id");
            System.out.println("6) List the largest meteorites");
            System.out.println("7) List the most recent meteorites by year");
            System.out.println("8) List the meteorite classes");
            System.out.print("Enter your choice: ");
            choice = scnr.nextInt();
            scnr.nextLine();

            switch (choice)
            {
                case 0:
                    break; //Prevents an error message from printing when user chooses 0.
                case 1:
                    System.out.print("Enter the JSON file name or press <Enter> to accept the default (data/NASA_Meteorite.json): ");
                    break;
                case 2:
                    System.out.println("you picked choice 2");
                    break;
                case 3:
                    System.out.println("choice 3");
                    break;
                case 4:
                    System.out.println("choice 4");
                    break;
                case 5:
                    System.out.println("choice 5");
                    break;
                case 6:
                    System.out.println("choice 6");
                    break;
                case 7:
                    System.out.println("choice 7");
                    break;
                case 8:
                    System.out.println("choice 8");
                    break;
                default:
                    System.out.println("Error. Invalid choice");
                    break;
            }
        } while (choice != 0);
    }
}

