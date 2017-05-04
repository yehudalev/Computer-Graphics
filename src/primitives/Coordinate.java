package primitives;


public class Coordinate implements Comparable<Coordinate>{
	
	private double _coordinate;

	//Default cons
	public Coordinate()
	{
		_coordinate=0;
	}
	//full cons
	public Coordinate(double coordinate)
	{
		set_coordinate(coordinate);
	}
	
	//copy cons
	public Coordinate(Coordinate coordinate)
	{
		set_coordinate(coordinate._coordinate);
	}
	//getter and setter

	public double get_coordinate() {
		return _coordinate;
	}
	public void set_coordinate(double _coordinate) {
		this._coordinate = _coordinate;
	}
	
	//class-operations
	
		//add function- sum this coordinate with the parameter coordinate 
	public void add (Coordinate coordinate)
	{
		_coordinate +=coordinate._coordinate;
		
	}
	//subtract function- sub this coordinate with the parameter coordinate 
	public void subtract (Coordinate coordinate)
	{
		
		_coordinate -=coordinate._coordinate;
	}
	
	
	//Compare 2 coordinate, if both are equal return 0, else then return -1 (with deviation of 0.0001)
		@Override
		public int compareTo(Coordinate coordinate) {
			if(Math.abs(_coordinate-coordinate._coordinate)<=0.0001)
				 return 0;
			return -1;		
				}
	
	//print the coordinate object (the element coordinate)
	@Override
	  public String toString() { 
	
		 return String.format("%.2f", _coordinate);
	      
	      } 
	
	

}
