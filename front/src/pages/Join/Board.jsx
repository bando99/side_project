import React from "react";
import styled from 'styled-components'

const Board = () => {
    return (
        <>
            <Totle>
                해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)
            </Totle>
            <OneLine>
                <Date>게시날짜 2023.01.01</Date>
                <See>조회</See>
                <Date>시작날짜 2023.02.01</Date>
                <During>예상기간 6개월</During>
            </OneLine>

            <Line />

            <Recruit>
                <All>
                    <Type>
                        <Type1>모집구분</Type1>
                        <Type2>프로젝트</Type2>
                    </Type>
                    <Stack>
                        <Stack1>사용기술</Stack1>
                        <Stack2>
                            <img src='/stack/JS.png' alt='dd'></img>
                            <img src='/stack/React.png' alt='dd'></img>
                            <img src='/stack/Spring.png' alt='dd'></img>
                        </Stack2>
                    </Stack>
                    <How>
                        <How1>진행방식</How1>
                        <How2>온라인 주 1회</How2>
                    </How>
                    <Long>
                        <Long1>프로젝트 기간</Long1>
                        <Long2>23.04.30 ~ 6개월</Long2>
                    </Long>
                </All>
                <Member>
                    <Now>프로젝트 / 스터디 현재 인원</Now>
                    <Bind>
                        <Job>PM</Job>
                        <People>1 / 1 모집완료</People>
                    </Bind>

                    <Bind>
                        <Job>디자이너</Job>
                        <People>0 / 2 신청하기</People>
                    </Bind>

                    <Bind>
                        <Job>프론트엔드</Job>
                        <People>1 / 4 신청하기</People>
                    </Bind>

                    <Bind>
                        <Job>백엔드</Job>
                        <People>1 / 2 신청하기</People>
                    </Bind>
                </Member>
            </Recruit>

            <Middle>
                <Person>현재 인원</Person>
                <Number>3/9</Number>
            </Middle>

            <Profiles>
                <Profile>
                    <Img src="/logo/Profile.png" alt="dd"></Img>
                    <Nick>닉네임</Nick>
                    <Part>역할</Part>
                    <Skill>기술 스택</Skill>
                    <Career>경력</Career>
                    <Search>프로필 자세히</Search>
                </Profile>

                <Profile>
                    <Img src="/logo/Profile.png" alt="dd"></Img>
                    <Nick>닉네임</Nick>
                    <Part>역할</Part>
                    <Skill>기술 스택</Skill>
                    <Career>경력</Career>
                    <Search>프로필 자세히</Search>
                </Profile>

                <Profile>
                    <Img src="/logo/Profile.png" alt="dd"></Img>
                    <Nick>닉네임</Nick>
                    <Part>역할</Part>
                    <Skill>기술 스택</Skill>
                    <Career>경력</Career>
                    <Search>프로필 자세히</Search>
                </Profile>

                <Profile>
                    <Img src="/logo/Profile.png" alt="dd"></Img>
                    <Nick>닉네임</Nick>
                    <Part>역할</Part>
                    <Skill>기술 스택</Skill>
                    <Career>경력</Career>
                    <Search>프로필 자세히</Search>
                </Profile>
            </Profiles>

            <Last>프로젝트 소개</Last>
            <LastLine />
            <Comment />

            <Button>등록하기</Button>

        </>
    );
};

export default Board;

const Totle = styled.div`
    width: 90%;
    height: 3rem;
    font-size: 2rem;
    margin: 0 auto;
    margin-top: 3rem;
    padding-left: 12rem;
`

const OneLine = styled.div`
    width: 90%;
    height: 3rem;
    font-size: 2rem;
    display: flex;
    margin: 0 auto;
    margin-top: 5rem;
    justify-content: space-around;
`

const Date = styled.div`
    height: 3rem;
    font-size: 2rem;
`

const See = styled.div`
    height: 3rem;
    font-size: 2rem;
`

const During = styled.div`
    height: 3rem;
    font-size: 2rem;
`

const Line = styled.div`
    width: 90%;
    border: 2px solid grey;
    margin: 0 auto;
    margin-top: 3rem;
`

const Recruit = styled.div`
    width: 90%;
    height: 30rem;
    border: 2px solid black;
    background-color: #DAE9FC;
    margin: 0 auto;
    margin-top: 5rem;
    display: flex;
    justify-content: column;
`

const All = styled.div`
    width: 50%;
    height: 30rem;
    border: 2px solid black;
`

const Type = styled.div`
    display: flex;
    justify-content: column;
`

const Type1 = styled.div`
    width: 20%;
    height: 3rem;
    font-size: 2rem;
    margin-top: 3rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const Type2 = styled.div`
    width: 20%;
    height: 3rem;
    font-size: 2rem;
    margin-top: 3rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const Stack = styled.div`
    display: flex;
    justify-content: column;
`

const Stack1 = styled.div`
    width: 20%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const Stack2 = styled.div`
    width: 10%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const How = styled.div`
    display: flex;
    justify-content: column;
`
const How1 = styled.div`
    width: 20%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const How2 = styled.div`
    width: 40%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const Long = styled.div`
    display: flex;
    justify-content: column;
`

const Long1 = styled.div`
    width: 30%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const Long2 = styled.div`
    width: 40%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const Member = styled.div`
    width: 50%;
    height: 30rem;
    border: 2px solid black;
`

const Now = styled.div`
    width: 90%;
    height: 3rem;
    font-size: 1.5rem;
    margin-top: 3rem;
    margin-bottom: 1rem;
    margin-left: 3rem;

`

const Bind = styled.div`
    display: flex;
    justify-content: column;
`

const Job = styled.div`
    width: 40%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 3rem;
`

const People = styled.div`
    width: 40%;
    height: 3rem;
    font-size: 2rem;
    margin-bottom: 3rem;
    margin-left: 7rem;
    cursor: pointer;
`

const Middle = styled.div`
    display: flex;
    justify-content: row;
`

const Person = styled.div`
    width: 10%;
    height: 3rem;
    font-size: 2rem;
    margin-top: 5rem;
    padding-left: 7rem;
    color: #1F7CEB;
`

const Number = styled.div`
    width: 30%;
    height: 3rem;
    font-size: 2rem;
    margin-top: 5rem;
    color: black;
`

const Profiles = styled.div`
    margin-top: 5rem;
    display: flex;
    justify-content: row;
    justify-content: space-around;
`

const Profile = styled.div`
    width: 15%;
    height: 30rem;
    border: 3px solid #DAE9FC;
    border-radius: 2rem;
    text-align: center;
`

const Img = styled.img`
    margin-top: 2rem;
`

const Nick = styled.div`
    width: 100%;
    height: 3rem;
    display: flex;
    justify-content: center;
    margin-top: 3rem;
`

const Part = styled.div`
    width: 100%;
    height: 3rem;
`

const Skill = styled.div`
    width: 100%;
    height: 3rem;
`

const Career = styled.div`
    width: 100%;
    height: 3rem;
`

const Search = styled.div`
    width: 100%;
    height: 3rem;
`

const Last = styled.div`
    width: 30%;
    height: 3rem;
    font-size: 2rem;
    margin-top: 3rem;
    padding-left: 7rem;
`

const LastLine = styled.div`
    width: 90%;
    border: 1px solid black;
    //#D9D9D9
    margin: 0 auto;
    margin-top: 3rem;
`

const Comment = styled.div`
    width: 90%;
    height: 10rem;
    border: 2px solid black;
    margin: 0 auto;
    margin-top: 10rem;
`

const Button = styled.button`
    width: 10%;
    height: 3rem;
    font-size: 2rem;
    background-color: #1F7CEB;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    margin: 0 auto;
    margin-top: 5rem;
    justify-content: center;
`