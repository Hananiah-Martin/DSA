import java.util.*;
public class jobsequecingproblem {
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i,int d,int p){
             id=i;
             deadline=d;
             profit=p;
        }
    }
    public static void main(String args[]){
        int JobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job>jobs=new ArrayList<>();
        for(int i=0;i<JobsInfo.length;i++){
            jobs.add(new Job(i,JobsInfo[i][0],JobsInfo[i][1]));
        }
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            System.out.print(curr.deadline);
            System.out.print(curr.profit);
            System.out.print(curr.id);
            System.out.println();
        }
        // ArrayList<Integer>seq=new ArrayList<>();
        // int time=0;
        // for(int i=0;i<jobs.size();i++){
        //     Job curr=jobs.get(i);
        //     if(curr.deadline>time){
        //         seq.add(curr.id);
        //         time++;
        //     }
        // }
        // System.out.println(seq.size());
        // for(int i=0;i<seq.size();i++){
        //     System.out.print(seq.get(i)+" ");
        // }
    }
}