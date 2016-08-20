/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 */


import java.util.Arrays;

/**
 * ArrayProblems.java
 * <p>
 * VERY IMPORTANT: For this assignment only,
 * the only methods and classes from the
 * Java standard library you may use in your final solutions are:<br>
 * 1. All methods from the System class<br>
 * 2. All methods from the Math class<br>
 * 3. native arrays, including the <tt>arr.length</tt> field and creating and using new native arrays
 */
public class ArrayProblems {
    //private static int sum=0;
    /**
     * Determine the Hamming distance between two arrays of ints.
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.
     *
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */
    public static int hammingDistance(int[] aList, int[] bList) {
        assert (aList != null && bList != null && aList.length == bList.length) : "Violation of precondition: hammingDistance";
        if(aList.length!=bList.length){
            return -1;
        }
        int distance=0;
        for(int i=0;i<aList.length;i++){
            if(aList[i]!=bList[i]){
                distance++;
            }
        }
        return distance;
    }

    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or
     * the parameter <tt>listB</tt> are altered as a result of this method.
     *
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, <tt>false</tt> otherwise
     */
    public static boolean isPermutation(int[] listA, int[] listB) {
        assert (listA != null && listB != null && listA.length==listB.length) : "Violation of precondition: isPermutation";
        int [] newListA = Arrays.copyOf(listA,listA.length);
        int [] newListB = Arrays.copyOf(listB,listB.length);
        Arrays.sort(newListA);
        Arrays.sort(newListB);
        if(Arrays.equals(newListA,newListB)) {
            return true; //must change
        }
        return false;
    }


    /**
     * Find the two values in an array of ints that have the smallest absolute
     * difference.
     * The parameter <tt>nums</tt> is not altered as a result of
     * this method.
     *
     * @param nums The array being searched.
     *             <tt>nums</tt> != null, <tt>nums.length</tt> >= 2
     * @return Returns an array of length 2.
     * The elements of the result are the indices of ints in
     * nums that have the smallest absolute difference
     * of any pair of ints in nums.<br>
     * If there is more than one pair of ints that meet this
     * criteria return the indices of the pair with the index closest
     * to zero.<br>
     * If there is more than one pair of ints with the
     * index closest to 0, return the indices of the pair with the
     * second index closest to 0.<br>
     * The first element of the result is the index closest to 0.
     * For example given the array <tt>{5, 3, 21, 10, 12, 7}</tt> the method
     * would return <tt>{0, 1}</tt>.
     */
    public static int[] minDifference(int[] nums) {
        int[] result = new int[2];
        int lowestFirstIndex=Integer.MAX_VALUE, distance = Integer.MAX_VALUE, lowestSecondIndex = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(Math.abs(nums[i]-nums[j])<distance){
                    distance=Math.abs(nums[i]-nums[j]);
                    /*if(i<=lowestFirstIndex)*/lowestFirstIndex=i;
                    /*if(j<lowestSecondIndex)*/lowestSecondIndex=j;
                }
            }
        }
        result[0]=lowestFirstIndex;
        result[1]=lowestSecondIndex;
       /* System.out.println("List : " + distance);
        System.out.println("List : " + Arrays.toString(result));*/
       return result;
    }


    /**
     * Determine which row or column in a matrix has the largest sum.
     * The parameter <tt>mat</tt> is not altered as a result of
     * this method call.
     * <p>pre: mat != null, mat.length > 0,
     * mat is a rectangular matrix, mat[0].length > 0
     * <p>post: determine which row or column of ints has the maximum sum in max.
     * If a row contains the maximum sum, return a string starting with "R" and
     * then the number of the row with no spaces. For example "R0" or "R12". If a
     * column contains the maximum sum, return a string starting with "C" and then
     * the number of the column with no spaces. For example "C0" or "C12".
     * If there is more than one row or column with the maximum sum
     * return rows over columns first, then smaller indices over
     * larger indices.<br>
     * Thus if rows 3, 5, and 12, and columns 0 and 2 all contained
     * the same maximum sum the method would return "R3".
     */
    public static String maxSum(int[][] mat) {
        assert (mat != null) && (mat.length > 0) && (mat[0].length > 0)
                && isRectangular(mat) : "Violation of precondition: maxSum";
        String row = "R", col = "C", ans1, ans2, index1, index2;
        int ind = 0, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++)
        {
            int x = 0;
            for (int j = 0; j < mat[i].length; j++)
            {
                x = x + mat[i][j];
            }
            if (x > max1)
            {
                max1 = x;
                ind = i;
            }
        }
        index1 = Integer.toString(ind);
        for (int i = 0; i < (mat[i].length) - 1; i++)
        {
            int x = 0;
            for (int j = 0; j < mat.length; j++)
            {
                x = x + mat[j][i];
            }
            if (x > max2)
            {
                max2 = x;
                ind = i;
            }
        }
        index2 = Integer.toString(ind);
        if (max1 >= max2) {
            ans1 = row + index1;
            return ans1;
        } else {

            ans2 = col + index2;
            return ans2;
        }
    }

    /**
     * Given a 2D array of ints return the value of the
     * most valuable contigous sub rectangle in the 2D array.
     * The sub rectnagle must be at lest 1 by 1.
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     *
     * @param city The 2D array of ints representing the value of
     *             each block in a portion of a city.
     * @return return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     */
    public static int mostValuablePlot(int[][] city) {
        assert city != null && city.length > 0 && city[0].length > 0 &&
                isRectangular(city) : "Failed precondition sizeOfLargestSubMatrix";
        int sum=Integer.MIN_VALUE, tempSum=0,k;
        for (int i = 0; i <city.length ; i++) {

            for (int j = 0; j < city[i].length; j++) {
                int l = i;
                while (l < city.length) {
                    k=j;
                    while (k < city[i].length) {
                        tempSum = addMatrix(city, i, j, l, k);
                        if (sum < tempSum) {
                            sum = tempSum;
                        }
                        k++;
                    }
                    l++;
                }
            }

        }
        return sum; //must change
        }

    public static int addMatrix(int[][] city, int i, int j, int maxX, int maxY){
        int tempSum=0;
        while( i <= maxX ) {
            while( j <= maxY) {
                tempSum += city[i][j];
                j++;
            }
            i++;
        }
        return tempSum;
    }

    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.), all elements of board == 'q' or '.'. 'q's represent queens, '.'s  represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,that is no queen can attack any other queen on the board. false otherwise.
     the parameter <tt>board</tt> is not altered as a result of this method.
     *
     * @param board the chessboard
     * @return true if the configuration of board is safe, that is no queen can attack any other queen on the board. false otherwise.
     */

    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
  assert (board != null) && (board.length > 0) && isSquare(board) && onlyContains(board, validChars) : "Violation of precondition: queensAreSafe";
        int attack = 0, queen, i = 0, j = 0;
        for (i = 0; i < board.length; i++) {
            queen = 0;
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'q') {
                    queen = 1;
                    break;
                }
            }

            if (queen != 0) {
                for (int k = j + 1; k < board.length; k++) {
                    if (board[i][k] == 'q')
                        attack = 1;
                    if (attack==1)
                        return false;
                }
                for (int row = i + 1, col = j - 1; row < board.length && col >= 0; row++, col--) {
                    if (board[row][col] == 'q')
                        attack = 1;
                    if (attack==1)
                        return false;

                }
                for (int row = i + 1; row < board.length; row++) {
                    if (board[row][j] == 'q')
                        attack = 1;
                    if (attack==1)
                        return false;
                }
                for (int row = i + 1, col = j + 1; row < board.length && col < board.length; row++, col++) {
                    if (board[row][col] == 'q')
                        attack = 1;
                    if (attack==1)
                        return false;
                }

            }

        }
        return true;
    }

    public static void main(String[] args) {

        //test 1
        int[] h1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] h2 = {1, 2, 10, 4, 5, 4, 3, -10, 1};
        int expected = 2;
        int actual = hammingDistance(h1, h2);
        System.out.print("Test 1 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 1, hamming distance");
        else
            System.out.println(" failed test 1, hamming distance");

        //test 2
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};
        boolean expectedBool = true;
        boolean actualBool = isPermutation(a, b);
        System.out.print("\nTest 2 expected value: " + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool)
            System.out.println(" passed test 2, isPermutation");
        else
            System.out.println(" failed test 2, isPermutation");

        //test 3
        b = new int[]{2, 1, 3, 3};
        expectedBool = false;
        actualBool = isPermutation(a, b);
        System.out.print("\nTest 3 expected value: " + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool)
            System.out.println(" passed test 3, isPermutation");
        else
            System.out.println(" failed test 3, isPermutation");

        //test 4
        int[] diffNums = {19, 0, -5, 4, 7, 10};
        int[] diffResult = minDifference(diffNums);
        if (diffResult.length == 2 && diffResult[0] == 3 &&
                diffResult[1] == 4)
            System.out.println(" passed test 4, nearest neighbor");
        else
            System.out.println(" failed test 4, nearest neighbor");

        //test 5
        char[][] safe = {{'.', '.', '.'},
                {'q', '.', '.'},
                {'.', '.', 'q'}};

        expectedBool = true;
        actualBool = queensAreSafe(safe);
        System.out.print("\nTest 5 expected value: " + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool)
            System.out.println(" passed test 5, queensAreSafe");
        else
            System.out.println(" failed test 5, queensAreSafe");

        //test 6
        char[][] unsafe = {{'.', '.', '.', 'q'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'q', '.', '.', '.'}};
        expectedBool = false;
        actualBool = queensAreSafe(unsafe);
        System.out.print("\nTest 6 expected value: " + expectedBool + ", actual value: " + actualBool);
        if (expectedBool == actualBool)
            System.out.println(" passed test 8, queensAreSafe");
        else
            System.out.println(" failed test 8, queensAreSafe");


        //test 7
        int[][] mat = {{1, 2, 3, 4},
                {0, 0, 0, 0},
                {1, 2, 3, 10},
                {4, 3, 2, 1}};
        String expectedString = "R2";
        String actualString = maxSum(mat);
        System.out.print("\nTest 7 expected value: " + expectedString + ", actual value: " + actualString);
        if (expectedString.equals(actualString))
            System.out.println(" passed test 7, maxSum");
        else
            System.out.println(" failed test 7, maxSum");

        // test 8
        mat = new int[][]{{-10, -20, -30, -40},
                {-2, -2, -200, -300},
                {-200, -2, -300, -100},
                {-200, -3, -200, -100}};
        expectedString = "C1";
        actualString = maxSum(mat);
        System.out.print("\nTest 8 expected value: " + expectedString + ", actual value: " + actualString);
        if (expectedString.equals(actualString))
            System.out.println(" passed test 8, maxSum");
        else
            System.out.println(" failed test 8, maxSum");

        //test 9
        mat = new int[][]{{1, 2, 3, 4},
                {2, 0, 0, -1},
                {3, -2, -2, -1},
                {4, 2, 3, 1}};
        expectedString = "R0";
        actualString = maxSum(mat);
        System.out.print("\nTest 9 expected value: " + expectedString + ", actual value: " + actualString);
        if (expectedString.equals(actualString))
            System.out.println(" passed test 9, maxSum");
        else
            System.out.println(" failed test 9, maxSum");

        // test 10
        mat = new int[][]{{0, -2, -7, 0, -1},
                {9, 2, -6, 2, 0},
                {-4, 1, -4, 1, 0},
                {-1, 8, 0, -2, 1},
                {-10, 1, 1, -5, -6},
                {-15, -1, 1, 5, 4}};

        expected = 15;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 10 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 10, mostValuablePlot");
        else
            System.out.println(" failed test 10, mostValuablePlot");


        // test 11
        mat[4][1] = 6;
        expected = 17;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 11 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 11, mostValuablePlot");
        else
            System.out.println(" failed test 11, mostValuablePlot");

        // test 12
        mat = new int[][]{{1}};
        expected = 1;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 12 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 12, mostValuablePlot");
        else
            System.out.println(" failed test 12, mostValuablePlot");

        // test 13
        mat = new int[][]{{1, 2, 3, 4, 5, 6, 7}};
        expected = 28;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 13 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 13, mostValuablePlot");
        else
            System.out.println(" failed test 13, mostValuablePlot");

        // test 14
        mat = new int[][]{{-10, -10, -10, -5},
                {-15, -15, -10, -10},
                {-5, -10, -20, -5},
                {-5, -5, -10, -20}};

        expected = -5;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 14 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 14, mostValuablePlot");
        else
            System.out.println(" failed test 14, mostValuablePlot");

		/*STUDENTS: ADD YOUR TESTS HERE*/
    }


    /* pre: mat != null
       post: return true if mat is a square matrix, false otherwise
    */
    private static boolean isSquare(char[][] mat) {
        assert mat != null : "Violation of precondition: isSquare";

        final int numRows = mat.length;
        int row = 0;
        boolean square = true;
        while (square && row < numRows) {
            square = (mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return square;
    }


    /* pre: mat != null, valid != null
       post: return true if all elements in mat are one of the characters in valid
    */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        assert mat != null && valid != null : "Violation of precondition: onlyContains";

        int row = 0;
        int col;
        boolean correct = true;
        while (correct && row < mat.length) {
            col = 0;
            while (correct && col < mat[row].length) {
                correct = contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }


    /* pre: list != null
       post: return true if c is in list
    */
    private static boolean contains(char[] list, char c) {
        assert (list != null) : "Violation of precondition: contains";

        boolean found = false;
        int index = 0;
        while (!found && index < list.length) {
            found = list[index] == c;
            index++;
        }
        return found;
    }


    /*
    /* pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }
}