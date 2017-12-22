package stars;

import java.awt.Graphics;


public class Planet extends Satellite 
{

	public Planet(double x, double y, double velocity_x, double velocity_y, double my_mass, double my_radius,
			String name) 
	{
		super(x, y, velocity_x, velocity_y, my_mass, my_radius, name);

	}


	
	/**
	 * Overrides the parent satellite because it is drawn different than the sun, flotsam, and 
	 * black hole.
	 * 
	 * this gets the width of the satellite and then divides it by the system radius and 
	 * multiplied by a big number so that
	 * we can see the satellite on the screen and then it sets the size of the satellite
	 * to the updated width of the satellite
	 */
	@Override
	protected void update_display_size(double radius_of_system) 
	{
		int width =  (int) (this.radius / radius_of_system *2_500_000);
		this.setSize(width, width);


	}



}
