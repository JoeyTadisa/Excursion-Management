import React from "react";
import InputField from "./InputField";
import SubmitButton from "./SubmitButton";

class ExcursionForm extends React.Component {
  render() {
    return (
      <div className="excursionForm">
        <h4>Excursion Form</h4>
        <h5>Excursion name</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="excursionName"
          placeholder="Excursion name"
        />
        <h5>Date of excursion</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="excursionDate"
          placeholder="Excursion date"
        />
        <h5>Destination</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="destination"
          placeholder="Destination"
        />
        <h5>Description</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="description"
          placeholder="Description"
        />
        <h5>Max number of students</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="max-num-participants"
          placeholder="Maximum number of students"
        />
        <h5>Registration deadline</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="register-deadline"
          placeholder="Registration deadline"
        />
        <h5>Deregistration deadline</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="deregister-deadline"
          placeholder="Deregistration deadline"
        />
        <h5>Meeting details</h5>
        <InputField
          type="text"
          class="form-excursion"
          id="meeting-details"
          placeholder="Meeting details"
        />
        <SubmitButton text="Save" />
        <SubmitButton text="Clear" />
      </div>
    );
  }
}

export default ExcursionForm;
