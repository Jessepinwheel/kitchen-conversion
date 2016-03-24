import java.util.ArrayList;
/**
 * 
 */

/**	testing whatever the hell
 * @author jessepinwheel
 *
 */
public class Test {

	
	public static void main(String []args){
		new GetData();
		GetData.fillUnits();
		GetData.unitSort();
		GetData.printVolume();
		GetData.printWeight();
		GetData.fillIngredients();
		GetData.printIngredients();
			
		ArrayList<IngredientBase> ingr=GetData.getIngredients();
		ArrayList<UnitBase> weight=GetData.getWeight();
		ArrayList<UnitBase> volume=GetData.getVolume();
		
		new Conversion();
		
		//System.out.println(Conversion.conversion(2, new UnitBase("Cup(s) (US)","c (US)",236.59,true,true),  new UnitBase("Tablespoon(s) (US)", "tbsp (US)", 14.79, true, true)));
		//System.out.println(Conversion.conversion(.5, ingr.get(2), weight.get(1), weight.get(2)));
		//System.out.println(Conversion.conversion(.5, ingr.get(0), weight.get(3), volume.get(1)));
		//System.out.println(Conversion.conversion(1, ingr.get(3), volume.get(1),weight.get(3)));
		System.out.println(Conversion.conversion(3, ingr.get(5), volume.get(1),false));
	
	}
}
