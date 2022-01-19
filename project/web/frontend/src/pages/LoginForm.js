import React from "react";
import InputField from "../components/UI/InputField";
import SubmitButton from "../components/UI/SubmitButton";
import UserStore from "../components/stores/UserStore";
import { Link } from "react-router-dom";
import {AuthContext} from '../context/AuthContext'
import configData from "../config.json";

/**
 * @class that shows the Login Form
 */
class LoginForm extends React.Component {
  /**
   *
   * @param {Object} props login details
   */
  constructor(props) {
    super(props);
    /**
     * to avoid double requests to API, initial state is empty for username/password
     */
    this.state = {
      /**
       * @property {string} username User username
       */
      username: "",
      /**
       * @property {string} username User password
       */
      password: "",
      buttonDisabled: false,
    };
  }
  /**
   * @property {Function} setInputValue both,the password & username is no longer than 15 characters
   * @param {Object} property
   * @param {string} val
   * @returns {void}
   */
  setInputValue(property, val) {
    val = val.trim();
    if (val.length > 15 && val.length < 5) {
      return;
    }
    /**
     * in property passing usermane/password, this way the method could be reused
     */
    this.setState({
      [property]: val,
    });
  }
  /**
   * @property {Function} resetForm the form will be reset if username/password is not correct
   */
  resetForm() {
    this.setState({
      username: "",
      password: "",
      buttonDisabled: false,
    });
  }

  /**
   * Download data from the specified URL.
   *
   * @async
   * @function doLogin
   * @param {string} url - "http://localhost:9191/login/" + this.state.username + "/" + this.state.password;
   * @return {Promise<string>} The data from the URL.
   *
   */
  async doLogin() {
    if (!this.state.username) {
      return;
    }
    if (!this.state.password) {
      return;
    }
    this.setState({
      //so user won't be able double click
      buttonDisabled: true,
    });
    try {
      let url =
      configData.SERVER_URL+"auth/signin"

      let res = await fetch(url, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          "username" : this.state.username,
          "password" : this.state.password
        })
      });

      let result = await res.json();
      /**
       *store the capitalized user name returned from database
       */
      UserStore.name_first =
        result.name_first.charAt(0).toUpperCase() + result.name_first.slice(1);
      UserStore.name_last =
        result.name_last.charAt(0).toUpperCase() + result.name_last.slice(1);

      UserStore.id = result.user_id;
      UserStore.user_type = result.user_type;
      /**
       * if successful, store user info in UserStore component
       */
      if (result) {
        this.context.login(result.accessToken, result.id);  
        UserStore.loading = false;
        UserStore.isLoggedIn = true;
        UserStore.username = result.username;
        UserStore.user_type = result.roles[0];
        UserStore.user_id = result.id;
        UserStore.user_no = result.user_no;
        <Link to={`/login/excursions`} className="excursion-item-link" />;
      } else if (result === false) {
        this.resetForm();
        alert(result.msg);
      }
    } catch (e) {
      UserStore.loading = false;
      UserStore.isLoggedIn = false;
      this.resetForm();
    }
  }
  /**
   * renders the LoginForm for user to input the login details
   * @function render
   */
  render() {
    return (
      <div className="loginForm">
        Log in
        <InputField
          type="text"
          placeholder="Username"
          value={this.state.username ? this.state.username : ""}
          onChange={(val) => this.setInputValue("username", val)}
          required
        />
        <InputField
          type="password"
          placeholder="Password"
          value={this.state.password ? this.state.password : ""}
          onChange={(val) => this.setInputValue("password", val)}
          required
        />
        <SubmitButton
          className="excursion-item-link"
          text="Login"
          disabled={this.state.buttonDisabled}
          onClick={() => this.doLogin()}
        />
      </div>
    );
  }
}
LoginForm.contextType = AuthContext;
export default LoginForm;
