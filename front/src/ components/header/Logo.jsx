import React, { Fragment, useState, useEffect } from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

export default function Logo() {
  const [currentImageIndex, setCurrentImageIndex] = useState(0);
  const images = ['/logo/Logo1.png', '/logo/Logo2.png'];

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentImageIndex((prevIndex) => (prevIndex + 1) % images.length);
    }, 4000);

    return () => {
      clearInterval(interval);
    };
  }, [images]);

  return (
    <>
      <ImageCarouselContainer>
        <CarouselImage src={images[currentImageIndex]} alt="carousel" />
      </ImageCarouselContainer>
    </>
  );
}

const ImageCarouselContainer = styled.div`
  display: flex;
  justify-content: center;
`;

const CarouselImage = styled.img`
  display: block;
  width: 100%;
  height: 25rem;
  /* 이미지 스타일 */
`;
