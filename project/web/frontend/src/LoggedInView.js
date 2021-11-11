import React from "react";
import "./App.css";
import SubmitButton from "./SubmitButton";
import UserStore from "./stores/UserStore";
import ExcursionForm from "./ExcursionForm";
import ExcursionData from "./stores/ExcursionData";

class LoggedInView extends React.Component {
  async componentDidMount() {
    try {
      //API call that expects json
      let res = await fetch("http://localhost:9191/excursions", {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });
      let result = await res.json();
      console.log(result);
      //if the excursion fetch from database successefull, excursion data is available
      if (result && result.success) {
        ExcursionData.loading = false;
        ExcursionData.isReady = true;
      } else {
        ExcursionData.loading = false;
        ExcursionData.isReady = false;
      }
    } catch (e) {
      ExcursionData.loading = false;
      ExcursionData.isReady = false;
    }
  }

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

  // once loggedin the logout button is set to be visible
  state = {
    visible: true,
    whichComponentToShow: "SubmitButton",
  };

  render() {
    //user is loggedin and logout button is visible, greet the user by the name
    if (this.state.whichComponentToShow === "SubmitButton") {
      return (
        <div className="loggedInView">
          <div className="app">
            <div className="container">
              {/* welcome the user with the name of the user*/}
              <h2>Welcome {UserStore.username}!</h2>
              <h4>Available Excursions</h4>
              {/* <div className="title-and-date">
                {this.state.titles.map(function (title, index) {
                  return (
                    <div key={index}>
                      <div>
                        {this.state.title} {this.state.excursion_date}
                      </div>
                    </div>
                  );
                })}
              </div> 
            */}

              <button
                className="btn btn-primary"
                type="button"
                onClick={() => {
                  this.setState({ whichComponentToShow: "ExcursionForm" });
                }}
              >
                New Excursion Form
              </button>
              <SubmitButton
                className="logout-btn"
                text={"Log out"}
                disabled={false}
                onClick={() => this.doLogout()}
              />
            </div>
          </div>
        </div>
      );
      // data is still loading, message shown "Loading..."
      //Excursion form will be displayed with logout button
    } else if (this.state.whichComponentToShow === "ExcursionForm") {
      return (
        <div className="loggedInView">
          <div className="app">
            <div className="container">
              <h4>Loading excursions...</h4>
              <ExcursionForm />
            </div>
          </div>
        </div>
      );
    }
  }
}

export default LoggedInView;
