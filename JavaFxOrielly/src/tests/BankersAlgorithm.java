/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author KIPTOO
 */
public class BankersAlgorithm {
    
    int n=5;// number of processes 
    int m=3; //number of resources
    
    int need[][]= new int [n][m];
    int max[][];
    int [][]alloc;
    int []avail;
    int safeSequence[]= new int[n];
    
    void init()
    {
        //P0, P1, P2, P3, P4 are the process names here
        //The allocation matrix
        alloc= new int[][]
        {
            {0,1,0},//p0
            {2,0,0},//p1
            {3,0,2},//p2
            {2,1,1},//p3
            {0,0,2}//p4
        };
        
        //The maximum matrix
        max= new int[][]
        {
            {7,5,3},//p0
            {3,2,2},//p1
            {9,0,2},//p2
            {2,2,2},//p3
            {4,3,3}//p4
        };
        
        //Available resources
        avail= new int[]
        {
            3,2,2
        };
        
        
    }
    
    //function to check the safe mode
    void isSafe()
    {
        int count=0;
        
        //visisted array to find if it is already allocated process
        boolean visited[]= new boolean[n];
        for(int i=0;i<n;i++)
        {
            visited[i]=false;
        }
        
        //work array to store the number of resources
        int work[]= new int[m];
        for(int i=0;i<n;i++)
        {
            work[i]= avail[i];
        }
        
        while(count<n)
        {
            boolean flag=false;
            for(int i=0;i<n;i++)
            {
                
        }
    }
}
}
