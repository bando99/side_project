import React, { Fragment, useState, useEffect } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const Header = (props) => {
  const navigate = useNavigate();

  const handleHome = () => {
    navigate('/');
  };

  const handleStudy = () => {
    navigate('/study');
  };

  const handleProject = () => {
    navigate('/project');
  };

  const handleJoin = () => {
    navigate('/join');
  };

  const handleLogin = () => {
    navigate('/user/login');
  };

  return (
    <>
      <HeaderContainer>
        <Logo onClick={handleHome} src="/logo/logoHead.png" alt="로고" />
        <Title onClick={handleStudy}>스터디</Title>
        <Title onClick={handleProject}>프로젝트</Title>
        <SearchInput type="text" placeholder="검색하기" />
        <LogButtons>
          <Button onClick={handleJoin}>회원가입</Button>
          <Button onClick={handleLogin}>로그인</Button>
        </LogButtons>
      </HeaderContainer>
    </>
  );
};

const HeaderContainer = styled.header`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 10vh;
  color: black;
  display: flex;
  background-color: skyblue;
  justify-content: space-around;
  align-items: center;
`;

const Logo = styled.img`
  cursor: pointer;
`;

const Title = styled.h1`
  cursor: pointer;
`;

const SearchInput = styled.input`
  width: 30%;
  height: 40%;
  border-radius: 1rem;
  font-size: 1rem;
`;

const LogButtons = styled.div``;

const Button = styled.button`
  margin-left: 1rem;
  font-size: 1.2rem;
  background-color: yellowgreen;
  border: 2px solid black;
  cursor: pointer;
`;

export default Header;
