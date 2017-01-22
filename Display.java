public class Display{
    
    //Inst Vars

    public String[][] gridDis;
    public int flippedVal;
    

    private String[] ALPHABET={
    "A","B","C","D","E","F","G","H","I","J","K","L","M",
    "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
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
    public int findR(String letter) {
<<<<<<< HEAD
    for (int r = 0; r < 6; r ++){
        for (int c = 0; c < 6; c ++){
                if (letter == this.gridDis[r][c]) {
=======
        for ( String[] r : this ) {
            for ( String c : r ) {
                if (letter == this[r][c]) {
>>>>>>> 53af7b33837f31565f165cb8bfac55d0c15c43fd
                    return r;
        }
        }
    }
    return 0;
    }
    
    
    //return the "y" (row) val of a letter in the grid
    public int findC(String letter) {
<<<<<<< HEAD
       for (int r = 0; r < 6; r ++){
        for (int c = 0; c < 6; c ++){
                if (letter == this.gridDis[r][c]) {
=======
        for ( String[] r : this ) {
            for ( String c : r ) {
                if (letter == this[r][c]) {
>>>>>>> 53af7b33837f31565f165cb8bfac55d0c15c43fd
                    return c;
        }
        }
       }
       return 0;
    }
              
    
    // TO BE CHANGED TO PRINT THE GRID AND POINTS AND TOPHERS
    //prints the grid
   public void printAll(){
        System.out.println("----------");   
        for(String[] r :gridDis){
     
            for (String x: r){
                System.out.print(x + " ");
		System.out.print(getValuePoints(1, x) + " ");
		System.out.print(getValueTophers(1, x) + " ");
            }
            System.out.println("");
	 
        }
	for (int i : pointsVal){
	    System.out.print(getValuePoints(0,i) + " ");
	}

	System.out.println(" ");

	for (int i : tophersVal){
	    System.out.print(getValueTophers(0,i) + " ");
	}
	


	
        System.out.println("----------");
    }
   
    
    
    public void multiplier(){
        Woo.pointCtr = Woo.pointCtr*flippedVal;
    }

    
}
