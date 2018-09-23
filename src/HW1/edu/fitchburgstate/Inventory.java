/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Date: 2018-09-18
 * Students: Aayusha Agrawal (@01395854)
 */

package HW1.edu.fitchburgstate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory keeps a searchable collection of Guitars. It is meant to be used
 * to find matching guitars for customers. 
 *
 */
public class Inventory {
  private List<Guitar> guitars = new LinkedList<Guitar>();

  /**
   * Full Constructor.
   *  @param serialNumber manufacturer serial number
   * @param price        store price
   * @param builder      the guitar's manufacturer
   * @param model        the manufacturers model
   * @param type         guitar type
   * @param backWood     the wood used for the guitar body
   * @param topWood      the wood used for the guitar's face
   */
  public void addGuitar(String serialNumber, double price,
                        GuitarManufacturer builder, String model,
                        GuitarType type, GuitarWood backWood, GuitarWood topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
    this.guitars.add(guitar);
  }

  /**
   * @param serialNumber - The Serial number of the Guitar.
   * @return Returns a guitar that matches with the input serial number, null if not found
   */
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar) i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  /**
   * searchGuitar is used to search for guitars according to customer preference .
   * Searches for customer preferences pertaining to parameters such as manufacturer, model ,
   * type,backWood ,topWood.
   * When used like this it may have missing attributes.
   * Attributes that are missing are considered to be a wildcard match.
   *
   * @param searchGuitarSpec - guitar specification
   * @return Returns a list of guitars which match the preference of the customer ,null if not found.
   */
  public List<Guitar> search(GuitarSpec searchGuitarSpec) {
    List<Guitar> matchedGuitars = new LinkedList<Guitar>();
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar) i.next();
      GuitarSpec guitarspec = guitar.getgSpec();

      if (guitarspec.match(searchGuitarSpec)) {
        matchedGuitars.add(guitar);   //If matched, guitar is added to the list
      }
    }
    return matchedGuitars;
  }

  /**
   * Search and returns guitars with given price
   * @param price Guitar's price
   * @return List returns list of matching guitars, null if not found
   */
  public List<Guitar> SearchGuitarByPrice(Double price)
  {
    List<Guitar> priceMatchGuitars = new LinkedList<Guitar>();
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); )
    {
      Guitar guitar = (Guitar)i.next();

      int Result = Double.compare(price,guitar.getPrice());
      if (Result == 0)
      {
        priceMatchGuitars.add(guitar); //Adds guitars matching with given price
      }
    }
    return priceMatchGuitars;
  }
}