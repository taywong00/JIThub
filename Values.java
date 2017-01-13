public class Values {

    //Inst Vars
    private int lastPos;
    private int[] lineVal;
    private int[][] gridVal;
    private int[][] pointsVal;
    private int[][] tophersVal;

    //default contructor
    public Values(){

	int lastPos = 0;
	int[] lineVal = new int[25]; //to be transcribed into gridVal
        int[][] gridVal = new int[5][5]; 
	int[][] pointsVal = new int[2][5]; //the first row will be the COLUMN
	int[][] tophersVal = new int[2][5];//the second row will be the ROW
    }

    // adds value (1, 2, 3) to lineVal for x times (x will depend on the level)
    public void addToLineVal( int value, int x )
    {
	for(int a = 0; a < x ; a++){
	    lineVal[lastPos] = value;
	    lastPos ++;
	}
    }

    //populates lineVal with 1 2 and 3 (the rest are 0s for tophers) 
    public void popLineVal (int level){
	addToLineVal(1, 17 - 2*level);
	if (Math.random()*2 > 1){
	    addToLineVal(2, level + 2);
	    addToLineVal(3, level + 1);
	}
	else {
	    addToLineVal(3, level + 2);
	    addToLineVal(2, level + 1);
	}
	lineScrambleGrid();
    }

    //scrambles the order of the lineVal
    public void lineScrambleGrid(){
    }

    //transcribes the scrambled values in lineVal into grid format
    public void popGridVal(){
	int x = 0;
	for(int[] a: gridVal)
	    {
		for(int b : a){
		    a[b] = lineVal[x];
		    x++;
		}
	    }
    }

    
    public int arrayColumnSum(int y){
	int sum = 0;
	for(int[] i: gridVal){
	    sum += i[y];
	}
	return sum;
    }

    public int arrayRowSum(int x){
	int sum = 0;
	for(int i : gridVal[x] ){
	    sum += i;
	}
	return sum;
    }

    
    public void popPoints(){
	
	for(int i : pointsVal[0]){
	    pointsVal[0][i] = arrayRowSum(i);
	}
	for(int i : pointsVal[1]){
	    pointsVal[1][i] = arrayColumnSum(i);
	}
    
    }

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
    

    public void popTophers(){
	for(int i : tophersVal[0]){
	    tophersVal[0][i] = arrayRowTopher(i);
	}
	for(int i : tophersVal[1]){
	    tophersVal[1][i] = arrayColumnTopher(i);
	}
    
    }
    
    
}
