import axios from 'axios';

const API_URL = process.env.VUE_APP_API_AUTHENTICATION;
const API_URL2 = process.env.VUE_APP_API_USER;

class AuthService {
  login(user) {
    return axios
      .post(API_URL + 'login', {
        userName: user.username,
        password: user.password
      })
      .then(response => {
        console.log(response)
        if(response.data.enable === false){
          return console.log("LOCKED")
        }else if (response.data.token) {
          localStorage.setItem('user', JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(user) {
    return axios.post(API_URL2 + 'saveUser', {
      userName: user.username,
      email: user.email,
      password: user.password,
      roles: "USER",
      permits: "USER",
      enable: true
    });
  }
}

export default new AuthService();