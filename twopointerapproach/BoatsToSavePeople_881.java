//used two pointer approach
//sorted the array nad placed i at 0 j at last index, becuase we wanted couple 
//high weight with low weight 
// youtube :- https://youtu.be/bC_tuyiAEac?si=R2AXijSsdoEHfGnt
public class BoatsToSavePeople_881 {

    public int numRescueBoats(int[] people, int limit) {
        //Sorting using count sort, not needed normal sorting also fine
        int countFreq[] = new int[limit + 1];
        for (int num : people) {
            countFreq[num] += 1;
        }
        int jIndex = 0;
        for (int value = 0; value <= limit; value++) {
            while (countFreq[value] > 0) {
                people[jIndex++] = value;
                countFreq[value] -= 1;
            }
        }
        //Sorting finished above 
        
        int i = 0;
        int j = people.length - 1;
        int count = 0;
        while (i <= j) {
            if (i == j) {
                count++;
                i++;
            } else if (people[j] + people[i] <= limit) {
                count++;
                i++;
                j--;
            } else if (people[j] == limit || people[j] + people[i] > limit) {
                count++;
                j--;
            }
        }
        return count;
    }
}
