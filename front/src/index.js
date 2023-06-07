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
import IDfound from './pages/User/IDfound';
import IDChange from './pages/User/IDChange';
import PWfound from './pages/User/PWfound';
import PWChange from './pages/User/PWChange';
import MyPage from './pages/User/MyPage';
import PostDetail from './pages/PostDetail';
import Assign from './pages/Assign';
import RecruitStatus from './pages/RecruitStatus';
import Home from './pages/Home';
import NotFound from './pages/NotFound';

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
      { path: '/user/idFound/:id', element: <IDfound /> },
      { path: '/user/idChange/:id', element: <IDChange /> },
      { path: '/user/pwFound/:id', element: <PWfound /> },
      { path: '/user/pwChange/:id', element: <PWChange /> },
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
