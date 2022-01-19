import React, { Fragment, useState } from "react";
import InputField from "../UI/InputField";
import SubmitButton from "../UI/SubmitButton";
import { Prompt } from "react-router-dom";
import { Link } from "react-router-dom";
import UserStore from "../stores/UserStore";

/**
 * @component ExcursionForm
 * @param {function} props
 */
const ExcursionForm = (props) => {
  const [isEntering, setIsEntering] = useState(false);
  /**
   * new enetered values will be stored in excursionData
   */
  const [enteredExcursionName, setEnteredExcursionName] = useState("");
  const [enteredExcursionDate, setEnteredExcursionDate] = useState("");
  const [enteredExcursionDestination, setEnteredExcursionDestination] =
    useState("");
  const [enteredExcursionDescription, setEnteredExcursionDescription] =
    useState("");
  const [enteredMaxNumParticipants, setEnteredMaxNumParticipants] =
    useState("");
  const [enteredRegistrDeadline, setEnteredRegistrDeadline] = useState("");
  const [enteredDeregistrDeadline, setEnteredDeregistrDeadline] = useState("");
  const [enteredMeetingDetails, setEnteredMeetingDetails] = useState("");
  const [enteredExcursionFee, setEnteredExcursionFee] = useState("");

  //a new value is past via event (user input)
  const excursionNameChangeHamdler = (event) => {
    setEnteredExcursionName(event);
  };
  const excursionDateChangeHandler = (event) => {
    setEnteredExcursionDate(event);
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
  const registrDeadlineChangeHandler = (event) => {
    setEnteredRegistrDeadline(event);
  };
  const deregistrDeadlineChangeHandler = (event) => {
    setEnteredDeregistrDeadline(event);
  };
  const meetingDetailsChangeHandler = (event) => {
    setEnteredMeetingDetails(event);
  };
  const excursionFeeChangeHandler = (event) => {
    setEnteredExcursionFee(event);
  };
  /**
   * the whole form will react on submit
   * @param {string|number|Object} event user entered data in the form
   */
  const submitHandler = (event) => {
    event.preventDefault();
    var dateReviewed = new Date();

    const excursionData = {
      title: enteredExcursionName,
      date_of_excursion: new Date(enteredExcursionDate),
      destination: enteredExcursionDestination,
      description: enteredExcursionDescription,
      max_participants: enteredMaxNumParticipants,
      excursion_fee: enteredExcursionFee,
      reg_deadline: new Date(enteredRegistrDeadline),
      dereg_deadline: new Date(enteredDeregistrDeadline),
      meeting_details: enteredMeetingDetails,
      date_reviewed: Date.parse(
        dateReviewed.getFullYear() +
          "-" +
          (dateReviewed.getMonth() + 1) +
          "-" +
          dateReviewed.getDate()
      ),
    };
    /**
     * pass generated here excursionData as argument and newExcursionEntry
     * component (parent) will receive enteredExcursionData as a parameter
     */
    props.onAddExcursion(excursionData);
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
  /**
   * watch if the user start entering the data into the form
   */
  const formFocusedHandler = () => {
    setIsEntering(true);
  };
  /**
   * if the user finished entering the data into the form, need to prevent
   * showing message "Are you sure you want to leave..."
   */
  const finishEnteringHandler = () => {
    setIsEntering(false);
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
    <Fragment>
      {/**
       * if the user tries to leave the page show a message
       */}
      <Prompt
        when={isEntering}
        message={(location) =>
          "Are you sure you want to leave? All the entered data will be lost!"
        }
      />
      <div className="excursionForm">
        <h4>Excursion Form</h4>
        <form onFocus={formFocusedHandler} onSubmit={submitHandler}>
          <div className="excursionFormF">
            <label>Excursion name</label>
            <InputField
              type="text"
              class="form-excursion"
              id="excursionName"
              placeholder="Excursion name"
              value={enteredExcursionName}
              onChange={excursionNameChangeHamdler}
              required
            />
            <label>Date of excursion</label>
            <InputField
              type="date"
              min="01-01-2022"
              max="01-01-2025"
              class="form-excursion"
              id="excursionDate"
              placeholder="Excursion date"
              value={enteredExcursionDate}
              onChange={excursionDateChangeHandler}
              required
            />
            <label>Destination</label>
            <InputField
              type="text"
              class="form-excursion"
              id="destination"
              placeholder="Destination"
              value={enteredExcursionDestination}
              onChange={destionationChangeHandler}
              required
            />
            <label>Description</label>
            <InputField
              type="text"
              className="form-excursion"
              id="description"
              placeholder="Description"
              value={enteredExcursionDescription}
              onChange={descriptionChangeHandler}
              required
            />
            <label>Max number of students</label>
            <InputField
              type="text"
              className="form-excursion"
              id="max-num-participants"
              placeholder="Maximum number of students"
              value={enteredMaxNumParticipants}
              onChange={maxNumParticipantsChangeHandler}
              required
            />
            <label>Excursion fee</label>
            <InputField
              type="text"
              className="form-excursion"
              id="excursion-fee"
              placeholder="Excursion fee"
              value={enteredExcursionFee}
              onChange={excursionFeeChangeHandler}
              required
            />
            <label>Registration deadline</label>
            <InputField
              type="date"
              min="01-01-2022"
              max="01-01-2025"
              className="form-excursion"
              id="register-deadline"
              placeholder="Registration deadline"
              value={enteredRegistrDeadline}
              onChange={registrDeadlineChangeHandler}
              required
            />
            <label>Deregistration deadline</label>
            <InputField
              type="date"
              min="01-01-2022"
              max="01-01-2025"
              className="form-excursion"
              id="deregister-deadline"
              placeholder="Deregistration deadline"
              value={enteredDeregistrDeadline}
              onChange={deregistrDeadlineChangeHandler}
              required
            />
            <label>Meeting details</label>
            <InputField
              type="text"
              className="form-excursion"
              id="meeting-details"
              placeholder="Meeting details"
              value={enteredMeetingDetails}
              onChange={meetingDetailsChangeHandler}
              required
            />
            <button
              onClick={finishEnteringHandler}
              className="btn btn-primary"
              type="submit"
            >
              Add New Excursion
            </button>
          </div>
        </form>
        <br />
        <Link to={"/login/excursions"} className="excursion-item-link">
          <button className="btn btn-primary">Back to Excursions</button>
        </Link>

        <Link to="/login">
          <SubmitButton
            className="logout-btn"
            text={"Log out"}
            disabled={false}
            onClick={doLogout}
          />
        </Link>
      </div>
    </Fragment>
  );
};

export default ExcursionForm;
