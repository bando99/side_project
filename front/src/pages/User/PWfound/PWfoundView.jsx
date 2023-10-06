import React, { useState } from 'react';
import styles from './PWfound.module.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function PWfoundView() {
  const navigate = useNavigate();

  const [id, setId] = useState('');
  const [isId, setIsId] = useState(false);
  const [isNotId, setIsNotId] = useState(false);

  const [mail, setMail] = useState('');
  const [isMail, setIsMail] = useState(false);
  const [isNotMail, setIsNotMail] = useState(false);

  const handleLogin = () => {
    navigate('/user/login');
  };

  const handleChangeId = (e) => {
    setId(e.target.value);
  };

  const handleChangeMail = (e) => {
    setMail(e.target.value);
  };

  const checkId = async () => {
    const userInfo = {
      username: id,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/find/checkId',
        userInfo
      );
      console.log(response);

      if (response.data.message === '유저 존재') {
        setIsId(true);

        setTimeout(() => {
          setIsId(false);
        }, 3000);
      }
    } catch (error) {
      console.log('아이디 체크 실패', error);
      if (
        error.response.data.message ===
        'Find Exception. find - checkId에서 username이 존재하지 않음 확인'
      ) {
        console.log('들어옴');
        setIsNotId(true);

        setTimeout(() => {
          setIsNotId(false);
        }, 3000);
      }
    }
  };

  const findPw = async () => {
    const mailInfo = {
      mail,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/find/findPw',
        mailInfo
      );
      console.log(response);

      setIsMail(true);

      setTimeout(() => {
        setIsMail(false);
      }, 3000);
    } catch (error) {
      console.log('비밀번호 변경 실패', error);
      if (
        error.response.data.message ===
        `Sign Exception. ${mail}은 등록되지 않은 mail입니다.`
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
      <p className={styles.title}>비밀번호 찾기</p>
      <div className={styles.container__box}>
        <p className={styles.subTitle}>아이디</p>
        <div className={styles.input__box}>
          <input
            type="text"
            value={id}
            onChange={handleChangeId}
            placeholder="내용을 입력해 주세요."
          />
          <button onClick={checkId} className={styles.check__btn}>
            확인
          </button>
        </div>
        {isId && <p className={styles.isId}>아이디를 확인했습니다</p>}
        {isNotId && (
          <p className={styles.isNotId}>아이디가 존재하지 않습니다.</p>
        )}
        <div className={styles.mail__container}>
          <p className={styles.subTitle}>이메일 주소</p>
          <div className={styles.input__box}>
            <input
              type="text"
              value={mail}
              onChange={handleChangeMail}
              placeholder="내용을 입력해 주세요."
            />
            <button onClick={findPw} className={styles.check__btn}>
              인증 요청
            </button>
          </div>
          {isMail && (
            <p className={styles.isMail}>임시 비밀번호를 생성했습니다.</p>
          )}
          {isNotMail && (
            <p className={styles.isNotMail}>위 메일은 없는 메일정보입니다. </p>
          )}
        </div>
        {/* <div className={styles.FoundBtn}>비밀번호 찾기</div> */}
        {/* <div className={styles.PW__box}>
          <p className={styles.PW__commnet}>회원님의 비밀번호는</p>
          <p className={styles.PW__content}>123465678</p>
          <p className={styles.PW__commnet}>입니다</p>
        </div> */}
        <div onClick={handleLogin} className={styles.loginBtn}>
          로그인
        </div>
      </div>
    </section>
  );
}
