package medium;

/**
 * @ClassName: Code_79_WordSearch
 * @Description:
 * 给定一个2D板和一个单词，找出该单词是否存在于网格中。
 *
 * 该单词可以由顺序相邻的单元的字母构成，其中“相邻”单元是水平或垂直相邻的单元。相同的字母单元格不得多次使用。
 * @Author: WilsonSong
 * @Date: 2019/6/8 9:08
 * @Version 1.0
 **/
public class Code_79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0){
            return false;
        }
        char[] words = word.toCharArray();
        boolean[][] flag = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j =0; j < board[0].length; j++){
                if (words[0] == board[i][j] && process(board,i,j, words,0, flag)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean process(char[][] board, int i, int j, char[] words, int k, boolean[][] flag){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if (k == words.length-1 && board[i][j] == words[k] && !flag[i][j]) {
            return true;
        }

        if (board[i][j]!= words[k] || flag[i][j]){
            return false;
        }
        flag[i][j] = true;
        if (process(board,i+ 1, j,words,k+1, flag)
        || process(board,i - 1, j,words,k+1, flag)
        ||process(board,i, j + 1,words,k+1, flag)
        ||process(board,i, j -1,words,k+1, flag)){
            return true;
        }
        flag[i][j] = false;

        return false;
    }
}
