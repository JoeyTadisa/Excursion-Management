import { extendObservable } from "mobx";

//store some data for currently logged user
/**
 * @class UserStore saves the state of login and login details fetched from the backend
 */
class UserStore {
  constructor() {
    //contains properties for this store
    extendObservable(this, {
      loading: false,
      isLoggedIn: false,
      username: " ",
      name_first: " ",
      name_last: " ",
      user_type: " ",
      user_id: " ",
      user_no: " ",
    });
  }
}

export default new UserStore();
