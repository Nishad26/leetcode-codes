package greedy;
//Here trick is think :- you dont need to think arrival and departure as a pair

//you will think ki appan array sort naahi kaaru shakat , paan taasa naahiye
//we can sort both the arroval and departyure array , karan tula time chi padley

//think ki time cha vichar klaartoy tu , 
//saamaj ek train aali taar tula naahi pharaak paadat ki ti kadhi nighte (thats why we sorted independently)
//,tu phakta time baghto
//next activity kaay honare te baghto, so 

import java.util.Arrays;

//great explation :- https://www.youtube.com/watch?v=AsGzwR_FWok
public class MinimumPlatform {
    public static void main(String[] args) {

        int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
        int n = arr.length;
        int totalCount = countPlatforms(n, arr, dep);
        System.out.println("Minimum number of Platforms required " + totalCount);
    }

    static int findPlatformOptimized(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 0, result = 0;
        int i = 0, j = 0;

        while (i < n) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result)
                result = plat_needed;
        }
        return result;
    }

    static int countPlatforms(int n, int arr[], int dep[]) {
        int ans = 1; // final value
        for (int i = 0; i <= n - 1; i++) {
            int count = 1; // count of overlapping interval of only this iteration

            // first condition :- samaz ek range fix keli tu ani tula pahije overalappig
            // trains
            // here i is your fixed train and j is your variable train , ji tu test
            // kaartoy overalap hote kaa

            // 1st if condition :- jaar tuzi variable train is arriving before the fixed
            // train
            // then tyacha departure time should be gretaer than arrival time of fixed train

            // 2nd condition :- jaar tuzi variable train is arrive after the arrival time of
            // fixed train
            // taar tyacha arrival time should be less than deprature time of the fixed
            // train
            for (int j = i + 1; j <= n - 1; j++) {
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) ||
                        (arr[j] >= arr[i] && arr[j] <= dep[i])) {
                    count++;
                }
            }
            ans = Math.max(ans, count); // updating the value
        }
        return ans;
    }
}
