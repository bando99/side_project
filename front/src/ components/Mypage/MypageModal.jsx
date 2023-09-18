import React from 'react';
import styled from 'styled-components';

const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 50;
  background: rgba(0, 0, 0, 0.5);
`;

const ModalContent = styled.div`
  border-radius: 20px;
  border: 2px solid #d2e2ec;
  background: #dae9fc;
  padding: 1rem;
  border-radius: 0.375rem;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  position: relative;
  height: 80%;
  overflow-y: auto;
`;

const CloseButton = styled.div`
  border-radius: 50%;
  position: absolute;
  top: 0.5rem;
  right: 0.5rem;
  cursor: pointer;
  transition: background 0.2s;
  width: 42px;
  height: 42px;
`;

const BodyContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Modal = ({ isOpen, onClose, titleContent, bodyContent }) => {
  if (!isOpen) return null;

  const handleModalContentClick = (e) => {
    e.stopPropagation();
  };

  return (
    <ModalOverlay onClick={onClose}>
      <ModalContent onClick={handleModalContentClick}>
        {titleContent}
        <CloseButton onClick={onClose}>
          <img src="/icons/close.png" alt="" />
        </CloseButton>
        <BodyContainer>{bodyContent}</BodyContainer>
      </ModalContent>
    </ModalOverlay>
  );
};

export default Modal;
