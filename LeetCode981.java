class TimeMap {
    private Map<String, List<Pair<String, Integer>>> word;
    public TimeMap() {
        word = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if(!word.containsKey(key))
            this.word.put(key, new ArrayList());
        this.word.get(key).add(new Pair(value, timestamp));
        return;
    }

    public String get(String key, int timestamp) {
        if(!word.containsKey(key))
            return "";
        List<Pair<String, Integer>> time = this.word.get(key);
        int index = 0;
        int left = 0;
        int right = time.size() - 1;
        while(left <= right){// binary search
            int mid = left + (right - left)/2;
            if(time.get(mid).getValue() > timestamp){ //possible timestamp on left
                if(mid == 0)
                    return "";
                if(time.get(mid-1).getValue() <= timestamp)
                    return time.get(mid-1).getKey();
                else
                    right = mid - 1;
            } else {                       //possible timestamp on right
                if(mid == time.size() - 1)
                    return time.get(mid).getKey();
                if(time.get(mid+1).getValue() > timestamp)
                    return time.get(mid).getKey();
                else
                    left = mid + 1;
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
