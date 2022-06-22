class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if(intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < intervals.length; i ++){
            if(list.isEmpty() || list.get(list.size()-1)[1] < intervals[i][0])
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            else
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
