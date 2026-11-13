package Week1;

import java.util.Scanner;
public class EqualStacks {
    public static int solution (int[] h1, int[] h2, int[] h3){
        int s1, s2, s3, i1, i2, i3;
        s1 = s2 = s3 = i1 = i2 = i3 = 0;
        for (int num : h1) {
            s1 += num;
        }
        for (int num : h2) {
            s2 += num;
        }
        for (int num : h3) {
            s3 += num;
        }
        while (s1 != s2 || s2 != s3) {
            if (s1 > s2) {
                if (s1 > s3){
                    s1 -= h1[i1];
                    i1 += 1;
                }
                else{
                    s3 -= h3[i3];
                    i3 += 1;
                }
            }
            else{
                if (s2 > s3){
                    s2 -= h2[i2];
                    i2 += 1;
                }
                else{
                    s3 -= h3[i3];
                    i3 += 1;
                }
            }
        }
        return s1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        sc.nextLine();

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n3];

        for (int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }

        sc.nextLine();

        for (int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        sc.nextLine();

        for (int i = 0; i < n3; i++){
            arr3[i] = sc.nextInt();
        }

        System.out.println(EqualStacks.solution(arr1, arr2, arr3));
    }
}