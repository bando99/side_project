import React, { useState } from 'react';
import styles from './LoginView.module.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function LoginView() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const navigate = useNavigate();

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleIdFound = () => {
    navigate('/user/idFound');
  };

  const handlePwFound = () => {
    navigate('/user/pwFound');
  };

  const handlePwChange = () => {
    navigate('/user/pwChange');
  };

  const hadnleLogin = async (e) => {
    e.preventDefault();
    console.log('로그인 정보:', {
      username,
      password,
    });
    const userData = { username, password };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/sign/sign-in',
        userData
      );
      console.log('로그인 성공');
      navigate('/');
    } catch (error) {
      console.error('로그인 실패', error);
    }
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>로그인</p>
      <div className={styles.container__box}>
        <form onSubmit={hadnleLogin}>
          <div className={styles.input__container}>
            <p>아이디</p>
            <input
              type="text"
              onChange={handleUsernameChange}
              placeholder="내용을 입력해 주세요."
            />
            <p>비밀번호</p>
            <input
              type="password"
              onChange={handlePasswordChange}
              placeholder="내용을 입력해 주세요."
            />
            <div className={styles.loginBtn__container}>
              <button className={styles.loginBtn}>로그인</button>
            </div>
          </div>
        </form>
        <div className={styles.button__container}>
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
      </div>

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
