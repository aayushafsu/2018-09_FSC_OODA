/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Date: 2018-09-18
 * Students: Aayusha Agrawal (@01395854)
 */

package HW1.edu.fitchburgstate;

/**
 * Created by Aayusha on 9/16/2018.
 * GuitarSpec contains attributes of the guitar such as builder,model,type,backwood and topwood
 */
public class GuitarSpec {

    /**
     * Full constructor
     * @param manufacturer the guitar's manufacturer
     * @param model        the manufacturers model
     * @param type         guitar type
     * @param backWood     the wood used for the guitar body
     * @param topWood      the wood used for the guitar's face
     */
    public GuitarSpec(GuitarManufacturer manufacturer, String model,
                      GuitarType type, GuitarWood backWood,
                      GuitarWood topWood) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }


    /**
     * Returns the name of the manufacturer
     */
    public GuitarManufacturer getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Returns the manufacturer model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the guitar Type
     *
     * @return
     */
    public GuitarType getType() {
        return type;
    }

    /**
     * Returns the type of wood used in the body
     */
    public GuitarWood getBackWood() {
        return backWood;
    }

    /**
     * Returns the type of wood used in the face
     *
     * @return
     */
    public GuitarWood getTopWood() {
        return topWood;
    }

    /**
     * The name of the manufacturer
     */
    private GuitarManufacturer manufacturer;

    /**
     * The manufacturer model number
     */
    private String model;

    /**
     * The guitar type (electric/acoustic)
     */
    private GuitarType type;

    /**
     * The wood used for the back of the guitar
     */
    private GuitarWood backWood;

    /**
     * The wood used for the face of the guitar
     */
    private GuitarWood topWood;


    /**
     * Given a Guitar specification, this method will match with this guitar specification and return true if the
     * input guitar specification attributes match with this guitar specification. This method will also return true
     * if only partial values of the input Guitar matches with the corresponding attributes of this Guitar spec
     * (provided other attributes of the input Guitar spec are null or empty), thus this method supports wildcard match.
     *
     * @param guitarSpec - The input Guitar spec to match with this guitar spec.
     * @return - true if the input guitar spec matches with this guitar spec including wildcard match, else returns
     * false.
     */
     boolean match(GuitarSpec guitarSpec) {
         GuitarManufacturer builder = guitarSpec.getManufacturer();
         if (builder != null && (!builder.equals(this.getManufacturer())))
            return false;
         String model = guitarSpec.getModel();
         if ((model != null) && (!model.equals("")) && (!model.equalsIgnoreCase(this.getModel())))
             return false;
         GuitarType type = guitarSpec.getType();
         if ((type != null) && (!type.equals(this.getType())))
             return false;
         GuitarWood backWood = guitarSpec.getBackWood();
         if ((backWood != null) && (!backWood.equals(this.getBackWood())))
             return false;
         GuitarWood topWood = guitarSpec.getTopWood();
         if ((topWood != null) && (!topWood.equals(this.getTopWood())))
             return false;
         return true;
     }
}



