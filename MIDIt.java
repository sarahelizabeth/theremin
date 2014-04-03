import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

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
public static String dotCol;


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

    String[] DotColor = new String[12];

    DotColor[0] = "FF0000";
    DotColor[1] = "FF8000";
    DotColor[2] = "FFFF00";
    DotColor[3] = "80FF00";
    DotColor[4] = "00FF00";
    DotColor[5] = "00FF80";
    DotColor[6] = "00FFFF";
    DotColor[7] = "0080FF";
    DotColor[8] = "0000FF";
    DotColor[9] = "7F00FF";
    DotColor[10] = "FF00FF";
    DotColor[11] = "FF007F";
    
    try{
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        Instrument[] orchestra = synthesizer.getAvailableInstruments();
        MidiChannel[] channels = synthesizer.getChannels();
        instruments = synthesizer.getDefaultSoundbank().getInstruments();
        int mc = 0;
        channels[mc].programChange(instruments[94].getPatch().getProgram());

        //The following code displays all available instruments
        //in the soundbank.gm file, again, not necessary if we implement
        //an external sequencer.

        StringBuilder sb = new StringBuilder();
        String eol = System.getProperty("line.separator");
        sb.append("The orchestra has " + orchestra.length + " instruments." + eol);
        for (Instrument instrument : orchestra) {
            sb.append(instrument.toString());
            sb.append(eol);
        }
        //synthesizer.close();
        JOptionPane.showMessageDialog(null,
                new JScrollPane(new JTextArea(sb.toString(),20,30)));


        while(login!="q"){


//Audio out test Parameters
       //v = 10;
       //p = 500;
 	   v = getV();
       p = getP();
   p = p/10;
   //v = v;

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

//dotCol = DotColor[NoteOut];
           // channels[mc+1].programChange(instruments[83].getPatch().getProgram());

            channels[mc].noteOn((p), (v));
            Thread.sleep(10);
           // channels[mc+1].allNotesOff();
            channels[mc+1].noteOn((p), (v));


    System.out.println("V: " + v);
	System.out.println("P: " + p);
    System.out.println(NoteBank[NoteOut]);

           System.out.println("Color: "+ DotColor[NoteOut]);


    if (p == 0 || v == 0)
    {
        channels[mc].allNotesOff();
        Thread.sleep(10);
        //channels[mc+1].allNotesOff();
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
