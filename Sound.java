import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*;
public class Sound {


	public Sound(String file, boolean Loop){
	  Clip clip;
	  try {
	  AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
	  clip = AudioSystem.getClip();
	  clip.open(ais);
	  clip.start();
	  for (int i=1;i<=1;i++)
	  {
		  clip.loop(1);
		  Thread.sleep(1000*3);
	  }
		  
	  } 
	  catch (Exception e) {
		  e.printStackTrace();
		  }
	  }
}
	

