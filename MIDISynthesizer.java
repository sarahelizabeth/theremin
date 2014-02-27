//MIDI SYNTHESIZER
package midi;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.util.*;  
import javax.sound.midi.*; 
import javax.swing.*;



public class MIDI {
    private static Instrument[] instruments;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MidiUnavailableException
{
    int i = 0;
    
    
    //Following code searches for active MIDI channels in the system
    //to output the midi signal to a sequencer like Abelton Live
    //instead of using the internal Java synthesizer
    //Leaving it here in case we have time!
    
    
    /*System.out.println("Searching");  
   MidiDevice.Info[] devices = MidiSystem.getMidiDeviceInfo();  
for (MidiDevice.Info deviceInfo : devices) 
{  
   System.out.println("Device Name : " + deviceInfo.getName());  
   System.out.println("Device Description : " + deviceInfo.getDescription() + "\n");
}
    */
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        Instrument[] orchestra = synthesizer.getAvailableInstruments();

       //The following code displays all available instruments 
        //in the soundbank.gm file, again, not necessary if we implement 
        //an external sequencer.
        
      /*  StringBuilder sb = new StringBuilder();
        String eol = System.getProperty("line.separator");
        sb.append(
            "The orchestra has " + 
            orchestra.length + 
            " instruments." + 
            eol);
        for (Instrument instrument : orchestra) {
            sb.append(instrument.toString());
            sb.append(eol);
        }
        //synthesizer.close();
        JOptionPane.showMessageDialog(null,
            new JScrollPane(new JTextArea(sb.toString(),20,30)));
                */
    
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
    
        
    while (i == 0)
    {
    try {
       // Synthesizer synthesizer = MidiSystem.getSynthesizer();
        //synthesizer.open();
        
       
        int vol = 40; //volume (velocity) of the note playing (min = 0, max = 100)
        int pitch = 12;//Pitch of the note playing (60 = C, 61 = C#, 62 = D etc)
        //pitch min = 0, max = 127, although this gives 8 1/2 octaves!
        //perhaps we would get better control with less notes
        int NoteOut = pitch;
        
        
            while (NoteOut > 11)
            {
                NoteOut = NoteOut - 12;
            }
       
        
        
        
        MidiChannel[] channels = synthesizer.getChannels();
        instruments = synthesizer.getDefaultSoundbank().getInstruments();  
         channels[0].programChange(instruments[40].getPatch().getProgram());
        channels[0].noteOn(pitch, vol);
        Thread.sleep(60);
        
        //channels[0].noteOff(y);
        //Note = (char) (y+7);
        System.out.println(NoteBank[NoteOut]);
        
        //synthesizer.close();
    } 
    catch (Exception e)
    {
        e.printStackTrace();
    }
            
 }
}
}
