import React, { Fragment } from "react";
import { observer } from "mobx-react";
import UserStore from "../components/stores/UserStore";
import LoginForm from "./LoginForm";
import LoggedInView from "./LoggedInView";
import LoadingSpinner from "../components/UI/LoadingSpinner";

class Login extends React.Component {
  //fetching the data from the database for the login
  // async componentDidMount() {
  //   try {
  //     //API call that expects json
  //     let res = await fetch(
  //       "http://localhost:9191/login/" +
  //         this.state.username +
  //         "/" +
  //         this.state.password,
  //       {
  //         method: "GET",
  //         headers: {
  //           Accept: "application/json",
  //           "Content-Type": "application/json",
  //         },
  //       }
  //     );
  //     let result = await res.json();
  //     //if the user loggedin successefully & the user data is stored in the UserStore
  //     if (result && result.success) {
  //       UserStore.loading = false;
  //       UserStore.isLoggedIn = true;
  //       UserStore.username = result.username;
  //       UserStore.user_type = result.user_type;
  //       UserStore.user_id = result.user_id;
  //       UserStore.user_no = result.user_no;
  //     } else {
  //       UserStore.loading = false;
  //       UserStore.isLoggedIn = false;
  //     }
  //   } catch (e) {
  //     UserStore.loading = false;
  //     UserStore.isLoggedIn = false;
  //     throw e;
  //   }
  // }

  render() {
    if (UserStore.loading) {
      return (
        <Fragment>
          <LoadingSpinner />
        </Fragment>
      );
    } else {
      //if the login is successful
      if (UserStore.isLoggedIn) {
        return (
          <Fragment>
            <LoggedInView />
          </Fragment>
        );
      }
      return (
        //the main page of the app where the login form is displayed
        <Fragment>
          <LoginForm />
        </Fragment>
      );
    }
  }
}

export default observer(Login);
