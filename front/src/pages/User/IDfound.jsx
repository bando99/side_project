import React from 'react';
import styles from './IDfound.module.css';

export default function IDfound() {
  return (
    <section>
      <p className={styles.title}>아이디 찾기</p>
      <div className={styles.container__box}>
        <p className={styles.email}>이메일 주소</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button>인증 요청</button>
        </div>
        <div className={styles.input__box}>
          <input
            className={styles.input__code}
            type="text"
            placeholder="내용을 입력해 주세요."
          />
          <button>인증 확인</button>
        </div>
        <div className={styles.btn__container}>
          <button className={styles.btn__login}>로그인</button>
          <button className={styles.btn__pw}>비밀번호 찾기</button>
        </div>
      </div>
    </section>
  );
}
