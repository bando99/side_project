import React, { Fragment, useState, useEffect } from 'react';
import classes from './Header.module.css';
import { useNavigate } from 'react-router-dom';

const Header = (props) => {
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate('/user/login');
  };

  return (
    <Fragment>
      <header className={classes.header}>
        <img src='/logo/logoHead.png' alt='로고' />
        <h1>스터디</h1>
        <h1>프로젝트</h1>
        <input type="text" placeholder="검색하기" />
        <div className={classes.log}>
          <button>회원가입</button>
          <button onClick={handleLogin}>로그인</button>
        </div>
      </header>

      <ImageCarousel />
    </Fragment>
  );
};

const ImageCarousel = () => {
  const [currentImageIndex, setCurrentImageIndex] = useState(0);
  const images = ["/logo/Logo1.png", "/logo/Logo2.png"];

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentImageIndex((prevIndex) => (prevIndex + 1) % images.length);
    }, 4000); // 2초마다 이미지 변경

    return () => {
      clearInterval(interval); // 컴포넌트 언마운트 시 인터벌 클리어
    };
  }, [images]);

  return (
    <div className={classes.pic}>
      <img src={images[currentImageIndex]} alt="carousel" />
    </div>
  );
};

export default Header;
