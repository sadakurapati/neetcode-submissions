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
        Queue<Task> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++; // CPU cycle
            if(pq.isEmpty()) {
                // Fast forward
                time = q.peek().nextAvailableTime();
            } else {
                Task el = pq.poll();
                if (el.frequency() > 1) {
                    q.offer(new Task(el.task, el.frequency - 1, time + n));
                }
            }
            if(!q.isEmpty() && q.peek().nextAvailableTime() == time) {
                Task el = q.poll();
                pq.offer(el);
            }
        }
        return time;
    }
}
