public class Woo {
    public static int level = 1;
    public static int pointCtr = 1;
    public static void main(String[] args){

	//Display
    String[][] gridDis = new String[5][5];
    int[][] pointsDis = new int[2][5];
    int[][] tophersDis = new int[2][5];
    Display foo = new Display();
    foo.populate(gridDis);
    foo.printGrid(gridDis);


    //Value
	int lastPos = 0;
	int[] lineVal = new int[25]; //to be transcribed into gridVal
        int[][] gridVal = new int[5][5]; 
	int[][] pointsVal = new int[2][5]; //the first row will be the COLUMN
	int[][] tophersVal = new int[2][5];//the second row will be the ROW

	/*
	Values boo = new Values();
	boo.popLineVal(level);
	boo.popGridVal();
	//turn is played, something is flipped
	//assume tile is 0,0
	int x = 0;
	int y = 0;
	foo.transcribe(boo, x, y);
	if (pointCtr == 0){
	    lose();
	}
	*/
    }
}
