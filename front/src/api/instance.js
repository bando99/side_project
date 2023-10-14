import axios from "axios";

const createAxiosInstance = (token) => {
  return axios.create({
    baseURL: 'http://1.246.104.170:8080',
    headers: {
      'X-AUTH-TOKEN': token,
    },
  });
};

export { createAxiosInstance };