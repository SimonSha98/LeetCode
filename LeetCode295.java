class MedianFinder {
    private List<Integer> list;
    public MedianFinder() {
        list = new ArrayList();
    }

    public void addNum(int num) {
        if(list.size() == 0){
            list.add(num);
            return;
        }
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            int mid = left + (right - left)/2;
            int val = list.get(mid);
            if(val == num){
                list.add(mid, num);
                return;
            }
            if(val > num)
                right = mid;
            else
                left = mid + 1;
        }
        if(list.get(left) > num)
            list.add(left, num);
        else
            list.add(left + 1, num);
        return;
    }

    public double findMedian() {
        int size = list.size();
        if(size % 2 == 1){
            double d = (double) list.get(size/2);
            return d;
        }
        double d1 = (double) list.get(size/2-1);
        double d2 = (double) list.get(size/2);
        return (d1+d2)/2;
    }
}
