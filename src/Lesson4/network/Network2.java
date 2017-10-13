package Lesson4.network;

import java.util.ArrayList;

public class Network2 {
    static public class Member{
        private Network2 outer;
        private String name;
        private ArrayList<Member> friends = new ArrayList<>();

        public Member(Network2 outer, String name){
            this.outer = outer;
            this.name = name;
        }
        public boolean belongsTo(Network2 n){
            return outer == n;
        }
        public void leave(){
            outer.unenroll(this);
        }
    }
    //network2----------------------------------
    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name){
        Member newMember = new Member(this, name);
        members.add(newMember);
        return newMember;
    }
    public void unenroll(Member member){
        members.remove(member);
    }

}
