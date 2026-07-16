class Solution {
    record Task(char task, int frequency, int nextAvailableTime){}
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCountsMap = new HashMap<>();
        for (char c: tasks) {
            taskCountsMap.merge(c, 1, Integer::sum);
        }
        // Max Heap
        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.frequency, a.frequency)
        );
        for(var entry: taskCountsMap.entrySet()) {
            pq.offer(new Task(entry.getKey(), entry.getValue(), 0));
        }
        // Cooldown queue
        Queue<Task> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++; // CPU cycle
            if(!pq.isEmpty()) {
                Task el = pq.poll();
                int remainingFreq = el.frequency() - 1;
                if (remainingFreq > 0) {
                    // need to process again, put it in cooldown queue
                    q.offer(new Task(el.task, remainingFreq, time + n));
                }                
            } else {
                // Fast forward to cooldown queue first element.
                time = q.peek().nextAvailableTime();
            }
            // Is the task available to process? then push it to heap
            if(!q.isEmpty() && q.peek().nextAvailableTime() == time) {
                Task el = q.poll();
                pq.offer(el);
            }
        }
        return time;
    }
}
