import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int m = matrix.length;    
        int n = matrix[0].length;   
        
        int srow = 0, erow = m - 1;
        int scol = 0, ecol = n - 1;

        while (srow <= erow && scol <= ecol) {
     
            for (int j = scol; j <= ecol; j++) {
                ans.add(matrix[srow][j]);
            }

            for (int i = srow + 1; i <= erow; i++) {
                ans.add(matrix[i][ecol]);
            }

            if (srow < erow) {
                for (int j = ecol - 1; j >= scol; j--) {
                    ans.add(matrix[erow][j]);
                }
            }

            if (scol < ecol) {
                for (int i = erow - 1; i > srow; i--) {
                    ans.add(matrix[i][scol]);
                }
            }

            srow++; 
            erow--; 
            scol++; 
            ecol--;
        }
        
        return ans;
    }
}