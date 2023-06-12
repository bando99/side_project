import Header from './ components/header/Header';
import './App.css';
import { Outlet } from 'react-router-dom';
import Profile from './pages/Join/Profile';
import Footer from './ components/header/Footer';

function App() {
  return (
    <>
      <Header />
      <Outlet />
      <Footer />
    </>
  );
}

export default App;