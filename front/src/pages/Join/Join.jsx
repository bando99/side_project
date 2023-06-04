import React from "react";
import styled from 'styled-components';

const Join = () => {
    return (
        <>
            <Header>
                <Div>닉네임</Div>
                <Id placeholder="jaeho" />
                <Div>이메일</Div>
                <Mail placeholder="exam@naver.com" />
                <Div>비밀번호</Div>
                <Secret placeholder="password" />
                <Div>비밀번호 확인</Div>
                <SecretCheck placeholder="password" />
                <Button>가입하기</Button>
            </Header>
        </>
    );
};


export default Join;


const Header = styled.div`
    width: 50%;
    height: 50rem;
    border: 2px solid black;
    border-radius: 2rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    margin-top: 5rem;
    margin-bottom: 5rem;
`

const Div = styled.div`
    font-size: 1.5rem;
`

const Id = styled.input`
    width: 70%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    font-size: 1.5rem;
    margin-bottom: 5rem;
`

const Mail = styled.input`
    width: 70%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    font-size: 1.5rem;
    margin-bottom: 5rem;
`

const Secret = styled.input`
    width: 70%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    font-size: 1.5rem;
    margin-bottom: 5rem;
`

const SecretCheck = styled.input`
    width: 70%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    font-size: 1.5rem;
`

const Button = styled.button`
    width: 30%;
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    display: flex;
    font-size: 1.5rem;
    margin-top: 5rem;
    justify-content: center;
    align-items: center;
    background-color: #1F7CEB;
    cursor: pointer;
`