import React from 'react';
import styled from 'styled-components';
import Role from './Role';

export default function Post({
  id,
  username,
  type,
  title,
  text,
  proceed_method,
  period,
  roles,
  tags,
}) {
  return (
    <>
      <ProjectList>
        <div>{type}</div>
        <div>{period}</div>
        <div>
          {tags.map((tag) => (
            <img src={`/tag/${tag}.png`} alt={tag} />
          ))}
        </div>
        <Topic>{title}</Topic>
        <span>현재인원</span>
        <Board>
          {roles.map((role) => (
            <Role
              name={role.name}
              id={role.role_id}
              pre_cnt={role.pre_cnt}
              want_cnt={role.want_cnt}
            />
          ))}
        </Board>
        <Writer>{username}</Writer>
      </ProjectList>
    </>
  );
}

const ProjectList = styled.div`
  width: 30%;
  height: 30rem;
  border: 2px solid skyblue;
  border-radius: 30px;
  margin-bottom: 5rem;
  margin-right: 2rem;
  margin-left: 2rem;
`;

const TopTopic = styled.div`
  width: 100%;
  height: 3rem;
  margin-top: 1rem;
  /* background-color: #FFCA3A; */
`;

const Topic = styled.div`
  width: 100%;
  height: 5rem;
  margin-top: 1rem;
`;

const Board = styled.div`
  width: 100%;
  height: 13rem;
  background-color: #dae9fc;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
`;

const Member = styled.div`
  width: 80%;
  height: 2rem;
  font-size: 1rem;
  /* border: 1px solid black; */
  /* margin-bottom: 0.5rem; */
`;

const Writer = styled.div`
  width: 100%;
  height: 2rem;
  margin-top: 1rem;
`;
