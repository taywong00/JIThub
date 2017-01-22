public class Values {

    //Inst Vars
    private int lastPos;
    private int[] lineVal;
    private static int[][] gridVal;
    private int[][] pointsVal;
    private int[][] tophersVal;
    private String allNotes;
    
    //default contructor
    public Values(){



        int lastPos = 0;
        lineVal = new int[25]; //to be transcribed into gridVal
        gridVal = new int[5][5]; 
        pointsVal = new int[2][5]; //the first row will be the COLUMN
        tophersVal = new int[2][5];//the second row will be the ROW 
        allNotes = "Your Notes: \n";
        /*
        is anyone editing this? 
        tophersVale);
       }
       else{
       takeNotes(letter);
       }
       */
     }
     
     
     
     
     
     
       //================================
    public void playTurn(){
       System.out.println("Enter a letter coordinate that's shown above:");
       String letter = Keyboard.readString();
       System.out.println(letter);
   
       System.out.println("What do you want to do with it?");
      
       System.out.println("1. Flipppp it!");
       System.out.println("2. Take notes...");
       int choice = Keyboard.readInt();
       
       // System.out.println(choice);
       if (choice == 1){
       System.out.println("//flip method here");
       }
       else{
       takeNotes(letter);
       }
     }
     
    //==================================================

        //takeNotes
    public void takeNotes(String letter){
    System.out.println("Please enter your notes for " + letter);
    String notes = Keyboard.readString();
    //System.out.println(notes);
    allNotes += notes;
    
    }
   
    
    //===================================================
    
    // adds value (1, 2, 3) to lineVal for x times (x will depend on the level)
    public void addToLineVal( int value, int x )
    {
    for(int a = 0; a < x ; a++){
        lineVal[lastPos] = value;
        lastPos ++;
    }
    }

    //populates lineVal with 0 1 2 and 3 
    public void popLineVal (int level){
    addToLineVal(1, 17 - 2*level );
    if (Math.random()*2 > 1){
        addToLineVal(2, level + 2);
        addToLineVal(3, level + 1);
    }
    else {
        addToLineVal(3, level + 2);
        addToLineVal(2, level + 1);
    }
    addToLineVal(0, 4 + level);
    lineScrambleGrid();
    }

    //swaps values for lineScrambleGrid method
    public void swap(int a, int b){
    int store = lineVal[a]; 
    lineVal[a] = lineVal[b];
    lineVal[b] = store;

    }

    //scrambles lineVal for popGridVal  
    public void lineScrambleGrid(){
    for (int i = 0; i < 24; i++){
        swap(lineVal[i], lineVal[Math.random()*25]);
         } 
    }

    //transcribes the scrambled values in lineVal into grid format
    public void popGridVal(){
    int x = 0;
    lineScrambleGrid();
    for(int[] a: gridVal)
        {
        for(int b : a){
            a[b] = lineVal[x];
            x++;
        }
        }
    }

//==============================THE ABOVE FOCUSES ON THE GRID VALUES=====
//==============================THE BELOW FOCUSES ON COUNTING POINTS=====

    //calculates the total number of points in a column
    public int arrayColumnSum(int y){
    int sum = 0;
    for(int[] i: gridVal){
        sum += i[y];
    }
    return sum;
    }

    //calculates the total number of points in a row
    public int arrayRowSum(int x){
    int sum = 0;
    for(int i : gridVal[x] ){
        sum += i;
    }
    return sum;
    }

    //populates pointsVal with the values from the array----Sum methods for display to call
    public void popPoints(){
    
    for(int i : pointsVal[0]){
        pointsVal[0][i] = arrayRowSum(i);
    }
    for(int i : pointsVal[1]){
        pointsVal[1][i] = arrayColumnSum(i);
    }
    
    }

//=====================THE ABOVE FOCUSES ON COUNTING POINTS======
//=====================THE BELOW FOCUSES ON COUNTING TOPHERS=====

    //counts number of tophers in a column
    public int arrayColumnTophers(int y){
    int topherCtr = 0;

    for(int[] i: gridVal){
        if (i[y] == 0){
        topherCtr++;
        }
    }

    
    return topherCtr;
    }

    //counts number of tophers in a row
    public int arrayRowTophers(int x){
    int topherCtr = 0;
    for(int i : gridVal[x] ){
        if (i == 0)
        {
            topherCtr++;
        }
    }
    return topherCtr;
    }
    
    //populates tophersVAL with values from the array---tophers methods for display to call
    public void popTophers(){
    for(int i : tophersVal[0]){
        tophersVal[0][i] = arrayRowTophers(i);
    }
    for(int i : tophersVal[1]){
        tophersVal[1][i] = arrayColumnTophers(i);
    }
    
    }
    
//================================THE ABOVE FOCUSES ON TOPHERS============    
  
    public static int getValuePoints(int x, int y){

        return pointsVal[x][y];
    }
    public static int getValueTophers(int x, int y){

        return tophersVal[x][y];
    }
    
    
    
    
    
    
    
}
