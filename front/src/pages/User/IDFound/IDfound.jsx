import React from 'react';
import styles from './IDfound.module.css';
import { useNavigate } from 'react-router-dom';

export default function IDfound() {
  const navigate = useNavigate();

  const handlePW = () => {
    navigate('/user/pwFound');
  };

  const handleLogin = () => {
    navigate('/user/login');
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>아이디 찾기</p>
      <div className={styles.container__box}>
        <p className={styles.email}>이메일 주소</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button className={styles.check__btn}>인증 요청</button>
        </div>
        <div className={styles.input__box}>
          <input
            className={styles.input__code}
            type="text"
            placeholder="내용을 입력해 주세요."
          />
          <button className={styles.check__btn}>인증 확인</button>
        </div>
        <div className={styles.ID__box}>
          <p className={styles.ID__commnet}>회원님의 아이디는</p>
          <p className={styles.ID__content}>abc1234</p>
          <p className={styles.ID__commnet}>입니다</p>
        </div>
        <div className={styles.btn__container}>
          <button onClick={handleLogin} className={styles.btn__login}>
            로그인
          </button>
          <button onClick={handlePW} className={styles.btn__pw}>
            비밀번호 찾기
          </button>
        </div>
      </div>
    </section>
  );
}
