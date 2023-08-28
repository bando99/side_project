import React, { useState } from 'react';
import axios from 'axios';
import styled from 'styled-components';

export default function AddPost() {
  const [title, setTitle] = useState('');
  const [skill, setSkill] = useState('');
  const [type, setType] = useState('');
  const [text, setText] = useState('');
  const [proceed_method, setProceed_method] = useState('');
  const [period, setPeriod] = useState('');
  const [tagDtoList, setTagDtoList] = useState([]);

  const [pmCnt, setPmCnt] = useState(0);
  const [mobileCnt, setMobileCnt] = useState(0);
  const [designerCnt, setDesignerCnt] = useState(0);
  const [frontEndCnt, setFrontEndCnt] = useState(0);
  const [backEndCnt, setBackEndCnt] = useState(0);
  const [etcCnt, setEtcCnt] = useState(0);

  const [projectBtn, setProjectBtn] = useState('');
  const [studyBtn, setStudyBtn] = useState('');

  const roleNeededDtoList = [];

  const handleTitle = (e) => {
    setTitle(e.target.value);
  };

  const handleSkill = (e) => {
    setSkill(e.target.value);
  };

  const handleText = (e) => {
    setText(e.target.value);
  };

  const handleProceedMethod = (e) => {
    setProceed_method(e.target.value);
  };

  const handleProejectBtn = () => {
    setType('프로젝트');
    setProjectBtn(true);
    setStudyBtn(false);
  };

  const handleStudyBtn = () => {
    setType('스터디');
    setProjectBtn(false);
    setStudyBtn(true);
  };

  const handleAddTags = (e) => {
    if (skill) {
      setTagDtoList([...tagDtoList, skill]);
      setSkill('');
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (pmCnt > 0) {
      roleNeededDtoList.push({
        name: 'PM',
        pre_cnt: 0,
        want_cnt: pmCnt,
      });
    }

    if (mobileCnt > 0) {
      roleNeededDtoList.push({
        name: '모바일',
        pre_cnt: 0,
        want_cnt: mobileCnt,
      });
    }

    if (designerCnt > 0) {
      roleNeededDtoList.push({
        name: 'designer',
        pre_cnt: 0,
        want_cnt: designerCnt,
      });
    }

    if (frontEndCnt > 0) {
      roleNeededDtoList.push({
        name: 'frontend',
        pre_cnt: 0,
        want_cnt: frontEndCnt,
      });
    }

    if (backEndCnt > 0) {
      roleNeededDtoList.push({
        name: 'backend',
        pre_cnt: 0,
        want_cnt: backEndCnt,
      });
    }

    if (etcCnt > 0) {
      roleNeededDtoList.push({
        name: '기타',
        pre_cnt: 0,
        want_cnt: etcCnt,
      });
    }

    const postData = {
      type,
      title,
      text,
      proceed_method,
      period,
      tagDtoList,
      roleNeededDtoList,
      user_id: 1,
    };

    console.log(postData);

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/boards',
        postData
      );
      console.log('글 작성 성공');
    } catch (error) {
      console.error('글 작성 실패', error);
    }
  };

  return (
    <Section>
      <Recruitment>
        <span>모집구분</span>
        <div>
          <button
            style={{ borderRadius: ' 8px 0px 0px 8px' }}
            className={projectBtn ? 'btnActive' : 'btn'}
            onClick={handleProejectBtn}
          >
            프로젝트
          </button>
          <button
            style={{ borderRadius: ' 0px 8px 8px 0px' }}
            className={studyBtn ? 'btnActive' : 'btn'}
            onClick={handleStudyBtn}
          >
            스터디
          </button>
        </div>
      </Recruitment>
      <form onSubmit={handleSubmit}>
        <Title>
          <span>글 제목</span>
          <input
            placeholder="내용을 입력해 주세요."
            type="text"
            value={title}
            onChange={handleTitle}
          />
        </Title>
        <DateContainer>
          <span>날짜 설정</span>
          <input type="date" />
          <span>시작 날짜</span>
          <input type="date" />
          <span>마감 날짜</span>
          <input
            value={period}
            onChange={(e) => setPeriod(e.target.value)}
            type="date"
          />
        </DateContainer>
        <Skill>
          <span>사용 기술</span>
          <select name="stack" id="" value={skill} onChange={handleSkill}>
            <option value="">선택</option>
            <option value="react">react</option>
            <option value="Spring">spring</option>
            <option value="javascript">javascript</option>
            <option value="flutter">flutter</option>
          </select>
          <PlusBtn onClick={handleAddTags}></PlusBtn>
          <div className="tags">
            {tagDtoList.map((tagName, index) => (
              <div key={index}>{tagName}</div>
            ))}
          </div>
        </Skill>
        <Playing>
          <span>진행 방식</span>
          <div>
            <input
              type="text"
              placeholder="내용을 입력해 주세요."
              name=""
              id=""
              value={proceed_method}
              onChange={handleProceedMethod}
            />
          </div>
          <button>입력</button>
        </Playing>
        <People>
          <span>인원 모집</span>
          <div>
            <div className="people_section">
              <div className="people_title">PM</div>
              <select
                name="pm"
                id=""
                value={pmCnt}
                onChange={(e) => setPmCnt(e.target.value)}
              >
                <option value="">선택</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4명이상</option>
              </select>
            </div>
            <div className="people_section">
              <div className="people_title">디자이너</div>
              <select
                name="designer"
                value={designerCnt}
                onChange={(e) => setDesignerCnt(e.target.value)}
              >
                <option value="">선택</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4명이상</option>
              </select>
            </div>
            <div className="people_section">
              <div className="people_title">프론트엔드</div>
              <select
                name="frontEnd"
                value={frontEndCnt}
                onChange={(e) => setFrontEndCnt(e.target.value)}
              >
                <option value="">선택</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4명이상</option>
              </select>
            </div>
            <div className="people_section">
              <div className="people_title">백엔드</div>
              <select
                name="backEnd"
                value={backEndCnt}
                onChange={(e) => setBackEndCnt(e.target.value)}
              >
                <option value="">선택</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4명이상</option>
              </select>
            </div>
            <div className="people_section">
              <div className="people_title">모바일</div>
              <select
                name="mobile"
                value={mobileCnt}
                onChange={(e) => setMobileCnt(e.target.value)}
              >
                <option value="">선택</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4명이상</option>
              </select>
            </div>
            <div className="people_section">
              <div className="people_title">기타</div>
              <select
                name="etc"
                value={etcCnt}
                onChange={(e) => setEtcCnt(e.target.value)}
              >
                <option value="">선택</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4명이상</option>
              </select>
            </div>
          </div>
        </People>
        <TextArea>
          <span>글 내용</span>
          <textarea
            name="content"
            id=""
            cols="30"
            rows="10"
            placeholder="내용을 입력해 주세요."
            value={text}
            onChange={handleText}
          ></textarea>
        </TextArea>
        <Submit>
          <button>수정하기</button>
          <button>작성 완료</button>
        </Submit>
      </form>
    </Section>
  );
}

const Section = styled.section`
  margin: auto;
  width: 850px;
  margin-top: 70px;
  display: flex;
  flex-direction: column;
  gap: 40px;
  span {
    display: inline-block;
    width: 90px;
    margin-right: 10px;
  }
`;

const Recruitment = styled.div`
  display: flex;
  align-items: center;

  div {
    width: 700px;
  }

  .btn {
    background-color: #1f7ceb;
    height: 42px;
    color: white;
    padding: 0.5rem 1rem;
    border: 1px solid #d2e2ec;
    width: 126px;
    cursor: pointer;
  }

  .btnActive {
    width: 6rem;
    background-color: #08438c;
    height: 42px;
    color: white;
    padding: 0.5rem 1rem;
    width: 126px;
    cursor: pointer;
    border: 1px solid #d2e2ec;
  }
`;

const DateContainer = styled.div`
  display: flex;
  align-items: center;
  padding-bottom: 40px;
  input {
    width: 130px;
    height: 22px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
  }
`;

const Title = styled.div`
  display: flex;
  align-items: center;
  padding-bottom: 40px;
  input {
    width: 700px;
    height: 21px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
  }
`;
const Playing = styled.div`
  display: flex;
  align-items: center;
  padding-bottom: 40px;

  div {
    width: 620px;
    height: 42px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
    display: flex;
    justify-content: center;
    align-items: center;
    input {
      margin: 0;
      padding: 5px;
      outline: none;
      background: none;
      flex: 0.95;
    }
  }
  button {
    margin-left: 12px;
    width: 88px;
    height: 42px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: #fff;
    box-shadow: 0px 0px 0px 0px #cbdafc;
    color: #1f7ceb;
  }
`;

const Skill = styled.div`
  display: flex;
  align-items: center;
  padding-bottom: 40px;
  select {
    width: 160px;
    height: 42px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
  }

  .tags {
    display: flex;
    gap: 5px;
    margin-left: 10px;
  }
`;

const People = styled.div`
  display: flex;
  padding-bottom: 40px;
  .people_section {
    display: flex;
    margin-bottom: 10px;
    gap: 10px;
  }

  .people_title {
    width: 150px;
    height: 42px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
    line-height: 42px;
    padding-left: 10px;
  }

  select {
    width: 160px;
    height: 42px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
  }
`;

const PlusBtn = styled.div`
  margin-left: 10px;
  cursor: pointer;
  background-image: url('/icons/plus.png');
  background-size: cover;
  width: 1.5rem;
  height: 1.5rem;
}
`;

const TextArea = styled.div`
  display: flex;
  padding-bottom: 40px;

  textarea {
    width: 710px;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: var(--bs-white, #fff);
    box-shadow: 0px 0px 0px 0px #cbdafc;
  }
`;

const Submit = styled.div`
  width: 100%;
  display: flex;
  margin: 30px auto;
  text-align: center;
  align-items: center;
  justify-content: center;
  gap: 20px;

  button:first-child {
    border-radius: 5px;
    border: 2px solid #d2e2ec;
    background: #fff;
    box-shadow: 0px 0px 0px 0px #cbdafc;
    display: flex;
    width: 100px;
    height: 42px;
    padding: 10px;
    justify-content: center;
    align-items: center;
    gap: 10px;
    flex-shrink: 0;
    color: #1f7ceb;
    font-size: 16px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    cursor: pointer;
  }
  button:nth-child(2) {
    border-radius: 5px;
    border: 2px solid #d2e2ec;
    background: #1f7ceb;
    box-shadow: 0px 0px 0px 0px #cbdafc;
    display: flex;
    width: 100px;
    height: 42px;
    padding: 10px;
    justify-content: center;
    align-items: center;
    gap: 10px;
    flex-shrink: 0;
    color: white;
    font-size: 16px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    cursor: pointer;
  }
`;
