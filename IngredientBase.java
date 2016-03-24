/**	The IngredientBase class creates the base type for the ingredient database.
 * 
 * @author jessepinwheel
 *
 */
public class IngredientBase {

	private String type; //Ingredient upper level, e.g., flour, sugar, butter
	private String subtype="Delicious"; //Ingredient sublevel, e.g., whole wheat all-purpose, white granulated, unsalted
	double n1=-1; //value corresponding to volume conversion
	UnitBase unit1=null; //volume unit used
	double n2=-1; //value corresponding to weight conversion
	UnitBase unit2=null; //weight unit used
	UnitCount count=new UnitCount(); //count unit data
	
	boolean isSet=false; //if count data has been set

	//regular density and count density.
	public IngredientBase(String ingredientType, String ingredientSub, double n1, UnitBase volumeUnit, double n2, UnitBase weightUnit,String countName, double countValue,UnitBase countUnit){
		type=ingredientType;
		subtype=ingredientSub;
		this.n1=n1;
		unit1=volumeUnit;
		this.n2=n2;
		unit2=weightUnit;
		System.out.println(unit2.getName());
		count=new UnitCount(countName,countValue,countUnit);
		System.out.println(count.getName()+" "+type);
		
		isSet=true;
	}
	//regular density only
	public IngredientBase(String ingredientType, String ingredientSub, double n1, UnitBase volumeUnit, double n2, UnitBase weightUnit){
		type=ingredientType;
		subtype=ingredientSub;
		this.n1=n1;
		unit1=volumeUnit;
		this.n2=n2;
		unit2=weightUnit;
	}
	//count density only
	public IngredientBase(String ingredientType, String ingredientSub, String countName, double countValue,UnitBase countUnit){
		type=ingredientType;
		subtype=ingredientSub;
		count=new UnitCount(countName,countValue,countUnit);
		
		isSet=true;
	}
	
	//same as above, but without subtype entries.
	public IngredientBase(String ingredientType, double n1, UnitBase volumeUnit, double n2, UnitBase weightUnit,String countName, double countValue,UnitBase countUnit){
		type=ingredientType;
		this.n1=n1;
		unit1=volumeUnit;
		this.n2=n2;
		unit2=weightUnit;
		System.out.println(unit2.getName());
		count=new UnitCount(countName,countValue,countUnit);
		System.out.println(count.getName()+" "+type);
		
		isSet=true;
	}
	public IngredientBase(String ingredientType, double n1, UnitBase volumeUnit, double n2, UnitBase weightUnit){
		type=ingredientType;
		this.n1=n1;
		unit1=volumeUnit;
		this.n2=n2;
		unit2=weightUnit;
	}
	public IngredientBase(String ingredientType,String countName, double countValue,UnitBase countUnit){
		type=ingredientType;
		count=new UnitCount(countName,countValue,countUnit);
		
		isSet=true;
	}
	
	public IngredientBase(){}
	
	//setter functions
	
	public void setIngredient(String ingredient){
		type=ingredient;
	}
	public void setIngredientSub(String ingredientSub){
		subtype=ingredientSub;
	}
	public void setVolumeValue(double volumeValue){
		n1=volumeValue;
	}
	public void setVolumeUnit(UnitBase volumeUnit){
		unit1=volumeUnit;
	}
	public void setWeightValue(double weightValue){
		n2=weightValue;
	}
	public void setWeightUnit(UnitBase weightUnit){
		unit2=weightUnit;
	}
	public void setCountUnit(UnitCount countUnit){
		count=countUnit;
		isSet=true;
	}
	public void setCountUnit(String countName, double countValue, UnitBase countUnit){
		count=new UnitCount(countName,countValue,countUnit);
		isSet=true;
	}
	
	
	//getter functions
	public boolean isSet(){
		return isSet;
	}
	
	public String getIngredient(){
		return type;
	}

	public String getIngredientSub(){
		return subtype;
	}
	
	public double getVolumeValue(){
		return n1;
	}
	
	public UnitBase getVolumeUnit(){
		return unit1;
	}
	
	public double getWeightValue(){
		return n2;
	}
	
	public UnitBase getWeightUnit(){
		return unit2;
	}
	
	public UnitCount getCountUnit(){
		return count;
	}
	
	public double getCountWeight(){
		//gets the weight in grams per count unit, but only if count information is present.
		if(count==null){
			System.out.println("Cannot retrieve count weight: Ingredient missing count data!");
			return -1;
		}
		else{
			return count.getWeightValue()*count.getWeightUnit().getConvert();
		}
	}
	
	public double getCountVolume(){
		//calculates the volume in mL per count unit, but only if density and count information is present.
		if(count==null){
			System.out.println("Cannot retrieve count volume: Ingredient missing count data!");
			return -1;
		}
		else if(n1==-1||unit1==null||n2==-1||unit2==null){
			System.out.println("Cannot retrieve count volume: Ingredient missing density data!");
			return -1;
		}
		else{
			double weight = count.getWeightValue()*count.getWeightUnit().getConvert();
			System.out.println(weight);
			double rho = (n1*unit1.getConvert())/(n2*unit2.getConvert());
			return rho*weight;
		}
	}
	
}
