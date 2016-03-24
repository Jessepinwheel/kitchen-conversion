import java.util.ArrayList;

/**	Code for Volume/Volume or Weight/Weight conversions.
 * 
 * 	This code takes an input of a number (double), volume/weight (boolean, volume for true),
 * 	an index number for input (int), and an index number for output (int).
 * 
 * 	Right now this is separated so people don't have to specify an ingredient density.
 * 
 */
public class Conversion {
	
	static private double n; //number to convert
	static private double c1, c2; //input and output conversion factors
	static private double rho; //density factor in g/mL
	
	static private String u1, u2; //names for units converted
	
	static private double output; //completed conversion
	static private double convert1; //conversion without density factor
	static private IngredientBase ingr; //input ingredient
	static private UnitBase unit1; //input unit
	static private UnitBase unit2; //output (converted) unit
	static private UnitCount count; //ingredient count unit

	public Conversion(){	
		}
		
	/**
	 * Basic like-unit conversion function.
	 */
	static public double conversionCore(double n, UnitBase cIn, UnitBase cOut){

		double out;
		double x=n;
		c1=cIn.getConvert();
		c2=cOut.getConvert();
		
		out=x*c1/c2;
		
		return out;
	}
	
	/**
	 * Density factor conversion calculator. It takes an ingredient input. For weight to volume
	 * conversions, this needs to be reciprocated.
	 */
	
	static public double densityCore(IngredientBase ingr){
		double x1 = ingr.getVolumeValue();
		double u1 = ingr.getVolumeUnit().getConvert();
		double x2 = ingr.getWeightValue();
		double u2 = ingr.getWeightUnit().getConvert();
		
		//System.out.println(x1);
		//System.out.println(unit1);
		//System.out.println(x2);
		//System.out.println(unit2);
		
		rho = (x2*u2)/(x1*u1);
		
		//System.out.println("rho equals: " +rho);
		return rho;

	}
	
	
	/**
	 * Unit to unit conversion. Does not require density or ingredient information. Only works
	 * for V/V or W/W
	 */
	static public double conversion(double value, UnitBase cIn, UnitBase cOut){
		n=value;
		
		if(cIn.getVolume() != cOut.getVolume()){
			System.out.println("Error: Units Incompatible. Ingredient density required.");
			return -1;
		}
		else{
			return conversionCore(n, cIn, cOut);
		}
	}
	
	/**
	 *  Weight to volume, volume to weight, volume to volume, or weight to weight conversion. This one
	 *  requires an ingredient. If doing V/W or W/V, density information is also required.
	 *  Normal density calculation.
	 */
	static public double conversion(double value, IngredientBase ingredient, UnitBase cIn, UnitBase cOut){
		n=value;
		ingr=ingredient;
		unit1=cIn;
		unit2=cOut;
		
		System.out.println(ingr.getIngredient()+" - "+ingr.getIngredientSub());
		
		convert1=conversionCore(n,unit1,unit2);
		rho=densityCore(ingr);
		
		if (unit1.getVolume()==unit2.getVolume()){	
			return convert1;
		}

		else if(unit1.getVolume()==true){
			//case for volume to weight conversion
			output = convert1*rho;
		}
		else{
			//case for weight to volume conversion
			output = convert1/rho;
		}
		return output;
	}
	
	/**
	 * Count to unit or vice versa. Count information is contained within IngredientBase.
	 */
	static public double conversion(double value, IngredientBase ingredient, UnitBase cOut,boolean countToUnit){
		System.out.println(ingredient.getIngredient()+" - "+ingredient.getIngredientSub());

		if (ingredient.isSet()==false){
			System.out.println("Ingredient does not have a count unit!");
			return -1;
		}
		
		else{
			ingr=ingredient;
			n=value;
			unit2=cOut;
			count=ingr.getCountUnit();
			
			if(unit2.getVolume()==true){
			if(ingr.getVolumeValue()==-1||ingr.getVolumeUnit()==null||ingr.getWeightValue()==-1||ingr.getWeightUnit()==null){
				System.out.println("Ingredient missing density data!");
				return -1;
			}
			else if(countToUnit==true){
				//converting count to volume
				output=n*ingr.getCountVolume()/unit2.getConvert();
				//System.out.println(ingr.getCountVolume());
			}
			else{
				//converting volume to count
				output=n*unit2.getConvert()/ingr.getCountVolume();
				//System.out.println(2);
			}
		}
		
			else if(countToUnit==true){
			output=ingr.getCountWeight()*n;
			//System.out.println(3);
		}
			else{
			output=n/ingr.getCountWeight();
			//System.out.println(4);
		}
		
			return output;
		}
	}
	
}
