import { extendObservable } from "mobx";

class ExcursionListStore {
  constructor() {
    extendObservable(this, {
      excursiondatalist: {},
    });
  }
}

export default new ExcursionListStore();
