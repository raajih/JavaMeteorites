import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;   
import java.time.LocalDateTime;
import java.util.Scanner;
import com.google.gson.Gson;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class UserInterface {
    private Meteorite[] meteorites = {};
    public static void main(String[] args) {
        
        double[] coord = {1.52105, 2.56451};
        Geolocation test = new Geolocation("Point", coord);


        Meteorite testMeteor = new Meteorite("Hailey's", "1", "nametype", "recclass", "5.2", "fell", "1880-01-01T00", "5.220000", "6.220000", test);
        

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
                    String filename = scnr.nextLine(); //Get filename from user.
                    Gson gson = new Gson(); //Gson object

                    if (filename.isEmpty()) 
                    {
                        filename = "data/NASA_Meteorite.json"; // Use default if user presses Enter
                    }

                    try {
                        Path filePath = Paths.get(filename);

                        // Check if the file exists
                        if (!Files.exists(filePath)) 
                        {
                            // If the file doesn't exist, create it
                            System.out.println("File not found. Creating new file: " + filename);
                            Files.createFile(filePath);  // Creates an empty file
                        }

                        // Check if the file is empty before attempting to read it
                        if (Files.size(filePath) == 0) 
                        {
                            System.out.println("The file is empty. No data to process.");
                            return;  // Exit the method if the file is empty
                        }

                        String jsonString = Files.readString(filePath); //Read in json file as one string.

                        //Turn string into array of Meteorites.
                        meteorites = gson.fromJson(jsonString, Meteorite[].class);

                        //Output number of elements in array.
                        System.out.println("\n" + meteorites.length + " records processed.");
                    } catch (IOException e)
                    {
                        System.out.println("Error reading file");
                    }

                    
                    break;
                case 2:
                    if (meteorites.length == 0)
                    {
                        System.out.println("There is no meteorite data saved. Please import data from a json file.");
                    }
                    else 
                    {
                        for (Meteorite x: meteorites)
                        {
                            System.out.println(x.toString());
                        }
                    }
                    break;
                case 3: //Write Meteorite array to a binary file of my choice.
                    
                try (ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream("meteoriteData.dat")))
                        {
                        out.writeObject(meteorites);
                        System.out.println("Data successfully saved to binary file");
                        }
                 catch (IOException e)
                {
                    System.out.println("Error writing to binary file");
                }
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

