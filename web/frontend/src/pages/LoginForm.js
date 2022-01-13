import React from "react";
import InputField from "../components/UI/InputField";
import SubmitButton from "../components/UI/SubmitButton";
import UserStore from "../components/stores/UserStore";
import { Link } from "react-router-dom";

class LoginForm extends React.Component {
  constructor(props) {
    super(props);
    //to avoid double requests to API, initial state is empty for username/password
    this.state = {
      username: "",
      password: "",
      buttonDisabled: false,
    };
  }

  //both,the password & username is no longer than 15 characters
  setInputValue(property, val) {
    val = val.trim();
    if (val.length > 15 && val.length < 5) {
      return;
    }

    //in property passing usermane/password, this way the method could be reused
    this.setState({
      [property]: val,
    });
  }
  //the form will be reset if username/password is not correct
  resetForm() {
    this.setState({
      username: "",
      password: "",
      buttonDisabled: false,
    });
  }

  //if both the username and the password exist and matches,
  //the login will happen and submit button will be disabled
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
        "http://localhost:9191/login/" +
        this.state.username +
        "/" +
        this.state.password;

      let res = await fetch(url, {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });

      let result = await res.json();

      //store the capitalized user name returned from database
      UserStore.name_first =
        result.name_first.charAt(0).toUpperCase() + result.name_first.slice(1);
      UserStore.name_last =
        result.name_last.charAt(0).toUpperCase() + result.name_last.slice(1);

      UserStore.id = result.user_id;
      UserStore.user_type = result.user_type;

      //result success
      if (result) {
        UserStore.loading = false;
        UserStore.isLoggedIn = true;
        UserStore.username = result.username;
        UserStore.user_type = result.user_type;
        UserStore.user_id = result.user_id;
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

export default LoginForm;
