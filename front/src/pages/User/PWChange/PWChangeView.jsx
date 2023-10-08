import React, { useState } from 'react';
import styles from './PWChange.module.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

// TODO 기존 비밀번호와 아이디 확인되면 변경 기능 활성화
export default function PWChangeView() {
  const navigate = useNavigate();

  const [id, setId] = useState('');
  const [isId, setIsId] = useState(false);
  const [isNotId, setIsNotId] = useState(false);

  const [newPw, setNewPw] = useState('');
  const [checkPw, setCheckPw] = useState('');

  const handleChangePw = () => {
    const userInfo = {
      username: id,
      newPw,
      checkPw,
    };

    try {
      const response = axios.post(
        'http://1.246.104.170:8080/change/password',
        userInfo
      );

      // 아이디와 기존 비밀번호 검사 로직 후 결과처리
      alert('비밀번호가 변경되었습니다.');
      navigate('/user/login');
    } catch (error) {
      console.error('비밀번호 변경 실패', error);
    }
  };

  const handleChangeId = (e) => {
    setId(e.target.value);
  };

  const handleChangeNewPw = (e) => {
    setNewPw(e.target.value);
  };

  const handleChangeCheckPw = (e) => {
    setCheckPw(e.target.value);
  };

  const checkId = async () => {
    const userInfo = {
      username: id,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/change/checkId',
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

  return (
    <section className={styles.container}>
      <p className={styles.title}>비밀번호 변경</p>
      <div className={styles.container__box}>
        <p className={styles.subTitle}>아이디</p>
        <div className={styles.input__box}>
          <input
            value={id}
            onChange={handleChangeId}
            type="text"
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
        <p className={styles.subTitle}>기존 비밀번호</p>
        <div className={styles.input__box}>
          <input type="text" placeholder="내용을 입력해 주세요." />
          <button className={styles.check__btn}>확인</button>
        </div>
        <p className={styles.subTitle}>새 비밀번호</p>
        <div className={styles.input__box}>
          <input
            value={newPw}
            onChange={handleChangeNewPw}
            type="password"
            placeholder="내용을 입력해 주세요."
          />
          <button className={styles.check__btn}>인증 요청</button>
        </div>
        <p className={styles.subTitle}>비밀번호 확인</p>
        <div className={styles.input__box}>
          <input
            className={styles.input__code}
            type="password"
            placeholder="내용을 입력해 주세요."
            value={checkPw}
            onChange={handleChangeCheckPw}
          />
          <button className={styles.check__btn}>인증 확인</button>
        </div>
        <div onClick={handleChangePw} className={styles.changeBtn}>
          변경하기
        </div>
      </div>
    </section>
  );
}
