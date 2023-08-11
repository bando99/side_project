import React, { useState } from 'react';
import styles from './AddPost.module.css';
import axios from 'axios';

export default function AddPost() {
  const [title, setTitle] = useState('');
  const [skill, setSkill] = useState('');
  const [type, setType] = useState('');
  const [text, setText] = useState('');
  const [proceed_method, setProceed_method] = useState('');

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
        name: 'Mobile',
        pre_cnt: 0,
        want_cnt: mobileCnt,
      });
    }

    if (designerCnt > 0) {
      roleNeededDtoList.push({
        name: 'Designer',
        pre_cnt: 0,
        want_cnt: designerCnt,
      });
    }

    if (frontEndCnt > 0) {
      roleNeededDtoList.push({
        name: 'FrontEnd',
        pre_cnt: 0,
        want_cnt: frontEndCnt,
      });
    }

    if (backEndCnt > 0) {
      roleNeededDtoList.push({
        name: 'BackEnd',
        pre_cnt: 0,
        want_cnt: backEndCnt,
      });
    }

    console.log(
      type,
      title,
      text,
      proceed_method,
      new Date(),
      skill,
      roleNeededDtoList
    );

    const postData = {
      type,
      title,
      text,
      proceed_method,
      period: new Date(),
      tagNames: skill,
      roleNeededDtoList,
    };

    console.log(postData);

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/users',
        postData
      );
      console.log('글 작성 성공');
    } catch (error) {
      console.error('글 작성 실패', error);
    }
  };

  return (
    <section>
      <div>
        <span>모집구분</span>
        <button
          className={projectBtn ? styles.btnActive : styles.btn}
          onClick={handleProejectBtn}
        >
          프로젝트
        </button>
        <button
          className={studyBtn ? styles.btnActive : styles.btn}
          onClick={handleStudyBtn}
        >
          스터디
        </button>
      </div>
      <form onSubmit={handleSubmit}>
        <div>
          <span>글 제목</span>
          <input
            placeholder="내용을 입력해 주세요."
            type="text"
            value={title}
            onChange={handleTitle}
          />
        </div>
        <div>
          <span>날짜 설정</span>
          <span>시작 날짜</span>
          <span>마감 날짜</span>
        </div>
        <div>
          <span>
            사용 기술
            <select name="stack" id="" value={skill} onChange={handleSkill}>
              <option value="">선택</option>
              <option value="React">React</option>
              <option value="Spring">Spring</option>
              <option value="Vue">Vue</option>
            </select>
          </span>
        </div>
        <div>
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
            <button>입력</button>
          </div>
        </div>
        <div>
          <span>인원 모집</span>
          <div>
            <span>PM</span>
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
          <div>
            <span>모바일</span>
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
          <div>
            <span>디자이너</span>
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
          <div>
            <span>프론트엔드</span>
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
          <div>
            <span>백엔드</span>
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
          <div>
            <span>기타</span>
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
        <div>
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
        </div>
        <div>
          <button>수정하기</button>
          <button className={styles.btn}>작성 완료</button>
        </div>
      </form>
    </section>
  );
}
