import React from "react";
import styled from 'styled-components';

const Profile = () => {
    return (
        <>
            <Header>
                <Pro>프로필등록</Pro>

                <Bind>
                    <FieldWrapper>
                        <InputLabel>이름</InputLabel>
                        <InputField type="text" />
                    </FieldWrapper>

                    <FieldWrapper>
                        <InputLabel>전화번호</InputLabel>
                        <InputField type="text" />
                    </FieldWrapper>
                </Bind>

                <Bind>
                    <FieldWrapper>
                        <InputLabel>학교</InputLabel>
                        <InputField type="text" />
                    </FieldWrapper>

                    <FieldWrapper>
                        <InputLabel>전공</InputLabel>
                        <InputField type="text" />
                    </FieldWrapper>
                </Bind>

                <Bind>
                    <FieldWrapper>
                        <InputLabel>이메일 주소</InputLabel>
                        <InputField type="email" />
                    </FieldWrapper>

                    <FieldWrapper>
                        <InputLabel>졸업여부</InputLabel>
                        <InputField type="text" />
                    </FieldWrapper>
                </Bind>
            </Header>

            <Button>
                <BackButton>이전으로</BackButton>
                <NextButton>다음</NextButton>
            </Button>
        </>
    );
}

export default Profile;

const Header = styled.div`
    width: 50%;
    height: 50rem;
    border: 2px solid black;
    border-radius: 2rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: 0 auto;
    margin-top: 5rem;
    margin-bottom: 5rem;
    background-color: #DAE9FC;
    font-size: 2rem;
`

const Bind = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    flex-wrap: wrap; /* 요소들이 한 줄에 다 들어가지 않을 경우 여러 줄에 걸쳐 표시 */
`

const FieldWrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-left: 2rem;
    margin-right: 2rem;
    flex-grow: 1; /* 공간을 균등하게 차지 */
`


const Pro = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 3rem;
`

const InputLabel = styled.div`
    margin-top: 5rem;
    align-self: flex-start;
`

const InputField = styled.input`
    height: 3rem;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
`

const Button = styled.div`
    display: flex;
    justify-content: center;
    margin-bottom: 3rem;
`

const BackButton = styled.button`
    width: 10%;
    height: 3rem;
    color: #1F7CEB;
    background-color: white;
    border: 2px solid black;
    border-radius: 1rem;
    font-size: 2rem;
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
`
