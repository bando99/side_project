import React, { useState } from 'react';
import styles from './Join.module.css';
import axios from 'axios';

export default function Join() {
  const [mail, setMail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleMailChange = (e) => {
    setMail(e.target.value);
  };

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('회원가입 정보:', {
      user_id: '테스트',
      username,
      password,
      mail,
    });
    const userData = { user_id: '테스트', username, password, mail };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/users',
        userData
      );
      console.log('회원가입 성공');
    } catch (error) {
      console.error('회원가입 실패', error);
    }
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>회원가입</p>
      <form className={styles.container__box} onSubmit={handleSubmit}>
        <div>
          <p className={styles.title__sub}>이메일 주소</p>
          <div className={styles.input__box}>
            <input
              type="mail"
              placeholder="내용을 입력해 주세요."
              name=""
              id="mail"
              onChange={handleMailChange}
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
