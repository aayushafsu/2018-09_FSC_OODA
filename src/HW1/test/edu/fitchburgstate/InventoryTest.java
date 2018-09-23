/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Date: 2018-09-18
 * Students: Aayusha Agrawal (@01395854)
 */
package HW1.test.edu.fitchburgstate;
import static org.junit.jupiter.api.Assertions.*;

import HW1.edu.fitchburgstate.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Contains tests to test methods of Inventory class.
 */
public class InventoryTest {

    Inventory inventory;
    Guitar guitar1;
    Guitar guitar2;
    Guitar guitar3;


    @BeforeEach
    public void setup() {
       inventory = new Inventory();

       guitar1 = new Guitar("X200", 1499, GuitarManufacturer.GIBSON, "Stratocastor", GuitarType.ELECTRIC,
               GuitarWood.MAHOGANY, GuitarWood.ALDER);
       inventory.addGuitar(guitar1.getSerialNumber(), guitar1.getPrice(), guitar1.getgSpec().getManufacturer(), guitar1.getgSpec().getModel(),
               guitar1.getgSpec().getType(), guitar1.getgSpec().getBackWood(), guitar1.getgSpec().getTopWood());

       guitar2 = new Guitar("X301", 5999, GuitarManufacturer.FENDER, "CJ", GuitarType.ACOUSTIC,
               GuitarWood.INDIAN_ROSEWOOD, GuitarWood.CEDAR);
       inventory.addGuitar(guitar2.getSerialNumber(), guitar2.getPrice(), guitar2.getgSpec().getManufacturer(),
               guitar2.getgSpec().getModel(), guitar2.getgSpec().getType(), guitar2.getgSpec().getBackWood(),
               guitar2.getgSpec().getTopWood());

       guitar3 = new Guitar("X501",2999, GuitarManufacturer.COLLINGS, "Stratocastor",GuitarType.ELECTRIC,
               GuitarWood.MAPLE, GuitarWood.COCOBOLO);
        inventory.addGuitar(guitar3.getSerialNumber(), guitar3.getPrice(), guitar3.getgSpec().getManufacturer(), guitar3.getgSpec().getModel(),
                guitar3.getgSpec().getType(), guitar3.getgSpec().getBackWood(), guitar3.getgSpec().getTopWood());
    }


    /**
     * Test if adding another Guitar to the Inventory does not affect the existing Inventory.
     */
    @Test
    void testAddGuitar(){
        Guitar newGuitar = new Guitar("X8020", 3500, GuitarManufacturer.FENDER, "CJ",
                GuitarType.ACOUSTIC, GuitarWood.INDIAN_ROSEWOOD, GuitarWood.MAPLE);
        //Add Guitar 2
       inventory.addGuitar(newGuitar.getSerialNumber(), newGuitar.getPrice(), newGuitar.getgSpec().getManufacturer(),
               newGuitar.getgSpec().getModel(),
               newGuitar.getgSpec().getType(), newGuitar.getgSpec().getBackWood(), newGuitar.getgSpec().getTopWood());


       //Check if the existing Guitar is present in the Inventory.
       Guitar returnedGuitar1 = inventory.getGuitar(this.guitar1.getSerialNumber());
       compareGuitars(this.guitar1, returnedGuitar1);

       //Check if the new Guitar is present in the Inventory.
        Guitar returnedNewGuitar = inventory.getGuitar(newGuitar.getSerialNumber());
        compareGuitars(newGuitar, returnedNewGuitar);
    }

    /**
     * Test if the guitar found is the right guitar
     */
    @Test
     void testGetGuitar(){
        Guitar guitar = inventory.getGuitar(guitar1.getSerialNumber());

        Guitar requiredGuitar = new Guitar("X200", 1499, GuitarManufacturer.GIBSON, "Stratocastor", GuitarType.ELECTRIC,
                GuitarWood.MAHOGANY, GuitarWood.ALDER);

        assertEquals(requiredGuitar.getSerialNumber(), guitar.getSerialNumber());
    }

    /**
     * Tests guitar search by manufacturer Gibson
     */
    @Test
    void testSearchGuitarByGibsonManufacturer(){
        GuitarSpec requiredGuitar = new GuitarSpec(GuitarManufacturer.GIBSON,null, null,
              null,null);
        List<Guitar> foundguitars= inventory.search(requiredGuitar);

        assertEquals(1,foundguitars.size());
        compareGuitars(guitar1, foundguitars.get(0));
    }

    /**
     * Tests guitar search by manufacturer fender
     */
    @Test
    void testSearchGuitarByFenderManufacturer(){
        GuitarSpec requiredGuitar = new GuitarSpec(GuitarManufacturer.FENDER,null, null,
                null,null);
        List<Guitar> foundguitars= inventory.search(requiredGuitar);

        assertEquals(1,foundguitars.size());
        compareGuitars(guitar2, foundguitars.get(0));
    }

    /**
     * Tests guitar search by Type Electric
     */
    @Test
    void testSearchGuitarByElectricType(){
        GuitarSpec requiredGuitar = new GuitarSpec(null,null, GuitarType.ELECTRIC,
                null,null);
        List<Guitar> foundguitars= inventory.search(requiredGuitar);

        assertEquals(2,foundguitars.size());
        compareGuitars(guitar1, foundguitars.get(0));
        compareGuitars(guitar3, foundguitars.get(1));
    }

    /**
     * Tests guitar search by bulder=fender, type=electric, topwood=alder, backwood=alder,  model=Stratocastor
     */
    @Test
    void testSearchGuitarBySpecficType(){
        GuitarSpec requiredGuitar = new GuitarSpec(GuitarManufacturer.FENDER,"Stratocastor",
                GuitarType.ELECTRIC, GuitarWood.ALDER,GuitarWood.ALDER);
        List<Guitar> foundguitars= inventory.search(requiredGuitar);

        assertEquals(0,foundguitars.size());

    }

    /**Compares two guitars if they are the same guitar. If the guitars are not equal the method throws
     * assertion error.
     * @param guitar1 some guitar
     * @param guitar2 some guitar
     */
    private void compareGuitars(Guitar guitar1, Guitar guitar2) {
        if (guitar1 == null ) {
            if (guitar2 == null) {
                //Both Guitar are null
                return;
            } else {
                //Guitar1 is null but Guitar2 is not.
                assertTrue(false);
            }
            // If guitar2 is null but guitar1 is not.
        } else if (guitar2 == null) {
            assertTrue(false);
        }

        assertEquals(guitar1.getSerialNumber(), guitar2.getSerialNumber());
        assertEquals(guitar1.getgSpec().getManufacturer(), guitar2.getgSpec().getManufacturer());
        assertEquals(guitar1.getgSpec().getModel(), guitar2.getgSpec().getModel());
        assertEquals(guitar1.getPrice(), guitar2.getPrice());
        assertEquals(guitar1.getgSpec().getType(), guitar2.getgSpec().getType());
        assertEquals(guitar1.getgSpec().getBackWood(), guitar2.getgSpec().getBackWood());
        assertEquals(guitar1.getgSpec().getTopWood(), guitar2.getgSpec().getTopWood());
    }
}

