import React from 'react';
import styled from 'styled-components';

const ProfileView = () => {
  return (
    <>
      <Container>
        <Header>프로필 등록</Header>

        <FieldsWrapper>
          <FieldRow>
            <FieldWrapper>
              <InputLabel>이름</InputLabel>
              <InputField type="text" />
            </FieldWrapper>

            <FieldWrapper>
              <InputLabel>전화번호</InputLabel>
              <InputField type="text" />
            </FieldWrapper>
          </FieldRow>

          <FieldRow>
            <FieldWrapper>
              <InputLabel>학교</InputLabel>
              <InputField type="text" />
            </FieldWrapper>

            <FieldWrapper>
              <InputLabel>전공</InputLabel>
              <InputField type="text" />
            </FieldWrapper>
          </FieldRow>

          <FieldRow>
            <FieldWrapper>
              <InputLabel>이메일 주소</InputLabel>
              <InputField type="email" />
            </FieldWrapper>

            <FieldWrapper>
              <InputLabel>졸업 여부</InputLabel>
              <InputField type="text" />
            </FieldWrapper>
          </FieldRow>
        </FieldsWrapper>
      </Container>
      <ButtonWrapper>
        <BackButton>이전으로</BackButton>
        <NextButton>다음</NextButton>
      </ButtonWrapper>
    </>
  );
};

export default ProfileView;

const Container = styled.div`
  width: 50%;
  height: 50rem;
  border: 2px solid black;
  border-radius: 2rem;
  margin: 5rem auto;
  background-color: #dae9fc;
  font-size: 2rem;
  overflow: hidden;
`;

const Header = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 5rem;
  font-size: 3rem;
`;

const FieldsWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 1rem;
`;

const FieldRow = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 5rem;
`;

const FieldWrapper = styled.div`
  display: flex;
  flex-direction: column;
  flex-basis: calc(50% - 1rem);
  flex-grow: 1;
`;

const InputLabel = styled.div`
  margin-bottom: 1rem;
  margin-left: 1rem;
`;

const InputField = styled.input`
  height: 3rem;
  width: 80%;
  border: 2px solid black;
  border-radius: 1rem;
  font-size: 2rem;
`;

const ButtonWrapper = styled.div`
  display: flex;
  justify-content: center;
  margin-top: 2rem;
`;

const BackButton = styled.button`
  width: 10%;
  height: 3rem;
  color: #1f7ceb;
  background-color: white;
  border: 2px solid black;
  border-radius: 1rem;
  font-size: 2rem;
`;

const NextButton = styled.button`
  width: 10%;
  height: 3rem;
  color: white;
  background-color: #1f7ceb;
  border: 2px solid black;
  border-radius: 1rem;
  font-size: 2rem;
  margin-left: 2rem;
`;
