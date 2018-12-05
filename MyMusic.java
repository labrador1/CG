/**
 * Model of Music
 */

/*この中のどれかがいらないかも*/
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class MyMusic {
    static Clip clip = null;
    static int count = 0;      // (count+1)回 再生する
    static AudioInputStream audioInputStream;
    static int flag = 0;

	public static void startMusic() {
		
	/**
	 * Start music
	 */
        {
            if (flag == 0) {
                //Clip clip = null;
                //int count = 0;      // (count+1)回 再生する
                //AudioInputStream audioInputStream;
                try {
                    File soundFile = new File("music.wav");
                    audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                    AudioFormat audioFormat = audioInputStream.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
                    clip = (Clip) AudioSystem.getLine(info);
                    clip.open(audioInputStream);
                    clip.loop(count);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                flag = 1;
            }
            else{
                clip.start();
            }
        }
	}

	public static void stopMusic() {
		
	/**
	 * Stop music
	 */
	{
        clip.stop();
      	}
	}

	

}
