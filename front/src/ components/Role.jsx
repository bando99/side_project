import React from 'react';
import styles from './Role.module.css';

export default function Role({ name, id, pre_cnt, want_cnt }) {
  return (
    <section className={styles.section} key={id}>
      <p>{name}</p>
      <div className={styles.cnt__box}>
        <p>{pre_cnt}</p>
        <p>/{want_cnt}</p>
      </div>
    </section>
  );
}
