import React from "react";
import logo from "./thu_logo.png";
import { observer } from "mobx-react";
import UserStore from "./stores/UserStore";
import LoginForm from "./LoginForm";
import "./App.css";
import LoggedInView from "./LoggedInView";

class App extends React.Component {
  //fetching the data from the database for the login
  async componentDidMount() {
    try {
      //API call that expects json
      let res = await fetch("http://localhost:9191/admin/6", {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });
      let result = await res.json();
      console.log(result);
      //if the user loggedin successefully
      if (result && result.success) {
        UserStore.loading = false;
        UserStore.isLoggedIn = true;
        UserStore.username = result.username;
      } else {
        UserStore.loading = false;
        UserStore.isLoggedIn = false;
      }
    } catch (e) {
      UserStore.loading = false;
      UserStore.isLoggedIn = false;
    }
  }
  //define logout function
  async doLogout() {
    try {
      let res = await fetch("/logout", {
        method: "post",
        headers: {
          Accept: "application/json",
          "Content-type": "application/json",
        },
      });
      let result = await res.json();
      if (result && result.success) {
        UserStore.isLoggedIn = false;
        UserStore.username = "";
      }
    } catch (e) {
      console.log(e);
    }
  }
  render() {
    if (UserStore.loading) {
      return (
        <div className="app">
          <div className="container">Loading, please wait ...</div>
        </div>
      );
    } else {
      //if the login is successful
      if (UserStore.isLoggedIn) {
        return (
          <div className="app">
            <div className="container">
              <LoggedInView />
            </div>
          </div>
        );
      }
      return (
        //the main page of the app where the login form is displayed
        <div className="app">
          <div className="container">
            <img src={logo} className="App-logo" alt="logo" />
            <h3>Welcome to THU excursions</h3>
            {/*<ExcursionForm />*/}
            <LoginForm />
          </div>
        </div>
      );
    }
  }
}

export default observer(App);
