import React, { useState } from 'react';
import styles from './IDfoundView.module.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function IDfoundView() {
  const navigate = useNavigate();

  const [mail, setMail] = useState('');
  const [isNotMail, setIsNotMail] = useState(false);

  const handlePW = () => {
    navigate('/user/pwFound');
  };

  const handleLogin = () => {
    navigate('/user/login');
  };

  const handleChangeMail = (e) => {
    setMail(e.target.value);
  };

  const findId = async () => {
    const mailInfo = {
      mail,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/find/findId',
        mailInfo
      );
      console.log(response.message);
      setIsNotMail(false);
    } catch (error) {
      console.error('아이디 찾기 실패', error);
      console.log(error.response.data.message);
      if (
        error.response.data.message ===
        `Sign Exception. ${mail}은 없는 mail정보입니다.`
      ) {
        console.log('들어옴');
        setIsNotMail(true);
        console.log(isNotMail);

        setTimeout(() => {
          setIsNotMail(false);
        }, 3000);
      }
    }
  };

  return (
    <section className={styles.container}>
      <p className={styles.title}>아이디 찾기</p>
      <div className={styles.container__box}>
        <p className={styles.email}>이메일 주소</p>
        <div className={styles.input__box}>
          <input
            type="text"
            value={mail}
            onChange={handleChangeMail}
            placeholder="내용을 입력해 주세요."
          />
          <button className={styles.check__btn} onClick={findId}>
            인증 요청
          </button>
        </div>
        {isNotMail && (
          <p className={styles.isNotMail}>위 메일은 없는 메일정보입니다. </p>
        )}
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
