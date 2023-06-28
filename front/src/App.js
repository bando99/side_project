import './App.css';
import { Outlet } from 'react-router-dom';
import Profile from './pages/Join/Profile';
import Footer from './ components/header/Footer';
import Home from './pages/Home';
import Header from './ components/header/Header';
import Logo from './ components/header/Logo';

function App() {
  return (
    <>
      <Home />
      <Outlet />
    </>
  );
}

export default App;