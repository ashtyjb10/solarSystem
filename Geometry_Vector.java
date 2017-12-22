package stars;
import java.awt.geom.Point2D;
import java.util.Vector;
/**  * @author germain/ Ashton Schmidt
 * **/
public class Geometry_Vector extends Point2D.Double
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Ashtons Javadoc
	 * 
	 * constructor
	 */
	public  Geometry_Vector(double xx, double yy)   
	{
		super(xx,yy);
		
	}
	/**    *    * A "Copy" constructor.  Creat ourself based on the given vector 
   * @param the_copy    */    
	public  Geometry_Vector(Geometry_Vector the_copy)
	{
		this.x = the_copy.x;
		this.y = the_copy.y;
	}
	

	/**
	 * adds x2(parameter) to x1, and adds y2 (parameter) to y1
	 * @param vector
	 */
	public void add_to_me(Geometry_Vector vector) 
	{
	
		this.x +=  vector.x;
		this.y +=  vector.y;
	}


	/**
	 * subtracts x2(parameter) from x1, and subtracts y2(parameter) from y1
	 * @param vector
	 */
	public void subtract_from_me(Geometry_Vector vector)  
	{
		this.x -= vector.x;
		this.y -= vector.y;
		
	}
	

	/**
	 * divides x1 by the scalar, and y1 by the scalar
	 * @param scalar
	 */
	
	public void divide_by( double scalar )  
	{
		if(scalar == 0)
		{
			return;
		}
		
		this.x /=  scalar;
		this.y /= scalar;
	}

	/**
	 *   multiplys x1 by the scalar, and y1 by the scalar
	 * @param scalar
	 */
	public  void   multiply_me_by(double scalar)  
	{
		this.x *=  scalar;
		this.y *= scalar;
	
		
	}
	
	
	/**
	 *  returns pythags therom a^2+b^2 = c^2
	 * @return
	 */
	public  double  magnitude()  
	{
			return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}
	
	/**
	 *  returns information about the x and y
	 * @return
	 */	public  String toString()   
	{
	
			return ("x: "+ this.x +" y: "+ this.y);
	}
	/**    
	 * Take this vector and turn it into a vector of length 1.  This is done by
   */   
	public   void   normalize()  
	{
		double magnitude = magnitude();
		this.x /= magnitude;
		this.y /= magnitude;

	}   
}


