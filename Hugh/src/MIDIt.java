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


    if (p>126)
    {
        p =127;
    }

return p;
		}

public static Integer decreaseP(){

		p-=1;
    if (p<1)
    {
        p = 0;
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
        MidiChannel[] channels = synthesizer.getChannels();
        instruments = synthesizer.getDefaultSoundbank().getInstruments();
        int mc = 0;
        channels[mc].programChange(instruments[81].getPatch().getProgram());

        while(login!="q"){
        
       
 	   v = getV();
        p = getP();
   p = p/10;
   v = v;

        int PtoNote = 0;
        String Note="";
    int NoteOut = p;



    while (NoteOut > 11)
    {
        NoteOut = NoteOut - 12;
    }

    if (p <= 11)
        {
            PtoNote = p + 12;
        }


           // channels[mc+1].programChange(instruments[83].getPatch().getProgram());

            channels[mc].noteOn((p), (v));
            Thread.sleep(10);
           // channels[mc+1].allNotesOff();
            channels[mc+1].noteOn((p), (v));

        
    System.out.println("V: " + v);
	System.out.println("P: " + p);
    System.out.println(NoteBank[NoteOut]);

    if (p == 0 || v == 0)
    {
        channels[mc].allNotesOff();
        Thread.sleep(10);
        channels[mc+1].allNotesOff();
    }
            //channels[mc].setPolyPressure(p, v/2);
            //Thread.sleep(20);

          } 

}
catch (Exception e)
    {
        e.printStackTrace();
    }

     
   }



   }
