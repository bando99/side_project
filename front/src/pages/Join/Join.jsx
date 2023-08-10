import React from 'react';
import styles from './Join.module.css';

export default function Join() {
  const handleSubmit = (e) => {};

  return (
    <section className={styles.container}>
      <p className={styles.title}>회원가입</p>
      <form className={styles.container__box} action="" onSubmit={handleSubmit}>
        <div>
          <p className={styles.title__sub}>이메일 주소</p>
          <div className={styles.input__box}>
            <input
              type="text"
              placeholder="내용을 입력해 주세요."
              name=""
              id=""
            />
            <button className={styles.check__btn}>인증하기</button>
          </div>
        </div>
        <div>
          <p className={styles.title__sub}>아이디 설정</p>
          <div className={styles.input__box}>
            <input
              type="text"
              name=""
              id=""
              placeholder="내용을 입력해 주세요."
            />
            <button className={styles.check__btn}>중복확인</button>
          </div>
        </div>
        <div>
          <p className={styles.title__sub}>비밀번호 설정</p>
          <input
            type="text"
            name=""
            id=""
            placeholder="내용을 입력해 주세요."
          />
        </div>
        <div>
          <p className={styles.title__sub}>비밀번호 확인</p>
          <input
            type="text"
            name=""
            id=""
            placeholder="내용을 입력해 주세요."
          />
        </div>
        <div className={styles.btn__container}>
          <button className={styles.btn__join}>가입하기</button>
        </div>
      </form>
    </section>
  );
}
