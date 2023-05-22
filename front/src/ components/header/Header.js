import React, { Fragment } from 'react';
import classes from './Header.module.css';

const Header = (props) => {
  return (
    <Fragment>
      <header className={classes.header}>
        <h1>9iN</h1>
        <h1>스터디</h1>
        <h1>프로젝트</h1>
        <input type="text" placeholder="검색하기" />
        <div className={classes.log}>
          <button>회원가입</button>
          <button>로그인</button>
        </div>
      </header>
      <div className={classes.pic}>
        {/* <img src={exampleImage} alt="what" /> */}
      </div>
    </Fragment>
  );
};

export default Header;
