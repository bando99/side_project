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

        </div>
        <div className='section2'>

        </div>
      </Section>
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
  background: #DAE9FC;

`