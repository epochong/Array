/**
 * @author epochong
 * @date 2019/9/16 23:00
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class LeetCode_1053 {
    public static   int[] prevPermOpt1(int[] A) {
        int index = 0;
        int cur = 0;
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] == A[i - 1]) {
                continue;
            }
            index = findIndex(A,i);
            if (index != -1) {
                cur = i;
                break;
            }
        }
        if (cur != 0) {
            int tem = A[index];
            A[index] = A[cur];
            A[cur] = tem;
        }
        return A;
    }

    public  static int findIndex(int[] arr,int cur) {
        for (int i = cur; i >= 0; i--) {
            if (arr[i] > arr[cur]) {
                int[] tem = new int[cur - i - 1];
                for (int k = i + 1; k < i; k++) {
                    tem[i] = arr[k];
                }
                if (findIndex(tem,cur - 1) != -1) {
                    return findIndex(tem,cur - 1);
                } else {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,1,3};
        arr = prevPermOpt1(arr);
        for (int i :
                arr) {
            System.out.println(i);
        }
    }
}
