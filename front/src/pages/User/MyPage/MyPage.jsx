import React from 'react';
import styles from './MyPage.module.css';

export default function MyPage() {
  return (
    <section>
      <div className={styles.header__container}>
        <div className={styles.profile__container}>
          <div className={styles.profile__img}></div>
          <div className={styles.profileSub__container}>
            <span className={styles.input__label}>닉네임</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <div className={styles.profileSub__container}>
            <span>역할</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <button className={styles.modifyBtn}>수정하기</button>
        </div>
        <div className={styles.profile__container}>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">경력</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">기술 스택</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <button className={styles.modifyBtn}>수정하기</button>
        </div>
        <div className={styles.profile__container}>
          <div className={styles.profileSub__container}>
            <p>아이디</p>
            <p>abc1234</p>
          </div>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">연락처</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">이메일</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">학교</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">전공</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <div className={styles.profileSub__container}>
            <label htmlFor="input">졸업여부</label>
            <input type="text" id="input" placeholder="내용을 입력해 주세요." />
          </div>
          <button className={styles.modifyBtn}>수정하기</button>
        </div>
        <div className={styles.total__blue__container}>
          <div className={styles.blue__container}>
            <div className={styles.blue__box}>
              <div className={styles.clipIcon}></div>
              <span>클립 해놓은 게시물</span>
            </div>
            <p className={styles.count}>3</p>
          </div>
          <div className={styles.blue__container}>
            <div className={styles.blue__box}>
              <div className={styles.recruitIcon}></div>
              <span>모집 현황</span>
            </div>
            <div className={styles.box}>
              <div>
                <p className={styles.recruit__count}>프로젝트</p>
                <p className={styles.count}>1</p>
              </div>
              <div>
                <p lassName={styles.recruit__count}>스터디</p>
                <p className={styles.count}>0</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
