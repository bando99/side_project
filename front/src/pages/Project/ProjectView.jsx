import React, { useEffect, useState } from 'react';
import styles from './ProjectView.module.css';
import Tag from '../../ components/tag/Tag';

import axios from 'axios';
import Post from '../../ components/Post';

export default function ProjectView() {
  const [isFetched, setIsFetched] = useState(false);
  const [Loading, setLoading] = useState(true);
  const [error, setError] = useState();

  const [projectList, setProjectList] = useState([]);

  useEffect(() => {
    if (!isFetched) {
      const getPostList = async () => {
        try {
          const response = await axios.get('http://1.246.104.170:8080/boards');
          const filterResponse = response.data.filter(
            (res) => res.type === 'project'
          );
          console.log(filterResponse);
          setProjectList(filterResponse);
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
    console.log(projectList);
  }, [projectList]);

  if (error) return <p>{error}</p>;

  return (
    <section>
      <div className={styles.header}>
        <div className={styles.inputContainer}>
          <div className={styles.icon}></div>
          <input
            className={styles.search}
            type="text"
            placeholder="제목, 게시글 검색"
          />
        </div>
        <div className={styles.tag__container}>
          <div className={styles.tagIcon}></div>
          <div className={styles.tag__box}>
            <Tag skill="JavaScript" />
            <Tag skill="TypeScript" />
            <Tag skill="React" />
            <Tag skill="Vue" />
            <Tag skill="Svelte" />
            <Tag skill="Next.js" />
            <Tag skill="Node.js" />
            <Tag skill="Java" />
            <Tag skill="Go" />
            <Tag skill="Spring" />
            <Tag skill="Nest.js" />
            <Tag skill="Pigma" />
            <Tag skill="XD" />
          </div>
        </div>
        <div className={styles.part}>
          <div className={styles.partIcon}></div>
          <div className={styles.partList}>
            <p className={styles.part__content}>전체</p>
            <p className={styles.part__content}>PM</p>
            <p className={styles.part__content}>디자이너</p>
            <p className={styles.part__content}>프론트</p>
            <p className={styles.part__content}>백엔드</p>
            <p className={styles.part__content}>모바일</p>
            <p className={styles.part__content}>기타</p>
          </div>
        </div>
      </div>
      <div className={styles.sort__container}>
        <div className={styles.sort__box}>
          <div className={styles.sortIcon}></div>
          <p className={styles.sort__text}>정렬</p>
          <select name="order">
            <option>업데이트 순</option>
            <option>인기 순</option>
          </select>
        </div>
        <label className={styles.toggle__box}>
          <span className={styles.toggle__text}>모집 중</span>
          <input className={styles.toggleBtn} role="switch" type="checkbox" />
        </label>
      </div>
      <div className={styles.projectGrid}>
        {Loading ? (
          <p>Loading...</p>
        ) : (
          projectList.map((post) => (
            <Post
              key={post.id}
              title={post.title}
              type={post.type}
              roles={post.roles}
              period={post.period}
              proceed_method={post.proceed_method}
              username={post.username}
              text={post.text}
              tags={post.tags}
            />
          ))
        )}
      </div>
    </section>
  );
}
