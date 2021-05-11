
public class Nivell3 {

	public static void main(String[] args) {
		
		
		int hours =  0;
		int minutes = 59;
		int seconds = 50;
		
			while(true) {
				
				seconds++;
				if(seconds == 60) {
					seconds = 0; 
					minutes++;
					if(minutes == 60) {
						minutes = 0;
						hours++;
						if(hours == 24) {
							hours = 0;
							
						}
					}
				}
				String hourStr = String.format("%02d", hours);
				String minuteStr = String.format("%02d", minutes);
				String secondsStr = String.format("%02d", seconds);
				System.out.println(hourStr+":"+minuteStr+":"+secondsStr);
				try {
				Thread.sleep(1000);
				}catch(InterruptedException e) {
					System.err.println("Error ");
				}
			}
		
	}
	
} 
