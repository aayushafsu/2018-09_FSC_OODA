/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-12
 * Students: Aayusha Agrawal (@01395854)
 */

package HW1.edu.fitchburgstate;

import HW1.edu.fitchburgstate.Guitar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory keeps a searchable collection of Guitars. It is meant to be use
 * to find matching guitars for customers. 
 * 
 * @author orlando
 * @version 2.0
 */
public class Inventory {
  private List<Guitar> guitars = new LinkedList<Guitar>();

  /**
   * Full Constructor.
   *
   * @param serialNumber manufacturer serial number
   * @param price store price
   * @param builder the guitar's manufacturer
   * @param model the manufacturers model
   * @param type guitar type (electric/accoustic)
   * @param backWood the wood used for the guitar body
   * @param topWood the wood used for the guitar's face
   */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
    this.guitars.add(guitar);
  }

  /**
   * @param serialNumber - The Serial number of the Guitar.
   * @return Returns a guitar that matches with the input serial number
   */
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  /**
   *  searchGuitar is used to search for guitars according to customer preference.
   *  Searches for customer preferences pertaining to parameters such as serialNumber ,manufacturer, price , model ,
   *  type,backWood ,topWood.
   *  When used like this it may have missing attributes.
   *  Attributes that are missing are considered to be a wildcard match.
   *
   * @param searchGuitar - Customer preferred guitar
   *
   * @return Returns a guitar which matches the preference of the customer as described by searchGuitar.
   */
  public Guitar search(Guitar searchGuitar) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equalsIgnoreCase(guitar.getManufacturer())))
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equalsIgnoreCase(guitar.getModel())))
        continue;
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equalsIgnoreCase(guitar.getType())))
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equalsIgnoreCase(guitar.getBackWood())))
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equalsIgnoreCase(guitar.getTopWood())))
        continue;
      return guitar;
    }
    return null;
  }
}
