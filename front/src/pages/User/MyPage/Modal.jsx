import React from 'react';
import styled from 'styled-components';

const Modal = ({ title, content, onClose }) => {
  const handleButtonClick = (e) => {
    e.stopPropagation();
    onClose();
  };
  return (
    <ModalOverlay onClick={handleButtonClick}>
      <ModalContainer onClick={(e) => e.stopPropagation()}>
        <ModalTitle>{title}</ModalTitle>
        <ModalContent>
          {content}
        </ModalContent>
        <ModalButton onClick={handleButtonClick}>❌</ModalButton>
      </ModalContainer>
    </ModalOverlay>
  );
};

const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.7);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
`;

const ModalContainer = styled.div`
  position: relative;
  background-color: white;
  width: 800px;
  height: 600px;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
`;

const ModalTitle = styled.h2`
  font-size: 24px;
  margin-bottom: 10px;
`;

const ModalContent = styled.p`
  font-size: 16px;
  margin-bottom: 20px;
`;

const ModalButton = styled.div`
  position: absolute;
  font-size: px;
  top : 10px;
  right: 15px;
  color: black;
  border:none;
  
`;
export default Modal;

