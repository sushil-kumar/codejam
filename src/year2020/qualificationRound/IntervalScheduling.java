package year2020.qualificationRound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalScheduling {
    public static ArrayList<Interval> intervalScheduling(ArrayList<Interval> intervals){
        Collections.sort(intervals, Comparator.comparing(p -> p.end));
 
        ArrayList<Interval> resultList = new ArrayList<>();
 
        for(Interval currentInterval : intervals) {
            if(resultList.isEmpty()) resultList.add(currentInterval);
            else{
                if(currentInterval.start > resultList.get(resultList.size()-1).end){
                    resultList.add(currentInterval);
                }
            }
        }
        return resultList;
    }
 
    public static void main(String args[] ) throws Exception {
        ArrayList<Interval> intervals = new ArrayList<>();
 
        intervals.add(new Interval(930,1100, 0));
        intervals.add(new Interval(930,1300, 1));
        intervals.add(new Interval(930,1100, 2));
        intervals.add(new Interval(1130,1300, 3));
        intervals.add(new Interval(1100,1400, 4));
        intervals.add(new Interval(1330,1500, 5));
        intervals.add(new Interval(1330,1500, 6));
        intervals.add(new Interval(1430,1700, 7));
        intervals.add(new Interval(1530,1700, 8));
 
        ArrayList<Interval> compatibleIntervals = intervalScheduling(intervals);
 
        for(Interval interval : compatibleIntervals) {
            System.out.println("(" + interval.start + "," + interval.end + ")");
        }
    }
}