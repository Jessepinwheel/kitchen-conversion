import java.util.ArrayList;

/** GetData reads the UnitBase.txt file containing all of the data for default measurements and
 *  reads them into UnitBase objects. UnitBase objects are then added to volume and weight arrays.
 *  Later, custom volumes and weights can be added, but they will go into separate arrays.
 */

/**
 * @author jessepinwheel
 *
 */
public class GetData {

 /* This is a placeholder until I can figure out how io works. For now, this assigns the objects in
 *  the order Name (string), Abbreviation (string), Conversion value to mL or grams (double),
 *	Imperial/Metric (boolean, true for imperial, false for metric), and Volume/Weight (boolean, true
 *	for volume, false for weight).
 *	
 *	This function populates an array with the database data read from an external file of some sort.
 *	It's very happy to meet you!
 */
	
	static private ArrayList<UnitBase> units =  new ArrayList<UnitBase>();
	static private ArrayList<IngredientBase> ingr = new ArrayList<IngredientBase>();
	
	static private ArrayList<UnitBase> volume = new ArrayList<>();
	static private ArrayList<UnitBase> weight = new ArrayList<>();
	
	public GetData(){
	//nothing goes here right now, I guess.
	}
	
	public static void fillUnits(){		
		//g and mL should be at the top of their respective lists so they'll be index 0. When we
		//read data from the database file or whatever, grams and milliliters will not be listed.
		units.add( new UnitBase("Gram(s)", "g", 1, false, false));
		units.add( new UnitBase("Millilitre(s)", "mL", 1, false, true));
		
		//basically, everything under here will be replaced with io stuff.
		units.add(new UnitBase("Cup(s) (US)","c (US)",236.59,true,true));
		units.add(new UnitBase("Tablespoon(s) (US)", "tbsp (US)", 14.79, true, true));
		units.add(new UnitBase("Pound(s)", "lb", 453.59, true, false));
		units.add(new UnitBase("Cup(s) (UK)", "c (UK)", 250, false, true));
		units.add(new UnitBase("Ounce(s)", "oz", 28.35, true, false));
		units.add(new UnitBase("Kilogram(s)", "kg", 1000, false, false));
		units.add(new UnitBase("Litre", "L", 1000, false, true));
		
		System.out.println(units.size());
	}
	
	
	//sorts units into volume and weight arrays.
	public static void unitSort(){
		for(int i=0; i<units.size(); i++ ){
				if(units.get(i).getVolume()==true){
					volume.add(units.get(i));
					//units.get(i).printUnit();
				}
				
				else{
					weight.add(units.get(i));
					//units.get(i).printUnit();
				}
		}
	}
	
	//populate the ingredient ArrayList
	public static void fillIngredients(){
		//eventually everything here will be replaced with io stuff.
		ingr.add(new IngredientBase("Flour","Wheat",1,volume.get(1), 140,weight.get(0)));
		ingr.add(new IngredientBase("Sugar","White Granulated",1,volume.get(1), 200,weight.get(0)));
		ingr.add(new IngredientBase("Dirt", "Grave, Damp",1, volume.get(4),1.25,weight.get(3)));
		ingr.add(new IngredientBase("Cocoa Powder", "Unsweetened", 20, volume.get(2), 3.79,weight.get(2)));
		ingr.add(new IngredientBase("Eggs","Large","Count",55,weight.get(0)));
		ingr.add(new IngredientBase("Butter",1,volume.get(1),.5,weight.get(1), "Stick",4,weight.get(2)));
	}
	
	//print functions
	public static void printUnits(){
		for(int i=0; i<units.size();i++){
			System.out.println("Unit "+i+": "+units.get(i).getName());
		}
	}
	public static void printVolume(){
		for(int i=0; i<(volume.size());i++){
			System.out.println("Volume "+i+": "+volume.get(i).getName());
		}
	}
	public static void printWeight(){
		for(int i=0; i<(weight.size());i++){
			System.out.println("Weight "+i+": "+weight.get(i).getName());
		}
	}
	public static void printIngredients(){
		for(int i=0; i<(ingr.size());i++){
			System.out.println("Ingredient "+i+": "+ingr.get(i).getIngredient()+" - "+ingr.get(i).getIngredientSub());
		}
	}
	
	//getter function
	public static ArrayList<UnitBase> getUnits(){
		return units;
	}
	public static ArrayList<UnitBase> getVolume(){
		return volume;
	}
	public static ArrayList<UnitBase> getWeight(){
		return weight;
	}
	public static ArrayList<IngredientBase> getIngredients(){
		return ingr;
	}
}
