import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8092/book/";
const API_URL2 = "http://localhost:8092/category/";
const API_URL3 = "http://localhost:8092/editorial/"
class BookDataService {

  getEditorials(){
      return axios.get(API_URL3 + "getAll", { headers: authHeader() });
  }

  saveBook(data) {
    console.log(data);

    // Check if editorial exists
    this.getEditorials().then((response) => {
        console.log(response.data)
        const coincidence = [];
        for (let i = 0; i < response.data.length; i++) {
          if(response.data[i].name === data.editorial){
            console.log("coincidencia")
          }
          
        }
        

    })
    

    /*data_final_book = {
        id: data.id,
        titleBook = data.title,

    }*/


    // return axios.post(API_URL + "saveBook", { headers: authHeader() });
  }
  getCategoryBook(id){
      return axios.get(API_URL2 + "bookCategory/" + id, { headers: authHeader() })
  }
}

export default new BookDataService();
