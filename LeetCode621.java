class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] freq = new Integer[26];
        for(int i = 0; i < 26; i ++)
            freq[i] = 0;
        for(int i = 0; i < tasks.length; i ++){
            freq[tasks[i]-'A'] ++;
        }
        Arrays.sort(freq, (a, b) -> b - a);
        int idle = (freq[0] - 1) * n;
        for(int i = 1; i < freq.length && idle > 0; i ++){
            idle -= Math.min(freq[i], freq[0]-1);
        }
        idle = idle < 0 ? 0 : idle;
        return idle + tasks.length;
    }
}
