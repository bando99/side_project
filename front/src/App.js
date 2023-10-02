import './App.css';
import { Outlet } from 'react-router-dom';
import Home from './pages/HomeView';
import Header from './ components/header/Header';
import Footer from './ components/header/Footer';
import { AuthProvider } from './ components/context/AuthContext';

function App() {
  return (
    <AuthProvider>
      <Header />
      <div className="content">
        <Outlet />
      </div>
      <Footer />
    </AuthProvider>
  );
}

export default App;
