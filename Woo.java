//import Keyboard;

public class Woo {
    public static int level = 1;
    public static int pointCtr = 1;

    
    
    //flip method
    //precond: have an array
    public void flip(String letter) {
    
    }
    
    public static void main(String[] args){
    
    //Display
    Display foo = new Display();
    foo.populate();
    foo.printGrid();


    //Value

    Values boo = new Values();
    
    boo.popLineVal(level);
    
    boo.popGridVal();

    System.out.println("Enter a letter coordinate that's shown above");
    String letter = Keyboard.readString();
    System.out.println(letter);
    

    
    //turn is played, something is flipped
    //assume tile is 0,0
    int x = 0;
    int y = 0;
    foo.transcribe(boo, x, y);
    foo.printGrid();
    if (pointCtr == 0){
        System.out.println("yuo lose");
    }
       
    }
}

/*

 System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
	    guess = Keyboard.readInt();

*/
