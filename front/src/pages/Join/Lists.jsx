import React from "react";
import styled from 'styled-components';
import Project from './Project'
import Study from './Study'

const Lists = () => {
    return (
        <>
            <Title>
                <Top>프로젝트</Top>
                <Top>스터디</Top>
            </Title>

            <Boards>
                <Bind>
                    <Project />
                    <Project />
                </Bind>
                <Bind>
                    <Study />
                    <Study />
                </Bind>
            </Boards>

            <Boards>
                <Bind>
                    <Project />
                    <Project />
                </Bind>

                <Bind>
                    <Study />
                    <Study />
                </Bind>
            </Boards>
        </>
    );
};

export default Lists;


const Title = styled.div`
  font-size: 2rem;
  display: flex;
  justify-content: space-around;
  align-items: center;
`

const Top = styled.div`
  width: 35%;
  height: 5rem;
  border: 2px solid black;
  background-color: #7CB2F3;
  margin-top: 3rem;
  display: flex;
  align-items: center;
`

const Boards = styled.div`
  display: flex;  
  flex-direction: row;
  margin-top: 3rem;
`

const Bind = styled.div`
  display: flex;
  justify-content: center;
`