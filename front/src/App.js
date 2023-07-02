import './App.css';
import { Outlet } from 'react-router-dom';
import Home from './pages/Home';

function App() {
  return (
    <>
      <Header />
      <div className="content">
        <Outlet />
      </div>
      <Footer />
    </>
  );
}

export default App;
