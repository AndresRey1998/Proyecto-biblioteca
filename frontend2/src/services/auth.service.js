import axios from 'axios';

const API_URL = 'http://localhost:8092/autenticacion/';
const API_URL2 = 'http://localhost:8092/user/'
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
      permits: "USER,ADMIN",
      enable: true
    });
  }
}

export default new AuthService();