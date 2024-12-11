//Raajih Roland
//Final Project

import java.io.Serializable;

public class Meteorite implements Serializable {
    private String name;
    private String id;
    private String nametype;
    private String recclass;
    private String mass;
    private String fall;
    private String year;
    private String reclat;
    private String reclong;
    private Geolocation geolocation;

    /**
     * Constructs a Meteorite object.
     * @param name name of Meteorite as String.
     * @param id id of Meteorite as String.
     * @param nametype nametype as String.
     * @param recclass recclass as String.
     * @param mass mass of Meteorite as double.
     * @param fall fall as String.
     * @param year year of Meteorite as LocalDate object.
     * @param reclat recclat as double.
     * @param reclong reclong as double.
     * @param geolocation geolocation as Geolocation object.
     */
    public Meteorite (String name, String id, String nametype, String recclass, String mass, String fall, String year, String reclat,
    String reclong, Geolocation geolocation)
    {
        this.name = name;
        this.id = id;
        this.nametype = nametype;
        this.recclass = recclass;
        this.mass = mass;
        this.fall = fall;
        this.year = year;
        this.reclat = reclat;
        this.reclong = reclong;
        this.geolocation = geolocation;
    }

    /**
     * Getter for name.
     * @return name as String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     * @param name String to be set as name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for id.
     * @return id as String.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets id.
     * @param id String to be set as id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for nametype.
     * @return nametype as String.
     */
    public String getNametype() {
        return this.nametype;
    }

    /**
     * Sets nametype.
     * @param nametype String to be set as nametype.
     */
    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    /**
     * Getter for recclass.
     * @return recclass as String.
     */
    public String getRecclass() {
        return this.recclass;
    }

    /**
     * Set recclass.
     * @param recclass String to be set as recclass.
     */
    public void setRecclass(String recclass) {
        this.recclass = recclass;
    }

    /**
     * Getter for mass.
     * @return mass as String.
     */
    public String getMass() {
        return this.mass;
    }

    /**
     * Set mass.
     * @param mass String to be set as mass.
     */
    public void setMass(String mass) {
        this.mass = mass;
    }

    /**
     * Getter for fall.
     * @return fall as String.
     */
    public String getFall() {
        return this.fall;
    }

    /**
     * Set fall.
     * @param fall String to be set as fall.
     */
    public void setFall(String fall) {
        this.fall = fall;
    }

    /**
     * Getter for year.
     * @return year as String object.
     */
    public String getYear() {
        return this.year;
    }

    /**
     * Set year.
     * @param year String object to be set as year.
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Getter for reclat.
     * @return reclat as String.
     */
    public String getReclat() {
        return this.reclat;
    }

    /**
     * Set reclat.
     * @param reclat String to be set as reclat.
     */
    public void setReclat(String reclat) {
        this.reclat = reclat;
    }

    /**
     * Getter for reclong.
     * @return reclong as String.
     */
    public String getReclong() {
        return this.reclong;
    }

    /**
     * Set reclong.
     * @param reclong String to be set as reclong.
     */
    public void setReclong(String reclong) {
        this.reclong = reclong;
    }

    /**
     * Getter for geolocation.
     * @return geolocation as Geolocation object.
     */
    public Geolocation getGeolocation() {
        return this.geolocation;
    }

    /**
     * Set geolocation.
     * @param geolocation Geolocation object to be set as geolocation.
     */
    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public String toString()
    {
        String result;

        // Check if geolocation is null before calling toString()
        String geoString = (geolocation != null) ? geolocation.toString() : "No geolocation data"; //AT LEAST ONE OBJECT IN JSON FILE DOESN'T HAVE GEOLOCATION

        result = "Meteorite [name=" + name + ", id=" + id + ", nametype=" + nametype + ", recclass=" 
        + recclass + ", mass=" + mass + ", fall=" + fall + ", year="
        + year + ", reclat=" + reclat + ", reclong=" + reclong + ", geolocation=" + geoString
        + "]";

        return result;
    }

    /**
     * Outputs name, id, recclass, and year.
     * @return string object holding name, id, recclass, and year.
     */
    public String display()
    {
        String result;

        result = "name = " + name + ", id = " + id + ", recclass = " + recclass + ", mass = " + mass + ", year = " + year.substring(0, 4);
        return result;
    }

}
