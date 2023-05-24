# nonogram
Nonogram
The goal of this assignment is to demonstrate your understanding of arrays and recursion by solving these puzzles.

Background
Nonogram is a logical puzzle with simple rules. Given a grid of squares, which must be filled in black or marked with X, to indicate that it cannot be black. Beside each row of the grid are listed the lengths of the runs of black squares on that row. Above each column are listed the length of the run of black squares in that column. The objective is to find all black squares. There are stacked numbers, which indicate black squares must be connected within the puzzle.

Example 1:
Input: columns = {{0,1}, {0,1}, {0,1}, {0,1}, {0,1}}; rows = {{0,5}}
Output: {{T, T, T, T, T},{}}
Example 2:
Input: columns = {{0,2}, {0,2}, {0,2}, {0,1}, {0,1}, {0,1}, {0,2}, {0,2}, {0,2}}; rows = {{4, 3}, {4, 3}}
Output: {{T, T, T, T, F, F, T, T, T}, {T, T, T, F, T, T, T, T, F}}
Example 3:
Input: columns = {{1,1}, {2,1}, {0,2}, {1,1}, {1,1}};  rows = {{1,2}, {0,1}, {0,5}, {0,1}, {1,2}}
Output: {{T, F, F, F, T},
         {F, T, F, F, F},
         {T, T, T, T, T},
         {F, F, T, F, F},
         {F, T, F, T, F}}
Example 4:
Input: columns = {{0,1}, {1,1}, {0,2}, {0,1}, {0,1}, {1,1}}; rows = {{0,1}, {3,1}, {1,1}, {1,1}}
Output: {{T, F, F, F, F, F},
         {F, T ,T ,T, F, T},
         {F, F, T, F, T, F},
         {F, T, F, F, F, T}}
Example 5:
Input: columns = {{0,1}, {1,1}, {1,1}, {1,1}, {0,1}}; rows = {{1,1}, {0,1}, {1,1}, {1,1}, {0,1}}
Output: {{F, T, F, T, F},
         {F, F, T, F, F},
         {T, F, F, F, T},
         {F, T, F, T, F},
         {F, F, T, F, F}}
Example 6:
Input: columns = {{1,1}, {1,3}, {1,3}, {2,1}, {2,1}, {2,2}, {1,3}, {2,1}}; rows = {{1,1}, {1,3}, {2,3}, {4,1}, {2,2}, {1,6}}
Output: {{F, T, F, F, F, F, F, T},
         {F, F, T, F, F, T, T, T},
         {T, T, F, T, T, T, F, F},
         {F, T, T, T, T, F, T, F},
         {F, T, T, F, F, T, T, F},
         {T, F, T, T, T, T, T, T}}
Example 7:
Input: columns = {{2,1}, {1,1}, {3,1}, {1,1}, {2,1}}; rows = {{0,1}, {2,1}, {0,3}, {2,1}, {0,1}}
Output: null
Explanation: this puzzle with the given columns and rows is impossible to solve as a nonogram.
