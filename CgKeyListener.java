/**
 * Listener for keyboard events
 */


import java.awt.event.*;
import com.jogamp.opengl.util.Animator;

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
			
		// "A": Music Start
		case KeyEvent.VK_A:
			MyMusic.startMusic();
			animator.start();
			break;
			
		// "S": Music Stop
		case KeyEvent.VK_S:
			MyMusic.stopMusic();
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
