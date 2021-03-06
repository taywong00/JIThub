public class Values {

    //Inst Vars
    private int lastPos;
    private int[] lineVal;
    public static int[][] gridVal;
    public static int[][] pointsVal;
    public static int[][] tophersVal;
    public static String allNotes;
    public static int product;
    
    //default contructor
    public Values(){



        int lastPos = 0;
        lineVal = new int[25]; //to be transcribed into gridVal
        gridVal = new int[5][5]; 
        pointsVal = new int[2][5]; //the first row will be the COLUMN
        tophersVal = new int[2][5];//the second row will be the ROW 
        allNotes = "===================\nYour Notes: ";
        product = 1;
     }

   
    
    public static void calcProduct(int level){
	product = (int)(Math.pow(2, level +2)) * (int)(Math.pow(3, level +1)) ;
    }
    
    //populates lineVal with 0 1 2 and 3 
    public void popLineVal (int level){

	for (int i = 0; i < 25; i ++){
	    if (i < 6){
		lineVal[i] = 0;
	    }
	    else if (i < 8 + level){
		lineVal[i] = 2;
	    }
	    else if (i < 10 + level){
		lineVal[i] = 3;
	    }
	    else{
		lineVal[i] = 1;
	    }	
	}

	for (int i = 0; i < 25; i ++){
	    int ran = (int)(Math.random()*25);
	    int temp = lineVal[i];
	    lineVal[i] = lineVal[ran];
	    lineVal[ran] = temp;
	        
	    
	}
	calcProduct(level);
	
    }
	    
   

    //transcribes the scrambled values in lineVal into grid format
    public void popGridVal(){
	
	for (int i = 0; i < 5; i ++){
	    for (int c = 0; c < 5; c  ++){
		gridVal[i][c] = lineVal[i*5 + c];
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
    
    for(int i = 0; i < 5; i ++){
        pointsVal[0][i] = arrayRowSum(i);
    }
    for(int i = 0; i < 5; i ++){
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
    
 
       for(int i = 0; i < 5; i ++){	
	tophersVal[0][i] = arrayRowTophers(i);
    }
       
       for(int i = 0; i < 5; i ++){
	   tophersVal[1][i] =  arrayColumnTophers(i);
    }
	
    
    }
    
    

    
}
