import React, { useState } from "react";
import "./App.css";
import SubmitButton from "./SubmitButton";
import UserStore from "./stores/UserStore";
import ExcursionList from "./Excursions/ExcursionList";
import NewExcursionEntry from "./NewExcursionEntry";

const DUMMY = [
  {
    id: " 1",
    title: " Munchen",
    excursion_date: new Date(2021, 12, 15),
    description: " Museum",
    max_participants: " 30",
    reg_deadline: new Date(2021, 12, 5),
    dereg_deadline: new Date(2021, 11, 30),
    meeting_details: " Ulm Hauptbahnhof",
    destination: " Munchen",
  },
  {
    id: " 2",
    title: " Stuttgart",
    excursion_date: new Date(2021, 12, 21),
    description: "City Tour",
    max_participants: " 40",
    reg_deadline: new Date(2021, 12, 1),
    dereg_deadline: new Date(2021, 12, 1),
    meeting_details: " Ulm Hauptbahnhof",
    destination: " Stuttgart",
  },
  {
    id: " 3",
    title: " Ulm",
    excursion_date: new Date(2022, 2, 12),
    description: " Fisherman Village",
    max_participants: " 25",
    reg_deadline: new Date(2022, 1, 20),
    dereg_deadline: new Date(2022, 1, 20),
    meeting_details: " Ulmer-Munster",
    destination: " Ulm",
  },
];

/*class LoggedInView extends React.Component {
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
      //if the excursion fetch from database successfull, excursion data is available
      if (result && result.success) {
        ExcursionDataStore.loading = false;
        ExcursionDataStore.isReady = true;
      } else {
        ExcursionDataStore.loading = false;
        ExcursionDataStore.isReady = false;
      }
    } catch (e) {
      ExcursionDataStore.loading = false;
      ExcursionDataStore.isReady = false;
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
  }*/

const LoggedInView = () => {
  const [excursions, setExcursions] = useState(DUMMY);

  // once loggedin the excursion list is set to be visible
  const [state, setState] = useState({
    visible: true,
    whichComponentToShow: "ExcursionList",
  });

  // changing state of excursions if a new excursion is added,
  // need to use prev in order to receive the latest state snapshot
  // clean way to update a state when it is based on older snapshot of the same state
  const addExcursionHandler = (excursion) => {
    console.log(excursion);
    setExcursions((prevExcursions) => {
      return [excursion, ...prevExcursions];
    });
  };
  // the function that is triggered when 'Back to Excursions' button
  // is clicked in the 'ExcursionForm' that brings back the excursion list view
  const BackToExcursionViewHandler = () => {
    setState({ whichComponentToShow: "ExcursionList" });
  };

  //render() {
  //user is loggedin, the excursion list & logout button is visible, greet the user by the name
  if (state.whichComponentToShow === "ExcursionList") {
    return (
      <div className="loggedInView">
        <div className="app">
          <div className="container">
            {/* welcome the user with the name of the user*/}
            <h2>
              Welcome {UserStore.name_first} {UserStore.name_last}!
            </h2>
            <br />
            <button
              className="btn btn-primary"
              type="button"
              onClick={() => {
                setState({ whichComponentToShow: "NewExcursionEntry" });
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
            <br />
            <h4>Available Excursions</h4>
            {/* <NewExcursionEntry onAddExcursion={addExcursionHandler} />*/}
            <ExcursionList items={excursions} />
          </div>
        </div>
      </div>
    );

    //Excursion form will be displayed with logout button
  } else if (state.whichComponentToShow === "NewExcursionEntry") {
    return (
      <div className="loggedInView">
        <div className="app">
          <div className="container">
            <NewExcursionEntry
              onAddExcursion={addExcursionHandler}
              onBackToExcursionView={BackToExcursionViewHandler}
            />
          </div>
        </div>
      </div>
    );
  }
};
//} if use render

export default LoggedInView;
