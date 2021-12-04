import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8092/book/";

class BookDataService {
  saveBook(data) {
    console.log(data);

    return axios.post(API_URL + "saveBook", { headers: authHeader() });
  }
}

export default new BookDataService();
