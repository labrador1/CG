/**
 * Drawing functions
 */


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.gl2.GLUgl2;
import com.jogamp.opengl.util.gl2.GLUT;


public class CgDrawer implements GLEventListener {
	GLAutoDrawable glAD;
	
	// Positions of light sources
	//static float light0pos[] = { 0.0f, -3.0f, -5.0f, 1.0f };
	//static float light1pos[] = { 5.0f, 3.0f, 3.0f, 1.0f };
    static float lightx = -200.0f;
    static float lighty = -200.0f;
    static float lightz = -200.0f;

    static double lookx = 3.0;
    static double looky = 0.0;
    static double lookz = 7.5;

    // Light change
    float lightchange = 0.0f;

    // Look change
    double lookchange = 0.0;

    /**
     * Set lightchange
     */
    public void setLightchange(float v) {
        lightchange = v;
    }

    /**
     * Set lookchange
     */
    public void setLookchange(double w) {
        lookchange = w;
    }

    /**
     * Calculate light
     */
    public void calculateLightx() {
        lightx += lightchange;
        if (lightx >= 200.0f) {
            lightx = -200.0f;
        }
    }

    public void calculateLighty() {
        lighty += lightchange;
        if (lighty >= 200.0f) {
            lighty = -200.0f;
        }
    }

    public void calculateLightz() {
        lightz += lightchange;
        if (lightz >= 200.0f) {
            lightz = -200.0f;
        }
    }

    /**
     * Calculate look
     */
    public void calculateLookup() {
        lookx += lookchange;
        if (lookx >= 10.0) {
            lookx = 10.0;
        }
    }

    public void calculateLookdown() {
        lookx -= lookchange;
        if (lookx <= -10.0) {
            lookx = -10.0;
        }
    }

    public void calculateLookright() {
        looky += lookchange;
        if (looky >= 10.0) {
            looky = 10.0;
        }
    }

    public void calculateLookleft() {
        looky -= lookchange;
        if (looky <= -10.0) {
            looky = -10.0;
        }
    }

    public void calculateLookzoomin() {
        lookz -= lookchange;
        if (lookz <= -10.0) {
            lookz = -10.0;
        }
    }

    public void calculateLookzoomout() {
        lookz += lookchange;
        if (lookz >= 10.0) {
            lookz = 10.0;
        }
    }



    /**
     * Move light
     */
    //
    public static void moveLight(float x, float y, float z) {
        lightx = x;
        lighty = y;
        lightz = z;
    }

    //static float light0pos[] = { x, y, z, 1.0f };
    //static float light1pos[] = { 5.0f, 3.0f, 3.0f, 1.0f };

    /**
	 * Initialization of drawing setting
	 */
    public void init(GLAutoDrawable drawable) {


        float silver[] = {0.5f, 0.5f, 0.5f, 1.0f};
    	
        this.glAD = drawable;
      
        GL2 gl= drawable.getGL().getGL2();
	    
        // Initialization of OpenGL setting
		gl.glEnable(GL.GL_RGBA);
		gl.glEnable(GL2.GL_DEPTH);
        gl.glEnable(GL2.GL_DOUBLE);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_NORMALIZE);
        gl.glEnable(GL.GL_CULL_FACE);
        gl.glCullFace(GL.GL_BACK);
        
        // Initialization of light sources
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_LIGHT1);
        //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, silver, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_DIFFUSE, silver, 0);
        
        // Specification of background color
        gl.glClearColor(0.82f, 1.0f, 1.0f, 1.0f);
        
	}
    
    /**
     * Called when the shape of the window is modified
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        GLUgl2 glu = new GLUgl2();

        if (height <= 0) 
            height = 1;
        float h = (float) width / (float) height;

        // Set the viewport
        gl.glViewport(0, 0, width, height);

        // Set the matrix for coordinate system transformation
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(30.0, h, 1.0, 100.0);

        // Set the matrix for object transformation
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        
		 
    }
    

    /**
     * Called when redraw is needed
     */
    public void display(GLAutoDrawable drawable) {
        moveLight(lightx,lighty,lightz);
        draw(drawable);

        //System.out.println(lightx);
    }
    

    /**
     * Dummy function (DO NOT remove)
     */
    public void displayChanged(
    	GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    	;
    }

    

	/**
	 * Called when redraw is needed
	 */
	public void draw(GLAutoDrawable drawable) {

         float light0pos[] = { lightx, lighty, lightz, 1.0f };
		 GL2 gl = drawable.getGL().getGL2();
		 GLUgl2 glu = new GLUgl2();

		 // Clear the scene
		 gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		 // Set the viewpoint
	     gl.glLoadIdentity();
		 glu.gluLookAt(looky, lookx, lookz, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
		
		 // Set the positions of light sources
		 gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light0pos, 0);
		 //gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, light1pos, 0);
		
		 // Draw
         MyScene.print();
		 MyScene.draw(drawable);


		 
	}
	
	
	public GLAutoDrawable getGLAutoDrawable() {
		return glAD;
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}


    /**
     * Change light
     */
    public void changeLightx() {
        calculateLightx();

    }

    public void changeLighty() {
        calculateLighty();

    }

    public void changeLightz() {
        calculateLightz();

    }

    /**
     * Reset light
     */
    public void resetLight() {
        lightx = 0.0f;
        lighty = 0.0f;
        lightz = 0.0f;
    }

    /**
     * Change look
     */
    public void changeLookup() {
        calculateLookup();

    }

    public void changeLookdown() {
        calculateLookdown();

    }

    public void changeLookright() {
        calculateLookright();

    }

    public void changeLookleft() {
        calculateLookleft();

    }

    public void changeLookzoomin() {
        calculateLookzoomin();

    }

    public void changeLookzoomout() {
        calculateLookzoomout();

    }

    /**
     * Reset look
     */
    public void resetLook() {
        lookx = 3.0;
        looky = 0.0;
        lookz = 7.5;
    }
}
