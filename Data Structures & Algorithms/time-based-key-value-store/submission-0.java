class TimeMap {

    HashMap<String, ArrayList<Integer>> timestamps;
    HashMap<String, ArrayList<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        timestamps.putIfAbsent(key, new ArrayList<>());
        values.putIfAbsent(key, new ArrayList<>());

        timestamps.get(key).add(timestamp);
        values.get(key).add(value);
    }

    public String get(String key, int timestamp) {

        if (!timestamps.containsKey(key)) {
            return "";
        }

        ArrayList<Integer> times = timestamps.get(key);
        ArrayList<String> vals = values.get(key);

        int left = 0;
        int right = times.size() - 1;
        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (times.get(mid) <= timestamp) {
                result = vals.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
