import axios from 'axios';

const API_URL = 'http://localhost:8092/user/';

class UserDataService {
  getAll() {
    return axios.get(API_URL + 'getAll');
  }
  
  updateUser(data){
    axios.get(API_URL + 'findRecord/' + data.id_current).then((response) => {
      console.log(response.data); 
      return axios.post(API_URL + 'saveUser', 
      {
        id: data.id_current,
        userName: data.userName,
        password: response.data.password,
        permits: response.data.permits,
        roles: response.data.roles,
        enable: response.data.enable,
        email: data.email,
      })
    }).catch((e) => {
      console.log(e);
    });
  }

  disableEnableUser(id){
    axios.get(API_URL + 'findRecord/' + id).then((response) => {
      console.log(response.data); 
      var isValue = response.data.enable;
      if(isValue === true){
        isValue = false
      }else{
        isValue = true
      }
      return axios.post(API_URL + 'saveUser', 
      {
        id: id,
        userName: response.data.userName,
        password: response.data.password,
        permits: response.data.permits,
        roles: response.data.roles,
        enable: isValue,
        email: response.data.email,
      })
    }).catch((e) => {
      console.log(e);
    });
  }
  
}

export default new UserDataService();