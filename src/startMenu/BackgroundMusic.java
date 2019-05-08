package startMenu;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class is used to select a music file. The chosen music file
 * can be player and stopped via the GUI.
 * @author AevanDino
 */
public class BackgroundMusic extends Thread {
 
	private Clip clip;
	private Thread musicThread;
	public Boolean shouldBeRunning;
	private int pos = 0;
	
	public BackgroundMusic() {
		this.clip = null;
	}

	/**
	 * If music isn't already playing, this method will start
	 * playing the chosen file, that is if there is a file to be played.
	 */
	public void startMusic() {
		
		if(clip!=null && shouldBeRunning) {
			clip.setFramePosition(pos);
			clip.start();
			
		
		} else if(musicThread==null) {
			musicThread = new Thread(this);
			shouldBeRunning=true;
			musicThread.start();
		}
	}    

	/**
	 * Pauses music, music continues where it stopped when player asks for music again.
	 */
	public void pauseMusic() {
		if(clip!=null) {
			pos = clip.getFramePosition();
			clip.stop();
		}
	}

	/**
	 * Run method from Thread class. This method starts playing music until told to stop.
	 */
	public void run() {
		while(shouldBeRunning && clip == null) {
			try {
				File musicPath = new File("music/bgMusic.wav");				
				AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception e)
			{
				System.out.println("You did not choose a WAV file");
			}
		}
	}
}