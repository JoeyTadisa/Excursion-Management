//import { set } from "mobx";
import React, { useState } from "react";
import InputField from "../InputField";
import SubmitButton from "../SubmitButton";

const ExcursionForm = (props) => {
  //new enetered values will be stored in excursionData

  const [enteredExcursionName, setEnteredExcursionName] = useState("");
  const [enteredExcursionDate, setEnteredExcursionDate] = useState("");
  const [enteredExcursionDestination, setEnteredExcursionDestination] =
    useState("");
  const [enteredExcursionDescription, setEnteredExcursionDescription] =
    useState("");
  const [enteredMaxNumParticipants, setEnteredMaxNumParticipants] =
    useState("");
  const [enteredExcursionFee, setEnteredExcursionFee] = useState("");
  const [enteredRegistrDeadline, setEnteredRegistrDeadline] = useState("");
  const [enteredDeregistrDeadline, setEnteredDeregistrDeadline] = useState("");
  const [enteredMeetingDetails, setEnteredMeetingDetails] = useState("");

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

  // the whole form is will react on submit
  const submitHandler = (event) => {
    event.preventDefault();

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
    };

    // pass generated here excursionData as argument and newExcursionEntry
    // component (parent) will receive enteredExcursionData as a parameter
    console.log(excursionData);
    props.onSaveExcursionData(excursionData);

    //after submit form, reset the form with empty strings
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

  return (
    <div className="excursionForm">
      <h4>Excursion Form</h4>
      <form onSubmit={submitHandler}>
        <div className="excursionFormF">
          {/*<label for="meeting-details">Meeting details</label>*/}
          <label>Excursion title</label>
          <InputField
            type="text"
            class="form-excursion"
            id="excursionName"
            placeholder="Excursion name"
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
            placeholder="Excursion date"
            value={enteredExcursionDate}
            onChange={excursionDateChangeHandler}
          />
          <label>Destination</label>
          <InputField
            type="text"
            class="form-excursion"
            id="destination"
            placeholder="Destination"
            value={enteredExcursionDestination}
            onChange={destionationChangeHandler}
          />
          <label>Description</label>
          <InputField
            type="text"
            className="form-excursion"
            id="description"
            placeholder="Description"
            value={enteredExcursionDescription}
            onChange={descriptionChangeHandler}
          />
          <label>Max number of students</label>
          <InputField
            type="text"
            className="form-excursion"
            id="max-num-participants"
            placeholder="Maximum number of students"
            value={enteredMaxNumParticipants}
            onChange={maxNumParticipantsChangeHandler}
          />
          <label>Excursion fee</label>
          <InputField
            type="text"
            className="form-excursion"
            id="excursion-fee"
            placeholder="Excursion fee"
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
            placeholder="Registration deadline"
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
            placeholder="Deregistration deadline"
            value={enteredDeregistrDeadline}
            onChange={deregistrDeadlineChangeHandler}
          />
          <label>Meeting details</label>
          <InputField
            type="text"
            className="form-excursion"
            id="meeting-details"
            placeholder="Meeting details"
            value={enteredMeetingDetails}
            onChange={meetingDetailsChangeHandler}
          />
          <button className="btn btn-primary" type="submit">
            Add New Excursion
          </button>
          <SubmitButton
            type="button"
            text="Back to Excursions"
            onClick={props.onBackToExcursionView}
          />
        </div>
      </form>

      <SubmitButton
        className="logout-btn"
        text={"Log out"}
        disabled={false}
        onClick={() => this.doLogout()}
      />
    </div>
  );
};

export default ExcursionForm;
