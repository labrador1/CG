/**
 * Listener for keyboard events
 */


import java.awt.event.*;
import com.jogamp.opengl.util.Animator;
import java.io.IOException;

public class CgKeyListener implements KeyListener {
	CgCanvas canvas;
	Animator animator;	


	public CgKeyListener(CgCanvas c, Animator a) {
		canvas = c;
		animator = a;
	}
	
	
   	/**
	 * Called when a key is pressed
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		double snowplace = 0.0;
		double velocity = 0.0;
		switch (key) {

			// "Q": exit
			case KeyEvent.VK_Q:
				System.exit(0);
				break;

			// "R": reset
			case KeyEvent.VK_R:
				MyScene.resetMovement();
				canvas.display();
				break;

			// "M": Music Start
			case KeyEvent.VK_M:
				MyMusic.startMusic();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException d) {
				}
				animator.start();
				break;


			// "S": Music Stop
			//case KeyEvent.VK_S:
			//	MyMusic.stopMusic();
			//	break;


			// "X": Move X
			//case KeyEvent.VK_X:
			///	CgDrawer.draw(drawer);
			//	canvas.display();
			//	break;

			// "A" : Move Left
			case KeyEvent.VK_A:
				snowplace = -0.6;
				MyScene.moveSnowman(snowplace);
				canvas.display();
				break;

			// "S" : Move Center
			case KeyEvent.VK_S:
				snowplace = 0.0;
				MyScene.moveSnowman(snowplace);
				canvas.display();
				break;

			// "D" : Move Right
			case KeyEvent.VK_D:
				snowplace = 0.6;
				MyScene.moveSnowman(snowplace);
				canvas.display();
				break;

			// "U" : Change Lightx
			case KeyEvent.VK_U:
				MyScene.changeLightx();
				canvas.display();
				break;

			// "I" : Change Lighty
			case KeyEvent.VK_I:
				MyScene.changeLighty();
				canvas.display();
				break;

			// "O" : Change Lightz
			case KeyEvent.VK_O:
				MyScene.changeLightz();
				canvas.display();
				break;

			// "P" : Reset Light
			case KeyEvent.VK_P:
				MyScene.resetLight();
				canvas.display();
				break;

			// "UP" : Change Lookup
			case KeyEvent.VK_UP:
				MyScene.changeLookup();
				canvas.display();
				break;

			// "DOWN" : Change Lookdown
			case KeyEvent.VK_DOWN:
				MyScene.changeLookdown();
				canvas.display();
				break;

			// "RIGHT" : Change Lookright
			case KeyEvent.VK_RIGHT:
				MyScene.changeLookright();
				canvas.display();
				break;

			// "LEFT" : Change Lookleft
			case KeyEvent.VK_LEFT:
				MyScene.changeLookleft();
				canvas.display();
				break;

			// "K" : ZOOMIN
			case KeyEvent.VK_K:
				MyScene.changeLookzoomin();
				canvas.display();
				break;

			// "J" : ZOONOUT
			case KeyEvent.VK_J:
				MyScene.changeLookzoomout();
				canvas.display();
				break;

			// "L" : Reset Look
			case KeyEvent.VK_L:
				MyScene.resetLook();
				canvas.display();
				break;

			// "F" : Move Left Smooth
			case KeyEvent.VK_F:
				velocity  = -4000;
				snowplace = MyScene.moveSnowmansmooth(velocity);
				MyScene.moveSnowman(snowplace);
				canvas.display();
				break;

			// "G" : Move Right Smooth
			case KeyEvent.VK_G:
				velocity = 4000;
				snowplace = MyScene.moveSnowmansmooth(velocity);
				MyScene.moveSnowman(snowplace);
				canvas.display();
				break;
		}
	}

	/**
	 * Called when a key is released
	 */
	public void keyReleased(KeyEvent e) {

	}

	/**
	 * Called when a key is typed
	 */
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		
		// "Q": exit
		case KeyEvent.VK_Q:
			System.exit(0);
		}
	}
}
