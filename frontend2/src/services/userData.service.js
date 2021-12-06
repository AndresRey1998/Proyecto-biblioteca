import axios from "axios";

const API_URL = process.env.VUE_APP_API_USER;

class UserDataService {
  getAll() {
    return axios.get(API_URL + "getAll");
  }

  async updateUser(data) {
    return axios
      .get(API_URL + "findRecord/" + data.id_current)
      .then((response) => {
        console.log(response.data);
        
          return axios.post(API_URL + "saveUser", {
          id: data.id_current,
          userName: data.userName,
          password: response.data.password,
          permits: response.data.permits,
          roles: data.roles.toString(),
          enable: response.data.enable,
          email: data.email,
        })      
      });
  }

  async getCurrentUser(id){
    return axios.get(API_URL + "findRecord/" + id)
  }

  async disableEnableUser(id) {
    return axios
      .get(API_URL + "findRecord/" + id)
      .then((response) => {
        console.log(response.data);
        var isValue = response.data.enable;
        if (isValue === true) {
          isValue = false;
        } else {
          isValue = true;
        }
        return axios.post(API_URL + "saveUser", {
          id: id,
          userName: response.data.userName,
          password: response.data.password,
          permits: response.data.permits,
          roles: response.data.roles,
          enable: isValue,
          email: response.data.email,
        });
      })

  }
}

export default new UserDataService();
