package comp.prep2019;

public class Prob1227 {
	/**
	 * The idea here is that if person i sits in the seat of person j then person j has to seat at a random place!.
Let's look at a smaller picture then we would extend our intuition form there onwards.
Let's say there are only 5 people.
1->2->4->5->1 ... This means that p1 seats at seat2. p2 at s4, p4 at s5 and p5 at s1, and meanwhile p3 comes after p2 and finds s3 empty so sits there. Note that this cycle should end at 1, because a person has to seat in a place alloted to him i.e. p_i must seat at s_i if s_i is empty. Thus this cycle starts at 1 and ends until some person seats at the seat alloted to person 1 and from there onwards all person would find there seat vacant and would sit there.
So with 5 people let's make some more cycles like that:
1->3->1
Here p1 seats at s3, p3 seats at s1 and p2,p4,p5 seats at their respective seats.
1->2->4->1
Here p1 seats at s2, p2 seats s4, p4 seats at s1 and p5 comes and finds his seats empty and seats there.
1->1 , here p1 seats at s1 so p1,p2,p3,p4,p5 all seat at their respective position.
So I guess by now it's very clear that why the cycle should start and end at 1.
The question now is:
HOW MANY CYCLES LIKE THIS YOU CAN MAKE ??
this is an elementary combinatorics problem!. The answer is (nc1)+(nc2)+...+(ncn) i.e. 2^n. Now we want n_th person to get his own seat, for this we want the cycle to end without including the n_th person so let's keep aside n_th person. The number of ways is clearly for that is 2^(n-1).
So the required probability is (2^(n-1)/2^n) = 0.5
	 * @param n
	 * @return
	 */
	public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
        
    }
}
