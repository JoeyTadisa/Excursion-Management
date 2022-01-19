import React, {useContext, useState, useEffect, useCallback } from "react";
import SubmitButton from "../components/UI/SubmitButton";
import UserStore from "../components/stores/UserStore";
import ExcursionList from "../components/Excursions/ExcursionList";
import { Link } from "react-router-dom";
import LoadingSpinner from "../components/UI/LoadingSpinner";
import {AuthContext} from "../context/AuthContext";
import configData from "../config.json";

/**
 * fetching excursions from database
 * @component
 */
const LoggedInView = () => {
  const [excursions, setExcursions] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [notApprovedExcursions, setNotApprovedExcursions] = useState([]);
  const [isLoading1, setIsLoading1] = useState(false);
  const [error, setError] = useState(null);
  const [error1, setError1] = useState(null);
  const authContext = useContext(AuthContext);

  // once loggedin the excursion list is displayed
  /**
   * Download data from http://localhost:9191/api/excursion/approvalstatus/a
   * @async
   * @function fetchExcursions
   * @param {string} response - The result of fetch is stored in response
   */

  const fetchExcursions = useCallback(async () => {
    setIsLoading(true);
    // clear previous error
    setError(null);
    try {
      const response = await fetch(
        configData.SERVER_URL+"excursion/approvalstatus/a",{
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
            "Authorization": `Bearer ${authContext.token}`
          }
        }
      );
      /**
       * need to check before parsing the response body
       * signals if the response was successful
       */
      if (!response.ok) {
        throw new Error("Something went wrong!");
      }
      const data = await response.json();

      /**
       * the fetched data is transformed in appropriate format and stored in array of objects
       * @type {Array<excursions>}
       * @returns {{id: number, title: string, date_of_excursion: Object, excursion_fee: number, description: string,
       *  max_participants: number, destination: string, reg_deadline: Object, dereg_deadline: Object, meeting_details: string}} excursions
       */

      const transformedExcursions = data.map((excursionData) => {
        return {
          id: excursionData.id,
          title: excursionData.title,
          date_of_excursion: new Date(excursionData.date_of_excursion),
          excursion_fee: excursionData.excursion_fee,
          description: excursionData.description,
          max_participants: excursionData.max_participants,
          destination: excursionData.destination,
          reg_deadline: new Date(excursionData.reg_deadline),
          dereg_deadline: new Date(excursionData.dereg_deadline),
          meeting_details: excursionData.meeting_details,
        };
      });
      /**
       *@param {Array.<excursions>} transformedExcursions
       *@returns {void}
       */
      setExcursions(transformedExcursions);
    } catch (error) {
      setError(error.message);
    }
    /**
     * done loading, no matter if we got successful or an error response
     */
    setIsLoading(false);
  }, []);

  /* useEffect is needed to load the content of the existing excursions on the load of LogedInView
     don't need to be called each time it is re-evaluated (hence, avoid infinite task)
     therefore, add 2nd argument, array of dependencies where we define when it should be executed
     will only execute again if the dependencies [] listed below change
     NEED TO BE CALLED AFTER fetchExcursions function !!!!!!!!!
   */
  useEffect(() => {
    let abortController = new AbortController();
    fetchExcursions();
    return () => {
      abortController.abort();
    };
  }, [fetchExcursions]);

  /**
   * Download data from http://localhost:9191/api/excursion/approvalstatus/p
   * fetch all not approved excursions from backend and display
   * @async
   * @function fetchNotApprovedExcursions
   * @param {string} response - The result of fetch is stored in response
   */

  const fetchNotApprovedExcursions = useCallback(async () => {
    setIsLoading1(true);
    /**
     * clear previous error
     */
    setError1(null);
    try {
      const response = await fetch(
        configData.SERVER_URL+"excursion/approvalstatus/p",{
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
            "Authorization": `Bearer ${authContext.token}`
          }
        }
      );
      /**
       * need to check before parsing the response body
       * signals if the response was successful
       */
      if (!response.ok) {
        throw new Error("*** Something went wrong! ***");
      }
      const data = await response.json();
      /**
       * the fetched data is transformed in appropriate format and stored in array of objects
       * @type {Array.<excursions>}
       * @returns {{id: number, title: string, date_of_excursion: Object, excursion_fee: number, description: string,
       *  max_participants: number, destination: string, reg_deadline: Object, dereg_deadline: Object, meeting_details: string}} excursions
       */
      const transformedNewExcursions = data.map((newExcursionData) => {
        return {
          id: newExcursionData.id,
          title: newExcursionData.title,
          date_of_excursion: new Date(newExcursionData.date_of_excursion),
          excursion_fee: newExcursionData.excursion_fee,
          description: newExcursionData.description,
          max_participants: newExcursionData.max_participants,
          destination: newExcursionData.destination,
          reg_deadline: new Date(newExcursionData.reg_deadline),
          dereg_deadline: new Date(newExcursionData.dereg_deadline),
          meeting_details: newExcursionData.meeting_details,
        };
      });
      setNotApprovedExcursions(transformedNewExcursions);
    } catch (error) {
      setError1(error.message);
    }
    /**
     * done loading, no matter if we got successful or an error response
     */
    setIsLoading1(false);
  }, []);

  /* useEffect is needed to load the content of the existing excursions on the load of LogedInView
     don't need to be called each time it is re-evaluated (hence, avoid infinite task)
     therefore, add 2nd argument, array of dependencies where we define when it should be executed
     will only execute again if the dependencies [] listed below change
     NEED TO BE CALLED AFTER fetchExcursions function !!!!!!!!!
   */
  useEffect(() => {
    let abortController = new AbortController();
    fetchNotApprovedExcursions();
    return () => {
      abortController.abort();
    };
  }, [fetchNotApprovedExcursions]);

  /**
   * @function doLogout the UserStore is reset
   */
  const doLogout = () => {
    UserStore.isLoggedIn = false;
    UserStore.username = "";
    UserStore.name_first = "";
    UserStore.name_last = "";
    UserStore.user_type = "";
    UserStore.user_id = "";
    UserStore.user_no = "";
    authContext.logout();

  };
  /**
   * for better user experience need to display to user
   * if the content is loading/error occured
   */
  let content = <p>Found no excursions.</p>;
  if (excursions.length > 0) {
    content = <ExcursionList items={excursions} />;
  }
  if (error) {
    content = <p>{error}</p>;
  }
  if (isLoading) {
    content = <LoadingSpinner />;
  }

  let content1 = <p>No excursions pending for approval.</p>;
  if (notApprovedExcursions.length > 0) {
    content1 = <ExcursionList items={notApprovedExcursions} />;
  }
  if (error1) {
    content1 = <p>{error1}</p>;
  }
  if (isLoading1) {
    content1 = <LoadingSpinner />;
  }
  /**
   * user is loggedin, the excursion list & logout button is visible, greet the user by the name
   */
  return (
    <div className="loggedInView">
      <div className="app">
        {/**
         * welcome the user with the name of the user
         */}
        <h2>
          Welcome {UserStore.name_first} {UserStore.name_last} !
        </h2>
        <br />
        {/* only if the user is organizer the button 'New Excursion Form' is displayed */}
        {UserStore.user_type === "ROLE_o" && (
          <Link to={`/new-excursion`} className="excursion-item-link">
            <button className="btn btn-primary" type="button">
              New Excursion Form
            </button>
          </Link>
        )}
        <Link to="/login">
          <SubmitButton
            className="logout-btn"
            text={"Log out"}
            disabled={false}
            onClick={doLogout}
          />
        </Link>
        <br />
        <h4 className="pending-for-approval">Pending for approval</h4>
        <section className="pending-for-approval-box">{content1}</section>
        <h4>Available Excursions</h4>
        <section>{content}</section>
      </div>
    </div>
  );
};

export default LoggedInView;
