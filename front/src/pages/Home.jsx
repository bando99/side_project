import React, { useEffect, useState } from 'react';
import Logo from '../ components/header/Logo';
import Post from '../ components/Post';
import styles from './Home.module.css';

import axios from 'axios';

const Home = () => {
  const [isFetched, setIsFetched] = useState(false);
  const [Loading, setLoading] = useState(true);
  const [error, setError] = useState();

  const [postList, setPostList] = useState([]);

  useEffect(() => {
    if (!isFetched) {
      const getPostList = async () => {
        try {
          const response = await axios.get('http://1.246.104.170:8080/boards');
          setPostList(response.data);
          setLoading(false);
        } catch (error) {
          setError('네트워크 에러가 발생했습니다.');
        } finally {
          setIsFetched(true);
          console.log('PostList를 정상적으로 받아왔습니다.');
        }
      };
      getPostList();
    }
  }, [isFetched]);

  useEffect(() => {
    console.log(postList);
  }, [postList]);

  if (Loading) return <p>Loading...</p>;

  if (error) return <p>{error}</p>;

  return (
    <>
      <Logo />
      <div className={styles.projectGrid}>
        {postList.map((post) => (
          <Post
            key={post.id}
            title={post.title}
            type={post.type}
            period={post.period}
            proceed_method={post.proceed_method}
            username={post.username}
            text={post.text}
          />
        ))}
      </div>
    </>
  );
};

export default Home;
