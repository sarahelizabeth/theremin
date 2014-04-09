package midi.src;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

import java.io.Console;
import java.util.*;  
import javax.sound.midi.*; 
import javax.swing.*;

import java.awt.*;

/**
 *
 * @author Grant adapted by Hugh
 */

public class MIDIt implements Runnable{

public static  Instrument[] instruments;
public static Integer p=0;
public static Integer v=0 ;



public static Integer increaseV(){

		v+=1	;
return v;
		}

public static Integer decreaseV(){

v-=1;

return v;
		}

public static Integer increaseP(){

		p+=1	;
return p;
		}

public static Integer decreaseP(){

		p-=1;

return p;
		}



public static Integer getV(){
return v;
}

public static Integer getP(){
return p;
}


public  void run(){


String login = "";
try{
Synthesizer synthesizer = MidiSystem.getSynthesizer();
synthesizer.open();
Instrument[] orchestra = synthesizer.getAvailableInstruments();

while(login!="q"){     
        
       
 	   v = getV();
        p = getP();
        int PtoNote = 0;
        String Note="";
        if (p <= 11)
        {PtoNote = p + 12;
        }
        MidiChannel[] channels = synthesizer.getChannels();
        instruments = synthesizer.getDefaultSoundbank				().getInstruments();  
         channels[0].programChange(instruments[93].getPatch	().getProgram());
    
        channels[0].noteOn(p, v);
        Thread.sleep(60);
        
     		System.out.println("V: " + v);
		System.out.println("P: " + p);
	
        

          } 

}
catch (Exception e)
    {
        e.printStackTrace();
    }

     
   }



   }
