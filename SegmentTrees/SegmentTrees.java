package SegmentTrees;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTrees{
    static int []arr;
    static int []tree;
    static void segmentTree(int []ar){
        arr=ar;
        tree=new int[4*arr.length];
        build(1,0,arr.length-1);
    }
    static int build(int node,int start,int end){
        //base case create the node when start equals to end
        if(start==end){
            tree[node]=arr[start];
            return arr[start];
        }
        //calculate mid and call the function recursively for left and right subtrees
        int mid=(start+end)/2;
        int left_index=2*node;
        int right_index=2*node+1;
        int left_ans=build(left_index,start,mid);
        int right_ans=build(right_index,mid+1,end);
        //since we want to find the maximum of interval we are taking maximum
        return tree[node]=tree[left_index]+tree[right_index];
    }
    static int query(int node,int start,int end,int left,int right){
        //out of range
        if(end<left ||right<start){
            return Integer.MIN_VALUE;
        }
        //if start is equal to end this is the only element left
        if(start==end){
            return tree[node];
        }
        //if it completely overlaps
        else if(left<=start&&end<=right){
            return tree[node];
        }
        //if it partially call for left and right subtrees
        int left_index=2*node;
        int right_index=2*node+1;
        int mid=(start+end)/2;
        int left_answer=query(left_index,start,mid,left,right);
        int right_answer=query(right_index,mid+1,end,left,right);
        return Math.max(left_answer,right_answer);
    }
    static void update_query(int new_value,int node,int start,int end,int pos){
        if(start==end){
            arr[start]=new_value;
            tree[node]=new_value;
            return;
        }
        int mid=(start+end)/2;
        if(start<=pos&&pos<=end){
            update_query(new_value,node*2,start,mid,pos);
        }
        else{
            update_query(new_value,node*2+1,mid+1,end,pos);
        }
        tree[node]=tree[node*2]+tree[node*2+1];
    }
    static int sum_query(int node,int start,int end,int l,int r){
        if(end<l ||r<start){
            return 0;
        }
        if(start==end){
            return tree[node];
        }
        //the range must be overlapped by the start and ending the node
        if(l<=start&&end<=r){
            return tree[node];
        }
        int mid=(start+end)/2;
        int left=sum_query(node*2,start,mid,l,r);
        int right=sum_query(node*2+1,mid+1,end,l,r);
        return left+right;
    }
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        segmentTree(arr);
        update_query(7,1,0,arr.length-1,3);
        segmentTree(arr);
        System.out.println();
        int ans=sum_query(1,0,arr.length-1,0,3);
        System.out.println(ans);
    }
}
