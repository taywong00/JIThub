public class Woo {
    public static int level = 1;
    public static int pointCtr = 1;
    public static void main(String[] args){
	Display foo = new Display();
	foo.populate();
	foo.printGrid();
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
    }
}
