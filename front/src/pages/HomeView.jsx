import React, { useEffect, useState } from 'react';
import Logo from '../ components/header/Logo';
import Post from '../ components/Post';
import styles from './Home.module.css';
import axios from 'axios';
import useFetchData from '../ components/hooks/getPostList';

export default function HomeView() {
  const { data: postList, Loading, error } = useFetchData('/boards');

  if (Loading) return <p>Loading...</p>;

  if (error) return <p>{error}</p>;

  return (
    <>
      <Logo />
      <div className={styles.projectGrid}>
        {postList.map((post) => (
          <Post
            key={post.board_id}
            title={post.title}
            type={post.type}
            roles={post.roles}
            period={post.period}
            proceed_method={post.proceed_method}
            username={post.username}
          />
        ))}
      </div>
    </>
  );
}
