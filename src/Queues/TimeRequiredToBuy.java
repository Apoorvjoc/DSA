package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int i = 0 , ans = 0;

        while(true){
            int idx = i%n;
            if(tickets[k] == 0){
                return ans;
            }

            if(tickets[idx] > 0){
                tickets[idx]--;
                ans++;
            }
            i++;
        }
    }
}

class UsingQueues{
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Queue to simulate the people standing in line
        Queue<Integer> queue = new LinkedList<>();
        int wait = 0;

        // Step 1: Populate the queue with indices of the tickets
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        // Step 2: Simulate the ticket buying process
        while (!queue.isEmpty()) {
            int idx = queue.poll();  // Get the front person in the queue
            tickets[idx]--;          // Decrease the number of tickets for this person
            wait++;                   // Increment the total waiting time

            // Step 3: If the person at index k has bought all their tickets, return the total waiting time
            if (tickets[idx] == 0 && idx == k) {
                return wait;
            }

            // Step 4: If the person hasn't bought all tickets, they go back to the end of the queue
            if (tickets[idx] > 0) {
                queue.offer(idx);
            }
        }

        return wait;
    }
}
