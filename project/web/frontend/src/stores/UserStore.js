import { extendObservable } from "mobx";

//store some data for currently logged user
class UserStore {
  constructor() {
    //contains properties for this store
    extendObservable(this, {
      loading: true,
      isLoggedIn: false,
      name_first: " ",
      name_last: " ",
      user_type: " ",
      user_id: " ",
    });
  }
}

export default new UserStore();
