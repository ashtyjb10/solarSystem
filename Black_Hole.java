package stars;

import java.awt.Color;
import java.awt.Graphics;

public class Black_Hole extends Satellite
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Black_Hole(double x, double y, double velocity_x, double velocity_y, double mass, double radius, String name) 
	{
		super(x, y, velocity_x, velocity_y, mass, radius, name);
	}
	
	
	public Black_Hole(double x, double y, double my_mass, String name) 
	{
		super(x, y, 0, 0,  0, my_mass, name);
	}
	
	 /** Overrides the parent satellite because it is drawn different than the sun, flotsam, and 
	 * planets.
	 * 
	 * this is hard coded in so that it will apear on screen and affect the planets
	 */

	@Override
	protected void update_display_size(double radius_of_system) 
	{
		
		this.setSize(100, 100);
	}
	
	/**
	 * this overrides the paintcomponent because the color is not stated in the information, 
	 * and we need to set the size differently than the other satellites.
	 */
	@Override
	public void paintComponent (Graphics g)
	{
		//wag.setColor(Color.GRAY);
		g.fillOval(0, 0, getWidth(), getHeight());
	}



}
