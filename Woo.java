public class Woo {
    public static int level = 1;
    public static void main(String[] args){
	Display foo = new Display();
	foo.populate();
	foo.printGrid();
	Values boo = new Values();
	boo.popLineVal(level);
	boo.popGridVal();
	
    }
}
