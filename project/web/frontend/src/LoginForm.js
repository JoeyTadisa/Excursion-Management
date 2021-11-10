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
    if (val.length > 12) {
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
      console.log(this.state.username);
      console.log(this.state.password);
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
        /*body: JSON.stringify({
          username: this.state.username,
          password: this.state.password,
        }),*/
      });

      let result = await res.json();
      //store the capitalized name returned from database
      UserStore.username =
        result.username.charAt(0).toUpperCase() + result.username.slice(1);

      console.log(result.email);
      console.log(result.success);
      //result && result.success
      if (result) {
        UserStore.isLoggedIn = true;

        console.log(UserStore.isLoggedIn);
        //temporary code
        // if (result.idAdmin == 6) {
        // UserStore.username = result.username;
        //go to admin page
        // } else if (result.idAdmin == 7) {
        //UserStore.username = result.username;

        //go to organizer page
        // } else {
        // alert("You are not registered!");
        // this.resetForm();
        // }
        //if admin id is 1 - go to admin page
        // if admin id is 2 - go to organizer page
        //UserStore.username = result.username;
      } else if (result && result.success === false) {
        this.resetForm();
        alert(result.msg);
      }
    } catch (e) {
      console.log(e);
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
