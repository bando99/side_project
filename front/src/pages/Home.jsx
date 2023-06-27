import React from 'react';
import Header from '../ components/header/Header';
import Logo from '../ components/header/Logo';
import List from './Join/List';
import Footer from '../ components/header/Footer';


const Home = () => {
  return (
    <>
      <Header />
      <Logo />
      <List />
      <Footer />
    </>
  );
}

export default Home;