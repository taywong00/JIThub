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

    public static void instructions() {
	String info = "\n{ HOW TO PLAY: }\n";
	info += "\nEach turn you will be prompted to have the choice to either flip a tile, make notes on it, or break the game (aka stop playing). Select an option by inputting the corresponding number and pressing ENTER. \n";
	
	info += "\n\n[FLIPPING:]\n";
	info += "\t 1) Flipping will reveal the value of that tile. This value can either be a point value or a Topher. \n";
	info += "\t    HOW TO FLIP: After selecting the option to flip, you will be asked to select the letter of the tile you want to flip. Input this letter and press ENTER. \n";

	info += "\n\n[TAKING NOTES:]\n";	
	info += "\t 2) You can take notes on the tile, meaning you can write whatever you want about it. Most use this section to keep track of which tiles have which potential values. \n";
	info += "\t\t Remember: indicate which tile letter you're taking notes for! (Its up to you how you want to go about this.) \n";
	info += "\t    HOW TO TAKE NOTES: After selecting the option to take notes, you will be asked to take them. Type in whatever note you would like to take on the tile and press ENTER. \n";

	info += "\n\n[BREAKING:]\n";
	info += "\t 3) If you ever feel like you don't want to play anymore (but let't be real, why would you??), you always have the option of breaking the game to stop playing.";
	info += "\t    HOW TO BREAK: Simply selecting the option to break the game will cause the game to terminate, so be careful! \n";

	System.out.print(info);
	
    }
    

    //===================
    public static void newGame() {

	String intro = "\n \n *** WELCOME TO TOPHER FLIP! *** \n";
	intro += "In this game you will be tested in your skills to see how long you can last without discovering a Topher!\n";
	

	System.out.println(intro);
    }


    // =========================
           
    public static void main(String[] args){

	int wannaPlay = 2;
	newGame();

	while (wannaPlay != 1) {
	    //ask if they wanna play
	    System.out.println("\n\nAre you ready to play??");
	    
	    System.out.println("1. OH YEAH BRING IT ON!!!");
	    System.out.println("2. Read the instructions.");	
	    System.out.println("3. Uhh not yet...?");
	    wannaPlay = Keyboard.readInt();


	    if (wannaPlay == 2) {
		instructions();
	    }
	
	    if (wannaPlay == 3)  {
		System.out.println("No problem, don't sweat it! Maybe next time when you feel ready to face THE TOPHER.");
		break;
	    }
	}
	    
	    if (wannaPlay == 1) {
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
}
