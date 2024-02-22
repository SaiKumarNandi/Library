package com.example.Library.controller;

import com.example.Library.model.Member;
import com.example.Library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;



    // create a member
    @PostMapping
    public Member createMember(@RequestBody  Member member){
        return memberService.createMember(member);
    }

    @PutMapping("/update")
    public Member modifyMember(@RequestParam Long memberId,@RequestBody Member member){
        return memberService.modifyMember(memberId,member);
    }

    @DeleteMapping("/delete")
    public String deleteMember(@RequestParam Long memberId){
        return memberService.deleteMember(memberId);
    }

    @GetMapping("/get")
    public Member getMemberData(@RequestParam Long memberId){
        return memberService.getMemberdata(memberId);
    }


    @GetMapping("/getAll")
    public Collection getAllMemberData(){
        return memberService.getAllMemberData();
    }
}