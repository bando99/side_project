import React from 'react';
import styles from './PWfound.module.css';
import { useNavigate } from 'react-router-dom';

export default function PWfound() {
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate('/user/login');
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>비밀번호 찾기</p>
      <div className={styles.container__box}>
        <p className={styles.subTitle}>아이디</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button className={styles.check__btn}>확인</button>
        </div>
        <p className={styles.subTitle}>이메일 주소</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button className={styles.check__btn}>인증 요청</button>
        </div>
        <div className={styles.input__check}>
          <input
            className={styles.input__code}
            type="text"
            placeholder="내용을 입력해 주세요."
          />
          <button className={styles.check__btn}>인증 확인</button>
        </div>
        <div className={styles.FoundBtn}>비밀번호 찾기</div>
        <div className={styles.PW__box}>
          <p className={styles.PW__commnet}>회원님의 비밀번호는</p>
          <p className={styles.PW__content}>123465678</p>
          <p className={styles.PW__commnet}>입니다</p>
        </div>
        <div onClick={handleLogin} className={styles.loginBtn}>
          로그인
        </div>
      </div>
    </section>
  );
}
