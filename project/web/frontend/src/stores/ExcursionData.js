import { extendObservable } from "mobx";

//store some data for currently logged user
class ExcursionData {
  constructor() {
    //contains properties for this store
    extendObservable(this, {
      loading: true,
      isReady: false,
      id: " ",
      title: " ",
      excursion_date: " ",
      description: " ",
      max_participants: " ",
      reg_deadline: " ",
      dereg_deadline: " ",
      meeting_details: " ",
      destination: " ",
    });
  }
}

export default new ExcursionData();
