package companies.google.closest_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by naco_siren on 9/16/17.
 */
public class ClosestTime {

    public static void main(String[] args) {
        ClosestTime closestTime1 = new ClosestTime("15:43");
        String nextTime1 = closestTime1.nextTime();

        ClosestTime closestTime2 = new ClosestTime("23:59");
        String nextTime2 = closestTime2.nextTime();

        ClosestTime closestTime3 = new ClosestTime("21:59");
        String nextTime3 = closestTime3.nextTime();


        return;
    }



    private String _input;
    private int[] _nums;
    public ClosestTime(String input){
        _input = input;

        /* Collect all the digits */
        HashSet<Integer> digits = new HashSet<>(4);
        digits.add(input.charAt(0) - '0');
        digits.add(input.charAt(1) - '0');
        digits.add(input.charAt(3) - '0');
        digits.add(input.charAt(4) - '0');

        /* Sort them into an array */
        _nums = new int[digits.size()];
        int i = 0;
        for (Integer digit : digits) {
            _nums[i++] = digit;
        }
        Arrays.sort(_nums);
    }

    private ArrayList<Time> _candidates;
    public String nextTime() {
        /* Generate candidates */
        _candidates = new ArrayList<>(_nums.length * _nums.length * _nums.length * _nums.length);
        for (int h = 0; h < _nums.length; h++) {
            for (int i = 0; i < _nums.length; i++) {
                for (int j = 0; j < _nums.length; j++) {
                    for (int k = 0; k < _nums.length; k++) {
                        int[] digits = new int[]{_nums[h], _nums[i], _nums[j], _nums[k]};
                        Time time = toTime(digits);
                        if (time != null) _candidates.add(time);
                    }
                }
            }
        }

        /* Scan all the candidates to find the result */
        Time curTime = toTime(_input);
        Time nextTime = null;
        for (Time cand : _candidates) {
            if (cand.subtract(curTime) > 0) {
                nextTime = cand;
                break;
            }
        }

        /* Return the first candidate if result not found for today */
        if (nextTime != null)
            return nextTime.toString();
        else
            return _candidates.get(0).toString();
    }

    public Time toTime(int[] digits) {
        int hour = digits[0] * 10 + digits[1];
        int minute = digits[2] * 10 + digits[3];

        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
            return new Time(digits, hour, minute);
        } else {
            return null;
        }
    }

    public Time toTime(String str) {
        int[] digits;
        if (str.length() == 5) {
            digits = new int[]{str.charAt(0) - '0', str.charAt(1) - '0', str.charAt(3) - '0', str.charAt(4) - '0'};
        } else {
            digits = new int[]{str.charAt(0) - '0', str.charAt(1) - '0', str.charAt(2) - '0', str.charAt(3) - '0'};
        }
        return toTime(digits);
    }

    class Time implements Comparable<Time> {
        int[] _digits;
        int _hour = -1;
        int _minute = -1;

        public Time(int[] digits, int hour, int minute) {
            this._digits = digits;
            this._hour = hour;
            this._minute = minute;
        }

        public int subtract(Time t){
            return (this._hour - t._hour) * 60 + (this._minute - t._minute);
        }

        @Override
        public int compareTo(Time t) {
            return this.subtract(t);
        }

        @Override
        public String toString() {
            return "" + _digits[0] + _digits[1] + ":" + _digits[2] + _digits[3];
        }
    }
}
