package stars;

import java.awt.Color;
import java.awt.Graphics;

public class Star extends Satellite
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Star(double x, double y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) 
	{
		super(x, y, velocity_x, velocity_y, my_mass, my_radius, name);
	}

	
	 /** Overrides the parent satellite because it is drawn different than the planet, flotsam, and 
	 * black hole.
	 * 
	 * this gets the width of the satellite and then divides it by the system radius and
	 * mulitplys it by a big number to make the sun smaller so that
	 * we can see the satellite on the screen and then it sets the size of the satellite
	 * to the updated width of the satellite
	 */
	@Override
	protected void update_display_size(double radius_of_system) 
	{
		double screen_size = (Math.sqrt(this.radius)/(radius_of_system));
		screen_size *= 50_000_000;
		this.setSize((int)screen_size, (int) screen_size);
	}

}
