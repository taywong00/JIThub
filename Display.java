public class Display{
    
    //Inst Vars

    private String[][] gridDis;
    private int[][] pointsDis;
    private int[][] tophersDis;

    private static String[] ALPHABET={
	"A","B","C","D","E","F","G","H","I","J","K","L","M",
	"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };

    
    //default constructor
    public Display(){
        String[][] gridDis = new String[5][5];
	int[][] pointsDis = new int[2][5];
        int[][] tophersDis = new int[2][5];
    }


    public void populate(String[][] grid){
	int alphaIndex = 0;
	for (String[] r : grid) {
	    for (String c : r) {
		c = ALPHABET[ alphaIndex ];
		alphaIndex += 1;
	    }
	}
    }
}
