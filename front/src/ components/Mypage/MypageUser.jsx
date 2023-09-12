import React from 'react'
import styled from 'styled-components';
import styles from '../../pages/User/MyPage/MyPage.module.css'

const MypageUser = () => {
  return (
    <UserEdit className="section1_profile">
      <div className={styles.profile__img}></div>
      <div className="section_profile_flex">
        <div>
          <span>닉네임</span>
          <input type="text" placeholder="닉네임을 입력해주세요" />
        </div>
        <div>
          <span>기술스택</span>
          <select name="stack" id="">
            <option value="">선택</option>
            <option value="react">react</option>
            <option value="Spring">spring</option>
            <option value="javascript">javascript</option>
            <option value="flutter">flutter</option>
          </select>
          <button className="add_btn">추가</button>
        </div>
        <div>
          <span></span>
          <div className="skill_stack">
            <div>React</div>
            <div>Java</div>
          </div>
        </div>
        <div>
          <span>역할</span>
          <select name="stack" id="">
            <option value="">선택</option>
            <option value="react">react</option>
            <option value="Spring">spring</option>
            <option value="javascript">javascript</option>
            <option value="flutter">flutter</option>
          </select>
        </div>
        <div>
          <span>경력</span>
          <input type="text" placeholder="닉네임을 입력해주세요" />
        </div>
      </div>
      <button
        className="section1_fix_btn"
      >
        수정하기
      </button>
    </UserEdit>
  )
}

const UserEdit = styled.div`
  position: relative;
  width: 660px;
  height: 416px;
  flex-shrink: 0;
  border-radius: 50px;
  border: 2px solid #dae9fc;
  background: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
`


export default MypageUser
