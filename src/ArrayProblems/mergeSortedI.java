package ArrayProblems;

public class mergeSortedI {
    public static void merge(int[] a, int[] b, int m, int n){
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(a[i]>b[j]){
                a[k]=a[i];
                i--;
            }else{
                a[k]=b[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            a[k]=b[j];
            j--;
            k--;
        }
    }
    public static void main(String[] args) {
        int[] a={1,2,3,0,0,0};
        int[] b={2,4,6};
        int m=3;
        int n=3;
        merge(a,b,m,n);
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
