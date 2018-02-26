import java.util.concurrent.TransferQueue;

/**
 * Created by edson on 2018/2/25.
 */
public class GlobalandLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        for (int i=0; i < A.length; i++){
            if (Math.abs(A[i]-i) > 1)
                return false;
        }

        return true;


    }
}
