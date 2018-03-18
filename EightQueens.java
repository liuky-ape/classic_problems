package ｅｉｇｈｔ＿ｑｕｅｅｎｓ;
/*八皇后问题：
 *  将八个皇后放到8*8的棋盘里，互相不能攻击
 */
public class EightQueens {
    //定义一个棋盘大小
    static final int MAX_NUM=8;
    static final int MAX_X=8;
    static final int MAX_Y=8;
    //以二维数组模拟棋盘
    int chessBoard[][]=new int[MAX_X][MAX_Y];
    //定义一个方法检验皇后位置是否合适
    boolean check(int x,int y){
        for(int i=0;i<y;i++){
          //检查纵向是否有子
          if(chessBoard[x][i]==1){
              return false;
          }
          //检查左斜向下是否有子
            if(x-1-i>=0&&chessBoard[x-1-i][y-1-i]==1){
              return false;
            }
            //检查右斜向下
            if(x+1+i<MAX_X && chessBoard[x+1+i][y-1-i]==1){
              return false;
            }
        }
        return true;
    }
    //定义方法进行递归回溯
    boolean settleQueen(int y){
        //行数超过8，说明已经找出答案
        if(y==MAX_Y){
            return true;
        }
        //遍历当前行，逐一各自检验
        for(int i=0;i<MAX_X;i++){
            //为当前行清零，以免出现在回溯过程中出现脏数据
            for(int x=0;x<MAX_X;x++){
                chessBoard[x][y]=0;
            }
            //检查是否符合，进一步递归
            if(check(i,y)){
                chessBoard[i][y]=1;
                //递归如果返回true则表示已经找到
                if(settleQueen(y+1)){
                    return true;
                }
            }
        }
        return  false;
    }
//定义输出结果
    void printResult(){
      //直接遍历int数组即可
      for (int y=0;y<MAX_Y;y++){
          for (int x=0;x<MAX_X;x++){
              System.out.print(chessBoard[x][y]);
          }
          System.out.println();
      }
    }
}
