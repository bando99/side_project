import axios from 'axios';

export async function refreshTokenAndRetry(method, url, data, headers) {
  try {
    const refreshData = {
      refreshToken: localStorage.getItem('refreshToken'),
    };

    const refreshResponse = await axios.post(
      'http://1.246.104.170:8080/sign/reissue',
      refreshData
    );

    // Update tokens
    const newAccessToken = refreshResponse.data.accessToken;
    const newRefreshToken = refreshResponse.data.refreshToken;
    localStorage.setItem('token', newAccessToken);
    localStorage.setItem('refreshToken', newRefreshToken);

    const newHeaders = {
      ...headers,
      'X-AUTH-TOKEN': newAccessToken,
    };

    const retryResponse = await axios({
      method: method,
      url: url,
      data: data,
      headers: newHeaders,
    });

    console.log('요청 성공 (재시도)');
    return retryResponse;
  } catch (refreshError) {
    console.error('새로운 액세스 토큰 얻기 실패', refreshError);
    throw refreshError;
  }
}
