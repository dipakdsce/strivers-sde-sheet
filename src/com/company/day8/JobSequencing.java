package com.company.day8;

import java.util.*;

class Job {
    int index;
    int deadline;
    int profit;

    Job(int index, int deadline, int profit) {
        this.index = index;
        this.deadline = deadline;
        this.profit = profit;
    }

    Job() {}
}

class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if(o1.profit > o2.profit) {
            return -1;
        } else if (o1.profit < o2.profit) {
            return 1;
        } else {
            return 0;
        }
    }
}
public class JobSequencing {
    public static void main(String[] args) {
        List<Job> jobList =  new ArrayList<>();
        jobList.add(new Job(1, 2, 100));
        jobList.add(new Job(2, 1, 19));
        jobList.add(new Job(3, 2, 27));
        jobList.add(new Job(4, 1, 25));
        jobList.add(new Job(5, 1, 15));
        System.out.println(Arrays.toString(findMaxProfit(jobList)));
    }

    private static int[] findMaxProfit(List<Job> jobList) {
        JobComparator jobComparator = new JobComparator();
        jobList.sort(jobComparator);
        int maxDeadLine = Integer.MIN_VALUE;
        for(Job job : jobList) {
            maxDeadLine = Math.max(maxDeadLine, job.deadline);
        }

        int[] jobExecutionSlot = new int[maxDeadLine + 1];

        for(int i = 0; i <=maxDeadLine; i++) {
            jobExecutionSlot[i] = -1;
        }
        int countJobs = 0;
        int jobProfit = 0;
        for(int i = 0; i < jobList.size(); i++) {
            for (int j = jobList.get(i).deadline; j > 0; j--) {
                if (jobExecutionSlot[j] == -1) {
                    jobExecutionSlot[j] = i;
                    countJobs++;
                    jobProfit += jobList.get(i).profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }
}
