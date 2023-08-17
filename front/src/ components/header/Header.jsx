import React, { Fragment } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const Header = (props) => {
  const navigate = useNavigate();

  const handleNavigation = (path) => {
    navigate(path);
  };

  return (
    <>
      <HeaderContainer>
        <Logo onClick={() => handleNavigation("/")} src="/logo/logoHead.png" alt="로고" />
        <Title onClick={() => handleNavigation("/study")}>스터디</Title>
        <Title onClick={() => handleNavigation("/project")}>프로젝트</Title>
        <SearchInput type="text" placeholder="검색하기" />
        <LogButtons>
          <button onClick={() => handleNavigation("/AddPost")}>글 작성하기</button>
          <Button onClick={() => handleNavigation("/join")}>회원가입</Button>
          <Button onClick={() => handleNavigation("/user/login")}>로그인</Button>
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
