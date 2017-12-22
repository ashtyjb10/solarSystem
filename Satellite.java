package stars;

import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * @author H. James de St. Germain
 * 
 *         Satellites are bodies that float around each other pulling at each
 *         other with gravity. The mass of an object determines how much gravitational
 *         force it applies to others.
 * 
 *
 *         Most of the methods below are labeled ABSTRACT... It is up to you to
 *         keep this labeling (and thus implement the functions in the children
 *         classes), or to remove the abstract label and implement the method
 *         for EVERY child, or two implement it here, but override it in specific children classes
 *         
 *         At the same time you are writing this class, you should consider writing specific children
 *         classes such as Planet, Star, or Flotsam. Also feel free to add comets, saucer, etc., but
 *         don't do so until the main program is itself working.
 *
 *         Finally, if you haven't implemented and testing your Geometry Vector code, any changes here
 *         will be in vain, as all math should use it.
 */


	/**
	 * This Satellite class is a parent class to planet, black hole, star and flotsam,
	 * where it paints the satelltes in space, scales the universe to the size of the screen,
	 * and updates velocity, and position so that the planets can orbit the sun, and the flotsams 
	 * can move around space.
	 * @author ashtonschmidt
	 *
	 */
public abstract class Satellite extends JComponent
{

	private double mass;
	protected double radius;
    private Geometry_Vector position;
    private Geometry_Vector velocity;

    //first version.
	private static final long serialVersionUID = 1L;

	//returns name
	public String toString()
	{
		return this.getName();
	}

	/**
	 * If necessary you can create this constructor
	 * 
	 * @param x            - where (in 2D) we are in the solar system
	 * @param y            - where (in 2D) we are in the solar system
	 * @param velocity_x   - how fast in 2D we are moving in meters per second
	 * @param velocity_y   - how fast in 2D we are moving in meters per second
	 * @param mass         - how big we are (in kilograms)
	 */
	public Satellite (double x, double y, double velocity_x, double velocity_y,
			double my_mass, double my_radius, String name)
	{

		this.position = new Geometry_Vector(x,y);
		this.velocity = new Geometry_Vector(velocity_x,velocity_y);
		this.mass = my_mass;
		this.radius = my_radius;
		this.setName(name);
	}


	/**
	 * Function Purpose:
	 * 
	 * Change position of this object by adding this object's velocity to this object's position.
	 *   
	 * Math Example: our position is 1,1.  The move vector is 10,10.  Our new position is 11,11
	 *
	 *
	 * Abstract Method Choice: for this function, and many below, you must choose whether to implement it here or in 
	 * all child classes.  In this case:
	 * 
	 * 1) is "moving" the same regardless of type.  Do stars and planets "move" through space the same.
	 *    (Hint, I would expect that they do).  If the answer is that all satellites move
	 *    the same, then remove the "Abstract" label and implement the code here.
	 *    
	 * 2) if what it means to move is different based on the type of object (this would be true in a video game)
	 *    then you would leave this as an abstract method and only implement it in the child classes.
	 * 
	 * 
	 * @param dt a small number representing how much time has gone by
	 * 
	 * Note: we are using discrete math work in a continuous system.  This means that in the real world time
	 *       is constantly flowing.  In a simluation time is broken into a stream of continuous tiny time blocks.
	 *       
	 *       To make the simulation work we must scale my a time factor.  What this means can be shown 
	 *       by looking at a car that is moving at 50 miles per hour down the highway.  If we took the car's current
	 *       position and velocity and drew a line 50 miles forward, we could try and say that is where the car
	 *       would be in an hour.  In reality, that would be wrong (no doubt the highway would change directions
	 *       (at least a little) long before that)).  
	 *       
	 *       What we can do is take the car that is moving at 50 miles per hour and compute how far it will go
	 *       in, say, 1 second.  Move it forward that much, then recompute.  If we do this 60*60 times we will
	 *       have a better approximation of where the car would be in reality.
	 *
	 * Note: the parameter dt represents the fraction of the velocity that will be applied at a given instant.
	 * 
	 * Math Example:  Our current position is 5,5.  Our current velocity is 100,100.  The time step is 0.05;
	 *                Our new position would be 10,10 -> 5,5 + (100,100 * .05)
	 *                
	 * WARNING: even if not explicitly stated in other parts of this documentation, all of the math should be done
	 *          via the Vector library.
	 *          
	 * WARNING 2: This code does not change anything about the GUI display of the object
	 *                
	 */
	

	public void update_position( double dt)
	{
		
		Geometry_Vector velocity_copy = new Geometry_Vector(this.velocity);
		velocity_copy.multiply_me_by(dt);
		position.add_to_me(velocity_copy);

		
	}

	/**
	 *
	 * change our velocity based on acceleration vector (the force applied on us) multiplied
	 * by the delta (time step) 
	 * 
	 * @param acceleration  - a vector of the force being exerted on us
	 *            
	 * Abstract Method Choice:
	 *   Once again, you can implement here or in the children, as appropriate
	 *   
	 *  Math Example:
	 *  
	 *  if my velocity is 100,100  (mph) and I have been told to accelerate by 50,50 mph (in say dt = one second)
	 *  then after one second my new velocity would be 150,150 (mph).
	 *  
	 *  if my velocity is 100,0 and I am told to accelerate by 200,100 (in say one tenth of a second)
	 *  we only apply one tenth of the 200,100, so the answer would be 100,0 + (200,100)/10 --> 120,10
	 *  
	 *  Thus the acceleration vector must be scaled by the time duration (dt) before adding to the velocity vector
	 *  
	 */
	
	

	public void update_velocity( Geometry_Vector acceleration, double dt )
	{
		acceleration.multiply_me_by(dt);
		velocity.add_to_me(acceleration);	
	}


	/**
	 *
	 *
	 * As previously stated, the location of the Satellite in the simulation is not the same as the pictures
	 * location in our GUI. For example, the earth might be at: x,y --> 149600000, 0
	 * but on the GUI the earth is displayed at 300,300 
	 * 
	 * In this method, transform the current objects position from WORLD coordinates into GUI coordinates x,y.
	 * 
	 * In order to do this we have to know our relation to the center of the solar system and how wide the solar
	 * system is. We also have to know how wide the GUI window is.
	 * 
	 * Note: The first thing to in an update_screen_coordinates method would be to update the display size of 
	 * the object. the last thing you would do is set the location of the object.
	 * 
	 * Abstract Method Choice:
	 *    Once again, if you believe the math to transform from one x,y to another is different for different
	 *    objects, then you should leave this method abstract and let each child class implement it.
	 *    
	 *    If you believe the math is the same for all objects, you should remove the "abstract" keyword and
	 *    write the code here.
	 *    
	 *  Math: to start try the following:  divide the simluation X,Y by say 1,000,000.  This should transform
	 *        the positions into something reasonable, (e.g., the earth becomes 149,0)  Then simply use this
	 *        vale.
	 *        
	 *        The planets (assuming everything else is correct) will now rotate around the 0,0 location
	 *        of the GUI (the upper left hand corner).  By then adding half the width of the screen/height of the
	 *        screen to this number (hard code to say 500,500) the planets will rotate around 500, 500.
	 *        
	 *        Once you have this working, try and make it work for any size screen
	 *
	 */
	
	
	
	/*
	 * Ashton's Java doc:
	 * 
	 * This method creates a copy of the position and then moves the position of the satellite
	 * from the top left of the screen to the center and then moves the center of the 
	 * satellite to the center where it should be.
	 */
	public void update_screen_coordinates(Geometry_Vector system_center, double system_radius,
			int window_width, int window_height )
	{
		this.update_display_size(system_radius);

		Geometry_Vector copy = new Geometry_Vector(this.position);
		copy.subtract_from_me(system_center);
		copy.divide_by(system_radius);
		copy.multiply_me_by(window_width/2);
		
		int gui_x = window_width /2;
		int gui_y = window_height / 2;
		
		gui_x += copy.x;
		gui_y += copy.y;
		
		gui_x -= this.getWidth() /2;
		gui_y-= this.getHeight() /2;
		
		this.setLocation(gui_x,gui_y);
		
	}

	/**
	 *
	 * Abstract Method Choice: if the mass of an object is a common property to all satellites, then
	 * define this getter here.  If the (property) mass of an object is different across various objects,
	 * leave this function abstract.  
	 *
	 * @return our mass
	 */
	public double get_mass()
	{
		return mass;
	}
	
	

	/**
	 *
	 * Abstract Method Choice: does what type we are define what are position is?
	 *
	 * @return our position
	 */
	public Geometry_Vector get_position()
	{
		return position;
	}

	/**
	 *
	 * Abstract Method Choice: You can implement here or in the children, as appropriate
	 *
	 * @return our velocity
	 */
	public Geometry_Vector get_velocity()
	{
		return velocity;
	}

	/**
	 *
	 * based on our physical size, change the gui component to be large enough to show itself....
	 * 
	 * unfortunately, the scales of the solar system are so large that we wouldn't
	 * be able to see more than one planet at a time if we simply divided the
	 * radius of the object by the radius of the solar system, so we must scale the satellite
	 * by some arbitrary "looks good" factor. You will have to play with this to
	 * find an appropriate size such that we can see everything, but they don't
	 * overlap each other
	 * 
	 * Abstract Method Choice: Consider the problems caused by the scales involved in "Seeing" the solar system.
	 *                         Choice 1) If all satellites should be drawn at the same scale, implement the code here.
	 *                         Choice 2) If all satellites need to be drawn at a larger scale, then implement this
	 *                         in the child classes.
	 *                         Choice 3) If some satellites need to be drawn at a larger scale, but most can be drawn
	 *                         at a common scale, write the code here, then override it in the appropriate child class.
	 *                          
	 * 
	 * Note: this function should use the JComponent Set Size function to change the size of the GUI display of
	 *       the object.
	 *       
	 * Note 2: we take in the radius_of_system parameter to allow this function to know how big the displayed area
	 *         is which can factor into how big we draw our planets.  To start you may want to make all displayed
	 *         objects the same size regardless, then see how changing their size affects the simulation
	 *         
	 * Note 3: in general, the larger the region we want to see on the screen, the smaller the satellites should be
	 *         drawn         
	 * 
	 * @param radius_of_universe - how far across the displayable universe (in our standard case we set the
	 *                             orbit of saturn as this value)
	 */
	
	/*
	 * 
	 * Ashton's Java doc:
	 * 
	 * kept as abstract because planet, sun, flotsam, and blackhole's display size are completely
	 * different.
	 * 
	 * This method makes it so that the satellites can fit on the screen, although they are 
	 * different sizes in actual space this is done by getting the radius of the system and then
	 * dividing it by the radius of the planet.
	 */
	abstract protected void update_display_size( double radius_of_system );
	
	/*
	 * Ashton's Java doc:
	 * Draws all satellites in space, and is done here because all are drawn the same, but
	 * also overridden because the black hole, and flotsams are drawn a little differently
	 */
	public void paintComponent(Graphics g)
	{
		g.fillOval(0, 0, this.getWidth(), this.getHeight());
	}
}
