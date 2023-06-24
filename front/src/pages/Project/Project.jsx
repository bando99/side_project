import React from 'react';
import styles from './Project.module.css';
import Tag from '../../ components/tag/Tag';

export default function Project() {
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
    </section>
  );
}
