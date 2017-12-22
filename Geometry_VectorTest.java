package stars;

import static org.junit.Assert.*;

import org.junit.Test;

public class Geometry_VectorTest {
	
	Geometry_Vector v1 = new Geometry_Vector(1,1);
	Geometry_Vector v2 = new Geometry_Vector(v1);
	Geometry_Vector v3 = new Geometry_Vector(v1);
	Geometry_Vector v4 = new Geometry_Vector(4,4);
	Geometry_Vector v5 = new Geometry_Vector(5,5);
	Geometry_Vector v6 = new Geometry_Vector(6,6);
	Geometry_Vector v7 = new Geometry_Vector(2,2);
	Geometry_Vector v8 = new Geometry_Vector(3,3);

	
	
	@Test
	public void test_copy() 
	{
		assertEquals(v1,v2);
		assertEquals(v1,v2);
	
	}
	@Test
	public void test_add()
	{
		v4.add_to_me(v1);
		assertEquals(v5,v4);
		
		v5.add_to_me(v1);
		assertEquals(v6,v5);
	}
	@Test
	public void test_sub()
	{
		v6.subtract_from_me(v1);
		assertEquals(v6,v5);
		v5.subtract_from_me(v1);
		assertEquals(v5,v4);
	}
	@Test
	public void test_divide()
	{
		v7.divide_by(1);
		assertEquals(v7,v7);
		
		v6.divide_by(2);
		assertEquals(v6,v8);
	}
	@Test
	public void test_mult()
	{
		v1.multiply_me_by(1);
		assertEquals(v1,v1);
		
		v7.multiply_me_by(3);
		assertEquals(v7,v6);
	}
	@Test
	public void test_mag()
	{
		v1.magnitude();
		assertEquals(v1,v1);
		
		v6.magnitude();
		assertEquals(v6,v6);
	}
	@Test
	public void test_norm()
	{
		v1.normalize();
		assertEquals(v1,v1);
		
		v6.normalize();
		assertEquals(v6,v6);

	}
	
	
	
	
	@Test
	public void test() 
	{
		
	}

}
