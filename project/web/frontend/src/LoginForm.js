import React from "react";
import InputField from "./InputField";
import SubmitButton from "./SubmitButton";
import UserStore from "./stores/UserStore";

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
  //the password is no longer than 12 characters
  setInputValue(property, val) {
    val = val.trim();
    if (val.length > 15) {
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
      // "http:localhost:3307/admin/1"   "/login"
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
      //store the capitalized name returned from database

      UserStore.name_first =
        result.name_first.charAt(0).toUpperCase() + result.name_first.slice(1);
      UserStore.name_last =
        result.name_last.charAt(0).toUpperCase() + result.name_last.slice(1);
      UserStore.id = result.idAdmin;

      UserStore.user_type = result.user_type;
      UserStore.user_id = result.user_id;

      //result success
      if (result) {
        UserStore.isLoggedIn = true;
        UserStore.username = result.username;
        UserStore.user_type = result.user_type;
        UserStore.user_id = result.user_id;
        UserStore.user_no = result.user_no;
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
        />
        <InputField
          type="password"
          placeholder="Password"
          value={this.state.password ? this.state.password : ""}
          onChange={(val) => this.setInputValue("password", val)}
        />
        <SubmitButton
          text="Login"
          disabled={this.state.buttonDisabled}
          onClick={() => this.doLogin()}
        />
      </div>
    );
  }
}

export default LoginForm;
