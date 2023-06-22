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
          <Tag skill="JavaScript" />
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
          <div className={styles.tag__box}>
            <div className={styles.IJavaScript}></div>
            <div className={styles.tag__name}>JavaScript</div>
          </div>
        </div>
      </div>
    </section>
  );
}
