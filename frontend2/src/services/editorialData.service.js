import axios from 'axios';
import authHeader from './auth-header';

const API_EDITORIAL = process.env.VUE_APP_API_EDITORIAL;

class EditorialDataService {
    getAll() {
      console.log(API_EDITORIAL)
      return axios.get(API_EDITORIAL + "getAll", { headers: authHeader() });
      }
}

export default new EditorialDataService();
