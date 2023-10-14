import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import styled from 'styled-components';

export default function IDfoundView() {
  const navigate = useNavigate();

  const [mail, setMail] = useState('');
  const [isNotMail, setIsNotMail] = useState(false);

  const handlePW = () => {
    navigate('/user/pwFound');
  };

  const handleLogin = () => {
    navigate('/user/login');
  };

  const handleChangeMail = (e) => {
    setMail(e.target.value);
  };

  const findId = async () => {
    const mailInfo = {
      mail,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/find/findId',
        mailInfo
      );
      console.log(response.message);
      setIsNotMail(false);
    } catch (error) {
      console.error('아이디 찾기 실패', error);
      console.log(error.response.data.message);
      if (
        error.response.data.message ===
        `Sign Exception. ${mail}은 없는 mail정보입니다.`
      ) {
        console.log('들어옴');
        setIsNotMail(true);
        console.log(isNotMail);

        setTimeout(() => {
          setIsNotMail(false);
        }, 3000);
      }
    }
  };

  return (
    <Container>
      <Title>아이디 찾기</Title>
      <ContainerBox>
        <Email>이메일 주소</Email>
        <InputBox>
          <Input
            type="text"
            value={mail}
            onChange={handleChangeMail}
            placeholder="내용을 입력해 주세요."
          />
          <CheckBtn onClick={findId}>인증 요청</CheckBtn>
        </InputBox>
        {isNotMail && <IsNotMail>위 메일은 없는 메일정보입니다. </IsNotMail>}
        <BtnContainer>
          <BtnLogin onClick={handleLogin}>로그인</BtnLogin>
          <BtnPW onClick={handlePW}>비밀번호 찾기</BtnPW>
        </BtnContainer>
      </ContainerBox>
    </Container>
  );
}

const Container = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const Title = styled.p`
  margin-top: 5rem;
  font-weight: 900;
  margin-bottom: 0.7rem;
`;

const Email = styled.p`
  font-weight: 800;
  margin: 0.5rem;
`;

const ContainerBox = styled.div`
  border: 2px solid #d2e2ec;
  border-radius: 20px;
  padding: 3rem 8rem;
`;

const InputBox = styled.div`
  display: flex;
  justify-content: center;
  margin-bottom: 1rem;
`;

const Input = styled.input`
  width: 100%;
  padding: 0.5rem 1rem;
  margin-right: 1.5rem;
  border: 1px solid #d2e2ec;
`;

const CheckBtn = styled.button`
  color: #1f7ceb;
  border: solid 1px #d2e2ec;
  background-color: white;
  width: 45%;

  &:hover {
    cursor: pointer;
  }
`;

const IsNotMail = styled.p`
  color: red;
  font-weight: 600;
  text-align: center;
  margin-bottom: 1.2rem;
`;

const BtnContainer = styled.div`
  margin-top: 3rem;
  display: flex;
  justify-content: center;
`;

const BtnLogin = styled.button`
  width: 45%;
  background-color: #dae9fc;
  margin-right: 0.5rem;
  border-radius: 25px;
  border: none;
  padding: 0.3rem 0.6rem;

  &:hover {
    cursor: pointer;
  }
`;

const BtnPW = styled.button`
  width: 45%;
  background-color: #1f7ceb;
  color: white;
  margin-left: 0.5rem;
  border-radius: 25px;
  padding: 0.3rem 0.6rem;
  border: none;

  &:hover {
    cursor: pointer;
  }
`;
