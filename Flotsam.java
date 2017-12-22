package stars;

import java.awt.Color;
import java.awt.Graphics;

public class Flotsam extends Satellite
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;

	public Flotsam(int x, int y, int velocity_x, int velocity_y, double mass, double radius, String name) 
	{
		super(x, y, velocity_x, velocity_y, 0, 0, name);

	}
	
	 /** Overrides the parent satellite because it is drawn different than the sun, planet, and 
	 * black hole.
	 * 
	 * this gets the width of the satellite and then divides it by the system radius and mulitplies 
	 * it by a semmi big number so that
	 * we can see the satellite on the screen and then it sets the size of the satellite
	 * to the updated width of the satellite
	 */

	@Override
	protected void update_display_size(double radius_of_system) 
	{

		double radius = radius_of_system;
		int num = (int) (Math.sqrt(radius)/ radius_of_system *100000);
		this.setSize(num, num);

	}

	/**
	 * overrides the paintcomponent becasuse it is a different color, and the color is not passed in.
	 */
	@Override
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillOval(0, 0,this.getWidth(), this.getWidth());

	}



}
