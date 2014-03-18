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

    if (v>126)
    {
        v = 127;
    }
    return v;
		}

public static Integer decreaseV(){

v-=1;
    if (v<1)
    {
        v = 0;
    }

return v;
		}

public static Integer increaseP(){

		p+=1;
    if (p>1000)
    {
        p =1001;
    }

return p;
		}

public static Integer decreaseP(){

		p-=1;
    if (p<260)
    {
        p = 260;
    }

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

    String[] NoteBank = new String[12];

    NoteBank[0] = "C";
    NoteBank[1] = "C#";
    NoteBank[2] = "D";
    NoteBank[3] = "D#";
    NoteBank[4] = "E";
    NoteBank[5] = "F";
    NoteBank[6] = "F#";
    NoteBank[7] = "G";
    NoteBank[8] = "G#";
    NoteBank[9] = "A";
    NoteBank[10] = "A#";
    NoteBank[11] = "B";

    try{
Synthesizer synthesizer = MidiSystem.getSynthesizer();
synthesizer.open();
Instrument[] orchestra = synthesizer.getAvailableInstruments();

while(login!="q"){     
        
       
 	   v = getV();
        p = getP();


        int PtoNote = 0;
        String Note="";
    int NoteOut = p/10;



    while (NoteOut > 11)
    {
        NoteOut = NoteOut - 12;
    }
        if (p <= 11)
        {PtoNote = p + 12;
        }
        MidiChannel[] channels = synthesizer.getChannels();
        instruments = synthesizer.getDefaultSoundbank				().getInstruments();  
         channels[0].programChange(instruments[89].getPatch	().getProgram());
    
        channels[0].noteOn((p/8), (v));

        
     		System.out.println("V: " + v);
		System.out.println("P: " + p/8);
    System.out.println(NoteBank[NoteOut]);
    Thread.sleep(5);
        

          } 

}
catch (Exception e)
    {
        e.printStackTrace();
    }

     
   }



   }
