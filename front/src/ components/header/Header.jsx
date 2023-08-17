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
      <Headers>
        <Container>
          <Logo onClick={() => handleNavigation("/")} src="/logo/logoHead.png" alt="로고" />
          <Title>
            <div onClick={() => handleNavigation("/project")}>프로젝트</div>
            <div onClick={() => handleNavigation("/study")}>스터디</div>
          </Title>
          <LogButtons>
            <button onClick={() => handleNavigation("/AddPost")}>글 작성하기</button>
            <button onClick={() => handleNavigation("/profile")}>
              <img src="/profile/profile.png" alt="프로필 이미지" />
            </button>
            <button onClick={() => handleNavigation("/user/login")}>
              <img src="/icons/vector.png" alt="알람 이미지" />
            </button>
            <div className='logout'>
              로그아웃
            </div>
          </LogButtons>
        </Container>
      </Headers>
    </>
  );
};

const Headers = styled.header`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 80px;
  color: black;
`;

const Container = styled.div`
  width: 1200px;
  margin : auto;
  background-color: "red";
  display : flex;
  position: relative;
`

const Logo = styled.img`
  cursor: pointer;
  position: absolute;
  top: 15px;
  left: 0;
  border-radius: 8px;
  height: 50px;
`;

const Title = styled.h1`
  display: flex;
  gap: 2rem;
  position: absolute;
  left: 140px;
  div {
    font-size:  22px;
    cursor: pointer;
  }
`;


const LogButtons = styled.div`
  position: absolute;
  right : 0;
  height: 80px;
  align-items: center;
  display: flex;
  gap: 1rem;
  button:first-child {
    background : #1F7CEB;
    width: 151px;
    height: 38px;
    border-radius: 8px;
    padding: 10px 12px 10px 12px;
    border: none;
    font-size: 18px;
    line-height: 22px;
    color: white;
    cursor: pointer;
  }

  button:nth-child(2) {
    background: #D9D9D9;
    width: 34px;
    height: 34px;
    border-radius: 100%;
    cursor: pointer;
    border: none;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-left: 10px;
    img{
      width: 34px;
      height: 34px;
    }
  }

  button:nth-child(3) {
    background: #D9D9D9;
    width: 34px;
    height: 34px;
    border-radius: 100%;
    cursor: pointer;
    border: none;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-right: 10px;
    img{
      width: 20px;
      height: 20px;
    }
  }

  .logout {
    font-size: 18px;
    cursor: pointer;
  }
`;



export default Header;
