
import java.io.IOException;
import java.lang.Math;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import sun.net.www.content.text.plain;


/**
 *
 * @author Hugh adapted from LeapMotion examples
 */


class LeapListener extends Listener {
MoveDot dot = new MoveDot(1200,600);
//dot.setDefaultCloseOperation(MoveDot.EXIT_ON_CLOSE);
MIDIt current = new MIDIt();
float y = 0;
float x = 0;
  
    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

	

    public void onFrame(Controller controller) {
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();
      
        if (!frame.hands().isEmpty()) {

            // Get the first hand
            Hand hand = frame.hands().get(0);

//Get hand position
Vector a = hand.palmPosition();
float vertical   = a.getY();

float horizontal = a.getX();

//if(vertical != y){
    y = a.getY();
    dot.panel.moveDot(x, y);
            current.p = (int) y;

    if (y > 1269)
    {
        current.p = 1270;
    }

    else if (y < 1)
    {
        current.p = 0;
    }

    else
    {
    current.p = (int) y;
    }
//}

//if(horizontal != x){
//current.increaseV();

    x=a.getX();
    dot.panel.moveDot(x, y);
    current.v = (int) x;

           if (x > 127 )
            {
                current.v = 127;
            }

            else if (x < 0)
            {
                current.v = 0;
            }

            else
            {
                current.v = (int) y;
            }
//}


//if(horizontal < x){
//current.decreaseV();
//x=horizontal;
//dot.panel.moveDot(x, y);
//}
}


        if (!frame.hands().isEmpty()) {
            System.out.println("");
        }

    }
}

class SoundControl {

    public static void main(String[] args) {



        // Create a Leap listener and controller

        LeapListener listener = new LeapListener();
        Controller controller = new Controller();

        // Have the Leap listener receive events from the controller

        controller.addListener(listener);
MIDIt dude = listener.current;

Thread midi = new Thread(dude);
midi.start();

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        
try {

            System.in.read();
			
try {
        	
		
		midi.interrupt();
		midi.join();
    } 
	
	catch (InterruptedException e) {
        // We've been interrupted: no more messages.
        return;
    }


        } catch (IOException e) {
 
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(listener);

	    }
}
