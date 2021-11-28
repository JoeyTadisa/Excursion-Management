import React, { useState, useEffect, useCallback } from "react";
import "./App.css";
import SubmitButton from "./SubmitButton";
import UserStore from "./stores/UserStore";
import ExcursionList from "./Excursions/ExcursionList";
import ExcursionsList from "./Excursions/ExcursionsList";
import NewExcursionEntry from "./NewExcursionEntry";
import ExcursionDetailedItem from "./Excursions/ExcursionDetailedItem";
import ExcursionsDetailedList from "./Excursions/ExcursionsDetailedList";

/* async doLogout() {
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

//fetching excursions from database
const LoggedInView = () => {
  const [excursions, setExcursions] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  // once loggedin the excursion list is set to be visible
  const [state, setState] = useState({
    visible: true,
    whichComponentToShow: "ExcursionList",
  });

  const fetchExcursions = useCallback(async () => {
    setIsLoading(true);
    // clear previous error
    setError(null);
    try {
      const response = await fetch("http://localhost:9191/excursions");

      // need to check before parsing the response body
      // signals if the response was successful
      if (!response.ok) {
        throw new Error("Something went wrong!");
      }
      const data = await response.json();

      const transformedExcursions = data.map((excursionData) => {
        return {
          id: excursionData.id,
          //excursion_date: excursionData.excursion_date,
          description: excursionData.description,
          max_participants: excursionData.max_participants,
          reg_deadline: new Date(excursionData.reg_deadline),
          dereg_deadline: new Date(excursionData.dereg_deadline),
          meeting_details: excursionData.meeting_details,
          title: excursionData.title,
        };
      });
      setExcursions(transformedExcursions);
      console.log(excursions);
    } catch (error) {
      setError(error.message);
    }
    // done loading, no matter if we got successful or an error response
    setIsLoading(false);
  }, []);

  /* useEffect is needed to load the content of the existing excursions on the load of LogedInView
     don't need to be called each time it is re-evaluated (hence, avoid infinite task)
     therefore, add 2nd argument, array of dependencies where we define when it should be executed
     will only execute again if the dependencies [] listed below change
     NEED TO BE CALLED AFTER fetchExcursions function !!!!!!!!!
   */
  useEffect(() => {
    fetchExcursions();
  }, [fetchExcursions]);

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
  // for better user experience need to display to user
  // if the content is loading/error occured
  let content = <p>Found no excursions.</p>;
  if (excursions.length > 0) {
    content = <ExcursionList items={excursions} />;
  }
  if (error) {
    content = <p>{error}</p>;
  }
  if (isLoading) {
    content = <p>Loading...</p>;
  }

  //render() {
  //user is loggedin, the excursion list & logout button is visible, greet the user by the name
  if (
    state.whichComponentToShow === "ExcursionList" &&
    UserStore.name_last == "Crawford"
  ) {
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

            <section>{content}</section>
            {/* <NewExcursionEntry onAddExcursion={addExcursionHandler} />*/}
            {/*{!isLoading && excursions.lenght > 0 && (
              <ExcursionList items={excursions} />
            )}
            {!isLoading && excursions.lenght === 0 && !error && (
              <p>Found no movies</p>
            )}
            {!isLoading && error && <p>{error}</p>}
            {isLoading && <p>Loading...</p>} */}
            <ExcursionsDetailedList items={excursions} />
          </div>
        </div>
      </div>
    );

    //Excursion form will be displayed with logout button
  } else if (
    UserStore.name_last === "Crawford" &&
    state.whichComponentToShow === "NewExcursionEntry"
  ) {
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
  } else if (
    UserStore.name_last === "Scroggins" &&
    state.whichComponentToShow === "ExcursionList"
  ) {
    return (
      <div className="loggedInView">
        <div className="app">
          <div className="container">
            {/* welcome the user with the name of the user*/}
            <h2>
              Welcome {UserStore.name_first} {UserStore.name_last}!
            </h2>
            <br />
            <SubmitButton
              className="logout-btn"
              text={"Log out"}
              disabled={false}
              onClick={() => this.doLogout()}
            />
            <br />

            <h4>Available Excursions</h4>

            <button className="btn btn-primary" onClick={fetchExcursions}>
              Fetch Excursions
            </button>
            <section>{content}</section>
            {/* <NewExcursionEntry onAddExcursion={addExcursionHandler} />*/}
            {/*{!isLoading && excursions.lenght > 0 && (
              <ExcursionList items={excursions} />
            )}
            {!isLoading && excursions.lenght === 0 && !error && (
              <p>Found no movies</p>
            )}
            {!isLoading && error && <p>{error}</p>}
            {isLoading && <p>Loading...</p>} */}
            <ExcursionsDetailedList items={excursions} />
          </div>
        </div>
      </div>
    );

    //Excursion form will be displayed with logout button
  }
};
//} if use render

export default LoggedInView;