import React from 'react';
import styles from './JoinSuccess.module.css';
import { useNavigate } from 'react-router-dom';

export default function JoinSuccess() {
  const navigate = useNavigate();

  return (
    <section className={styles.container}>
      <div className={styles.container__box}>
        <p>회원가입이 완료되었습니다.</p>
        <p>
          프로필을 작성하여 나를 소개하면서 프로젝트와 스터디 구인 매칭률을
          높여보세요!
        </p>
        <button onClick={() => navigate('/profile')} className={styles.btn}>
          프로필 작성하기
        </button>
      </div>
    </section>
  );
}
