import React, { useState } from "react";
import InputField from "./InputField";
import SubmitButton from "./SubmitButton";

function ExcursionForm(props) {
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

  //a new value is past via event
  const excursionNameChangeHamdler = (event) => {
    setEnteredExcursionName(event.target.value);
  };
  const excursionDateChangeHandler = (event) => {
    setEnteredExcursionDate(event.target.value);
  };
  const destionationChangeHandler = (event) => {
    setEnteredExcursionDestination(event.target.value);
  };
  const descriptionChangeHandler = (event) => {
    setEnteredExcursionDescription(event.target.value);
  };
  const maxNumParticipantsChangeHandler = (event) => {
    setEnteredMaxNumParticipants(event.target.value);
  };
  const registrDeadlineChangeHandler = (event) => {
    setEnteredRegistrDeadline(event.target.value);
  };
  const deregistrDeadlineChangeHandler = (event) => {
    setEnteredDeregistrDeadline(event.target.value);
  };
  const meetingDetailsChangeHandler = (event) => {
    setEnteredMeetingDetails(event.target.value);
  };

  // the whole form is will react on submit
  const submitHandler = (event) => {
    event.preventDefault();

    //new enetered values will be stored in excursionData
    const excursionData = {
      title: enteredExcursionName,
      excursion_date: new Date(enteredExcursionDate),
      destination: enteredExcursionDestination,
      description: enteredExcursionDescription,
      max_participants: enteredMaxNumParticipants,
      reg_deadline: new Date(enteredRegistrDeadline),
      dereg_deadline: new Date(enteredDeregistrDeadline),
      meeting_details: enteredMeetingDetails,
    };

    // pass generated here excursionData as argument and newExcursionEntry
    // component (parent) will receive enteredExcursionData as a parameter

    props.onSaveExcursionData(excursionData);

    //after submit form, reset the form with empty strings
    setEnteredExcursionName("");
    setEnteredExcursionDate("");
    setEnteredExcursionDestination("");
    setEnteredExcursionDescription("");
    setEnteredMaxNumParticipants("");
    setEnteredRegistrDeadline("");
    setEnteredDeregistrDeadline("");
    setEnteredMeetingDetails("");
  };

  return (
    <div className="excursionForm">
      <h4>Excursion Form</h4>
      <form onSubmit={submitHandler}>
        <label for="excursionName">Excursion name</label>
        <InputField
          type="text"
          class="form-excursion"
          id="excursionName"
          placeholder="Excursion name"
          value={enteredExcursionName}
          onChange={excursionNameChangeHamdler}
        />
        <label for="excursionDate">Date of excursion</label>
        <InputField
          type="date"
          min="01-01-2022"
          max="01-01-2030"
          class="form-excursion"
          id="excursionDate"
          placeholder="Excursion date"
          value={enteredExcursionDate}
          onChange={excursionDateChangeHandler}
        />
        <label for="destination">Destination</label>
        <InputField
          type="text"
          class="form-excursion"
          id="destination"
          placeholder="Destination"
          value={enteredExcursionDestination}
          onChange={destionationChangeHandler}
        />
        <label for="description">Description</label>
        <InputField
          type="text"
          className="form-excursion"
          id="description"
          placeholder="Description"
          value={enteredExcursionDescription}
          onChange={descriptionChangeHandler}
        />
        <label for="max-num-participants">Max number of students</label>
        <InputField
          type="text"
          className="form-excursion"
          id="max-num-participants"
          placeholder="Maximum number of students"
          value={enteredMaxNumParticipants}
          onChange={maxNumParticipantsChangeHandler}
        />
        <label for="register-deadline">Registration deadline</label>
        <InputField
          type="date"
          min="01-01-2022"
          max="01-01-2030"
          className="form-excursion"
          id="register-deadline"
          placeholder="Registration deadline"
          value={enteredRegistrDeadline}
          onChange={registrDeadlineChangeHandler}
        />
        <label for="deregister-deadline">Deregistration deadline</label>
        <InputField
          type="text"
          className="form-excursion"
          id="deregister-deadline"
          placeholder="Deregistration deadline"
          value={enteredDeregistrDeadline}
          onChange={deregistrDeadlineChangeHandler}
        />
        <label for="meeting-details">Meeting details</label>
        <InputField
          type="text"
          className="form-excursion"
          id="meeting-details"
          placeholder="Meeting details"
          value={enteredMeetingDetails}
          onChange={meetingDetailsChangeHandler}
        />
        <SubmitButton lassName="btn btn-primary" type="submit" text="Save" />
      </form>
      <SubmitButton type="submit" text="Clear" />
      <SubmitButton
        className="logout-btn"
        text={"Log out"}
        disabled={false}
        onClick={() => this.doLogout()}
      />
    </div>
  );
}

export default ExcursionForm;
