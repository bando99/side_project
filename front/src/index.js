import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Project from './pages/Project';
import Study from './pages/Study';
import AddPost from './pages/AddPost';
import Login from './pages/User/Login/Login';
import IDfound from './pages/User/IDFound/IDfound';
import PWfound from './pages/User/PWfound/PWfound';
import PWChange from './pages/User/PWChange/PWChange';
import MyPage from './pages/User/MyPage';
import PostDetail from './pages/PostDetail';
import Assign from './pages/Assign';
import RecruitStatus from './pages/RecruitStatus';
import Home from './pages/Home';
import NotFound from './pages/NotFound';
import Join from './pages/Join/Join';
import Profile from './pages/Join/Profile';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    errorElement: <NotFound />,
    children: [
      { index: true, path: '/', element: <Home /> },
      { path: '/project/:id', element: <Project /> },
      { path: '/study/:id', element: <Study /> },
      { path: '/Addpost', element: <AddPost /> },
      { path: '/postDetail/:post', element: <PostDetail /> },
      { path: '/postDetail/assign/:post', element: <Assign /> },
      { path: '/mypage', element: <MyPage /> },
      { path: '/mypage/recruit/:post', element: <RecruitStatus /> },
      { path: '/mypage/addPost', element: <AddPost /> },
      { path: '/user/login', element: <Login /> },
      { path: '/user/idFound', element: <IDfound /> },
      { path: '/user/pwFound', element: <PWfound /> },
      { path: '/user/pwChange', element: <PWChange /> },
      { path: '/join', element: <Join /> },
      { path: '/profile', element: <Profile /> }, 
    ],
  },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
