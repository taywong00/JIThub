public class Display{
 
    //Inst Vars

    private String[][] gridDis;
    private int[][] pointsDis;
    private int[][] tophersDis;
    private int flippedVal;

    private String[] ALPHABET={
	"A","B","C","D","E","F","G","H","I","J","K","L","M",
	"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };

    
    //default constructor
    public Display(){
        String[][] gridDis = new String[5][5];
	int[][] pointsDis = new int[2][5];
        int[][] tophersDis = new int[2][5];
    }

  //populates gridDis with letters of alphabet
    public void populate(){
	int alphaIndex = 0;

	for (int i = 0; i < gridDis.length; i ++){
	    for (int u = 0; u < gridDis[1].length; u ++){
	        gridDis[i][u] = ALPHABET[alphaIndex];
		alphaIndex ++;
	    }
	}
    }

     //prints the grid
    public void printGrid(){
        System.out.println("----------");	
	for(String[] i :gridDis){
	 
		for (String x: i){
		    System.out.print(x + " ");
		}
		System.out.println("");	
	    }
	System.out.println("----------");	
	
    }
}



 

