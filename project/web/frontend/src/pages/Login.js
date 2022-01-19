import React, { Fragment } from "react";
import { observer } from "mobx-react";
import UserStore from "../components/stores/UserStore";
import LoginForm from "./LoginForm";
import LoggedInView from "./LoggedInView";
import LoadingSpinner from "../components/UI/LoadingSpinner";

/**
 * @class Login that renders the view depending on logged in status
 */
class Login extends React.Component {
  render() {
    if (UserStore.loading) {
      return (
        <Fragment>
          <LoadingSpinner />
        </Fragment>
      );
    } else {
      /**
       * if the login is successful
       */
      if (UserStore.isLoggedIn) {
        return (
          <Fragment>
            <LoggedInView />
          </Fragment>
        );
      }
      return (
        /**
         * the main page of the app where the login form is displayed
         */
        <Fragment>
          <LoginForm />
        </Fragment>
      );
    }
  }
}

export default observer(Login);
