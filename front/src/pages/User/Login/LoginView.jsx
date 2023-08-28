import React from 'react';
import styles from './LoginView.module.css';
import { useNavigate } from 'react-router-dom';

export default function LoginView() {
  const navigate = useNavigate();

  const handleIdFound = () => {
    navigate('/user/idFound');
  };

  const handlePwFound = () => {
    navigate('/user/pwFound');
  };

  const handlePwChange = () => {
    navigate('/user/pwChange');
  };

  // { path: '/user/idFound/:id', element: <IDfound /> },
  //     { path: '/user/idChange/:id', element: <IDChange /> },
  //     { path: '/user/pwFound/:id', element: <PWfound /> },
  //     { path: '/user/pwChange/:id', element: <PWChange /> },

  return (
    <section className={styles.container}>
      <p className={styles.title}>로그인</p>
      <form className={styles.container__box}>
        <div className={styles.input__container}>
          <p>아이디</p>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <p>비밀번호</p>
          <input type="text" placeholder="내용을 입력해 주세요." />
        </div>
        <div className={styles.button__container}>
          <p className={styles.loginBtn}>로그인</p>
          <div className={styles.modify__container}>
            <p className={styles.menu__text} onClick={handleIdFound}>
              아이디 찾기
            </p>
            <p className={styles.menu__text} onClick={handlePwFound}>
              비밀번호 찾기
            </p>
            <p className={styles.menu__text} onClick={handlePwChange}>
              비밀번호 변경
            </p>
          </div>
        </div>
      </form>
      <p className={styles.loginSNS}>SNS로 로그인 하기</p>
      <div className={styles.sns__container}>
        <div className={styles.snsIcon__container}>
          <div className={styles.kakao}></div>
          <span className={styles.SNStext}>Kakao로 로그인 하기</span>
        </div>
        <div className={styles.snsIcon__container}>
          <div className={styles.naver}></div>
          <span className={styles.SNStext}>Naver로 로그인 하기</span>
        </div>
        <div className={styles.snsIcon__container}>
          <div className={styles.github}></div>
          <span className={styles.SNStext}>Github로 로그인 하기</span>
        </div>
      </div>
      <div className={styles.join__container}>
        <p className={styles.join__qa}>아직 회원이 아니세요?</p>
        <p className={styles.join__text} onClick={() => navigate('/join')}>
          회원가입하기
        </p>
      </div>
    </section>
  );
}
