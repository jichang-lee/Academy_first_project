# Shopping-Project 
스프링부트 + 쇼핑몰 프로젝트

## 🖥️ 개요
- SpringFramework를 이용한 쇼핑몰 웹 프로젝트

<br>

## 🕰️ 프로젝트 기간
   2023. 02-13 ~ 2023. 03-13

<br>

## 🧑‍🤝‍🧑 참여 인원
- 팀장 : 이지창 - DB설계,장바구니 서비스(CRD) ,마이페이지 , AWS EC2 배포
- 팀원1 : 강창신 - 페이지 Header&Footer layout , main&Admin 페이지 , 게시판 댓글 기능
- 팀원2 : 김득주 - 회원서비스(CRUD) , Spring Security
- 팀원3 : 장효선 - 상품서비스(CRUD) , 전체적인 디자인 수정 , Chat-bot 
- 팀원4 : 허인경 - 게시판서비스(CRUD), PPT제작

<br>

## ⚙️ 개발환경
- OS : Windows10
- Language : Java , HTML , CSS
- IDE : IntelliJ , MySQL workbench , Visual studio
- Framework : Springboot(2.x)
- Database : Oracle DB

<br>

## 📰 DB구조

![image](https://user-images.githubusercontent.com/116870832/231031994-045dab5d-5dba-4dd1-94a9-3762488410a8.png)

* Item 테이블에 member_id는 상품을 추가할 때 Member 테이블에 Role = ADMIN 관리자가 상품 추가한 목록을 확인하기 위함
* cartItem은 cart 와 Item 사이에 매개역할 : 장바구니에 여러 아이템이 생길 수 있는데 여러개 상품정보에 대한 중복 처리 & 관리에 용이

<br>

##  🧷 프로젝트 소개
#### - <Mixtape Seoul> 모방하여 팀 프로젝트 제작
#### - 음악 제작을 위한 디지털 믹스테이프를 판매, 제공하는 아티스트 타겟 쇼핑몰
#### - 타 쇼핑몰과 달리 분류항목이 많지않아 차분한 느낌을 주고, 여러상품이 한눈에 들어오는 장점
#### - 아티스트들이 서로 소통할 수 있는 커뮤니티 게시판 추가

<br>


## 🔧 기능 소개
###  ❗ 프로젝트 
#### 1. 회원가입
#### 2. 상품 추가,조회,수정,삭제
#### 3. 장바구니 담기,조회,삭제  - [코드 보기](https://github.com/jichang-lee/Mixtape-shopping/wiki/%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88-%EA%B8%B0%EB%8A%A5)
#### 4. 게시판 추가,조회,수정,삭제
#### 5. 게시판에 대한 댓글기능

---

#### 간단한 Main View 영상

https://user-images.githubusercontent.com/116870832/231089788-804e8fd3-97a1-48cf-8d6e-59ffd03ff640.mp4








