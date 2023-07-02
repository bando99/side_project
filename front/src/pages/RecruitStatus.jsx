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
      </div>
      <span className={styles.main__title}>신청 알림</span>
      <div className={styles.newBox}>
        <div className={styles.leftBox}>
          <div className={styles.icon}></div>
          <div className={styles.textContainer}>
            <div className={styles.line1}>
              [프로젝트] 해커톤 모집합니다. (UXUI/프론트엔드/기획자/백엔드)
              열심히 하실분만...의 디자이너 신청이 1건 있습니다.
            </div>
            <div className={styles.line2}>신청자: 공대생23</div>
          </div>
        </div>
        <div className={styles.rightBox}>
          <button className={styles.btn1}>프로필 자세히</button>
          <button className={styles.btn2}>승낙하기</button>
        </div>
      </div>
    </section>
  );
}
