public class Woo {
    public static int level = 1;
    public static int pointCtr = 1;
    private Display foo;
    private Values boo;
    private boolean flippedTopher = false;
    
    //NOTE: display method has methods to find x and y of a letter in the display grid 
    
    //flip method
    public void flip(String letter) {
        //find the coordinatyes of the letter;
        String letterR = foo.gridDis.findR(letter);
        String letterC = boo.gridVal.findC(letter);
        
        //get new number from boo (values)
        newNumVal = boo.gridVal[letterR][letterC];
        
        //check to see if you flipped a topher!
        if (newNumVal == 0) {
            foo.gridDis[letterR][letterC] = "" + newNumVal;
            flipAll();
            flippedTopher = true;
        }
        else {
            //put the regular newNumVal where the letter was (and thats it)
            foo.gridDis[letterR][letterC] = "" + newNumVal;
        }
        
        
    }
    
    //occurs when you flip a topher
    //basically just set the gridDis to gridVal
    public void flipAll() {
        for (String[] r : foo.gridDis ) {
            for (String c : r ) {
                foo.gridDis[r][c] = "" + boo.gridVal[r][c];
            }
    }
    
    
    }

        //convert the 0s to T's for topher
    public void toTopher() {
        for (String[] r : foo.gridDis ) {
            for (String c : r ) {
                if (foo.gridDis[r][c] == "0") {
                    foo.gridDis[r][c] = "T";
                }
            }
        }
    }
    
    
    public static void playTurn(){
        System.out.println("Enter a letter coordinate that's shown above:");
        String letter = Keyboard.readString();
        System.out.println(letter);
    
        System.out.println("What do you want to do with it?");
        System.out.println("1. Flip it!");
        System.out.println("2. Take notes...");
        int choice = Keyboard.readInt();
       
        // System.out.println(choice);
        if (choice == 1){
            flip(letter);
            toTopher();
            //regular continue of gameplay
            if (flippedTopher == false) {
                System.out.println("Here's what your grid looks like after you flipped " + letter + ":\n");
                foo.printAll();
            }
            else {
                System.out.print("Oh no! Looks like you flipped a Topher!");
                foo.printAll();
            }
            
        }
        else{
        takeNotes(letter);
        }
     }
       
           
    public static void main(String[] args){
    
        //Display
        foo = new Display();
        foo.populate();
        foo.printAll();


        //Value
    
        boo = new Values();
            
        boo.popLineVal(level);
        
        boo.popGridVal();
        
          //actual game playing
        while (flippedTopher = false) {
            playTurn();
        }
        
     
           
    }
}
