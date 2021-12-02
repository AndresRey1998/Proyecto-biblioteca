import axios from 'axios';

const API_URL = 'http://localhost:8092/user/';

class UserDataService {
  getAll() {
    return axios.get(API_URL + 'getAll');
  }
}

export default new UserDataService();