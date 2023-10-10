import React, { useState } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

// TODO 기존 비밀번호와 아이디 확인되면 변경 기능 활성화
export default function PWChangeView() {
  const navigate = useNavigate();

  const [id, setId] = useState('');
  const [isId, setIsId] = useState(false);
  const [isNotId, setIsNotId] = useState(false);

  const [newPw, setNewPw] = useState('');
  const [checkPw, setCheckPw] = useState('');

  const handleChangePw = () => {
    const userInfo = {
      username: id,
      newPw,
      checkPw,
    };

    try {
      const response = axios.post(
        'http://1.246.104.170:8080/change/password',
        userInfo
      );

      // 아이디와 기존 비밀번호 검사 로직 후 결과처리
      alert('비밀번호가 변경되었습니다.');
      navigate('/user/login');
    } catch (error) {
      console.error('비밀번호 변경 실패', error);
    }
  };

  const handleChangeId = (e) => {
    setId(e.target.value);
  };

  const handleChangeNewPw = (e) => {
    setNewPw(e.target.value);
  };

  const handleChangeCheckPw = (e) => {
    setCheckPw(e.target.value);
  };

  const checkId = async () => {
    const userInfo = {
      username: id,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/change/checkId',
        userInfo
      );
      console.log(response);

      if (response.data.message === '유저 존재') {
        setIsId(true);

        setTimeout(() => {
          setIsId(false);
        }, 3000);
      }
    } catch (error) {
      console.log('아이디 체크 실패', error);
      if (
        error.response.data.message ===
        'Find Exception. find - checkId에서 username이 존재하지 않음 확인'
      ) {
        console.log('들어옴');
        setIsNotId(true);

        setTimeout(() => {
          setIsNotId(false);
        }, 3000);
      }
    }
  };

  return (
    <Container>
      <Title>비밀번호 변경</Title>
      <ContainerBox>
        <SubTitle>아이디</SubTitle>
        <InputBox>
          <StyledInput
            value={id}
            onChange={handleChangeId}
            type="text"
            placeholder="내용을 입력해 주세요."
          />
          <CheckBtn onClick={checkId}>확인</CheckBtn>
        </InputBox>
        {isId && <IsId>아이디를 확인했습니다</IsId>}
        {isNotId && <IsNotId>아이디가 존재하지 않습니다.</IsNotId>}
        <SubTitle>기존 비밀번호</SubTitle>
        <InputBox>
          <StyledInput type="text" placeholder="내용을 입력해 주세요." />
          <CheckBtn>확인</CheckBtn>
        </InputBox>
        <SubTitle>새 비밀번호</SubTitle>
        <InputBox>
          <StyledInput
            value={newPw}
            onChange={handleChangeNewPw}
            type="password"
            placeholder="내용을 입력해 주세요."
          />
          <CheckBtn>인증 요청</CheckBtn>
        </InputBox>
        <SubTitle>비밀번호 확인</SubTitle>
        <InputBox>
          <StyledInput
            type="password"
            placeholder="내용을 입력해 주세요."
            value={checkPw}
            onChange={handleChangeCheckPw}
          />
          <CheckBtn>인증 확인</CheckBtn>
        </InputBox>
        <ChangeBtn onClick={handleChangePw}>변경하기</ChangeBtn>
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
`;

const SubTitle = styled.p`
  font-weight: 800;
  margin: 0.5rem 0;
`;

const ContainerBox = styled.div`
  border: 2px solid #d2e2ec;
  border-radius: 20px;
  padding: 3rem 8rem;
`;

const InputBox = styled.div`
  display: flex;
  justify-content: center;
  margin-bottom: 1.2rem;
`;

const StyledInput = styled.input`
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

const IsId = styled.p`
  color: #1f7ceb;
  font-weight: 600;
  text-align: center;
  margin-bottom: 1.2rem;
`;

const IsNotId = styled.p`
  color: red;
  font-weight: 600;
  text-align: center;
  margin-bottom: 1.2rem;
`;

const ChangeBtn = styled.div`
  background-color: #1f7ceb;
  color: white;
  border-radius: 25px;
  width: 50%;
  margin: auto;
  text-align: center;
  padding: 0.3rem;

  &:hover {
    cursor: pointer;
  }
`;
