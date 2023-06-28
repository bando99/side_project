import React from 'react';
import Header from '../ components/header/Header';
import Logo from '../ components/header/Logo';
import Lists from './Join/Lists';
import Footer from '../ components/header/Footer';


const Home = () => {
  return (
    <>
      <Header />
      <Logo />
      <Lists />
      <Footer />
    </>
  );
}

export default Home;