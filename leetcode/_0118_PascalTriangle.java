import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**118.杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和
 *
 * tag: hot100, 动态规划
 */
public class _0118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                if (j==0||j==i){
                    row.add(1);
                }else {
                    row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        new _0118_PascalTriangle().generate(6);
    }
}
