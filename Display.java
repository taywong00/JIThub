public class Display{
    
    //Inst Vars

    public String[][] gridDis;
    public int flippedVal;
    

    public String[] ALPHABET={
    "A","B","C","D","E","F","G","H","I","J","K","L","M",
    "N","O","P","Q","R","S","T","U","V","W","X","Y"
    };

    
    //default constructor
    public Display(){
        gridDis = new String[5][5];
       
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


  
    
    //return the "x" (row) val of a letter in the grid
    public int findC(String letter) {
	String here ="ABCDEFGHIJKLMNOPQRSTUVWXY";
   
 
	int ind =  here.indexOf(letter);

	return ind%5; 

    }
	  



    //return the "y" (row) val of a letter in the grid
    public int findR(String letter) {
	String here ="ABCDEFGHIJKLMNOPQRSTUVWXY";
   
 
	int ind =  here.indexOf(letter);

	return ind / 5; 
	
       

    }

    
    
              
    
    public void printAll(int[][] tophersVal, int[][] pointsVal){
       
        System.out.println("\n\n\n=========*** GRID ***=========");
        System.out.println("P/T  --------------------");
	
	for (int i = 0; i < 5; i ++){
	    System.out.print( pointsVal[0][i]);
	    System.out.print(" ");
	    
	    System.out.print(tophersVal[0][i]);
	    System.out.print("  ");
	    
	 
	    for (int c = 0; c < 5; c ++){
		System.out.print(" - " + gridDis[i][c]);
	    }
		System.out.print("-");
	    
	    System.out.println("  ");
	   
 System.out.println("     ---------------------");	  
	}

	System.out.print("    T");


	for (int i : tophersVal[1]){
	    System.out.print("   " + i);
	}

	
        System.out.println(" ");	
	System.out.print("    P");
  
	for (int i : pointsVal[1]){
	    System.out.print("   "+i );
	}
	
 	System.out.println(" ");
   }
   
   

	

	   
	    

    
    public void multiplier(){
        Woo.pointCtr = Woo.pointCtr*flippedVal;
    }

    
}
