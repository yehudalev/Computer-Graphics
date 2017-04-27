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

	public double get_coordinate() {
		return _coordinate;
	}
	public void set_coordinate(double _coordinate) {
		this._coordinate = _coordinate;
	}
	

	public void add (Coordinate coordinate)
	{
		_coordinate +=coordinate._coordinate;
		
	}
	public void subtract (Coordinate coordinate)
	{
		
		_coordinate -=coordinate._coordinate;
	}
	
	
	@Override
	public int compareTo(Coordinate coordinate) {
		if(Math.abs(_coordinate-coordinate._coordinate)<=0.0001)
			 return 0;
		/*if(_coordinate-coordinate._coordinate>=0 && _coordinate-coordinate._coordinate<0.0001)
			return 0;
             if(coordinate._coordinate-_coordinate>=0 && coordinate._coordinate-_coordinate<0.0001)	
            	 return 0;
             */return -1;
		//return Double.compare(_coordinate, coordinate._coordinate);
		
			}
	@Override
	  public String toString() { 
	
		 return String.format("%.2f", _coordinate);
	         //return Double.toString(_coordinate);
	      } 
	
	

}
