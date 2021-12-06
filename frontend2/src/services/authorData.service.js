import axios from 'axios';
import authHeader from './auth-header';

const API_AUTHOR = process.env.VUE_APP_API_AUTHOR;

class AuthorDataService {
    getAll() {
      console.log(API_AUTHOR)
      return axios.get(API_AUTHOR + "getAll", { headers: authHeader() });
      }
}

export default new AuthorDataService();
