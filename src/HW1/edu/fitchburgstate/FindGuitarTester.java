/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Date: 2018-09-18
 * Students: Aayusha Agrawal (@01395854)
 */

package HW1.edu.fitchburgstate;

import HW1.edu.fitchburgstate.Guitar;
import HW1.edu.fitchburgstate.Inventory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Finds appropriate guitar for Erin's needs using Rick's music store inventory
 */
public class FindGuitarTester {

  /**
   * Entry point of the program.
   *
   * @param args - Command lime arguments.
   */

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);
    priceSearch();

    GuitarSpec whatErinLikes = new GuitarSpec(GuitarManufacturer.FENDER, "Stratocastor", GuitarType.ELECTRIC, GuitarWood.ALDER,
            GuitarWood.ALDER);

    List<Guitar> matchedGuitars = new LinkedList<>();
    matchedGuitars = inventory.search(whatErinLikes);

    //Searches Guitars according to customer preference of guitar specifications

    System.out.println("Searching with specifications:");
    if (!matchedGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars matching your specifications:");
      for (Iterator i = matchedGuitars.iterator(); i.hasNext(); )


      {
        Guitar guitar = (Guitar) i.next();
        GuitarSpec gSpec = guitar.getgSpec();
        if (gSpec != null) {
          System.out.println("Erin, you might like this " + gSpec.getManufacturer() + " " + gSpec.getModel() + " " +
                  gSpec.getType() + " guitar:\n   " +
                  gSpec.getBackWood() + " back and sides,\n   " +
                  gSpec.getTopWood() + " top.\nYou can have it for only $" +
                  guitar.getPrice() + "!");
        } else {
          System.out.println("Sorry, Erin, we have nothing for you.");
        }
      }
    }
  }

  /**
   * Searches Guitars according to customer preference of price
   */
  private static void priceSearch()
  {
    Inventory inventory = new Inventory();
    initializeInventory(inventory);
    Guitar priceSpecification = new Guitar(null,2100.95,null,null,null,null,null); //Guitar object
    List<Guitar> PriceMatchGuitars = new LinkedList<>();
    PriceMatchGuitars = inventory.priceSearch(priceSpecification);
    System.out.println("Searching with Price:");
    if (!PriceMatchGuitars.isEmpty())
    {
      System.out.println("Erin, you might like these guitars matching your price:");
      for (Iterator i = PriceMatchGuitars.iterator();i.hasNext();)
      {
        Guitar guitar= (Guitar)i.next();
        GuitarSpec gSpec = guitar.getgSpec();
        System.out.println("We have a " +
                gSpec.getManufacturer() + " " + gSpec.getModel() +  " " +
                gSpec.getType() + " guitar:\n   " +
                gSpec.getBackWood() + " back and sides,\n   " +
                gSpec.getTopWood() + " top.\nYou can have it for only $" +
                guitar.getPrice() + "!");
      }
    }
    else
    {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  /**
   * Initialize Inventory with some Guitars.
   *
   * @param inventory - Guitar Inventory.
   */
  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("11277", 3999.95, GuitarManufacturer.COLLINGS, "CJ", GuitarType.ACOUSTIC,
                        GuitarWood.INDIAN_ROSEWOOD, GuitarWood.SITKA);
    inventory.addGuitar("V95693", 1499.95, GuitarManufacturer.FENDER, "Stratocastor", GuitarType.ELECTRIC,
                        GuitarWood.ALDER, GuitarWood.ALDER);
    inventory.addGuitar("V9512", 1549.95, GuitarManufacturer.FENDER, "Stratocastor", GuitarType.ELECTRIC,
                        GuitarWood.ALDER, GuitarWood.ALDER);
    inventory.addGuitar("122784", 5495.95, GuitarManufacturer.MARTIN, "D-18", GuitarType.ACOUSTIC,
                        GuitarWood.MAHOGANY, GuitarWood.ADRONDACK);
    inventory.addGuitar("76531", 6295.95, GuitarManufacturer.MARTIN, "OM-28", GuitarType.ACOUSTIC,
                        GuitarWood.BRAZILIAN_ROSEWOOD, GuitarWood.ADRONDACK);
    inventory.addGuitar("70108276", 2295.95, GuitarManufacturer.GIBSON, "Les Paul", GuitarType.ELECTRIC,
                        GuitarWood.MAHOGANY, GuitarWood.MAPLE);
    inventory.addGuitar("82765501", 1890.95, GuitarManufacturer.GIBSON, "SG '61 Reissue",
                        GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAHOGANY);
    inventory.addGuitar("77023", 6275.95, GuitarManufacturer.MARTIN, "D-28", GuitarType.ACOUSTIC,
                        GuitarWood.BRAZILIAN_ROSEWOOD, GuitarWood.ADRONDACK);
    inventory.addGuitar("1092", 12995.95, GuitarManufacturer.OLSON, "SJ", GuitarType.ACOUSTIC,
                        GuitarWood.INDIAN_ROSEWOOD, GuitarWood.CEDAR);
    inventory.addGuitar("566-62", 8999.95, GuitarManufacturer.RYAN, "Cathedral", GuitarType.ACOUSTIC,
                        GuitarWood.COCOBOLO, GuitarWood.CEDAR);
    inventory.addGuitar("6 29584", 2100.95, GuitarManufacturer.PRS, "Dave Navarro Signature",
                        GuitarType.ELECTRIC, GuitarWood.MAHOGANY, GuitarWood.MAPLE);
  }
}
