package com.prep2020.easy;
import java.time.LocalDate;
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob){
        LocalDate d1 = LocalDate.of(2021,Integer.parseInt(arriveAlice.substring(0,2)),Integer.parseInt(arriveAlice.substring(3,5)));
        LocalDate d2 = LocalDate.of(2021,Integer.parseInt(leaveAlice.substring(0,2)),Integer.parseInt(leaveAlice.substring(3,5)));
        LocalDate d3 = LocalDate.of(2021,Integer.parseInt(arriveBob.substring(0,2)),Integer.parseInt(arriveBob.substring(3,5)));
        LocalDate d4 = LocalDate.of(2021,Integer.parseInt(leaveBob.substring(0,2)),Integer.parseInt(leaveBob.substring(3,5)));
        long aa = d1.toEpochDay(); //Alice Arrive
        long al = d2.toEpochDay(); //Alice Left
        long ba = d3.toEpochDay(); //Bob Arrive
        long bl = d4.toEpochDay(); //Bob Left
        if(al<ba || bl<aa) return 0; //No intersection of days
        return (int) ((Math.min(al,bl)-Math.max(aa,ba))+1); //Intersection of days
    }
}
