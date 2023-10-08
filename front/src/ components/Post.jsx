import React, { useState } from 'react';
import styled from 'styled-components';
import Role from './Role';
import styles from './Post.module.css';
import axios from 'axios';
import { useAuth } from './context/AuthContext';

export default function Post({
  board_id,
  username,
  type,
  title,
  proceed_method,
  period,
  roles,
  tags,
}) {
  const { user_id } = useAuth();

  const [isClip, setIsClip] = useState(false);

  console.log(board_id);
  console.log(isClip);

  const handleClip = async (e) => {
    const clipInfo = {
      user_id,
      board_id,
    };

    try {
      const response = await axios.post(
        'http://1.246.104.170:8080/cliped',
        clipInfo,
        {
          headers: {
            'X-AUTH-TOKEN': localStorage.getItem('token'),
          },
        }
      );
      console.log(response);
      setIsClip(true);
      alert('게시글을 즐겨찾기에 등록했습니다.');
    } catch (error) {
      console.log('즐겨찾기 등록 실패', error);
      alert('게시글 즐겨찾기 등록에 실패했습니다.');
      setIsClip(false);
    }
    console.log(isClip);
    e.stopPropagation();
  };

  return (
    <div className={styles.container}>
      {!isClip && (
        <img
          onClick={handleClip}
          className={styles.clip}
          src="/icons/isNotClip.png"
        />
      )}
      {isClip && (
        <img
          onClick={handleClip}
          className={styles.clip}
          src="/icons/isClip.png"
        />
      )}
      <div className={styles.type__container}>
        <div className={styles.type__text}>{type}</div>
        <div className={styles.period__text}>{period}</div>
      </div>
      <p className={styles.title}>{title}</p>
      <div>
        {tags &&
          tags.length > 0 &&
          tags.map((tag) => (
            <img
              className={styles.tagImg}
              src={`/tag/${tag.charAt(0).toUpperCase()}${tag.slice(1)}.png`}
              alt={tag}
            />
          ))}
      </div>
      <div className={styles.role__container}>
        <p className={styles.cur__cnt}>현재인원</p>
        <div className={styles.role}>
          {roles.map((role) => (
            <Role
              name={role.name}
              id={role.role_id}
              pre_cnt={role.pre_cnt}
              want_cnt={role.want_cnt}
            />
          ))}
        </div>
      </div>
      <p>{username}</p>
    </div>
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
