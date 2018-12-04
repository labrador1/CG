/**
 * Model of a snowman
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;


public class MySnowman {

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
	double r = 0.0;

	// Speed
	double velocity = 0.0;

	// Distance from the c
	// enter of the orbit
	double transform = 0.0;

	// Place of snowman
	///double snowplace = 0.04;
	double snowplace = 0.00;

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
	/*
	public void setVelocity(int v) {
		velocity = v;
	}*/

	/**
	 * Set transform
	 */
	public void setTransform(double t) {
		transform = t;
	}

	/**
	 * Calculate the movement
	 */

	public void calculateMovement(double velocity) {
		r += velocity;
		if (r >= 60000) {
			r = 60000;
		}
		else if (r <= -60000) {
			r = -60000;
		}
	}
	public double moveSnowmansmooth(double u) {
		calculateMovement(u);
		return (double)r*0.00001;
	}


	/**
	 * Reset the movement (reset the rotation angle)
	 */
	public void resetMovement() {
		r = 0;
	}

	/**
	 * Move snowman
	 */
	public void moveSnowman(double s) {
		snowplace = s;
	}



	/**
	 * Draw the snowman
	 */
	public void draw(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		GLUT glut = new GLUT();

		// Set rotation and transformation
		//gl.glRotated(((double)r * 0.1), 0.0, 1.0, 0.0);
		gl.glRotated(0.0, 0.0, 1.0, 0.0);
		//gl.glTranslated(-((double)r * 0.001), 0.0, transform);
		///gl.glTranslated(snowplace, 0.0, transform);
		gl.glTranslated(snowplace, 0.0, 3.0);
		//gl.glTranslated(0.0, 0.0, 0.0);

		//
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, silver, 0);
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);

		// Draw four spheres
		//gl.glTranslated(0.5, 0.5, 3.0);
		gl.glTranslated(0.0, 0.5, 0.0);
		glut.glutSolidSphere(0.25, 30, 20);

		gl.glTranslated(0.0, 0.3, 0.0);
		glut.glutSolidSphere(0.2, 30, 20);

		// Calculate the movement (rotation angle)
		//calculateMovement();
	}



}
