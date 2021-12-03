import axios from 'axios';

const API_URL = 'http://localhost:8092/user/';

class UserDataService {
  getAll() {
    return axios.get(API_URL + 'getAll');
  }
  
  updateUser(data){
    console.log(data)
    return axios.patch(API_URL + 'update-record/' + id)
  }
}

export default new UserDataService();