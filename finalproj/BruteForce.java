import java.util.ArrayList;

public class BruteForce {
    int n; // number of items
    int[] weights;
    int[] values;
    int capacity;
    ArrayList<String> strings; // generated binary strings for arrangements

    public BruteForce(int n, int[] value, int[] weight, int capacity) {
        this.n = n;
        this.values = value;
        this.weights = weight;
        this.capacity = capacity;
    }

    private ArrayList<String> getGrayCode(int n) {
        ArrayList<String> grayCode = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        if (n > 1) {
            // recursive
            temp = getGrayCode(--n);
            // prepend a 0
            for (int i = 0; i < temp.size(); i++) {
                grayCode.add("0" + temp.get(i));
            }
            // prepend 1
            for (int i = temp.size(); i-- > 0;) {
                grayCode.add("1" + temp.get(i));
            }
            return grayCode;
        } else {
            // graycode for n=1 is just {0,1}, it's the base case
            grayCode.add("0");
            grayCode.add("1");
            return grayCode;
        }
    }

    public void getMaxProfit() {
        ArrayList<String> binString = getGrayCode(n);
        int maxProfit=0,maxWeight=0,tempProfit,tempWeight;
        char[] binStr = new char[n];
        int[] binInt = new int[n];
        int[] maxProfitItems=new int[n];
        for (String str : binString) {
            binStr = str.toCharArray();
            for (int i = 0; i < n; i++) {
                   binInt[i]=binStr[i]-'0';
            }
            tempProfit=0;
            tempWeight=0;
            for(int i=0;i<n;i++){
                tempProfit+=binInt[i]*values[i];
                tempWeight+=binInt[i]*weights[i];
            }
            if(tempWeight<=capacity && tempProfit>maxProfit){
                maxProfit=tempProfit;
                maxWeight=tempWeight;
                maxProfitItems=binInt.clone();
            }
        }
        System.out.printf("Using Brute force the best feasible solution found: Value %d, Weight %d\n",maxProfit,maxWeight);
        for(int i=0;i<n;i++){
            if(maxProfitItems[i]==1){
                System.out.printf("%d ",i+1);
            }
        }
        System.out.println();
    }
}