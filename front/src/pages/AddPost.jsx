import React from 'react';

export default function AddPost() {
  return (
    <div>
      <div>
        <span>모집구분</span>
        <button>프로젝트</button>
        <button>스터디</button>
      </div>
      <div>
        <span>글 제목</span>
        <input placeholder="내용을 입력해 주세요." type="text" />
      </div>
      <div>
        <span>날짜 설정</span>
        <span>시작 날짜</span>
        <span>마감 날짜</span>
      </div>
      <div>
        <span>
          사용 기술
          <select name="stack" id="">
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
          />
          <button>입력</button>
        </div>
      </div>
      <div>
        <span>인원 모집</span>
        <div>
          <span>PM</span>
          <select name="count" id="">
            <option value="">선택</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>
        <div>
          <span>PM</span>
          <select name="count" id="">
            <option value="">선택</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>
        <div>
          <span>디자이너</span>
          <select name="count" id="">
            <option value="">선택</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>
        <div>
          <span>프론트엔드</span>
          <select name="count" id="">
            <option value="">선택</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>
        <div>
          <span>백엔드</span>
          <select name="count" id="">
            <option value="">선택</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>
        <div>
          <span>모바일</span>
          <select name="count" id="">
            <option value="">선택</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
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
        ></textarea>
      </div>
      <div>
        <button>수정하기</button>
        <button>작성 완료</button>
      </div>
    </div>
  );
}
