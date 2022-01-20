import React, { useState, useEffect } from "react";
import InputField from "../components/UI/InputField";
import UserStore from "../components/stores/UserStore";
import SubmitButton from "../components/UI/SubmitButton";
import { Link, useLocation, useHistory } from "react-router-dom";
import { updateExcursion } from "../lib/api";
import useHttp from "../hooks/use-http";

/**
 * the form with populated details of excursion is displayed for organiser
 * purpose: to view or modify the details
 * @component
 */

const ExcursionFormPopulated = () => {
  const { sendRequest, status, error } = useHttp(updateExcursion);
  const location = useLocation();
  const history = useHistory();
  const state = location.state;

  /**
   *
   * @param {Object} rawDate
   * @returns {string} year-month-day
   */
  const convertDate = (rawDate) => {
    const month = new Date(rawDate).toLocaleString("en-US", {
      month: "2-digit",
    });
    const day = new Date(rawDate).toLocaleString("en-US", {
      day: "2-digit",
    });
    const year = new Date(rawDate).getFullYear().toString();
    return year + "-" + month + "-" + day;
  };

  /**
   * new enetered values will be stored in excursionData
   */
  const [enteredExcursionName, setEnteredExcursionName] = useState(state.title);
  const [enteredExcursionDate, setEnteredExcursionDate] = useState(
    convertDate(state.date_of_excursion)
  );

  const [enteredExcursionDestination, setEnteredExcursionDestination] =
    useState(state.destination);
  const [enteredExcursionDescription, setEnteredExcursionDescription] =
    useState(state.description);
  const [enteredMaxNumParticipants, setEnteredMaxNumParticipants] = useState(
    state.max_participants
  );
  const [enteredExcursionFee, setEnteredExcursionFee] = useState(
    state.excursion_fee
  );
  const [enteredRegistrDeadline, setEnteredRegistrDeadline] = useState(
    convertDate(state.reg_deadline)
  );
  const [enteredDeregistrDeadline, setEnteredDeregistrDeadline] = useState(
    convertDate(state.dereg_deadline)
  );
  const [enteredMeetingDetails, setEnteredMeetingDetails] = useState(
    state.meeting_details
  );
  /**
   * a new value is past via event (user input)
   */
  const excursionNameChangeHamdler = (event) => {
    setEnteredExcursionName(event);
  };
  const excursionDateChangeHandler = (event) => {
    setEnteredExcursionDate(event);
    console.log(event);
  };
  const destionationChangeHandler = (event) => {
    setEnteredExcursionDestination(event);
  };
  const descriptionChangeHandler = (event) => {
    setEnteredExcursionDescription(event);
  };
  const maxNumParticipantsChangeHandler = (event) => {
    setEnteredMaxNumParticipants(event);
  };
  const excursionFeeChangeHandler = (event) => {
    setEnteredExcursionFee(event);
  };
  const registrDeadlineChangeHandler = (event) => {
    setEnteredRegistrDeadline(event);
  };
  const deregistrDeadlineChangeHandler = (event) => {
    setEnteredDeregistrDeadline(event);
  };
  const meetingDetailsChangeHandler = (event) => {
    setEnteredMeetingDetails(event);
  };

  /**
   * the whole form will react on submit
   */
  const submitHandler = (event) => {
    event.preventDefault();

    let dateWritten = new Date();
    const date_written = Date.parse(
      dateWritten.getFullYear() +
        "-" +
        (dateWritten.getMonth() + 1) +
        "-" +
        dateWritten.getDate()
    );
    const excursionData = {
      id: state.id,
      title: enteredExcursionName,
      date_of_excursion: new Date(enteredExcursionDate),
      destination: enteredExcursionDestination,
      description: enteredExcursionDescription,
      max_participants: enteredMaxNumParticipants,
      excursion_fee: enteredExcursionFee,
      reg_deadline: new Date(enteredRegistrDeadline),
      dereg_deadline: new Date(enteredDeregistrDeadline),
      meeting_details: enteredMeetingDetails,
      requested_by: UserStore.user_no,
      date_written: date_written,
      is_approved: state.is_approved,
    };
    /**
     * pass modified here excursionData as argument
     */
    sendRequest(excursionData);
    /**
     * after submit form, reset the form with empty strings
     */
    setEnteredExcursionName("");
    setEnteredExcursionDate("");
    setEnteredExcursionDestination("");
    setEnteredExcursionDescription("");
    setEnteredMaxNumParticipants("");
    setEnteredExcursionFee("");
    setEnteredRegistrDeadline("");
    setEnteredDeregistrDeadline("");
    setEnteredMeetingDetails("");
  };

  useEffect(() => {
    if (status === "completed" && !error) {
      alert("✨ The excursion was updated ✨");
      history.push("/login/excursions");
    }
    if (status === "completed" && error) {
      alert("😅 The excursion was not updated");
      history.push("/login/excursions");
    }
    return () => {};
  }, [status, history, error]);

  const closeView = () => {
    history.goBack();
  };
  /**
   * define logout function
   */
  const doLogout = () => {
    UserStore.isLoggedIn = false;
    UserStore.username = "";
    UserStore.name_first = "";
    UserStore.name_last = "";
    UserStore.user_type = "";
    UserStore.user_id = "";
    UserStore.user_no = "";
  };

  return (
    <div className="excursionForm">
      <h4>Excursion Form</h4>
      <form onSubmit={submitHandler}>
        <div className="excursionFormF">
          {/**
           * <label for="meeting-details">Meeting details</label>
           */}
          <label>Excursion title</label>
          <InputField
            type="text"
            class="form-excursion"
            id="excursionName"
            value={enteredExcursionName}
            onChange={excursionNameChangeHamdler}
          />
          <label>Date of excursion</label>
          <InputField
            type="date"
            min="01-01-2021"
            max="01-01-2025"
            class="form-excursion"
            id="excursionDate"
            value={enteredExcursionDate}
            onChange={excursionDateChangeHandler}
          />
          <label>Destination</label>
          <InputField
            type="text"
            class="form-excursion"
            id="destination"
            value={enteredExcursionDestination}
            onChange={destionationChangeHandler}
          />
          <label>Description</label>
          <InputField
            type="text"
            className="form-excursion"
            id="description"
            value={enteredExcursionDescription}
            onChange={descriptionChangeHandler}
          />
          <label>Max number of students</label>
          <InputField
            type="text"
            className="form-excursion"
            id="max-num-participants"
            value={enteredMaxNumParticipants}
            onChange={maxNumParticipantsChangeHandler}
          />
          <label>Excursion fee</label>
          <InputField
            type="text"
            className="form-excursion"
            id="excursion-fee"
            value={enteredExcursionFee}
            onChange={excursionFeeChangeHandler}
          />
          <label>Registration deadline</label>
          <InputField
            type="date"
            min="01-01-2021"
            max="01-01-2025"
            className="form-excursion"
            id="register-deadline"
            value={enteredRegistrDeadline}
            onChange={registrDeadlineChangeHandler}
          />
          <label>Deregistration deadline</label>
          <InputField
            type="date"
            min="01-01-2021"
            max="01-01-2025"
            className="form-excursion"
            id="deregister-deadline"
            value={enteredDeregistrDeadline}
            onChange={deregistrDeadlineChangeHandler}
          />
          <label>Meeting details</label>
          <InputField
            type="text"
            className="form-excursion"
            id="meeting-details"
            value={enteredMeetingDetails}
            onChange={meetingDetailsChangeHandler}
          />
          <br />
          <button className="btn btn-primary" type="submit">
            Update Excursion
          </button>

          <button
            className="btn btn-primary"
            id="back-to-excursion"
            onClick={closeView}
          >
            Back to Excursions
          </button>
        </div>
      </form>

      <Link to="/login">
        <SubmitButton
          className="logout-btn"
          text={"Log out"}
          disabled={false}
          onClick={doLogout}
        />
      </Link>
    </div>
  );
};

export default ExcursionFormPopulated;
