//Raajih Roland
//Final Project
//12/10/2024
import java.util.Arrays;
import java.io.Serializable;

public class Geolocation implements Serializable{
    private String type;
    private double[] coordinates;

    /**
     * Construct a Geolocation object.
     * @param type the type of geolocation as a string.
     * @param coordinates Array of doubles.
     */
    public Geolocation (String type, double[] coordinates)
    {
        this.type = type;
        this.coordinates = coordinates;
    }

    /**
     * Get type.
     * @return type as a string.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set type.
     * @param type a string to be set as type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get coordinates.
     * @return array of doubles.
     */
    public double[] getCoordinates() {
        return this.coordinates;
    }

    /**
     * Set coordinates.
     * @param coordinates an array of doubles to be set as coordinates.
     */
    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString()
    {
        String result;



        result = "Geolocation [type=" + type + ", coordinates=" + Arrays.toString(coordinates) + "]";

        return result;
    }

}
