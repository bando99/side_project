import React from 'react';
import styled from 'styled-components';

export default function PostDetail() {
  return (
    <Container>
      <h1>해커톤 팀원 모집합니다. 열심히 하실분만 오싶쇼</h1>
      <Content>
        <div className='content_flex'>
          <span>게시날짜</span>
          <span>2023.04.16</span>
        </div>
        <div className='content_flex'>
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18" fill="none">
            <path d="M7.65039 9.00039C7.65039 9.35843 7.79262 9.70181 8.0458 9.95498C8.29897 10.2082 8.64235 10.3504 9.00039 10.3504C9.35843 10.3504 9.70181 10.2082 9.95498 9.95498C10.2082 9.70181 10.3504 9.35843 10.3504 9.00039C10.3504 8.64235 10.2082 8.29897 9.95498 8.0458C9.70181 7.79262 9.35843 7.65039 9.00039 7.65039C8.64235 7.65039 8.29897 7.79262 8.0458 8.0458C7.79262 8.29897 7.65039 8.64235 7.65039 9.00039Z" stroke="black" stroke-linecap="round" stroke-linejoin="round"/>
            <path d="M15.75 9C13.95 12 11.7 13.5 9 13.5C6.3 13.5 4.05 12 2.25 9C4.05 6 6.3 4.5 9 4.5C11.7 4.5 13.95 6 15.75 9Z" stroke="black" stroke-linecap="round" stroke-linejoin="round"/>
          </svg>
          <span>123</span>
        </div>
        <div className='content_flex'>
          <span>시작날짜</span>
          <span>2023.04.16</span>
        </div>
        <div className='content_flex'>
          <span>예상기간</span>
          <span>6개월</span>
        </div>
      </Content>
      <Line>

      </Line>
      <Section>
        <div className='section1'>
          <div>
            <span>모집구분</span>
            <p>프로젝트</p>
          </div>
          <div>
            <span>사용기술</span>
            <p>이미지</p>
          </div>
          <div>
            <span>진행방식</span>
            <p>온라인 주 1회, 오프라인 주1회</p>
          </div>
          <div>
            <span>프로젝트 기간</span>
            <p>2023.04.30 ~ 6개월</p>
          </div>
        </div>
        <div className='section2'>
          <div className='section2_title'>프로젝트/스터디의 현재 인원</div>
          <div className='section2_content'>
            <span>PM</span>
            <div>
              <p>1/1</p>
              <button>모집완료</button>
            </div>
          </div>
          <div className='section2_content'>
            <span>디자이너</span>
            <div>
              <p>1/1</p>
              <button>신청하기</button>
            </div>
          </div>
          <div className='section2_content'>
            <span>프론트엔드</span>
            <div>
              <p>1/1</p>
              <button>모집완료</button>
            </div>
          </div>
          <div className='section2_content'>
            <span>백엔드</span>
            <div>
              <p>1/1</p>
              <button className='active_btn'>모집완료</button>
            </div>
          </div>
          <div className='section2_content'>
            <span>모바일</span>
            <div>
              <p>1/1</p>
              <button className='active_btn'>모집완료</button>
            </div>
          </div>
          <div className='section2_content'>
            <span>기타</span>
            <div>
              <p>1/1</p>
              <button>모집완료</button>
            </div>
          </div>
        </div>
      </Section>
      <Section2>
        <div className='section2_title'>
          <div>현재 인원</div>
          <div>3/9</div>
        </div>
        <ul className='section2_content'>
          <li>
            <div>
              <img src="/profile/profile.png" width="150" height="150" alt="프로필" />
            </div>
            <div className='section2_content_text'>
              <div>
                <span>닉네임</span>
                <p>김슬구</p>
              </div>
              <div>
                <span>역할</span>
                <p>프론트엔드</p>
              </div>
              <div>
                <span>기술 스택</span>
                <p>
                  <img src="/stack/js.png" alt="" />
                </p>
              </div>
              <div>
                <span>경력</span>
                <p>신입</p>
              </div>
            </div>
            <button>프로필 자세히</button>
          </li>
          <button className='next_btn'>
            <img src="/icons/prev.png" alt="" />
          </button>
        </ul>
      </Section2>
      <Section3>
        <div className='section3_title'>프로젝트 소개</div>
        <div className='section3_content'>
          {/* content */}
        </div>
        <form>
          <textarea className='section3_textarea' placeholder='간단한 궁금한 점을 물어보세요.'/>
          <button className='section3_btn'>등록하기</button>
        </form>
      </Section3>
    </Container>
  );
}

const Container = styled.div`
  width: 1344px;
  margin : 50px auto;
  height: 2000px;
  
  h1 {
    color: #000;
    font-size: 18px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    margin-left: 100px;
  }
`

const Content = styled.div`
  margin-left: 100px;
  display: flex;
  margin-top: 67px;
  margin-bottom: 24px;
  gap: 160px;
  .content_flex {
    display: flex;
    align-items: center;
    gap: 30px;
    color: #000;
    font-size: 20px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    span:first-child {
      color: #000;
      font-size: 20px;
      font-style: normal;
      font-weight: 700;
      line-height: normal;
    }
  }
`
const Line = styled.div`
  width: 1344.006px;
  height: 2px;
  background: #D9D9D9;
  margin-bottom: 24px;
`

const Section = styled.div`
  width: 1344px;
  height: 384px;
  flex-shrink: 0;
  border-radius: 15px;
  display: flex;
  justify-content: center;
  gap: 20px;
  align-items: center;
  background: #DAE9FC;
  .section1, .section2 {
    width:577px;
    height: 350px;
    border-radius: 15px;
  }

  .section1 {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 50px;
    div {
      display : flex;
      align-items: center;
      span{
        display : inline-block;
        width: 150px;
        color: #1F7CEB;
        font-size: 18px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
      }

      p{
        color: #000;
        font-size: 20px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
      }
    }
  }

  .section2 {
    background: #FFF;
    display: flex;
    flex-direction: column;
    
    .section2_title {
      padding-left: 20px;
      padding-top: 10px;
      padding-bottom: 20px;
      color: #000;
      font-size: 14px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
    }

    .section2_content {
      display: flex;
      justify-content: space-between;
      padding-left: 20px;
      padding-right: 20px;
      margin-bottom: 7px;
      span{
        font-size: 20px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
      }

      div{
        display: flex;
        gap: 15px;
        align-items: center;
        color: #000;
        font-size: 20px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
      }

      button{
        display: flex;
        padding: 10px;
        align-items: flex-start;
        gap: 10px;
        border-radius: 8px;
        background: #DAE9FC;
        border: none;
        color: #000;
        font-size: 16px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        cursor: pointer;
      }

      .active_btn {
        border-radius: 8px;
        background: #1F7CEB;
        color: white;
      }
    }
  }
`

const Section2 = styled.div`
  margin-top: 50px;

  .section2_title {
    display: flex;
    gap: 10px;
    margin-bottom: 20px;
    div:first-child {
      color: #1F7CEB;
      font-size: 22px;
      font-style: normal;
      font-weight: 700;
      line-height: normal;
    }
    div:last-child {
      color: #000;
      font-size: 22px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
    }
  }

  .section2_content {
    position: relative;
    display: flex;
    gap: 15px;
    justify-content: start;
    padding: 0;
    li {
      list-style: none;
      width: 300.168px;
      height: 392.673px;
      flex-shrink: 0;
      border-radius: 50px;
      border: 2px solid #DAE9FC;
      background: #FFF;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      gap: 10px;
      .section2_content_text {
        div {
          display: flex;
          padding-bottom: 5px;
          gap: 15px;
          span {
            width: 100px;
            text-align: right;
            color: #858585;
            font-size: 14px;
            font-style: normal;
            font-weight: 400;
            line-height: normal;
          }
          p {
            color: #000;
            text-align: justify;
            font-size: 16px;
            font-style: normal;
            font-weight: 400;
            line-height: normal;
          }
        }
      } 
      button {
        display: flex;
        width: 151px;
        height: 34px;
        padding: 10px 12px;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        flex-shrink: 0;
        border-radius: 8px;
        background: #1F7CEB;
        box-shadow: 0px 1px 2px 0px rgba(0, 0, 0, 0.10);
        color: #FFF;
        font-size: 16px;
        font-style: normal;
        font-weight: 500;
        line-height: 22px; 
        border: none;
        cursor : pointer;
      }
    }
    .next_btn {
      right: -100px;
      top: 50%;
      position: absolute;
      width: 50px;
      height: 50px;
      flex-shrink: 0;
      border-radius: 100%;
      border: none;
      cursor: pointer;
      background-color: #FFF;
      transform : rotate(180deg);
    }
  }
`

const Section3 = styled.div`
  margin-top: 100px;

  .section3_title {
    color: #000;
    font-size: 22px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    border-bottom: 2px solid #D9D9D9;
    padding-bottom: 10px;
  }

  .section3_content {
    height: 500px;
  }
  form {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
    textarea {
      width: 1343px;
      height: 147px;
      flex-shrink: 0;
      border-radius: 30px;
      border: 2px solid #D9D9D9;

      &::placeholder {
        padding: 20px;
        color: #C2C2C2;
        font-size: 16px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
      }
    }
    button {
      display: flex;
      width: 151px;
      height: 34px;
      padding: 10px 12px;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      flex-shrink: 0;
      border-radius: 8px;
      background: #1F7CEB;
      box-shadow: 0px 1px 2px 0px rgba(0, 0, 0, 0.10);
      border: none;
      color: white;
      cursor: pointer;
    }
  }
`