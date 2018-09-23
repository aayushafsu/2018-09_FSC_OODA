/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 2
 * Date: 2018-09-18
 * Students: Aayusha Agrawal (@01395854)
 */

package HW1.edu.fitchburgstate;

/**
 * Guitar contains the information needed to keep track of a type of guitar from
 * Rick's music store
 */
public class Guitar {

	/**
	 * GuitarSpec is the guitar specifications contains parameters manufacturer, model, type, backWood, topWood.
	 */
	private GuitarSpec gSpec;

	/**
	 * Full constructor
	 * @param serialNumber manufacturer serial number
	 * @param price store price
	 * @param manufacturer the guitar's manufacturer
	 * @param model the manufacturers model
	 * @param type guitar type (electric/accoustic)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
	 */
	public Guitar(String serialNumber, double price,
				  GuitarManufacturer manufacturer, String model,
				  GuitarType type, GuitarWood backWood,
				  GuitarWood topWood) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.gSpec = new GuitarSpec(manufacturer, model, type, backWood, topWood);
	}

	/**
	 * Returns the manufacturer serial number
	 * 
	 * NB: Gets and sets do not need @params or @returns because they do one thing which
	 * is already in the comment
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Returns store price of guitar
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the store price of the guitar
	 */
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	/**
	 * The guitars manufacturer serial number
	 */
	private String serialNumber;

	/**
	 * Rick's price for the guitar
	 */
	private double price;

	/**
	 * @return GuitarSpec returns guitarspec
	 */
	public GuitarSpec getgSpec()
	{
		return gSpec;
	}

}
