/** UnitBase class stores the data for each unit conversion.
 *  Each unit has data for whether it is Imperial/metric, a volume/weight unit,
 *  its value in mL (volume) or g (weight), its name, and abbreviation.
 */

/**
 * @author jessepinwheel
 *
 */
public class UnitBase {
	
		private boolean imperial;
		private boolean volume;
		private double convert=-1;
		private String name;
		private String abrv;

		
		//constructors or whatever.
		public UnitBase(String unitName, String unitAbrv, double unitConv, boolean unitImp, boolean unitVol){
			name=unitName;
			abrv=unitAbrv;
			convert=unitConv;
			imperial=unitImp;
			volume=unitVol;
		}
		
		public UnitBase(){
			
		}
		
		//Setter functions
		public void setName(String setName){
			name=setName;
		}
		
		public void setAbrv(String setAbrv){
			abrv=setAbrv;
		}
		
		public void setConvert(double setConv){
			convert=setConv;
		}
		
		public void setImperial(boolean setImp){
			imperial=setImp;
		}
		
		public void setVolume(boolean setVol){
			volume=setVol;
		}
		
		//Return functions
		public String getName(){
			return name;
		}
		
		public String getAbrv(){
			return abrv;
		}
		
		public double getConvert(){
			return convert;
		}
		public boolean getImperial(){
			return imperial;
		}
		
		public boolean getVolume(){
			return volume;
		}
		
		//Print test function
		public void printUnit(){
			System.out.println("name: "+name+", abbreviation: "+abrv+", conversion rate: "+convert);
		}
		
}
