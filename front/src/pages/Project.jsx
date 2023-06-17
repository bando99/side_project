import React from 'react';
import styled from 'styled-components';

const tagMenu = styled.div`
  border: 2px solid #dae9fc;
  border-radius: 15px;
  width: 7rem;
  height: 2.5rem;
  background-color: black;
`;

// const MainImageWrapper = styled.div`
//   height: 500px;
//   width: 100%;
//   position: relative;
//   background-image: linear-gradient(
//       to bottom,
//       rgba(0, 0, 0, 0) 39%,
//       rgba(0, 0, 0, 0) 41%,
//       rgba(0, 0, 0, 0.65) 100%
//     ),
//     url(${(props) => props.image});
//   background-size: 100%, cover;
//   background-position: center, center;
//   background-blend-mode: overlay;

//   & h2 {
//     color: white;
//   }

//   & p {
//     color: white;
//     font-size: 1rem;
//   }

//   & > div {
//     position: absolute;
//     max-width: 500px;
//     bottom: 2rem;
//     margin-left: 2rem;
//   }
// `;

const tags = styled.div``;

export default function Project() {
  return (
    <section>
      <tagMenu>
        <div>
          <input type="text" placeholder="제목, 게시글 검색" />
        </div>
      </tagMenu>
    </section>
  );
}
