package org.spring.teamproject.controller;

import lombok.RequiredArgsConstructor;
import org.spring.teamproject.dto.ItemDto;
import org.spring.teamproject.dto.MemberDto;
import org.spring.teamproject.entity.ItemEntity;
import org.spring.teamproject.repository.ItemRepository;
import org.spring.teamproject.service.ItemService;
import org.spring.teamproject.service.MemberService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;
    private final ItemService itemService;


    @GetMapping({"/", "", "/index"})                    //기본페이지설정
    public String index(Model model) {

        List<ItemDto> itemDtoList=itemService.itemList();

        model.addAttribute("itemDtoList",itemDtoList);

        return "/pages/main";
    }

    @GetMapping("/join")                                //회원가입페이지 이동
    public String join(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "/pages/member/join";
    }
    @PostMapping("/join")                               //form 받아 회원가입실행
    public String joinPost(@Valid MemberDto memberDto,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "/pages/member/join";
        }
//        Admin 입력하기
        if(memberDto.getEmail().equals("admin@gmail.com")){
            memberService.insertAdmin(memberDto);
            return "redirect:/login";
        }

        memberService.insertMember(memberDto);
        System.out.println("회원가입 성공");
        System.out.println("join :" + memberDto);
        return "redirect:/login";
    }
    @PostMapping("/emailChecked")                        //회원가입 email 중복체크버튼
    public @ResponseBody int nameChecked(
            @RequestParam String email) {
        int rs = memberService.findByUserNameDo(email);
        return rs;
    }
    @GetMapping("/login")                               //로그인
    public String login(@RequestParam(value = "error" ,required = false ) String error,
                        @RequestParam(value = "exception" ,required = false)String exception,
                        Model model) {
    model.addAttribute("error",error);
    model.addAttribute("exception",exception);

        return "/pages/member/login";
    }



}
