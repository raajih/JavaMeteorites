import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;   
import java.time.LocalDateTime;
import java.util.Scanner;
import com.google.gson.Gson;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;

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
                    String filename = scnr.nextLine().trim(); //Get filename from user.
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
                case 4: //Find a specific meteorite by name.
                    System.out.print("Enter the name of the meteorite: ");
                    String findMeteorite = scnr.nextLine(); //Get user's input for name.

                    //Find the first match, if no match found then Meteorite is set to null.
                    Stream<Meteorite> meteoriteStream = Stream.of(meteorites);
                    Meteorite foundMeteorite = meteoriteStream
                        .filter(w -> w.getName().equalsIgnoreCase(findMeteorite))
                        .findFirst()
                        .orElse(null);

                    if (foundMeteorite == null)
                    {
                        System.out.println("No meteorite with that name found.");
                    }
                    else 
                    {
                        System.out.println(foundMeteorite.display()); //Output info for meteorite.
                    }

                    break;
                case 5: //Find a specific meteorite by id.
                    System.out.print("Enter the ID of the meteorite: ");
                    findMeteorite = scnr.nextLine();

                    Stream<Meteorite> stream = Stream.of(meteorites);
                    Meteorite found = stream
                        .filter(w -> w.getId().equals(findMeteorite))
                        .findFirst()
                        .orElse(null);

                        if (found == null)
                        {
                            System.out.println("No meteorite with that id found.");
                        }
                        else 
                        {
                            System.out.println(found.display()); //Output info for meteorite.
                        }
                    break;
                case 6: //Display largest meteorites.
                    System.out.print("Enter the number of largest meteorites to display: ");
                    int numLargest = scnr.nextInt();
                    scnr.nextLine();

                    if (meteorites.length == 0) //If there is no meteorite objects in array.
                    System.out.println("No meteorite data loaded. Please add data from file.");
                    else 
                    {
                        //Create list of the largest meteorites.
                        List<Meteorite> largestMeteorites = Stream.of(meteorites)
                            .sorted((m1, m2) -> {
                                // Get the mass of each meteorite, default to 0.0 if mass is null
                                double mass1 = (m1.getMass() != null) ? Double.parseDouble(m1.getMass()) : 0.0; //Helps prevent NullPointerException.
                                double mass2 = (m2.getMass() != null) ? Double.parseDouble(m2.getMass()) : 0.0;
                                return Double.compare(mass2, mass1); // Compare in descending order
                            })
                            .limit(numLargest)
                            .collect(Collectors.toList());

                        System.out.println("Largest " + numLargest + " meteorites:");
                        for (Meteorite meteorite: largestMeteorites)
                        {
                            System.out.println(meteorite.display()); //Output largest meteorites.
                        }
                    }
                    break;
                case 7: //Display latest meteorites.
                    System.out.print("How many of the most recent meteorites do you want to see: ");
                    int numLatest = scnr.nextInt();
                    scnr.nextLine();

                    if (meteorites.length == 0) //If there is no meteorite objects in array.
                    System.out.println("No meteorite data loaded. Please add data from file.");
                    else 
                    {
                        //Create list of the latest meteorites.
                        List<Meteorite> latestMeteorites = Stream.of(meteorites)
                            .sorted((m1, m2) -> {
                                // Get the year of each meteorite, default to 0.0 if year is null
                                double year1 = (m1.getYear() != null) ? Double.parseDouble(m1.getYear().substring(0,4)) : 0.0; //Helps prevent NullPointerException.
                                double year2 = (m2.getYear() != null) ? Double.parseDouble(m2.getYear().substring(0,4)) : 0.0;
                                return Double.compare(year2, year1); // Compare in descending order
                            })
                            .limit(numLatest)
                            .collect(Collectors.toList());

                        System.out.println("Latest " + numLatest + " meteorites:");
                        for (Meteorite meteorite: latestMeteorites)
                        {
                            System.out.println(meteorite.display()); //Output latest meteorites.
                        }
                    }

                    break;
                case 8: //Display groups of classifications.
                if (meteorites.length == 0) 
                { // If there are no meteorite objects in the array
                    System.out.println("No meteorite data loaded. Please add data from file.");
                } else 
                {
                    // Group meteorites by classification and count the number of meteorites in each classification.
                    Map<String, Long> classificationCounts = Stream.of(meteorites)
                        .collect(Collectors.groupingBy(
                            w -> w.getRecclass(), // Group by classification.
                            Collectors.counting()         // Count the number of meteorites in each classification.
                        ));
            
                    // Sort classifications by the number of meteorites in descending order
                    List<Map.Entry<String, Long>> sortedClassifications = classificationCounts.entrySet()
                        .stream()
                        .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue())) // Sort by count descending
                        .toList();
            
                    // Display results
                    System.out.println("Meteorite classifications sorted by number of meteorites:");
                    for (Map.Entry<String, Long> entry : sortedClassifications) 
                    {
                        System.out.println("Classification: " + entry.getKey() + ", Count: " + entry.getValue());
                    }
                }
                    break;
                default:
                    System.out.println("Error. Invalid choice");
                    break;
            }
        } while (choice != 0);
    }
}

