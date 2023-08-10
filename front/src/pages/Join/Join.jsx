import React, { useState } from 'react';
import styles from './Join.module.css';

export default function Join() {
  const [email, setEmail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('회원가입 정보:', { email, username, password });
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>회원가입</p>
      <form className={styles.container__box} action="" onSubmit={handleSubmit}>
        <div>
          <p className={styles.title__sub}>이메일 주소</p>
          <div className={styles.input__box}>
            <input
              type="email"
              placeholder="내용을 입력해 주세요."
              name=""
              id="email"
              onChange={handleEmailChange}
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
              onChange={handleUsernameChange}
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
            onChange={handlePasswordChange}
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
