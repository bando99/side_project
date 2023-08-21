import React from 'react';
import styles from './PWChange.module.css';
import { useNavigate } from 'react-router-dom';

export default function PWChangeView() {
  const navigate = useNavigate();

  const handleChange = () => {
    navigate('/user/login');
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>비밀번호 변경</p>
      <div className={styles.container__box}>
        <p className={styles.subTitle}>아이디</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button className={styles.check__btn}>확인</button>
        </div>
        <p className={styles.subTitle}>새 비밀번호</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button className={styles.check__btn}>인증 요청</button>
        </div>
        <p className={styles.subTitle}>비밀번호 확인</p>
        <div className={styles.input__box}>
          <input
            className={styles.input__code}
            type="text"
            placeholder="내용을 입력해 주세요."
          />
          <button className={styles.check__btn}>인증 확인</button>
        </div>
        <p className={styles.subTitle}>자동입력 방지문자</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
        </div>
        <div onClick={handleChange} className={styles.changeBtn}>
          변경하기
        </div>
      </div>
    </section>
  );
}
