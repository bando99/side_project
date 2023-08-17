import React from 'react';
import styled from 'styled-components';

const Container = styled.section`
  padding: 4rem;
`;

const MainTitle = styled.span`
  font-size: 0.8rem;
  margin-left: 2.5rem;
`;

const MyBox = styled.div`
  display: flex;
  justify-content: center;
`;

const MyRecruit = styled.div`
  background-color: #dae9fc;
  margin: 1rem;
  width: 45%;
  height: 12rem;
  border-radius: 1rem;
`;

const Title = styled.div`
  display: flex;
  justify-content: center;
  margin: 1rem;
  font-size: 1.1rem;
`;

const TitleCount = styled.span`
  margin-left: 0.5rem;
`;
const ContentContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Truncate = styled.span`
  margin-left: 1rem;
  font-size: 0.8rem;
  display: block;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  max-width: 70%;
`;

const Options = styled.div`
  font-size: 0.8rem;
  margin-right: 1.5rem;
`;

const OptionItem = styled.span`
  position: relative;

  &:not(:last-child)::after {
    content: ' | ';
    margin-left: 0.5rem;
  }
`;

const NewBox = styled.div`
  border: 2px solid #d2e2ec;
  display: flex;
  justify-content: space-between;
  width: 93%;
  margin: auto;
`;

const LeftBox = styled.div`
  display: flex;
  align-items: center;
`;

const Icon = styled.div`
  background: url('/icons/click.png');
  background-size: cover;
  width: 2.5rem;
  height: 2.5rem;
  margin: 0.5rem;
`;

const TextContainer = styled.div`
  padding: 0.5rem;
  margin: 1rem;
`;

const Line1 = styled.div`
  font-size: 0.8rem;
  margin-bottom: 0.5rem;
`;

const Line2 = styled.div`
  font-size: 0.7rem;
`;

const RightBox = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const Button1 = styled.button`
  background: none;
  padding: 1.5rem 0.7rem;
  border: 0.1rem solid #1f7ceb;
  color: #1f7ceb;
  font-size: 0.7rem;
  margin: 0.3rem;
  width: 5.5rem;
  border-radius: 0.5rem;
`;

const Button2 = styled.button`
  background: none;
  padding: 1.5rem 0.7rem;
  background-color: #1f7ceb;
  color: white;
  font-size: 0.7rem;
  margin: 0.3rem;
  width: 5.5rem;
  border: none;
  border-radius: 0.5rem;
`;

export default function RecruitStatusView() {
  return (
    <Container>
      <MainTitle>내가 운영중인</MainTitle>
      <MyBox>
        <MyRecruit>
          <Title>
            <span>프로젝트</span>
            <TitleCount>1</TitleCount>
          </Title>
          <ContentContainer>
            <Truncate>
              해커톤 팀원 모집합니다(UX/UI/프론트엔드/기획자/백엔드) 열심히
              하실분만 구합니다
            </Truncate>
            <Options>
              <OptionItem>수정</OptionItem>
              <OptionItem>삭제</OptionItem>
            </Options>
          </ContentContainer>
        </MyRecruit>
        <MyRecruit>
          <Title>
            {' '}
            <span>스터디</span>
            <TitleCount>1</TitleCount>
          </Title>
          <ContentContainer>
            <Truncate>
              해커톤 팀원 모집합니다(UX/UI/프론트엔드/기획자/백엔드) 열심히
              하실분만 구합니다
            </Truncate>
            <Options>
              <OptionItem>수정</OptionItem>
              <OptionItem>삭제</OptionItem>
            </Options>
          </ContentContainer>
        </MyRecruit>
      </MyBox>
      <MainTitle>신청 알림</MainTitle>
      <NewBox>
        <LeftBox>
          <Icon />
          <TextContainer>
            <Line1>
              [프로젝트] 해커톤 모집합니다. (UXUI/프론트엔드/기획자/백엔드)
              열심히 하실분만...의 디자이너 신청이 1건 있습니다.
            </Line1>
            <Line2>신청자: 공대생23</Line2>
          </TextContainer>
        </LeftBox>
        <RightBox>
          <Button1>프로필 자세히</Button1>
          <Button2>승낙하기</Button2>
        </RightBox>
      </NewBox>
    </Container>
  );
}
