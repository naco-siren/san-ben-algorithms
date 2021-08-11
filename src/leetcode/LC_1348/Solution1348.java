package leetcode.LC_1348;

import java.util.*;


/**
 * 1348. Tweet Counts Per Frequency
 *
 * Your TweetCounts object will be instantiated and called as such:
 * Solution1348 obj = new Solution1348();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
class Solution1348 {
    Map<String, TreeMap<Integer, Integer>> nameToTimestamps;

    public Solution1348() {
        nameToTimestamps = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        TreeMap<Integer, Integer> timestamps = nameToTimestamps.computeIfAbsent(tweetName, name -> new TreeMap<>());
        timestamps.put(time, timestamps.getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        final List<Integer> result = new ArrayList<>();

        final TreeMap<Integer, Integer> timestamps = nameToTimestamps.get(tweetName);
        if (timestamps == null)
            return result;

        final int frequency = mapFreqNameToValue(freq);
        int start = startTime;
        while (start <= endTime) {
            int end = Math.min(endTime, start + frequency - 1);

            final int sum = timestamps
                    .subMap(start, true, end, true)
                    .values()
                    .stream()
                    .reduce(0, Integer::sum);

            result.add(sum);

            start = end + 1;
        }
        return result;
    }

    private static int mapFreqNameToValue(final String freq) {
        switch(freq) {
            case "minute":
                return 60;
            case "hour":
                return 60 * 60;
            case "day":
                return 24 * 60 * 60;
            default:
                throw new IllegalArgumentException("Unexpected freq name: " + freq);
        }
    }
}
