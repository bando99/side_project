import React from 'react';
import styles from './RecruitStatus.module.css';

export default function RecruitStatus() {
  return (
    <section className={styles.container}>
      <span className={styles.main__title}>내가 운영중인</span>
      <div className={styles.myBox}>
        <div className={styles.myRecruit}>
          <div className={styles.title}>
            <span>프로젝트</span>
            <span>1</span>
          </div>
          <div className={styles.content__container}>
            <span className={styles.truncate}>
              해커톤 팀원 모집합니다(UX/UI/프론트엔드/기획자/백엔드) 열심히
              하실분만 구합니다
            </span>
            <div className={styles.options}>
              <span>수정</span>
              <span>삭제</span>
            </div>
          </div>
        </div>
        <div className={styles.myRecruit}>
          <div className={styles.title}>
            <span>스터디</span>
            <span>0</span>
          </div>
          <div>
            <span>
              해커톤 팀원 모집합니다(UX/UI/프론트엔드/기획자/백엔드) 열심히
              하실분만
            </span>
            <div>
              <span>수정</span>
              <span>삭제</span>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
