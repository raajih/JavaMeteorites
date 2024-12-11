//Raajih Roland
//Final Project

import java.time.LocalDate;

public class Meteorite {
    private String name;
    private int id;
    private String nametype;
    private String recclass;
    private double mass;
    private String fall;
    private LocalDate year;
    private double reclat;
    private double reclong;
    private Geolocation geolocation;

    /**
     * Constructs a Meteorite object.
     * @param name name of Meteorite as String.
     * @param id id of Meteorite as int.
     * @param nametype nametype as String.
     * @param recclass recclass as String.
     * @param mass mass of Meteorite as double.
     * @param fall fall as String.
     * @param year year of Meteorite as LocalDate object.
     * @param reclat recclat as double.
     * @param reclong reclong as double.
     * @param geolocation geolocation as Geolocation object.
     */
    public Meteorite (String name, int id, String nametype, String recclass, double mass, String fall, LocalDate year, double reclat,
    double reclong, Geolocation geolocation)
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
     * @return id as int.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets id.
     * @param id int to be set as id.
     */
    public void setId(int id) {
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
     * @return mass as double.
     */
    public double getMass() {
        return this.mass;
    }

    /**
     * Set mass.
     * @param mass double to be set as mass.
     */
    public void setMass(double mass) {
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
     * @return year as LocalDate object.
     */
    public LocalDate getYear() {
        return this.year;
    }

    /**
     * Set year.
     * @param year LocalDate object to be set as year.
     */
    public void setYear(LocalDate year) {
        this.year = year;
    }

    /**
     * Getter for reclat.
     * @return reclat as double.
     */
    public double getReclat() {
        return this.reclat;
    }

    /**
     * Set reclat.
     * @param reclat double to be set as reclat.
     */
    public void setReclat(double reclat) {
        this.reclat = reclat;
    }

    /**
     * Getter for reclong.
     * @return reclong as double.
     */
    public double getReclong() {
        return this.reclong;
    }

    /**
     * Set reclong.
     * @param reclong double to be set as reclong.
     */
    public void setReclong(double reclong) {
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

}
