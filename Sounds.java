import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds{
	private Clip clip1;

	public void slap(){
		try {
	        URL url = this.getClass().getClassLoader().getResource("./sounds/slap.wav");
	        clip1 = AudioSystem.getClip();
	        clip1.open(AudioSystem.getAudioInputStream(url));
	        clip1.start();
	    } catch (Exception exc) {
	        exc.printStackTrace(System.out);
	    }
	}
}
