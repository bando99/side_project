import React, { useState } from 'react';
import styles from './MyPage.module.css';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

export default function MyPage() {
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
    <Section>
      <Section1>
        <div className="section1_profile">
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
          <button className="section1_fix_btn">수정하기</button>
        </div>
        <Section1school>
          <div className="section1_school">
            <span>아이디</span>
            <p>abc1234</p>
          </div>
          <div className="section1_school">
            <span>연락처</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <div className="section1_school">
            <span>이메일</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <div className="section1_school">
            <span>학교</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <div className="section1_school">
            <span>전공</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <div className="section1_school">
            <span>졸업여부</span>
            <input type="text" placeholder="내용을 입력해 주세요." />
          </div>
          <div className="section1_school_btn_flex">
            <button className="section1_school_btn">수정하기</button>
          </div>
        </Section1school>
        <Section1Etc>
          <div className="section1_etc_clip">
            <div>
              <img
                src="icons/clip.png"
                width="24"
                height="24"
                alt="clip icon"
              />
              <p>클립 해놓은 게시물 {'>'}</p>
            </div>
            <div>3</div>
          </div>
          <div className="section1_etc_recruitment">
            <div className="section1_etc_recruitment_title">
              <img
                src="icons/clip.png"
                width="24"
                height="24"
                alt="clip icon"
              />
              <p>모집 현황 {'>'}</p>
            </div>
            <div className="section1_etc_recruitment_content">
              <div className="section1_etc_recruitment_content_project">
                <div>프로젝트</div>
                <div>1</div>
              </div>
              <div className="section1_etc_recruitment_content_study">
                <div>스터디</div>
                <div>1</div>
              </div>
            </div>
          </div>
        </Section1Etc>
      </Section1>
      <Section2>
        <div className="section2_title">
          자격증 현 <p className="title_length">1</p>
        </div>
        <div className="section2_container">
          <div className="section2_content">
            <div>토익</div>
            <div>880</div>
            <div>2022.02.22 ~ 2024.02.21</div>
          </div>
          <div className="section2_plus">+</div>
        </div>
      </Section2>
      <Section3>
        <div className="section3_title">
          직무 경험 <p className="title_length">2</p>
        </div>
        <div className="section3_flex">
          <div className="section3_container">
            <div className="section3_container_left">
              <div className="section3_container_leftright_flex">
                <span>회사 이름</span>
                <p>모나미</p>
              </div>
              <div className="section3_container_leftright_flex">
                <span>사용한 기술 스택</span>
                <p>
                  <img
                    src="stack/JS.png"
                    width="24"
                    height="24"
                    alt="js icon"
                  />
                </p>
              </div>
              <div className="section3_container_leftright_flex">
                <span>직무 설명</span>
                <p></p>
              </div>
            </div>
            <div className="section3_container_right">
              <div className="section3_container_leftright_flex">
                <span>재직 기간</span>
                <p>
                  <div>2015.06</div>
                  <div>~</div>
                  <div>2018.03</div>
                </p>
              </div>
            </div>
          </div>
          <div className="section3_next">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="20"
              height="20"
              viewBox="0 0 20 20"
              fill="none"
            >
              <path
                d="M13.477 9.16591H3.33366V10.8326H13.477L9.00699 15.3026L10.1853 16.4809L16.667 9.99924L10.1853 3.51758L9.00699 4.69591L13.477 9.16591Z"
                fill="#1F7CEB"
              />
            </svg>
          </div>
        </div>
        <div className="section3_btn">
          <button>수정하기</button>
          <button>추가하기</button>
        </div>
      </Section3>
      <Section3>
        <div className="section3_title">
          프로젝트 이력 <p className="title_length">2</p>
        </div>
        <div className="section3_flex">
          <div className="section3_container">
            <div className="section3_container_left">
              <div className="section3_container_leftright_flex">
                <span>프로젝트 이름</span>
                <p>물류관련 앱</p>
              </div>
              <div className="section3_container_leftright_flex">
                <span>기술 스택</span>
                <p>
                  <img
                    src="stack/JS.png"
                    width="24"
                    height="24"
                    alt="js icon"
                  />
                </p>
              </div>
              <div className="section3_container_leftright_flex">
                <span>프로젝트 설명</span>
                <p></p>
              </div>
            </div>
            <div className="section3_container_right">
              <div className="section3_container_leftright_flex">
                <span>진행 기간</span>
                <p>
                  <div>2015.06</div>
                  <div>~</div>
                  <div>2018.03</div>
                </p>
              </div>
              <div className="section3_container_leftright_flex">
                <span>역할</span>
                <p>프론트엔드</p>
              </div>
              <div className="section3_container_leftright_flex">
                <span>업로드/링크</span>
                <p>물류.html</p>
              </div>
            </div>
          </div>
          <div className="section3_next">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="20"
              height="20"
              viewBox="0 0 20 20"
              fill="none"
            >
              <path
                d="M13.477 9.16591H3.33366V10.8326H13.477L9.00699 15.3026L10.1853 16.4809L16.667 9.99924L10.1853 3.51758L9.00699 4.69591L13.477 9.16591Z"
                fill="#1F7CEB"
              />
            </svg>
          </div>
        </div>
        <div className="section3_btn">
          <button>수정하기</button>
          <button>추가하기</button>
        </div>
      </Section3>
    </Section>
  );
}

const Section = styled.div`
  width: 1300px;
  padding-top: 50px;
  margin: auto;
  height: 2000px;
`;

const Section1 = styled.div`
  display: flex;
  justify-content: center;
  gap: 20px;
  .section1_profile {
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
  }

  .section1_etc {
    width: 200px;
    height: 318px;
    flex-shrink: 0;
    border-radius: 50px;
    border: 2px solid #dae9fc;
    background: #fff;
  }

  .section1_fix_btn {
    display: flex;
    width: 100px;
    bottom: 20px;
    position: absolute;
    height: 34px;
    padding: 10px;
    justify-content: center;
    align-items: center;
    gap: 10px;
    flex-shrink: 0;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: #fff;
    box-shadow: 0px 0px 0px 0px #cbdafc;
    cursor: pointer;
    color: #1f7ceb;
  }

  .section_profile_flex {
    div {
      display: flex;
      gap: 5px;
      margin-bottom: 5px;
      align-items: center;
      span {
        display: inline-block;
        width: 120px;
        text-align: center;
      }

      input {
        display: flex;
        width: 187px;
        height: 22px;
        padding: 10px;
        align-items: center;
        gap: 5px;
        flex-shrink: 0;
        border-radius: 5px;
        border: 1px solid #d2e2ec;
        background: var(--bs-white, #fff);
        box-shadow: 0px 0px 0px 0px #cbdafc;
      }

      select {
        width: 208px;
        height: 42px;
        border-radius: 5px;
        border: 1px solid #d2e2ec;
        background: var(--bs-white, #fff);
        box-shadow: 0px 0px 0px 0px #cbdafc;
      }

      .skill_stack {
      }

      .add_btn {
        display: flex;
        width: 74px;
        height: 34px;
        padding: 10px;
        justify-content: center;
        align-items: center;
        gap: 10px;
        flex-shrink: 0;
        color: #1f7ceb;
        font-family: SUITE Variable;
        font-size: 14px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        border-radius: 5px;
        border: 1px solid #d2e2ec;
        background: #fff;
        box-shadow: 0px 0px 0px 0px #cbdafc;
        cursor: pointer;
      }
    }
  }
`;

const Section1school = styled.div`
  width: 318px;
  height: 416px;
  flex-shrink: 0;
  border-radius: 50px;
  border: 2px solid #dae9fc;
  background: #fff;
  display: flex;
  flex-direction: column;
  align-items: start;
  padding-left: 20px;
  justify-content: center;
  gap: 20px;

  .section1_school {
    display: flex;
    gap: 5px;
    align-items: center;
    justify-content: center;

    span {
      width: 80px;
      display: inline-block;
    }

    input {
      width: 180px;
      border-radius: 5px;
      border: 1px solid #d2e2ec;
      background: var(--bs-white, #fff);
      box-shadow: 0px 0px 0px 0px #cbdafc;
    }
  }

  .section1_school_btn_flex {
    width: 100%;
    display: flex;
    justify-content: center;
    padding-top: 10px;
  }

  .section1_school_btn {
    display: flex;
    width: 100px;
    bottom: 20px;

    padding: 10px;
    justify-content: center;
    align-items: center;
    gap: 10px;
    text-align: center;
    flex-shrink: 0;
    border-radius: 5px;
    border: 1px solid #d2e2ec;
    background: #fff;
    box-shadow: 0px 0px 0px 0px #cbdafc;
    cursor: pointer;
    color: #1f7ceb;
  }
`;

const Section1Etc = styled.div`
  display: flex;
  flex-direction: column;
  .section1_etc_clip,
  .section1_etc_recruitment {
    width: 240px;
    height: 200px;
    border-radius: 30px;
    border: 2px solid #dae9fc;
    background: #dae9fc;
    margin-bottom: 10px;
  }

  .section1_etc_clip {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 20px;

    div:first-child {
      display: flex;
      gap: 3px;
      color: #000;
      font-family: SUITE Variable;
      font-size: 18px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
      cursor: pointer;
    }
    div:last-child {
      color: #1f7ceb;
      font-family: SUITE Variable;
      font-size: 50px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
    }
  }

  .section1_etc_recruitment {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 20px;
    .section1_etc_recruitment_title {
      display: flex;
      gap: 3px;
      color: #000;
      font-family: SUITE Variable;
      font-size: 18px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
      cursor: pointer;
      padding-bottom: 15px;
      border-bottom: 1px solid #c2c2c2;
    }
    .section1_etc_recruitment_content {
      display: flex;
      .section1_etc_recruitment_content_project {
        width: 100px;
        text-align: center;
        div:last-child {
          color: #1f7ceb;
          font-family: SUITE Variable;
          font-size: 50px;
          font-style: normal;
          font-weight: 400;
          line-height: normal;
          text-align: center;
          border-right: 1px solid #c2c2c2;
        }
      }

      .section1_etc_recruitment_content_study {
        width: 100px;
        text-align: center;
        div:last-child {
          color: #1f7ceb;
          font-family: SUITE Variable;
          font-size: 50px;
          font-style: normal;
          font-weight: 400;
          line-height: normal;
          text-align: center;
        }
      }
    }
  }
`;
const Section2 = styled.div`
  margin-top: 100px;
  .section2_title {
    color: #000;
    font-size: 16px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    display: flex;
    gap: 5px;
    align-items: center;
    margin-bottom: 50px;
  }
  .title_length {
    color: #000;
    font-size: 16px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }

  .section2_container {
    display: flex;
    align-items: center;
    gap: 50px;
  }

  .section2_content {
    width: 204px;
    height: 204px;
    flex-shrink: 0;
    border-radius: 15px;
    border: 2px solid #dae9fc;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 5px;

    div:first-child {
      padding-top: 5px;
      padding-bottom: 10px;
      width: 150px;
      border-bottom: 1.5px solid #dae9fc;
      display: flex;
      justify-content: center;
      gap: 3px;
      color: #000;
      font-family: SUITE Variable;
      font-size: 20px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
      cursor: pointer;
    }
    div:nth-child(2) {
      color: #1f7ceb;
      font-family: SUITE Variable;
      font-size: 50px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
      padding-bottom: 20px;
    }
    div:lasth-child {
      color: #5c5c5c;
      font-size: 12px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
    }
  }

  .section2_plus {
    cursor: pointer;
    width: 50px;
    height: 50px;
    flex-shrink: 0;
    display: flex;
    justify-content: center;
    border: 2px solid #d2e2ec;
    border-radius: 100%;
    font-size: 30px;
    color: #1f7ceb;
  }
`;

const Section3 = styled.div`
  margin-top: 50px;
  .section3_title {
    color: #000;
    font-size: 16px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    display: flex;
    gap: 5px;
    align-items: center;
    margin-bottom: 50px;
  }
  .title_length {
    color: #000;
    font-size: 16px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }

  .section3_flex {
    display: flex;
    gap: 10px;
    align-items: center;
  }

  .section3_container {
    width: 1280px;
    height: 344px;
    flex-shrink: 0;
    border-radius: 20px;
    border: 2px solid #dae9fc;
    display: flex;
    align-items: start;
    .section3_container_left,
    .section3_container_right {
      padding-top: 90px;
      width: 640px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 40px;

      .section3_container_leftright_flex {
        display: flex;
        justify-content: center;
        align-items: center;
        span {
          display: inline-block;
          width: 150px;
          color: #5c5c5c;
          font-size: 16px;
          font-style: normal;
          font-weight: 400;
          line-height: normal;
        }
        p {
          width: 300px;
          color: #000;
          font-size: 20px;
          font-style: normal;
          font-weight: 400;
          line-height: normal;
          display: flex;
          gap: 50px;
        }
      }
    }
  }
  .section3_next {
    width: 50px;
    height: 50px;
    flex-shrink: 0;
    border: 2px solid #d2e2ec;
    border-radius: 100%;
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .section3_btn {
    margin-top: 50px;
    width: 100%;
    display: flex;
    justify-content: center;
    gap: 30px;
    button {
      cursor: pointer;
      display: flex;
      width: 100px;
      height: 34px;
      padding: 10px;
      justify-content: center;
      align-items: center;
      gap: 10px;
      flex-shrink: 0;
      border-radius: 5px;
      border: 1px solid #d2e2ec;
      background: #fff;
      box-shadow: 0px 0px 0px 0px #cbdafc;
      color: #1f7ceb;
      font-family: SUITE Variable;
      font-size: 16px;
      font-style: normal;
      font-weight: 400;
      line-height: normal;
    }
  }
`;
