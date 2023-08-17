import React, { useState } from 'react';
import styles from './MyPage.module.css';
import { useNavigate } from 'react-router-dom';

export default function MyPageView() {
  const navigate = useNavigate();
  const [modalState, setModalState] = useState(false);

  const handleRecruit = () => {
    navigate('/mypage/recruit');
  };

  const handleClip = () => {
    navigate('/mypage/clip');
  };

  const handleAddModal = () => {
    const modal = document.getElementById('modal');
    setModalState(!modalState);

    if (modalState) modal.style.display = 'flex';
    else {
      modal.style.display = 'none';
    }
  };

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
          <div className={styles.blue__container} onClick={handleClip}>
            <div className={styles.blue__box}>
              <div className={styles.clipIcon}></div>
              <span>클립 해놓은 게시물</span>
            </div>
            <p className={styles.count}>3</p>
          </div>
          <div className={styles.blue__container} onClick={handleRecruit}>
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
      <div>
        <p>직무 경험2</p>
        <div>
          <div>
            <div>
              <span>회사이름</span>
              <span>모나미</span>
            </div>
            <div>
              <span>제작기간</span>
              <span>2015.06 ~ 2018.03</span>
            </div>
            <div>
              <span>사용한 기술 스택</span>
              <span>리액트</span>
            </div>
            <div>
              <span>직무 설명</span>
              <span>~~~~~~</span>
            </div>
            <div>
              <button>수정하기</button>
              <button onClick={handleAddModal}>추가하기</button>
            </div>
          </div>
          <div className="next__icon"></div>
        </div>
      </div>
      <div className={styles.modal__rapper}>
        <div id="modal" className={styles.modal}>
          <span>직무경험 등록</span>
          <div>
            <div>
              <span>회사이름</span>
              <input type="text" placeholder="내용을 입력해주세요." />
            </div>
            <div>
              <span>재직기간</span>
              <input type="text" />
            </div>
          </div>
          <div>
            <span>사용한 기술 스택</span>
            <select name="skill" id="skill">
              <option value="react">React</option>
              <option value="vue">Vue</option>
            </select>
          </div>
          <div>
            <span>직무설명</span>
            <textarea
              name="description"
              id="description"
              cols="30"
              rows="10"
            ></textarea>
          </div>
        </div>
      </div>
    </section>
  );
}
