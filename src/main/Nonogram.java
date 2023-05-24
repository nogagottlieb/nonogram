
//@name Noga Gottlieb
//@date 1/31/22 version 5
//CS245 Nonogaram (assignment 1)

public class Nonogram{
	  private static boolean[][] board;
	  private static int[][] Columns;
	  private static int[][] Rows;
	  
	  //nonogram method solves the puzzle with the given two parameters
	  //@param Columns double array of integers that represent the columns
	  //@param Rows double array of integers that represent the rows
	  //@param board double array of boolean to represent the board
	  //@returns double boolean array of solution
	  public static boolean[][] solveNonogram(int[][] columns, int[][] rows)
	  {
		    Columns=columns;
		    Rows=rows;
		    board = new boolean[rows.length][columns.length]; //creating the board
		    for (int i=0; i<board.length; i++)                //filling the board with False
		      for(int j=0; j<board[i].length; j++)
		        board[i][j]=false;
		    
		   //if the board is solvable, print the board and return the board
		    if(solve(0,0,0)) {
		    	for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
					    System.out.print(board[i][j]+"\t ");
					    } 
				    System.out.println();
					}
				
		    	return board;
		    }
		    
		    //if the board has no solution, print a messege and return null
		    else
		    {
		      System.out.println("The board has no solution");
		      return null;
		    }
	  }
	  
	  //isSafeCol method to check if it safe to color the column.
	  //use 4 while loops to count the numbers of squares that already colored and the gaps.
	  //@param int row to check from 0 to the row 
	  //@param int column to check the specific column
	  //returns true is the columns is safe, false if not.
	  public static boolean isSafeCol(int row,int col)
	  {
		int countFirstValue=0;
	    int countSecondValue=0;
	    int countFirstGap=0;
	    int countSecondGap=0;
	    for(int r=0; r<=row; r++)
	    {
	    	
	    	while(r<=row && board[r][col]==false)
	    	{
	    		countFirstGap++;
	    		r++;
	   	
	    	}
	    	
	    	while((r<row && board[r][col]==true && Columns[col][0]!=0) || (r==row && board[r][col]==false))
	    	{
	    		countFirstValue++;
	    		r++;
	    	}
	    	
	    	while( r<=row && board[r][col]==false)
	    	{
	    		countSecondGap++;
	    		r++;
	   	
	    	}
	    	
	    	while((r<row && board[r][col]==true) || (r==row && board[r][col]==false))
	    	{
	    		countSecondValue++;
	    		r++;
	    	}
	    	
	    }
	    
	    //in case that the first column value is not 0, check 3 different condition to decide if the column is safe or not
	    if(Columns[col][0]!=0) 
	    {
	    	if ( countFirstGap>=0 && countSecondValue==0 && countSecondGap==0 && countFirstValue<=Columns[col][0]) {
	    		return true;
	    	}
	    	if (countFirstValue==Columns[col][0] && Columns[col][1]>=countSecondValue && countSecondGap>1) {
	    		return true;
	    	}
	    	if(countFirstValue>Columns[col][0] || countSecondValue>Columns[col][1])
	    	{
	    		return false;
	    	}
	    	
	    	
	    }
	    
	  //in case that the first column value is 0, check 5 different condition to decide if the column is safe or not
	    if (Columns[col][0]==0)
	    {
	    	 if (Columns[col][1]<countSecondValue && countFirstGap>0){
	    		return false;
	    	}
	    	
	    	if (countSecondValue==Columns[col][1] && countSecondGap==0 && countFirstGap==0 ) {
	    		return true;
	    	}
	    	
	    	if(countSecondValue<Columns[col][1] && countSecondGap==0 && countFirstGap==0) {
	    		return true;
	    	}
	    	
	    	if(countSecondValue==0 && countFirstGap>=1)
	    	{
	    		return true;
	    	}
	    	
	    	if(countSecondValue<=Columns[col][1] && countFirstGap==0) {
	    		return true;
	    	}
	    	
	    	
	    	
	    }
	    
	    //if all the condition failed, return false
	    return false;

	  }
	  
	  
	  
	  
	  //isSafeRow method to decide if the row is safe to color.
	  //@param int row to get the row we want to check
	  //@param int column to get the columns we start the check with
	  //@return true if the row is safe, false if not
	  
	  public static boolean isSafeRow(int row, int column, int blockI)
	  {
	    //if the number the we want to paint is not 0, run a loop that count how many false there are
		//if count==number return true
		if(Rows[row][blockI]!=0)
	    {
	      int count=0;
	      //check for the first value
	      if (blockI==0)
	      {  
	    	 for(int col=column; col<Columns.length; col++)
	    	 {      
	    		if(board[row][col]==false && Columns.length-col>Rows[row][0]+Rows[row][1]-count)
	    		{ 
	        	
	    		  count++;
	    		  if(count==Rows[row][blockI])
	            	return true;
	    		  
	    		}else 
	    			return false;
	    	  	
	    	  } 
	      } 
	      
	      //check for the second value
	      if(blockI==1)
	      {
	    	  for(int col=column; col<Columns.length; col++)
	    	  {
	    		if(board[row][col]==false && Columns.length-col>=Rows[row][1]-count)
	    		{
	    		  
	    		  count++;
	    		  if(count==Rows[row][blockI])
	            	return true;
	    		  
	    		} else 
	    			return false;
	    	  	
	    	  
	    	  }	
	      }
	    }

	    return true;
	  }
	   
	  
	  //method isSafe to decide if the specific position is safe (row and column)
	  //@param int row to get the position row
	  //@param int col to get the specific col
	  //@param int blockI to get the row block that we are checking if is safe
	  //@return boolean true if safe, false if not
	  public static boolean isSafe(int row, int col, int blockI)
	  {
		 int count=0;
		 if(isSafeRow(row, col, blockI))
		 {
		  for(int c=col; c<col+Rows[row][blockI]; c++)
		  {
			  if(isSafeCol(row, c))
				  count++;
		  }
		 } 
		 if (count==Rows[row][blockI]) 
			 return true;
		   
		  else 
			  return false;
		  
	  }
	  
	  
	  //method paint to paint the positions
	  //@param int row to get the row position
	  //@param int col to get the col position
	  //@param int blockI to get the block number that we want to paint
	  public static void paint(int row, int col, int blockI)
	  {
		  for (int i=col; i<col+Rows[row][blockI] && i<Columns.length;  i++)
		  {
			 board[row][i]=true;
		  }
	  }
	  
	  
	  //method unPaint to put false. Use for backtracking
	  //@param int row to get the row position
	  //@param int col to get the col position
	  //@param int blockI to get the block number that we want to Unpaint
	  public static void unPaint(int row, int col, int blockI)
	  {
		  
		  for (int i=col; i<col+Rows[row][blockI]; i++) {
			  board[row][i]=false;
		  }
	  }
	  
	  
	//method unPaint to put false. Use for backtracking for previous row. unPainting backwards
	  //@param int row to get the row position
	  //@param int col is the last col of the row
	  //@param int blockI to get the block number that we want to Unpaint
	  public static void unPaintBack(int row, int col, int blockI)
	  {
		  //start with the last col, find the first true value to start unpaint from 
		  while(board[row][col]==false && col>0) {
			  col--;
		  }
		  for(int i=col; i>col-Rows[row][blockI]; i--) {
			  board[row][i]=false;
		  } 
	  }
	  
	  
	  //method solve to recursively solve the board
	  ////@param int row to get the row position
	  //@param int col to get the col position
	  //@param int blockI to get the block number that we want to solve for
	  public static boolean solve(int row, int col, int blockI)
	  {
		  if (row == Rows.length) 		//base case
			 return true;
			 
		  //for loop to run between the columns to check if is safe to solve
		  for(int c=col; c<Columns.length; c++)
		  {
			  	if(isSafe(row,c,blockI))  //if safe, paint the positions
			  	{
				  paint(row,c, blockI);
				  if(blockI==1) {			//if it is the last blockI (==1)
					  if(solve(row+1,0,0))  //if solvable for the next row, return true
						  return true;
					  else 					//if not, backtrack and try for the next col
						  unPaintBack(row,Columns.length-1,blockI);
					  	 
				  }
				  
				  //if it is the first blockI, solve for the next one 
				  else {
					  if(Rows[row][blockI]!=0)
						  c=c+Rows[row][blockI]+1;
					  blockI++;				  
					  
					  if(solve(row,c,blockI))  	//if solvable, return true
						  return true;

					  
					  else { 					//if not, backtrack
						  if (c>0) {			//if the col>0, unPaint the previous position
							  unPaint(row,c-Rows[row][blockI],blockI--);
						  	  c=c-Rows[row][blockI];
						  } 
						  if(c==0) {			//if the c=0, unpaint the previous block
							  unPaint(row,c,blockI--);
						      if(row>0) 
						    	  unPaintBack(row-1,Columns.length-1,blockI);
						    	 
						  } 
	
				  	} 	  
				  
				}
				  
				   
			  }
			 	  
		  }
		  
		  
		  return false;
	  }
	
	 
	
	  public static void main(String[] args)
	  {
	  //test your code
	  int[][] columns1 = {{0,2}, {2,1}, {0,4}, {0,3}, {0,1}};
	  int[][] rows1 =  {{0,4}, {0,4}, {0,3}, {0,1}, {0,1}};
	  solveNonogram(columns1, rows1);  
	  
	  
	 
	  }
		  
	  
}
