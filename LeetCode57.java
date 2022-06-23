class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = intervals.length;
        List<int[]> list = new LinkedList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int index = 0;
        while(index < l && intervals[index][1] < start){
            list.add(new int[]{intervals[index][0], intervals[index][1]});
            index ++;
        }
        if(index == l){
            list.add(new int[]{start, end});
            return list.toArray(new int[list.size()][2]);
        }
        if(intervals[index][0] > end){
            list.add(new int[]{start, end});
        } else {
            list.add(new int[]{Math.min(intervals[index][0], start), Math.max(intervals[index][1], end)});
            index ++;
        }
        for(int i = index; i < l; i ++){
            if(list.get(list.size()-1)[1] >= intervals[i][0]){
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
            } else
                list.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
