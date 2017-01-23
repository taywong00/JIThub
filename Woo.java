public class Woo {
    // public static int level = 1;
    public static int pointCtr = 1;
    private static Display foo;
    private static Values boo;
    private static boolean flippedTopher = false;
    
    //NOTE: display method has methods to find x and y of a letter in the display grid 
    
    //flip method
    public static void flip(String letter) {
        //find the coordinatyes of the letter;
	
        int letterR = foo.findR(letter);
	int letterC = foo.findC(letter);
	

        
        //get new number from boo (values)
        
        int newNumVal = boo.gridVal[letterR][letterC];
        
        //check to see if you flipped a topher!
        if (newNumVal == 0) {
            foo.gridDis[letterR][letterC] = "" + newNumVal;
            flipAll();
            flippedTopher = true;
        }
        else {
            //put the regular newNumVal where the letter was (and thats it)
            foo.gridDis[letterR][letterC] = "" + newNumVal;
	    pointCtr = newNumVal * pointCtr;
        }
        
        
    }
    
    //occurs when you flip a topher
    //basically just set the gridDis to gridVal
    public static  void flipAll() {
       
    for (int r = 0; r < 5; r ++){
        for (int c = 0; c < 5; c ++){
        foo.gridDis[r][c] = "" + boo.gridVal[r][c];
        }
    }
    }
    
    
    

        //convert the 0s to @'s for topher
    public static  void toTopher() {
        for (int r = 0; r < 5; r ++){
        for (int c = 0; c < 5; c ++){
                if (foo.gridDis[r][c] == "0") {
                    foo.gridDis[r][c] = "@";
                }
            }
        }
    }
    
    
    public static void playTurn(){
	System.out.println(boo.allNotes);
	System.out.println("===================");
        System.out.println("Select a letter... Don't run into a topher! ");
        String letter = Keyboard.readString().toUpperCase();
	
      
	System.out.println("===================");
        System.out.println("I want to ..... ");
        System.out.println("1. Flipppp it!");
        System.out.println("2. Take notes!");
	System.out.println("3. Break!");
        int choice = Keyboard.readInt();
    
    
        
        if (choice == 1){
	    flip(letter);
            toTopher();
	    
	    
            //regular continue of gameplay
	    
            if (flippedTopher == false) {
                System.out.println("Here's what your grid looks like after you flipped " + letter + ":\n");
		System.out.println("You have " + pointCtr + " point(s)!");
                foo.printAll(boo.tophersVal, boo.pointsVal);
            }
            else {
                System.out.println("Oh no! Looks like you flipped a Topher! DX");
		System.out.println("STUDY the grid below and be SMARTER next time! :)");
                foo.printAll(boo.tophersVal, boo.pointsVal);
            }   
        }

	
        else if (choice == 2){
        takeNotes(letter);
        foo.printAll(boo.tophersVal, boo.pointsVal);
        }


	
	else{
	    flippedTopher = true;
	}
     }

    //====================        
    public static void takeNotes(String letter){
    System.out.println("Please enter your notes for " + letter);
    String notes = Keyboard.readString();
   
    boo.allNotes += "\n" + letter + ": " +  notes;
    
    }
    //====================
       
           
    public static void main(String[] args){
    
        //Display
        foo = new Display();

	
	String allNotes = "";

        //Value
    
        boo = new Values();
            
        boo.popLineVal();

        boo.popGridVal();

	boo.popTophers();
	boo.popPoints();

	//================

        foo.populate();
       
	foo.printAll(boo.tophersVal, boo.pointsVal);

	//================

	
	 


        while (flippedTopher == false) {
            playTurn();
        }
 
	
     
           
    }
}
