package leetcode.e47;

/**
 * Created by txwyy123 on 18/8/22.
 */
public class No733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        doFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    void doFill(int[][] image, int sr, int sc, int newColor, int color){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length)
            return;

        if(image[sr][sc] == newColor)
            return;

        if(image[sr][sc] == color) {
            image[sr][sc] = newColor;
            doFill(image, sr-1, sc, newColor, color);
            doFill(image, sr+1, sc, newColor, color);
            doFill(image, sr, sc-1, newColor, color);
            doFill(image, sr, sc+1, newColor, color);
        }
    }

    public static void main(String[] args){
        No733 no733 = new No733();
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        no733.floodFill(image, sr, sc, newColor);
        System.out.print(image);
    }
}
