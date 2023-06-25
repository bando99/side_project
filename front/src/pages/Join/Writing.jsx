import React from "react";
import styled from 'styled-components';

const Wiriting = () => {
    return (
        <>
            <Wrapper>
                <Group>모집구분</Group>
                <GroupInput type="text" />
            </Wrapper>

            <Wrapper>
                <Topic >글 제목</Topic>
                <TopicField type="text" placeholder="내용을 입력해 주세요." />
            </Wrapper>

            <Wrapper>
                <Date>날짜 설정</Date>
                <DateInput type="text" placeholder="시작 날짜" />
                <DateInput type="text" placeholder="마감 날짜" />
            </Wrapper>

            <Wrapper>
                <Stack>사용 기술</Stack>
                <StackInput type="text" placeholder="내용을 입력해 주세요." />
            </Wrapper>

            <Wrapper>
                <How>진행 방식</How>
                <HowInput type="text" placeholder="내용을 입력해 주세요." />
            </Wrapper>

            <Wrapper>
                <People>인원 모집</People>
                <PeopleInput type="text" placeholder="PM" />
                <PeopleInput type="text" placeholder="내용을 입력해 주세요." />
            </Wrapper>

            <Wrapper>
                <Content>글 내용</Content>
                <ContentInput type="text" placeholder="내용을 입력해 주세요." />
            </Wrapper>

            <ButtonWrapper>
                <BackButton>수정하기</BackButton>
                <NextButton>작성완료</NextButton>
            </ButtonWrapper>
        </>
    );
};

export default Wiriting;

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    margin-top: 3rem;
    margin-left: 5rem;
`

const Group = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const GroupInput = styled.input`
    width: 30%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const Topic = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const TopicField = styled.input`
    height: 3rem;
    width: 60%;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const Date = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const DateInput = styled.input`
    width: 30%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const Stack = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const StackInput = styled.input`
    width: 30%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const How = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const HowInput = styled.input`
    height: 3rem;
    width: 60%;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const People = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const PeopleInput = styled.input`
    width: 30%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const Content = styled.div`
    width: 20%;
    height: 4rem;
    font-size: 2rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

const ContentInput = styled.textarea`
    width: 60%;
    height: 20rem;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 3rem;
`

const ButtonWrapper = styled.div`
    display: flex;
    justify-content: center;
    margin-top: 5rem;
`

const BackButton = styled.button`
    width: 10%;
    height: 3rem;
    color: #1F7CEB;
    background-color: white;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    cursor: pointer;
`

const NextButton = styled.button`
    width: 10%;
    height: 3rem;
    color: white;
    background-color: #1F7CEB;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
    margin-left: 2rem;
    cursor: pointer;
`

