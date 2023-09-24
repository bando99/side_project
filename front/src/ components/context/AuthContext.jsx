import { createContext, useContext, useEffect, useState } from 'react';

const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(localStorage.getItem('token') || null);
  const [refreshToken, setRefreshToken] = useState(
    localStorage.getItem('refreshToken') || null
  );
  const [user_id, setUser_id] = useState(0);

  // 로그인
  const login = (token, refreshToken, user_id) => {
    setToken(token);
    setRefreshToken(refreshToken);
    setUser_id(user_id);
  };

  // 로그아웃
  const logout = () => {
    setToken(null);
    localStorage.removeItem('token');
    localStorage.removeItem('refreshToken');
    setUser_id(0);
  };

  // 초기 로딩 시 토큰 확인
  useEffect(() => {
    const storedToken = localStorage.getItem('token');
    const storedRefreshToken = localStorage.getItem('refreshToken');
    if (storedToken) {
      setToken(storedToken);
    }
    if (storedRefreshToken) {
      setRefreshToken(storedRefreshToken);
    }
  }, []);

  return (
    <AuthContext.Provider
      value={{ token, refreshToken, login, logout, user_id }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}
