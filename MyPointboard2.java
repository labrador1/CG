/**
 * Model of a flag
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;
import java.io.IOException;

public class MyPointboard2 {

	double i2 = 0.8;
	double j2 = 0.0;

	// Positions of vertices
	double vertex3[][] = {
			{ 2.3, 0.0, -8.0 },
			{ 2.6, 0.0, -8.0 },
			{ 2.6, 0.6, -8.0 },
			{ 2.3, 0.6, -8.0 },
			{ 2.3, 0.0, -7.5 },
			{ 2.6, 0.0, -7.5 },
			{ 2.6, 0.6, -7.5 },
			{ 2.3, 0.6, -7.5 }
	};

	double TexCoord2[][] = {
			{ i2, j2 },
			{ i2 + 0.2, j2 },
			{ i2 + 0.2, j2 + 0.5 },
			{ i2, j2 + 0.5 },
			{ i2, j2 },
			{ i2 + 0.2, j2 },
			{ i2 + 0.2, j2 + 0.5 },
			{ i2, j2 + 0.5 }
	};

	// Positions of vertices
	double vertex4[][] = {
			{ 0.5, 0.8, -0.5},
			{ 0.0, 1.0, 0.0},
			{ 0.0, 0.6, 0.0}
	};

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


	// Colors
	float red[] = { 0.8f, 0.0f, 0.0f, 1.0f };
	float blue[] = { 1.0f, 0.2f, 0.8f, 1.0f };
	float silver[] = { 0.5f, 0.5f, 0.5f, 1.0f };



	/**
	 * Draw the board
	 */
	public void draw(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		try {
			File imageFile = new File("number.png");
			Texture texture = TextureIO.newTexture(imageFile, true);
			texture.enable(gl);
			texture.bind(gl);
		} catch (IOException ex) {
			ex.printStackTrace();
		}


		// Set reflection coefficients
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, blue, 0);
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);


		// Draw a box
		for (int j = 0; j < 6; ++j) {
			gl.glBegin(GL2.GL_POLYGON);
			gl.glNormal3dv(normal[j], 0);
			for (int i = 0; i < 4; ++i) {
				gl.glTexCoord2dv(TexCoord2[face[j][i]], 0);
				gl.glVertex3dv(vertex3[face[j][i]], 0);
			}
			gl.glEnd();
		}

		// Set reflection coefficients
		gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, red, 0);

		gl.glEnd();
	}

}
