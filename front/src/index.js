import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import NotFound from './pages/NotFoundView';
import JoinView from './pages/Join/JoinView';
import JoinSuccessView from './pages/Join/JoinSuccessView';
import ProjectView from './pages/Project/ProjectView';
import StudyView from './pages/Study/StudyView';
import IDfoundView from './pages/User/IDFound/IDfoundView';
import AddPostView from './pages/AddPostView';
import RecruitStatusView from './pages/RecruitStatusView';
import MyPageView from './pages/User/MyPage/MyPageView';
import PWfoundView from './pages/User/PWfound/PWfoundView';
import PWChangeView from './pages/User/PWChange/PWChangeView';
import ClipView from './pages/User/ClipView';
import ProfileView from './pages/ProfileView';
import HomeView from './pages/HomeView';
import AssignView from './pages/AssignView';
import PostDetailView from './pages/PostDetailView';
import LoginView from './pages/User/Login/LoginView';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    errorElement: <NotFound />,
    children: [
      { index: true, path: '/', element: <HomeView /> },
      { path: '/project', element: <ProjectView /> },
      { path: '/study', element: <StudyView /> },
      { path: '/Addpost', element: <AddPostView /> },
      { path: '/postDetail/:post', element: <PostDetailView /> },
      { path: '/postDetail/assign/:post', element: <AssignView /> },
      { path: '/mypage', element: <MyPageView /> },
      { path: '/mypage/recruit', element: <RecruitStatusView /> },
      { path: '/mypage/addPost', element: <AddPostView /> },
      { path: '/user/login', element: <LoginView /> },
      { path: '/user/idFound', element: <IDfoundView /> },
      { path: '/user/pwFound', element: <PWfoundView /> },
      { path: '/user/pwChange', element: <PWChangeView /> },
      { path: '/join', element: <JoinView /> },
      { path: '/joinSuccess', element: <JoinSuccessView /> },
      { path: '/mypage/clip', element: <ClipView /> },
      { path: '/profile', element: <ProfileView /> },
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
