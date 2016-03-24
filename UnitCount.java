/**
 * UnitCount is a special type of unit that can be specified for each ingredient.
 * This is for discrete numbers of ingredients, like sticks of butter or single eggs.
 * It requires a name and equivalent value (double) and weight unit (UnitBase)
 */

/**
 * @author jessepinwheel
 *
 */
public class UnitCount {

	private String count;
	private double x;
	private UnitBase unit;

	public UnitCount(){}
	
	public UnitCount(String name, double weightValue, UnitBase weightUnit){
		count=name;
		x=weightValue;
		unit=weightUnit;

	}
	
	//get functions

	public String getName(){
		return count;
	}
	public double getWeightValue(){
		return x;
	}
	public UnitBase getWeightUnit(){
		return unit;
	}
	
	//set functions
	public void setName(String name){
		count=name;
	}
	public void setWeightUnit(UnitBase weightUnit){
		unit=weightUnit;
	}
	public void setWeightValue(double weightValue){
		x=weightValue;
	}
	
}
