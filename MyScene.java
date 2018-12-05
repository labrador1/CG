/**
 * Model of a scene
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.lang.Math;


public class MyScene {

	// Models of a flag and a car
	static MyFlag flag1 = null;
	static MyCar car1 = null;
	static MyDonut donut = null;
	static MyBoard1 board1 = null;
	static MyBoard2 board2 = null;
	static MyBoard3 board3 = null;
	static MySnowman snowman = null;
	static MyPointboard pointboard = null;
	static MyPointboard2 pointboard2 = null;
	static MyPointboard3 pointboard3 = null;
	static CgDrawer cgdrawer = null;

	static int all_point = 0;
	static int point1 = 0;
	static int point2 = 0;
	static int point3 = 0;
	static int flag = 0;
	
	/**
	 * Initialization
	 */
	public static void init() {
		
		 // Allocate a flag
		 flag1 = new MyFlag();
		 
		 // Allocate a car
		 car1 = new MyCar();
		 car1.setColor(1.0, 0.0, 0.0);
		 car1.setVelocity(100);
		 car1.setTransform(-0.6);

		// Allocate a donut
		donut = new MyDonut();
		donut.setColor(1.0, 0.0, 0.0);
		donut.setVelocity(200);

		// Allocate a board
		 //board1 = new MyBoard();
		 board1 = new MyBoard1();
		 board2 = new MyBoard2();
		 board3 = new MyBoard3();

		// Allocate a snowman
		snowman = new MySnowman();
		snowman.setColor(1.0, 1.0, 1.0);
		//snowman.setVelocity(10.0);
		snowman.setTransform(0.0);

		cgdrawer = new CgDrawer();
		cgdrawer.setLightchange(10.0f);
		cgdrawer.setLookchange(0.1);

		pointboard = new MyPointboard();
		pointboard2 = new MyPointboard2();
		pointboard3 = new MyPointboard3();
	}
	
	/**
	 * Draw the scene
	 */
	public static void draw(GLAutoDrawable drawable) {
		if(drawable == null) return;
		
		GL2 gl = drawable.getGL().getGL2();
		 gl.glLightModeli(GL2.GL_LIGHT_MODEL_TWO_SIDE, GL2.GL_TRUE); 
		
	    // Draw the flag
	    gl.glPushMatrix();
	    if(flag1 != null)
	    	flag1.draw(drawable);
	    gl.glPopMatrix();
	 
	    // Draw the car
		gl.glPushMatrix();
	    if(car1 != null)
	    	car1.draw(drawable);
	    gl.glPopMatrix();

		// Draw the donut
		gl.glPushMatrix();
		if(donut != null)
			donut.draw(drawable);
		gl.glPopMatrix();

		// Draw the donut2
		gl.glPushMatrix();
		if(donut != null)
			donut.draw2(drawable);
		gl.glPopMatrix();

		// Draw the board1
		gl.glPushMatrix();
		if(board1 != null)
			board1.draw(drawable);
		gl.glPopMatrix();

		// Draw the board2
		gl.glPushMatrix();
		if(board2 != null)
			board2.draw(drawable);
		gl.glPopMatrix();

		// Draw the board3
		gl.glPushMatrix();
		if(board3 != null)
			board3.draw(drawable);
		gl.glPopMatrix();

		// Draw the snowman
		gl.glPushMatrix();
		if(snowman != null)
			snowman.draw(drawable);
		gl.glPopMatrix();

		// Draw the pointboard
		gl.glPushMatrix();
		if(pointboard != null)
			pointboard.draw(drawable);
		gl.glPopMatrix();

		// Draw the pointboard2
		gl.glPushMatrix();
		if(pointboard2 != null)
			pointboard2.draw(drawable);
		gl.glPopMatrix();

		// Draw the pointboard2
		gl.glPushMatrix();
		if(pointboard3 != null)
			pointboard3.draw(drawable);
		gl.glPopMatrix();
	}

	/**
	 * Reset the movement
	 */
	public static void resetMovement() {

		// Reset the position of the car
		car1.resetMovement();

		// Reset the position of the snowman
		//snowman.resetMovement();
	}

	/**
	 * move snowman
	 */
	public static void moveSnowman(double s) {

		// Move the position of the snowman
		snowman.moveSnowman(s);
	}

	/**
	 * move snowman smooth
	 */
	public static double moveSnowmansmooth(double u) {

		// Move the position of the snowman
		double r = snowman.moveSnowmansmooth(u);
		return r;
	}

	/**
	 * move light
	 */

	public static void moveLight(float lightx, float lighty, float lightz) {
		cgdrawer.moveLight(lightx, lighty, lightz);
	}


	/**
	 * Change light
	 */
	public static void changeLightx() {

		// Change lightx
		cgdrawer.changeLightx();
	}

	public static void changeLighty() {

		// Change lighty
		cgdrawer.changeLighty();
	}

	public static void changeLightz() {

		// Change lightz
		cgdrawer.changeLightz();
	}

	/**
	 * Reset light
	 */
	public static void resetLight() {

		// Reset light
		cgdrawer.resetLight();
	}

	/**
	 * Change look
	 */
	public static void changeLookup() {

		// Change lookup
		cgdrawer.changeLookup();
	}

	public static void changeLookdown() {

		// Change lookdown
		cgdrawer.changeLookdown();
	}

	public static void changeLookright() {

		// Change lookright
		cgdrawer.changeLookright();
	}

	public static void changeLookleft() {

		// Change lookleft
		cgdrawer.changeLookleft();
	}

	public static void changeLookzoomin() {

		// Change lookzoomin
		cgdrawer.changeLookzoomin();
	}

	public static void changeLookzoomout() {

		// Change lookzoomout
		cgdrawer.changeLookzoomout();
	}

	/**
	 * Reset look
	 */
	public static void resetLook() {

		// Reset light
		cgdrawer.resetLook();
	}

	/**
	 * Caluculate hit
	 */
/*	bool calculatehit(){
		if(){
			return true;
		}

		else{
			return false;
		}

	}
*/

//当たり判定
	public static void print() {

		double hit_dis = 10.0;
		double hit_dis_1 = 10.0;
		double hit_dis_2 = 10.0;

		hit_dis = Math.sqrt((Math.pow(snowman.snowplace - car1.transform, 2.0) + Math.pow(3.0 - car1.carplace, 2.0)));
		hit_dis_1 = 3.0 - car1.carplace;
		hit_dis_2 = snowman.snowplace - car1.transform;

		//System.out.println(hit_dis);
		if(flag == 0 && (hit_dis_1 <= 0.5 + car1.widthy) && (hit_dis_1 >= -(0.5 + car1.widthy)) && (hit_dis_2 <= car1.widthy) && (hit_dis_2 >= -car1.widthy)){
			//System.out.println(hit_dis_1);
			car1.setColor(0.0,0.0,1.0);
			all_point += 1;
			point1 =  all_point % 10;
			point2 =  all_point / 10 % 10;
			point3 =  all_point / 100 % 10;
			System.out.println(all_point);
			//System.out.println(point1);
			//System.out.println(point2);
			//System.out.println(point3);
			flag = 1;
		}
		else{
			car1.setColor(1.0,0.0,0.0);
		}

	}

}