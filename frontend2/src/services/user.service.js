import axios from 'axios';
// import authHeader from './auth-header';

const API_URL = 'http://localhost:8092/user/';

// Acciones API
class UserService {
  getPublicContent() {
    // return axios.get(API_URL + 'getAll');
  }

  getUserBoard() {
    return axios.get(API_URL + 'getAll');
  }

  getAdminBoard() {
    // return axios.get(API_URL + 'getAll', { headers: authHeader() });
  }
}

export default new UserService();