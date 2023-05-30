import Header from './ components/header/Header';
import './App.css';
import { Outlet } from 'react-router-dom';
import Join from './pages/Join/Join';

function App() {
  return (
    <>
      <Header />
      <Outlet />
    </>
  );
}

export default App;
