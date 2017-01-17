public class Woo {
    public static int level = 1;
    public static int pointCtr = 1;
    public static void main(String[] args){
	/*
	Display foo = new Display();
	foo.populate();
	foo.printGrid();
	*/

     String[][] gridDis = new String[5][5];
	int[][] pointsDis = new int[2][5];
        int[][] tophersDis = new int[2][5];
    Display obj = new Display();
    obj.populate(gridDis);
obj.printGrid(gridDis);

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
