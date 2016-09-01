package growingrectangles;

/**
 * This program opens a window full of randomly colored squares.  A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits.  The program runs until the user closes the window.
 */

public class RandomMosaicWalk {
    
    public static final int ROWS = 41;
    public static final int COLUMNS = 41;
 
    static int currentRow = 10;    // Row currently containing the disturbance.
    static int currentColumn = 10; // Column currently containing disturbance.
    static int rectTop = ROWS;             // row that comprises top edge of rectangle
    static int rectLeft = COLUMNS;            // column that comprises left edge of rectangle
    static int rectHeight = 1;          // number of rows spanning the length of the rectangle
    static int rectWidth = 1;           // number of columns spanning the width of the rectangle
    static int rectRed = 0;         // red component of rectangle
    static int rectGreen = 0;       // green component of rectangle
    static int rectBlue = 0;        // blue component of rectangle
 
    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbance in a random walk around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.open(ROWS,COLUMNS,20,20);
     //   fillWithRandomColors();
    //    currentRow = ROWS/2;   // start at center of window
      //  currentColumn = COLUMNS/2;
        
        while (Mosaic.isOpen()) {
            System.out.println("First rectLeft = " + rectLeft);
        //    for(int i = ROWS / 2; i > 0 ; i--) {
        //        rectTop -= 1;
        //        rectLeft -= 1;
        //        System.out.println(rectLeft);
        //        rectHeight += 1;
        //        rectWidth += 1;
        //        System.out.println(rectTop + ",  " + rectLeft + ",  " + rectHeight + ",  " + rectWidth);
                outlineRectangle(rectTop,rectLeft,rectHeight,rectWidth,rectRed,rectGreen,rectBlue);
                
            
        //         changeToRandomColor(currentRow, currentColumn);
                
       //          randomMove();
                Mosaic.delay(2000);
      //      }
            
        }
    }  // end main
    
    
    /**
     * Fills the window with randomly colored squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to a random color. 
     */
    static void fillWithRandomColors() {
         for (int row=0; row < 20; row++) {
            for (int column=0; column < 20; column++) {
                changeToRandomColor(row, column);  
            }
         }
    }  // end fillWithRandomColors
 
    /**
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {
         int red = (int)(256*Math.random());    // Choose random levels in range
         int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
         int blue = (int)(256*Math.random());   //     and blue color components.
         Mosaic.setColor(rowNum,colNum,red,green,blue);  
     }  // end changeToRandomColor
    
    
/*    static void outlineRectangle(int top, int left, int height, int width, int red, int green, int blue) {
        int row = 0;
        int column = 0;
        
        for(row = top; row < ROWS; row++) {
            for (column = left; column < COLUMNS; column++) {
                
                    rectRed += 5;
                    rectGreen += 5;
                    rectBlue += 5;
                    Mosaic.setColor(row,column,rectRed,rectGreen,rectBlue);
                    System.out.println("row = " + row + "  left = " + column);
                }
            }
        } */
        
        
/*    static void outlineRectangle(int top, int left, int width, int height, int red, int green, int blue) {
        int row = 0;
        int column = 0;
        
        for (int i = 0; i < 10; i++) {
            top -= i;
            left -= i;
            width += 2;
            height += 2;
            red += 10;
            green += 10;
            blue += 10;
            
            for (row = top; row > 0; row = (row + height) ) {
                for (column = left; row < 0; column = column + width) {
                    Mosaic.setColor(row, column, red, green, blue);
                }
                    
            }
        } 
    } */
    
    
    // top = 20, left = 20, width = 1, height = 1, red = 0, green = 0, blue = 0
    static void outlineRectangle(int top, int left, int width, int height, int red, int green, int blue) {
        int row = 0;
        int column = 0;        
        

            // top
            for (column = left; column <= left + width - 1; column+=2 ) {
                for (row = top; row <= top + height - 1; row+=2 ) {
             //   row = top;
      //      top -= 1;
       //     left -= 1;
            height += 2;
            width += 2;
            row = top - 1;
            column = left - 1;
                Mosaic.setColor(row, column, red += 20, green += 20, blue += 20);
   //         }
  //          for (column = left; column <= left + width - i; column++) {
        //        Mosaic.setColor(top + height - 1, column, red + 50, green + 50, blue + 50);
            
            }
        }    
    }
    
    
     /**
      * Move the disturbance.
      * Precondition:   The global variables currentRow and currentColumn
      *                 are within the legal range of row and column numbers.
      * Postcondition:  currentRow or currentColumn is changed to one of the
      *                 neighboring positions in the grid -- up, down, left, or
      *                 right from the current position.  If this moves the
      *                 position outside of the grid, then it is moved to the
      *                 opposite edge of the grid.
      */
     static void randomMove() {
         int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
         directionNum = (int)(4*Math.random());
         switch (directionNum) {
            case 0:  // move up 
               currentRow--;
               if (currentRow < 0)
                  currentRow = 9;
               break;
            case 1:  // move right
               currentColumn++;
               if (currentColumn >= 20)
                  currentColumn = 0;
               break; 
            case 2:  // move down
               currentRow ++;
               if (currentRow >= 10)
                  currentRow = 0;
               break;
            case 3:  // move left  
               currentColumn--;
               if (currentColumn < 0)
                  currentColumn = 19;
               break; 
         }
     }  // end randomMove
     
     
 /*    public void moveRectangleRows(int left, int top) {
         
         for(int i = 0; i < ROWS / 2; i++) {
             currentRow += 
         }
     } */
 
} // end class RandomMosaicWalk
