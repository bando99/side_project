import React from 'react';
import styled from 'styled-components';

const Home = () => {
  return (
    <>
      <Title>
        <Top>프로젝트</Top>
        <Top>스터디</Top>
      </Title>

      <Boards>
        <Bind>
          <Project>
            <TopTopic>프로젝트 6개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Project>

          <Project>
            <TopTopic>프로젝트 3개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Project>
        </Bind>

        <Bind>
          <Study>
            <TopTopic>프로젝트 6개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Study>

          <Study>
            <TopTopic>프로젝트 6개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Study>
        </Bind>
      </Boards>

      <Boards>
        <Bind>
          <Project>
            <TopTopic>프로젝트 6개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Project>

          <Project>
            <TopTopic>프로젝트 3개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Project>
        </Bind>

        <Bind>
          <Study>
            <TopTopic>프로젝트 6개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Study>

          <Study>
            <TopTopic>프로젝트 6개월이상</TopTopic>
            <Stack>
              <img src='/stack/JS.png' alt='dd'></img>
              <img src='/stack/React.png' alt='dd'></img>
              <img src='/stack/Spring.png' alt='dd'></img>
            </Stack>
            <Topic>해커톤 팀원 모집합니다(UXUI 디자이너/프론트엔트/기획자/백엔드)</Topic>
            <Board>
              <Member>현재인원</Member>
              <Member>PM</Member>
              <Member>디자이너</Member>
              <Member>프론트엔드</Member>
              <Member>백엔드</Member>
            </Board>
            <Writer>홍길동</Writer>
          </Study>
        </Bind>
      </Boards>

    </>
  );
}

export default Home;

const Title = styled.div`
  font-size: 2rem;
  display: flex;
  justify-content: space-around;
  align-items: center;
`

const Top = styled.div`
  width: 35%;
  height: 5rem;
  border: 2px solid black;
  background-color: #7CB2F3;
  margin-top: 3rem;
  display: flex;
  align-items: center;
`

const Boards = styled.div`
  display: flex;  
  flex-direction: row;
  margin-top: 3rem;
`

const Bind = styled.div`
  display: flex;
  justify-content: center;
`

const Project = styled.div`
  width: 30%;
  height: 30rem;
  border: 2px solid skyblue;
  border-radius: 30px;
  margin-bottom: 5rem;
  margin-right: 2rem;
  margin-left: 2rem;
`

const Study = styled.div`
  width: 30%;
  height: 30rem;
  border: 2px solid skyblue;
  border-radius: 30px;
  margin-bottom: 5rem;
  margin-right: 2rem; 
  margin-left: 2rem;
`

const TopTopic = styled.div`
  width: 100%;
  height: 3rem;
  margin-top: 1rem;
  /* background-color: #FFCA3A; */
`

const Stack = styled.div`
  width: 10%;
  height: 2em;
  display: flex;
  justify-content: row;
`

const Topic = styled.div`
  width: 100%;
  height: 5rem;
  margin-top: 1rem;
`

const Board = styled.div`
  width: 100%;
  height: 13rem;
  background-color: #DAE9FC;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
`

const Member = styled.div`
  width: 80%;
  height: 2rem;
  font-size: 1rem;
  /* border: 1px solid black; */
  /* margin-bottom: 0.5rem; */
`

const Writer = styled.div`
  width: 100%;
  height: 2rem;
  margin-top: 1rem;
`