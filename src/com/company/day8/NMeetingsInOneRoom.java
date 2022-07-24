package com.company.day8;

import java.util.*;

class Meeting {
    int startTime;
    int endTime;
    int index;

    public Meeting(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}

class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.endTime < o2.endTime) {
            return -1;
        } else if (o1.endTime > o2.endTime) {
            return 1;
        } else if (o1.index < o2.index) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int n = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 5, 7, 9, 9};
        System.out.println(findNumberOfMeetings(start, end, n));
        System.out.println(findMeetingNumber(start, end, n));
    }

    private static int findNumberOfMeetings(int[] start, int[] end, int n) {
        /*List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
            MeetingComparator meetingComparator = new MeetingComparator();
            meetings.sort(meetingComparator);
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).index);
        int endTime = meetings.get(0).endTime;
        for(int i=1; i<n; i++) {
            if(meetings.get(i).startTime > endTime) {
                endTime = meetings.get(i).endTime;
                answer.add(meetings.get(i).index);
            }
        }
        return answer.size();*/

        // add your code here
        /*List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
            MeetingComparator meetingComparator = new MeetingComparator();
            meetings.sort(meetingComparator);
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).index);
        int endTime = meetings.get(0).endTime;
        for(int i=1; i<n; i++) {
            if(meetings.get(i).startTime > endTime) {
                endTime = meetings.get(i).endTime;
                answer.add(meetings.get(i).index);
            }
        }
        return answer.size();*/

        PriorityQueue<Meeting> pq = new PriorityQueue<>((p1, p2) -> (p1.endTime - p2.endTime));
        for (int i = 0; i < n; i++) {
            pq.add(new Meeting(start[i], end[i], i));
        }
        int count = 1;
        Meeting prev = pq.poll();
        while (!pq.isEmpty()) {
            Meeting pol = pq.poll();
            if (pol.startTime > prev.endTime) {
                count++;
                prev = pol;
            }
        }
        return count;
    }

    private static ArrayList<Integer> findMeetingNumber(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
        }
        MeetingComparator meetingComparator = new MeetingComparator();
        meetings.sort(meetingComparator);

        int endTime = meetings.get(0).endTime;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(meetings.get(0).index);
        for(int i=1; i<n; i++) {
            if(meetings.get(i).startTime >= endTime) {
                result.add(meetings.get(i).index);
                endTime = meetings.get(i).endTime;
            }
        }
        return result;
    }
}
