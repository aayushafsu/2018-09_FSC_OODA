/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-12
 * Students: Aayusha Agrawal (@01395854)
 */

package HW1.test.edu.fitchburgstate;

import static org.junit.jupiter.api.Assertions.*;
import HW1.edu.fitchburgstate.Guitar;
import HW1.edu.fitchburgstate.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Contains tests to test methods of Inventory class.
 */
public class InventoryTest {
    Inventory inventory;
    Guitar testGuitar1;
    Guitar testGuitar2;

    /**
     * Test setup. Create Inventory by adding test guitars.
     */
    @BeforeEach
    public void setup() {
        // instantiate inventory class
        inventory = new Inventory();

        testGuitar1 = new Guitar("1000", 599.99, "Nirma", "Xtreme", "acoustic",
                "Indian Rosewood", "Rosewood");

        inventory.addGuitar(testGuitar1.getSerialNumber(), testGuitar1.getPrice(), testGuitar1.getManufacturer(),
                testGuitar1.getModel(), testGuitar1.getType(), testGuitar1.getBackWood(), testGuitar1.getTopWood());

        testGuitar2 = new Guitar("X200", 1199.99, "Gain", "Zeta", "electric",
                "Alder", "Mahogany");

        inventory.addGuitar(testGuitar2.getSerialNumber(), testGuitar2.getPrice(), testGuitar2.getManufacturer(),
                testGuitar2.getModel(), testGuitar2.getType(), testGuitar2.getBackWood(), testGuitar2.getTopWood());
    }

    /**
     * Tests if we can get a guitar by the serial number.
     */
    @Test
    void testGetGuitarBySerialNumber() {
        Guitar userGuitarPreference = inventory.getGuitar(testGuitar1.getSerialNumber());
        compareGuitars(testGuitar1, userGuitarPreference);
    }


    /**
     * Tests to see if a guitar is returned on No preference specified by the user
     */
    @Test
    void testGetGuitarNoPreference() {

        Guitar userGuitarPreference = new Guitar(null, 0, null, null, null,
                null, null);

        Guitar returnedGuitar = inventory.search(userGuitarPreference);

        try {
            //Check if testGuitar 1 is returned
            compareGuitars(testGuitar1, returnedGuitar);
        } catch (AssertionError e) {
            //If testGuitar1 is not returned, check if testGuitar2 is returned.
            compareGuitars(testGuitar2, returnedGuitar);
        }
    }

    /**
     * Compares two guitars if they are the same guitar. If the guitars are not equal the method throws
     * assertion error.
     *
     * @param guitar1 - some guitar.
     * @param guitar2 - some guitar.
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
        assertEquals(guitar1.getManufacturer(), guitar2.getManufacturer());
        assertEquals(guitar1.getModel(), guitar2.getModel());
        assertEquals(guitar1.getPrice(), guitar2.getPrice());
        assertEquals(guitar1.getType(), guitar2.getType());
        assertEquals(guitar1.getTopWood(), guitar2.getTopWood());
        assertEquals(guitar1.getBackWood(), guitar2.getBackWood());
    }

    /**
     * Tests if a Guitar is returned when the user searches guitar by Backwood.
     */
    @Test
    void testSearchGuitarByBackwood() {
        Guitar userGuitarPreference = new Guitar("", 0, "", null, null,
                "Indian Rosewood","");

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(userGuitarPreference.getBackWood(), returnedGuitar.getBackWood());
    }

    /**
     * Tests if a Guitar is returned when the user searches guitar by topwood 
     */
    @Test
    void testSearchGuitarByTopwood() {
        Guitar userGuitarPreference = new Guitar("", 0, "", null, null,
                "","Mahogany");

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(userGuitarPreference.getTopWood(), returnedGuitar.getTopWood());
    }

    /**
     * Tests if a Guitar is returned when the user searches guitar by model
     */
    @Test
    void testSearchGuitarByModel() {
        Guitar userGuitarPreference = new Guitar("", 0, "", "Zeta", null,
                "", "");

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(userGuitarPreference.getModel(), returnedGuitar.getModel());

    }

    /**
     * Tests if a Guitar is returned when the user searches guitar by Type
     */
    @Test
    void testSearchGuitarByType() {
        Guitar userGuitarPreference = new Guitar("", 0, "", null, "acoustic",
                "", "");

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(userGuitarPreference.getType(), returnedGuitar.getType());


    }

    /**
     * Tests if a Guitar is returned when the user searches guitar by Manufacturer name
     */
    @Test
    void testSearchGuitarByManufacturer() {
        Guitar userGuitarPreference = new Guitar("", 0, "Nirma", "", null,
                "", "");

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(userGuitarPreference.getManufacturer(), returnedGuitar.getManufacturer());

    }

    /**
     * Tests to see if no guitar is returned when the user specified manufacturer Guitar is not present in the
     * Inventory.
     */
    @Test
    void testSearchGuitarByUnavailableManufacturer() {
        Guitar userGuitarPreference = new Guitar(null, 0, null, null, null,
                null, null);

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(null, returnedGuitar);

    }

    /**
     * Tests to see if no guitar is returned when the user specified model of Guitar is not present in the
     * Inventory.
     */
    @Test
    void testSearchGuitarByUnavailableModel() {
        Guitar userGuitarPreference = new Guitar(null, 0, null, "Alpha", null,
                null, null);

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(null, returnedGuitar);

    }

    /**
     * Tests to see if no guitar is returned when the user specified Type of Guitar is not present in the
     * Inventory.
     */
    @Test
    void testSearchGuitarByUnavailableType() {
        Guitar userGuitarPreference = new Guitar(null, 0, null, null, "Bass",
                null, null);

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(null, returnedGuitar);

    }

    /**
     * Tests to see if no guitar is returned when the user specified Guitar Backwood material is not present in the
     * Inventory.
     */
    @Test
    void testSearchGuitarByUnavailableBackwood() {
        Guitar userGuitarPreference = new Guitar(null, 0, null, null, null,
                "Sandalwood", null);

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(null, returnedGuitar);

    }

    /**
     * Tests to see if no guitar is returned when the user specified Guitar Topwood material is not present in the
     * Inventory.
     */
    @Test
    void testSearchGuitarByUnavailableTopwood() {
        Guitar userGuitarPreference = new Guitar(null, 0, null, null, null,
                "", "Sandalwood");

        Guitar returnedGuitar = inventory.search(userGuitarPreference);
        assertEquals(null, returnedGuitar);

    }
}



