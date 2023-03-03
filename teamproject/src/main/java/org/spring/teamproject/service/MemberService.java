package org.spring.teamproject.service;

import lombok.RequiredArgsConstructor;
import org.spring.teamproject.dto.MemberDto;
import org.spring.teamproject.entity.MemberEntity;
import org.spring.teamproject.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional  // 추가, 삭제 ,수정
    public void insertMember(MemberDto memberDto) {
        MemberEntity memberEntity=
                MemberEntity.memberEntity(memberDto,passwordEncoder);
        memberRepository.save(memberEntity);
    }

    //회원조회
    public MemberDto memberDetail(String email) {
        Optional<MemberEntity> memberEntity=memberRepository.findByEmail(email);
//        Optional<Optional<MemberEntity>> memberEntity1=Optional.ofNullable(memberRepository.findByEmail(email));
//        Optional<MemberEntity> memberEntity2=Optional.ofNullable(email);
        if (!memberEntity.isPresent()){
            return null;
        }
        //Entity -> Dto
        MemberDto memberDto=MemberDto.updateMemberDto(memberEntity.get());
        return memberDto;
    }

    @Transactional  //회원수정
    public void updateOk(MemberDto memberDto) {

        MemberEntity memberEntity=MemberEntity.updateMemberEntity(memberDto,passwordEncoder);
        memberRepository.save(memberEntity);
    }

    @Transactional //삭제
    public int deleteOk(Long id) {
        MemberEntity memberEntity = memberRepository.findById(id).get();
        memberRepository.delete(memberEntity);
        if(memberRepository.findById(id)!=null){
            return 0;
        }
        return 1;
    }


}