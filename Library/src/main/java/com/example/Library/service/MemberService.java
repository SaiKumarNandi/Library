package com.example.Library.service;



import com.example.Library.model.Member;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.springframework.http.RequestEntity.put;

@Service
public class MemberService {

    private Map<Long, Member> memberMap = new HashMap<>();

    public Member createMember(Member member){

        // call the database
        Long memberId = new Random().nextLong();
        member.setMemberId(Math.abs(memberId));
        memberMap.put(memberId, member);
        return  member;
    }


    public Member modifyMember(Long memberId, Member newmember){
        System.out.println(memberMap);
        if(memberMap.containsKey(memberId))
        {
            Member member = memberMap.get(memberId);
            if(!member.getFirstName().isEmpty()){
                member.setFirstName(newmember.getFirstName());
            }
            if(!member.getLastName().isEmpty()){
                member.setLastName(newmember.getLastName());
            }
            if(!member.getEmailAddress().isEmpty()){
                member.setEmailAddress(newmember.getEmailAddress());
            }
            if(!member.getPhoneNumber().isEmpty()){
                member.setPhoneNumber(newmember.getPhoneNumber());
            }
            memberMap.put(memberId, newmember);
            System.out.println("updated successfully");
            return member;
        }

        return null;

    }



    public String deleteMember(Long MemberId){
        if(memberMap.containsKey(MemberId)){
            memberMap.remove(MemberId);
            return "Member Deleted Successfully";
        }
        else{
            return "Member Not found";
        }

    }




    public Member getMemberdata(Long memberId){
        return memberMap.get(memberId);
    }


    public Collection getAllMemberData(){
        return memberMap.values();
    }



}
