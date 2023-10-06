import { useState, useEffect } from 'react';
import axios from 'axios';

axios.defaults.baseURL = 'http://1.246.104.170:8080';

function useAxios(params) {
  const [response, setResponse] = useState(null);
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(true);

    const fetchData = async (params) => {
      try{  
        const res = await axios({
          ...params,
        });
        setResponse(res.data);
        }catch(err) {
          setError(err);
        }
        finally{
          setLoading(false);
        };
      };

  useEffect(() => {
    fetchData(params);
  }, []);

  return { response, error, loading };
};

export default useAxios;