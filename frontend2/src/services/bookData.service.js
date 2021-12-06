import axios from "axios";
import authHeader from "./auth-header";

const API_URL2 = process.env.VUE_APP_API_CATEGORY;
const API_URL3 = process.env.VUE_APP_API_EDITORIAL;
const API_URL4 = process.env.VUE_APP_API_AUTHOR;
const API_URL5 = process.env.VUE_APP_API_BOOK;

class BookDataService {

  getEditorials(){
      return axios.get(API_URL3 + "getAll", { headers: authHeader() });
  }
  
  getAuthors(){
    return axios.get(API_URL4 + "getAll", { headers: authHeader() });
  }
  saveEditorial(){
    return axios.post(API_URL3 + "saveEditorial", { headers: authHeader() } )
  }

  async saveBook(data) {
    console.log(data);
    
    let editorials_response = await this.getEditorials();
    console.log(editorials_response.data)
    let isCoincidenceEditorial = false;

    let id_editorial_coincidence = null;
    let id_author_coincidence = null;

    for (let i = 0; i < editorials_response.data.length; i++) {
      if(editorials_response.data[i].name === data.editorial){
        isCoincidenceEditorial = true;
        id_editorial_coincidence = editorials_response.data[i].id;
      }
    }
    let response_editorial = null;
    if(isCoincidenceEditorial === false){
      response_editorial = await axios({
        method: 'post',
        url: API_URL3 + "saveEditorial",
        data: {
          name: data.editorial,
          email: 'Undefined',
          address: 'Undefined',
          telephone: 0
        },
        headers: authHeader()
      });
    };

    let authors_response = await this.getAuthors();
    let isCoincidenceAuthor = false;
    for (let i = 0; i < authors_response.data.length; i++) {
      if(authors_response.data[i].name === data.author){
        id_author_coincidence = authors_response.data[i].id;
        isCoincidenceAuthor = true;
        }
    }
    let response_author = null;
    if(isCoincidenceAuthor === false){
      response_author = await axios({
        method: 'post',
        url: API_URL4 + "saveAuthor",
        data: {
          name: data.author,
          email: 'Undefined',
          address: 'Undefined',
          telephone: 0
        },
        headers: authHeader()
      });
    };
    
    let id_author = null;
    if(isCoincidenceAuthor === false){
      id_author = response_author.data.id;
    }else if(isCoincidenceAuthor === true){
      id_author = id_author_coincidence
    }

    let id_editorial = null;
    if(isCoincidenceEditorial === false){
      id_editorial = response_editorial.data.id;
    }else if(isCoincidenceEditorial === true){
      id_editorial = id_editorial_coincidence
    }
    let user = JSON.parse(localStorage.getItem('user'));
    var today = new Date();
    await axios({
      method: 'post',
      url: API_URL5 + "saveBook",
      data: {
        titleBook: data.title,
        date: data.date,
        availibility: false,
        url: data.url,
        dateC: today,
        user: user.id,
        category_book: data.category_book,
        author: id_author,
        editorial: id_editorial,
        edicion: 1
      },
      headers: authHeader()
    });

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
