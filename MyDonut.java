/**
 * Model of a snowman
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import java.lang.Math;


public class MyDonut {

	// Colors
	float color[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	float silver[] = { 1.0f, 1.0f, 1.0f, 1.0f };


	// IDs of vertices of faces
	int face[][] = {
			{ 0, 3, 2, 1 },
			{ 1, 2, 6, 5 },
			{ 5, 6, 7, 4 },
			{ 4, 7, 3, 0 },
			{ 4, 0, 1, 5 },
			{ 3, 7, 6, 2 }
	};

	// Normal vector of vertices
	double normal[][] = {
			{ 0.0, 0.0, 1.0 },
			{-1.0, 0.0, 0.0 },
			{ 0.0, 0.0,-1.0 },
			{ 1.0, 0.0, 0.0 },
			{ 0.0, 1.0, 0.0 },
			{ 0.0,-1.0, 0.0 }
	};

	// Place of snowman smooth
	double r1 = 0.0;
	double r2 = 0.0;

	// Speed
	double velocity = 0.0;

	// Distance from the c
	// enter of the orbit
	double transform = 0.0;

	// Place of snowman
	double donutstart1 = 0.0;
	double donutstart2 = 0.5;
	double donutplacex1 = 0.0;
	double donutplacex2 = 0.0;
	double donutplacey1 = 0.0;
	double donutplacey2 = 0.0;

	double donutplace1[] = { 0.0, 0.0, 0.0, 0.0 };
	double donutplace2[] = { 0.0, 0.0, 0.0, 0.0 };

	double ranx = 0.0;
	double rany = 0.0;

	/**
	 * Set color
	 */
	public void setColor(double r, double g, double b) {
		color[0] = (float)r;
		color[1] = (float)g;
		color[2] = (float)b;
		color[3] = 1.0f;
	}

	/**
	 * Set velocity
	 */

	public void setVelocity(int v) {
		velocity = v;
	}

	/**
	 * Set transform
	 */
	public void setTransform(double t) {
		transform = t;
	}


	/**
	 * Calculate the movement
	 */

	public double[] calculateMovement(double[] donutplace) {
		donutplace[3] += velocity;

		if (donutplace[2] >= 8.0 || donutplace[0] == 0.0) {
			rany = (int)(Math.random() * 10);
			ranx = (int)(Math.random() * 3) * 0.6 + -0.6;
			donutplace[0] = -15 - rany;
			donutplace[1] = ranx;
			donutplace[2] = 0.0;
			donutplace[3] = 0.0;
		}
		return donutplace;
	}

	/**
	 * Draw the donut
	 */

	public void draw(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		GLUT glut = new GLUT();
		donutplace1[2] = donutplace1[0] + ((double)donutplace1[3] * 0.001);

		// Set rotation and transformation
		gl.glRotated(90.0, 1.0, 0.0, 0.0);
		gl.glTranslated(donutplace1[1], donutplace1[2], -0.5);

		//
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, color, 0);
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);

		// Draw four spheres
		gl.glTranslated(0.0, 0.0, 0.0);
		glut.glutSolidTorus(0.05, 0.10, 30, 20);


		// Calculate the movement (rotation angle)
		calculateMovement(donutplace1);
	}



	/**
	 * Draw the donut2
	 */
	public void draw2(GLAutoDrawable drawable) {

		// Calculate the movement (rotation angle)
		calculateMovement(donutplace2);

		GL2 gl = drawable.getGL().getGL2();
		GLUT glut = new GLUT();
		donutplace2[2] = donutplace2[0] + ((double)donutplace2[3] * 0.001);

		// Set rotation and transformation
		gl.glRotated(90.0, 1.0, 0.0, 0.0);
		gl.glTranslated(donutplace2[1], donutplace2[2], -0.5);

		//
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, color, 0);
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);

		// Draw four spheres
		gl.glTranslated(0.0, 0.0, 0.0);
		glut.glutSolidTorus(0.05, 0.10, 30, 20);


		// Calculate the movement (rotation angle)
		//calculateMovement(donutplace2);

	}


}
