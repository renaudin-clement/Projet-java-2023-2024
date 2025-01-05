
/** public class RandomNumberInRange */
public class RandomNumberInRange {
	/** public static double getRandom(double min, double max)
	 * @param min double
	 * @param max double
	 * @return double double
	 */
	public static double getRandom(double min, double max) {
     		return (((max - min) * Math.random()) + min);
	}

	/** public static int getRandomInt(int min, int max) 
	 * @param min int
	 * @param max int
	 * @return int int
	*/
	public static int getRandomInt(int min, int max) {
		double val = getRandom(min, max);
		return (int)Math.round(val);
	}
}