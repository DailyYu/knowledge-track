import Axios from 'axios';

const API_URL = import.meta.env.VITE_API_URL;

console.log('API_URL:', API_URL);

const instance = Axios.create({
  baseURL: API_URL,
  timeout: 20000
})

export default instance;